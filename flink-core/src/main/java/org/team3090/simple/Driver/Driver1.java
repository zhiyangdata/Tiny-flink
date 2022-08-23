package org.team3090.simple.Driver;

import java.util.ArrayList;

/**
 * @BelongsProject: Tiny-flink
 * @BelongsPackage: org.team3090.simple.Driver
 * @Author: Zhiyang Zhu
 * @CreateTime: 2022-08-16  21:02
 * @Description: 作业提交
 * @Version: 2.0
 */
public class Driver1 {
    public static void main(String[] args) {
        ReadConfig readConfig = new ReadConfig("./result.json");
        ArrayList<String> tasknames = readConfig.scheduler();
        System.out.println(tasknames);
        Scheduler1 scheduler1 = new Scheduler1(tasknames);
        scheduler1.submitJob();
    }
}
