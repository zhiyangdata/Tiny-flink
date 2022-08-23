package org.team3090.simple.Driver;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

/**
 * @Author ds666
 * @Date 2022/8/20 16:34
 * @Version 1.0
 */
public class ReadConfig {
    private static String path;
    public static JSONObject obj = new JSONObject();  //json配置文件：可更新
    public ReadConfig() {}
    public ReadConfig(String path) {
        this.path = path;
    }

    public static JSONObject getObj() {
        return obj;
    }

    public static void setObj(JSONObject obj) {
        ReadConfig.obj = obj;
    }

    /*
     * @Description: 读取配置文件，String转化成JSONObject返回
     * @return: com.alibaba.fastjson.JSONObject
     * @Author: ws
     * @Date: 2022/8/20 16:41
     * @version 1.0
     */
    public JSONObject readconfig(String path) {
        String url = ReadConfig.path;
        File jsonFile = new File(url);
        String str = getStr(jsonFile);
        JSONObject obj = JSON.parseObject(str);
        return obj;
    }
    /*
     * @Description: 解析json，返回任务列表。
     * @return: java.util.ArrayList
     * @Author: ws
     * @Date: 2022/8/20 16:46
     * @version 1.0
     */
    public ArrayList scheduler() {
        //配置文件转json
        ArrayList<String> tasknames = new ArrayList<String> ();
        JSONObject obj = readconfig(ReadConfig.path);
        JSONArray features = obj.getJSONArray("configall");
        //挨个遍历
        for (Object feature : features) {
            JSONObject featureObject =(JSONObject)feature;
            System.out.println(Integer.parseInt(featureObject.get("concurrent").toString()));
            for( int a= Integer.parseInt(featureObject.get("concurrent").toString());a>0;a--){ //根据并行度创建多个任务
                JSONObject task = new JSONObject();
//                String tasktype = (String) featureObject.get("concurrent");
                String tasktype = featureObject.get("operatpr").toString();
                tasknames.add(tasktype + a);
            }
        }
        ReadConfig.obj=obj;
        return tasknames;
    }
    //把一个文件中的内容读取成一个String字符串
    public static String getStr(File jsonFile) {
        String jsonStr = "";
        try {
            FileReader fileReader = new FileReader(jsonFile);
            Reader reader = new InputStreamReader(new FileInputStream(jsonFile), "utf-8");
            int ch = 0;
            StringBuffer sb = new StringBuffer();
            while ((ch = reader.read()) != -1) {
                sb.append((char) ch);
            }
            fileReader.close();
            reader.close();
            jsonStr = sb.toString();
            return jsonStr;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static boolean createJsonFile(Object jsonData, String filePath) {
        String content = JSON.toJSONString(jsonData, SerializerFeature.PrettyFormat, SerializerFeature.WriteMapNullValue,
                SerializerFeature.WriteDateUseDateFormat);
        try {
            File file = new File(filePath);
            // 创建上级目录
            if (!file.getParentFile().exists()) {
                file.getParentFile().mkdirs();
            }
            // 如果文件存在，则删除文件
            if (file.exists()) {
                file.delete();
            }
            // 创建文件
            file.createNewFile();
            // 写入文件
            Writer write = new OutputStreamWriter(new FileOutputStream(file), StandardCharsets.UTF_8);
            write.write(content);
            write.flush();
            write.close();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
