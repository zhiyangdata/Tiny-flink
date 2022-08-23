package org.team3090.simple.Driver;

import org.team3090.simple.Worker.Executor;
import org.team3090.simple.Worker.Executor2;

import java.util.ArrayList;

/**
 * @BelongsProject: Tiny-flink
 * @BelongsPackage: org.team3090.simple.Driver
 * @Author: Zhiyang Zhu
 * @CreateTime: 2022-08-16  21:07
 * @Description: 将task发往worker的调度逻辑
 * @Version: 2.0
 *
 */
public class Scheduler1 {
    private ArrayList<String> tasks;
     Executor2 worker2;

    public Scheduler1(ArrayList<String> tasks) {
        this.tasks = tasks;
    }
    public void submitJob(){
        int tasknums = tasks.size();
        for(int a = 1;a< tasknums ;a=a+2){
            //向worker提交作业
            worker2.submitJob(tasks.get(a),a);   //a 层层 被 用来 分配worker
        }
    }
}
