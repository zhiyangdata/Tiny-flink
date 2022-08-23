package org.team3090.simple.Worker;

import com.alibaba.fastjson.JSONObject;
import org.team3090.simple.Driver.ReadConfig;
import org.team3090.simple.Worker.rpcServer.ThriftServer;

import java.io.IOException;
import java.util.concurrent.ExecutionException;

/**
 * @BelongsProject: Tiny-flink
 * @BelongsPackage: org.team3090.simple.Worker
 * @Author: Zhiyang Zhu
 * @CreateTime: 2022-08-16  21:12
 * @Description:
 * @Version: 2.0
 */
public class  Source implements Runnable{
    String udf="com.team.map";
    private int post;

    public int getPost() {
        return post;
    }
    public void setPost(int post) {
        this.post = post;
    }

    public void run(){
        KafkaUtil kafkaUtil = new KafkaUtil();

        try {
            kafkaUtil.kafkaconsumer("hadoop1","first");
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
//        int post = this.post;
//        ThriftServer thriftServer = new ThriftServer();
//        thriftServer.runServer(post);
//        ReadConfig readConfig = new ReadConfig();
//        JSONObject obj = readConfig.readconfig("./result.json");
//        int a =obj.getJSONArray(("tasks")).size()-1; //找
//        for (int i =a; i >=0 ; i--) {
//            if(obj.getJSONArray(("tasks")).getJSONObject(0).containsValue("taskname")){
//
//                //Todo：1. 监听，创建rpc客户端连接
//                //Todo：2. 接收Source算子的rpc server发出的消息，
//                //Todo：3. 通过本地rpc服务端发出。
//
//                break;
//            }
//        }



    }

}
