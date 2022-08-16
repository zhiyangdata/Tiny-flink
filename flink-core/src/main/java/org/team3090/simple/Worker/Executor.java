package org.team3090.simple.Worker;

/**
 * @BelongsProject: Tiny-flink
 * @BelongsPackage: org.team3090.simple.Worker
 * @Author: Zhiyang Zhu
 * @CreateTime: 2022-08-16  21:02
 * @Description: 节点上运行端，执行task
 * @Version: 1.0
 */
public class Executor {
    public void submitJob(String json){
        //向worker提交作业
        if(json.equals("map")){
            Map map = new Map();
            new Thread(map).start();
        }else if(json.equals("reduce")){

        }else if(json.equals("sink")){

        }else if(json.equals("source")){

        }
    }
}
