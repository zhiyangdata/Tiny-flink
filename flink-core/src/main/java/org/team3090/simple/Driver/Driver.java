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
public class Driver {
    public static void main(String[] args) {
        Config config = new Config("/usr/data/config.txt");
        ArrayList<String> tasknames = config.scheduler();
        Scheduler scheduler = new Scheduler(tasknames);
        scheduler.submitJob();
    }
}
