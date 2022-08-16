package org.team3090.simple.Driver;

/**
 * @BelongsProject: Tiny-flink
 * @BelongsPackage: org.team3090.simple.Driver
 * @Author: Zhiyang Zhu
 * @CreateTime: 2022-08-16  21:02
 * @Description: 作业提交
 * @Version: 1.0
 */
public class Driver {
    public static void main(String[] args) {
        Config config = new Config("/usr/data/wordcount.txt");
        String[] tasks = config.scheduler();
        Scheduler scheduler = new Scheduler(tasks);
        scheduler.submitJob();
    }
}