package org.team3090.simple.Driver;

import org.apache.zookeeper.Op;
import org.team3090.simple.Worker.Executor;

import java.util.List;

/**
 * @BelongsProject: Tiny-flink
 * @BelongsPackage: org.team3090.simple.Driver
 * @Author: Zhiyang Zhu
 * @CreateTime: 2022-08-16  21:07
 * @Description: 将task发往worker的调度逻辑 ，内部须增加op上下游依赖的处理逻辑 @ws
 * @Version: 1.0
 */
public class Scheduler {
    private List<Operator> tasks;
    private Executor worker;
    public Scheduler() {
        worker=new Executor();
    }

    public Scheduler(List<Operator> tasks) {
        this.tasks = tasks;
    }
    public void submitJob(){
        //向worker提交作业
        tasks.stream().map(x->x.toString()).forEach(System.out::println);
//        worker.submitJob(tasks.get(0).toString());
        //
    }
}
