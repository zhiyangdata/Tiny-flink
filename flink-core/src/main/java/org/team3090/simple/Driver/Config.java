package org.team3090.simple.Driver;


import cn.hutool.core.io.file.FileReader;
import cn.hutool.json.JSONArray;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @BelongsProject: Tiny-flink
 * @BelongsPackage: org.team3090.simple.Driver
 * @Author: Zhiyang Zhu
 * @CreateTime: 2022-08-16  21:01
 * @Description: 解析配置文件生成operator对象
 * @Version: 1.0
 */
public class Config {
    private String path;

    public Config(String path) {
        this.path = path;
    }

    public List<Operator> scheduler() {
        //配置文件转json
        JSONObject obj = JSONUtil.parseObj(new FileReader(path).readString());
        JSONArray pipeline = obj.getJSONArray("pipeline");

        List<Operator> opList=new ArrayList<>();
        Iterator<Object> iterator = pipeline.iterator();
        while (iterator.hasNext()){
            JSONObject jsonObject = JSONUtil.parseObj(iterator.next());
            Operator operator = new Operator( jsonObject.getStr("name"),jsonObject.getStr("opFunc"), jsonObject.getInt("parallelism"));
            opList.add(operator);
        }
        return opList;

    }
}
