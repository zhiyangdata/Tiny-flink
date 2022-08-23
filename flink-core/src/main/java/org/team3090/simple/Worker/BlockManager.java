package org.team3090.simple.Worker;

import com.alibaba.fastjson.JSONObject;
import org.team3090.simple.Driver.Config;
import org.team3090.simple.Socket.SocketServer;

import java.util.Objects;
import java.util.Queue;

/**
 * @BelongsProject: Tiny-flink
 * @BelongsPackage: org.team3090.simple.Worker
 * @Author: Zhiyang Zhu
 * @CreateTime: 2022-08-16  21:03
 * @Description: 只创建 RPC本地文件传输服务端
 * @Version: 2.0
 * Todo-------在Worker上创建rpcserver(localip,localpost)
 */
public class BlockManager {
    JSONObject obj = Config.obj;  // 目前是Config更新后的配置文件
    public void createrpc(String taskname, int tasknow, Queue<String> queue){
        String local= null;   //本机server
        String localip= null;   //本机s0  erver
        int localpost= 9900+tasknow;   //本机server

        if(tasknow%2==0){
            {
                localip = "39.99.245.209";
                local = localip+":"+localpost;
                // Todo: 在Worker1上创建rpcserver(localip,localpost)
                SocketServer socketServer = new SocketServer();
                socketServer.socketserver(localpost);
            }
                //向Master注册：将rpc server ip+post 传到json对应的任务中
            for (int i =0; i < obj.getJSONArray(("tasks")).size()-1; i++) {
                if(obj.getJSONArray(("tasks")).getJSONObject(i).containsValue(taskname)){
                    JSONObject objchange = obj.getJSONArray(("tasks")).getJSONObject(i);
                    objchange.put("local",local);  //注册：只提供本机server地址
                    break;
                }
            }
                changejson(); //创建一个更新一下配置文件的tasks.task.local （rpc server）
        }
    }
    /**
     * @Description: source特殊，不需要处理数据

     * @return: void
     * @Author: ws
     * @Date: 2022/8/22 1:16
     * @version 1.0
     */
    public void createrpc(String taskname, int tasknow){
        String local= null;   //本机server
        String localip= null;   //本机s0  erver
        int localpost= 9900+tasknow;   //本机server

        if(tasknow%2==0){
            {
                localip = "39.99.245.209";
                local = localip+":"+localpost;
                // Todo: 在Worker1上创建rpcserver(localip,localpost)
                SocketServer socketServer = new SocketServer();
                socketServer.socketserver(localpost);
            }
//      -测试source      //向Master注册：将rpc server ip+post 传到json对应的任务中
//            for (int i =0; i < obj.getJSONArray(("tasks")).size()-1; i++) {
//                if(obj.getJSONArray(("tasks")).getJSONObject(i).containsValue(taskname)){
//                    JSONObject objchange = obj.getJSONArray(("tasks")).getJSONObject(i);
//                    objchange.put("local",local);  //注册：只提供本机server地址
//                    break;
//                }
//            }
//            changejson(); //创建一个更新一下配置文件的tasks.task.local （rpc server）
        }
    }
    public void changejson(){
        Config.obj=this.obj;
    }

}
























