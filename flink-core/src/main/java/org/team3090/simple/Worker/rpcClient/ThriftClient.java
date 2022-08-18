package org.team3090.simple.Worker.rpcClient;
//Sunlly0 2022.8.18
// thrift 客户端，调用 RPCBlockTransfer 函数
// 实现以字符串的形式将上游计算结果传输到下游的thrift服务端

import org.team3090.simple.Worker.rpcClass.JsonString;
import org.team3090.simple.Worker.rpcClass.RPCBlockService;
import org.apache.thrift.TException;
import org.apache.thrift.protocol.TCompactProtocol;
import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.transport.TSocket;
import org.apache.thrift.transport.TTransport;
import org.apache.thrift.transport.TTransportException;
import org.apache.thrift.transport.layered.TFramedTransport;


public class ThriftClient {

//    private static int port =8899;
//    private static String host = "39.99.245.209";

    public void runClient(int port, String host) {
        trythread td = new trythread();
        td.port=port;
        td.host =host;

        for (int i = 0; i <1 ; i++) {//循环创建n个线程
            Thread t = new Thread(td);
            t.start();
        }
    }
}



//客户端可以起多个线程连接服务端
class trythread implements Runnable{
//    public static int port =8899;
//    public static String host = "39.99.245.209";
    public int port;
    public String host;

    // 线程 run 函数，每起一个线程就调用一次 RPC 过程
    public void run(){
        try{
            rpcrun();
        }
        catch(Exception ex) {
        }
    }


    public void rpcrun() throws TTransportException,Exception {
        TTransport transport = new TFramedTransport(new TSocket(host, port), 600);
        //指定编码格式
        TProtocol protocol = new TCompactProtocol(transport);
        //生成客户端
        RPCBlockService.Client client = new RPCBlockService.Client(protocol);
        try{
            transport.open();
            JsonString jsonString = new JsonString();
            jsonString.upstreamResult = "test12345678; "+Thread.currentThread().getName();
            //客户端调用 RPC 过程 ：RPCBlockTransfer
            //将包含了上游计算结果的结构体，jsonString，发送给服务端
            Boolean res = client.RPCBlockTransfer(jsonString);
            //如果
            if (res) {
                System.out.println("传输成功,"+jsonString.upstreamResult);

            } else {
                System.out.println("传输失败");
            }
        } catch (TTransportException e) {
            e.printStackTrace();
        } catch (TException e) {
            e.printStackTrace();
        }finally {
            transport.close();
        }
    }

}