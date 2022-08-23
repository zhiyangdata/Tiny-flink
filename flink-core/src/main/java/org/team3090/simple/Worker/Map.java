package org.team3090.simple.Worker;

import org.team3090.simple.Socket.SocketClient;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;

/**
 * @BelongsProject: Tiny-flink
 * @BelongsPackage: org.team3090.simple.Worker
 * @Author: Zhiyang Zhu
 * @CreateTime: 2022-08-16  21:12
 * @Description:
 * @Version: 2.0
 */
public class Map implements Runnable{
    String udf="com.team.map";
    private int post;

    public int getPost() {
        return post;
    }
    public void setPost(int post) {
        this.post = post;
    }
    public void run(){
        String ip = null;
        int   bzw = 0; //写死两个
        if(post%2==1){
            ip = "39.99.245.209";
        }else{
            ip = "8.142.30.177";
        }
        SocketClient socketClient = new SocketClient();
        socketClient.socketclient(ip,post-1);

        Socket s = null;
        try {
            s = new Socket("8.142.30.177",post);
        } catch (IOException e) {
            e.printStackTrace();
        }
        //打开输出流
        OutputStream os = null;
        try {
            os = s.getOutputStream();
        } catch (IOException e) {
            e.printStackTrace();
        }
        DataOutputStream dos = new DataOutputStream(os);

        while(true){
            String nowdatas = socketClient.queue.poll();
            try {
                dos.writeUTF(nowdatas);
            } catch (IOException e) {
                e.printStackTrace();
            }

        }


//        if(bzw==0){
//            Socket s = null;
//            try {
//                s = new Socket("8.142.30.177",post);
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//            //打开输出流
//            OutputStream os = null;
//
//            DataOutputStream dos = new DataOutputStream(os);
//            dos.writeUTF();
//        }

        //Todo：1. 创建rpc客户端连接，更新配置文件的tasks.task.source （上游source算子的 rpc server地址）
        //Todo：2. 接收Source算子的rpc server发出的消息，
        //Todo：3. 通过本地rpc服务端发出。


    }

}
