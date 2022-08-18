package org.team3090.simple.Driver;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import org.team3090.simple.Worker.BlockManager;
import org.team3090.simple.Worker.Map;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

/**
 * @BelongsProject: Tiny-flink
 * @BelongsPackage: org.team3090.simple.Driver
 * @Author: Zhiyang Zhu
 * @CreateTime: 2022-08-16  21:01
 * @Description: 解析配置文件生成json
 * @Version: 2.0
 */
public class Config {
    private static String path;
    public static JSONObject obj = new JSONObject();  //json配置文件：可更新
    public Config() {}
    public Config(String path) {
        this.path = path;
    }

    public ArrayList scheduler() {    //更新json配置文件，返回 任务列表。
        //配置文件转json
        ArrayList<String> tasknames = new ArrayList<String> ();
        String url = "C:\\Users\\ds666\\Desktop\\青训营项目会\\Tiny-flink\\Tiny-flink\\package.json";
//        String url = Config.path;
        File jsonFile = new File(url);
        String str = getStr(jsonFile);
        JSONObject obj = JSON.parseObject(str);
        System.out.println(obj);
        System.out.println(obj.getJSONArray("configall"));
        JSONArray features = obj.getJSONArray("configall");
        //挨个遍历
        JSONArray tasks = new JSONArray();
        for (Object feature : features) {
            JSONObject featureObject =(JSONObject)feature;
            System.out.println(Integer.parseInt(featureObject.get("concurrent").toString()));
            for( int a= Integer.parseInt(featureObject.get("concurrent").toString());a>0;a--){ //根据并行度创建多个任务
                JSONObject task = new JSONObject();
//                String tasktype = (String) featureObject.get("concurrent");
                String tasktype = featureObject.get("operatpr").toString();
                switch (tasktype) {
                    case "map":
                        task.put("tasktype",tasktype);
                        task.put("taskname",tasktype + a);
                        task.put("func", "方法地址");
                        tasks.add(task);
                        break;
                    case "reduce":
                        task.put("tasktype",tasktype);
                        task.put("taskname",tasktype + a);
                        task.put("func", "方法地址");
                        tasks.add(task);
                        break;
                    case "sink":
                        task.put("tasktype",tasktype);
                        task.put("taskname",tasktype + a);
                        task.put("func", "方法地址");
                        tasks.add(task);
                        break;
                    case "source":
                        task.put("tasktype",tasktype);
                        task.put("taskname",tasktype + a);
                        task.put("func", "方法地址");
                        tasks.add(task);
                        break;
                }
                tasknames.add(tasktype + a);
            }
        }
        Config.obj=obj;
        obj.put("tasks",tasks);
        createJsonFile(obj,"./result.json");
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
