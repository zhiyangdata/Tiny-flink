package org.team3090.simple.Driver;

import org.team3090.simple.Worker.Executor;

/**
 * @BelongsProject: Tiny-flink
 * @BelongsPackage: org.team3090.simple.Driver
 * @Author: Zhiyang Zhu
 * @CreateTime: 2022-08-16  21:07
 * @Description: 将task发往worker的调度逻辑
 * @Version: 1.0
 */
public class Scheduler {
    private String[] tasks;
    private Executor worker;
    public Scheduler() {

    }

    public Scheduler(String[] tasks) {
        this.tasks = tasks;
    }
    public void submitJob(){
        //向worker提交作业
        worker.submitJob(tasks[0]);
        //
    }
}
