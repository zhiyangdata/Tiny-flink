package org.team3090.simple.Worker.rpcClient;
// Sunlly0 2022.8.18
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
    // runClient: 当上游要向下游发送数据的时候，调用runClient 函数。
    // 需要提供 host, port, 传输的String 作为参数
    //    private static int port =8899;
    //    private static String host = "39.99.245.209";

    public void runClient(int port, String host,String upstreamResult) {
        trythread td = new trythread();
        td.port=port;
        td.host =host;
        td.upstreamResult=upstreamResult;

        for (int i = 0; i <1 ; i++) {//循环创建n个线程。此处暂时令 n=1
            Thread t = new Thread(td);
            t.start();
        }
    }
}

//客户端可以起多个线程连接服务端
class trythread implements Runnable{

    public int port;
    public String host;

    public String upstreamResult;

    // 线程 run 函数，每起一个线程就调用一次 RPC 过程
    public void run(){
        try{
            rpcrun();
        }
        catch(Exception ex) {
        }
    }

    public void rpcrun() throws TTransportException,Exception {
        TTransport transport = new TFramedTransport(new TSocket(this.host, this.port), 600);
        //指定编码格式
        TProtocol protocol = new TCompactProtocol(transport);
        //生成客户端
        RPCBlockService.Client client = new RPCBlockService.Client(protocol);
        try{
            transport.open();

            // Todo:根据需要采用 Push 模式或 Pull 模式
            JsonString jsonString = new JsonString();

            //Push 尝试
//            jsonString.upstreamResult = "test12345678; "+Thread.currentThread().getName();
            jsonString.StreamResult=this.upstreamResult;
            //客户端调用 RPC 过程 ：RPCBlockTransferPush
            //将包含了上游计算结果的结构体jsonString，发送给服务端
            client.RPCBlockTransferPush(jsonString);
            System.out.println("Push 传输成功,内容："+jsonString.StreamResult);

            //Pull 尝试
            //客户端调用 RPC 过程 ：RPCBlockTransferPull
            //服务端将将包含了上游计算结果的结构体jsonString，以return 的方式返回给客户端
            jsonString=client.RPCBlockTransferPull();
            System.out.println("Pull 传输成功,内容："+jsonString.StreamResult);


        } catch (TTransportException e) {
            e.printStackTrace();
        } catch (TException e) {
            e.printStackTrace();
        }finally {
            transport.close();
        }
    }

}