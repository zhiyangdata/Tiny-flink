package org.team3090.simple.Worker;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @BelongsProject: Tiny-flink
 * @BelongsPackage: org.team3090.simple.Worker
 * @Author: Zhiyang Zhu
 * @CreateTime: 2022-08-16  21:02
 * @Description: 节点上运行端，执行task    ,服务端端口990*
 * @Version: 2.0
 */
public class Executor2 {
    public void submitJob(String taskname,int tasknow){
        //向worker提交作业
        if(taskname.startsWith("source")){
            BlockManager blockManagerMap = new BlockManager();
            blockManagerMap.createrpc("source",tasknow);
            Source source = new Source();
            source.setPost(tasknow+9900);
            new Thread(source).start();
        }else if(taskname.startsWith("map")){
            Queue<String> queue = new LinkedList<String>();
            BlockManager blockManagerMap = new BlockManager();
            blockManagerMap.createrpc("map",tasknow,queue);
            Map map = new Map();
            map.setPost(tasknow+9900);
            new Thread(map).start();
//        }else if
//        (taskname.startsWith("reduce")){
//            BlockManager blockManagerMap = new BlockManager();
//            blockManagerMap.createrpc("reduce",tasknow);
//            Reduce reduce = new Reduce();
////            reduce.setPost(tasknow+9900);
//            new Thread(reduce).start();
//        }else if(taskname.startsWith("sink")){
//            BlockManager blockManagerMap = new BlockManager();
//            blockManagerMap.createrpc("sink",tasknow);
//            Sink sink = new Sink();
////            sink.setPost(tasknow+9900);
//            new Thread(sink).start();
        }
    }
}
