package org.team3090.simple.Worker;

/**
 * @BelongsProject: Tiny-flink
 * @BelongsPackage: org.team3090.simple.Worker
 * @Author: Zhiyang Zhu
 * @CreateTime: 2022-08-16  21:12
 * @Description:
 * @Version: 2.0
 */
public class Reduce implements Runnable{
    String udf="com.team.map";
    public void run(){

        //Todo：1. 创建rpc客户端连接，更新配置文件的tasks.task.source （上游Map算子的 rpc server地址）
        //Todo：2. 接收Map算子的rpc server发出的消息，
        //Todo：3. 通过本地rpc服务端发出。
    }

}
