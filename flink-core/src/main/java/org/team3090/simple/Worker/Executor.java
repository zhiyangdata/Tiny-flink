package org.team3090.simple.Worker;

/**
 * @BelongsProject: Tiny-flink
 * @BelongsPackage: org.team3090.simple.Worker
 * @Author: Zhiyang Zhu
 * @CreateTime: 2022-08-16  21:02
 * @Description: 节点上运行端，执行task
 * @Version: 2.0
 */
public class Executor {
    public void submitJob(String taskname,int tasknow){
        //向worker提交作业
        if(taskname.startsWith("source")){
            BlockManager blockManagerMap = new BlockManager();
            blockManagerMap.createrpc("source",tasknow);
            Source source = new Source();
            new Thread(source).start();
        }else if(taskname.startsWith("map")){
            BlockManager blockManagerMap = new BlockManager();
            blockManagerMap.createrpc("map",tasknow);
            Map map = new Map();
            new Thread(map).start();
        }else if
        (taskname.startsWith("reduce")){
            BlockManager blockManagerMap = new BlockManager();
            blockManagerMap.createrpc("reduce",tasknow);
            Reduce reduce = new Reduce();
            new Thread(reduce).start();
        }else if(taskname.startsWith("sink")){
            BlockManager blockManagerMap = new BlockManager();
            blockManagerMap.createrpc("sink",tasknow);
            Sink sink = new Sink();
            new Thread(sink).start();
        }
    }
}
