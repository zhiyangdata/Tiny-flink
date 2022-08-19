package org.team3090.simple.Driver;

import com.alibaba.fastjson.JSONObject;
import org.team3090.simple.Worker.Executor;

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
public class Scheduler {
    private ArrayList<String> tasks;
    Executor worker;

    public Scheduler(ArrayList<String> tasks) {
        this.tasks = tasks;
    }
    public void submitJob(){
        int tasknums = tasks.size();
        for(int a = 0;a< tasknums ;a++){
            //向worker提交作业
            worker.submitJob(tasks.get(a),a);   //a 层层 被 用来 分配worker
        }
    }
}
