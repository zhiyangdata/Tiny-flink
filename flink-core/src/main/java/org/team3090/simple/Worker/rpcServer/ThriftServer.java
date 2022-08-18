package org.team3090.simple.Worker.rpcServer;

//Sunlly0 2022.8.18
// Thrift 服务端启动

import org.apache.thrift.TProcessorFactory;
import org.apache.thrift.protocol.TCompactProtocol;
import org.apache.thrift.server.THsHaServer;
import org.apache.thrift.server.TServer;
import org.apache.thrift.transport.TNonblockingServerSocket;
import org.apache.thrift.transport.TTransportException;
import org.apache.thrift.transport.layered.TFramedTransport;
import org.team3090.simple.Worker.rpcClass.RPCBlockService;


public class ThriftServer {

    // runServer:  调用runServer，启动 rpc 服务，以接收上游发送过来的数据
    // 需要提供 port 作为参数来创建 transport，(host 没有显示定义，应该是默认本机)
//    private static int port = 8899;

    public void runServer(int port){
        /*
        四个步骤进行server端的编写
        1.创建Transport
        2.为Transport创建Protocol
        3.为Protocol创建Processor
        4.创建Server并启动
         */
        //设置服务器端口
        try {
            //TNonblockingServerSocket-非堵塞服务模型，经过测试，可以多线程方式响应客户端请求
            TNonblockingServerSocket serverSocket = new TNonblockingServerSocket(port);
            //参数设置
            THsHaServer.Args arg = new THsHaServer.Args(serverSocket).minWorkerThreads(2).maxWorkerThreads(4);

            //创建协议protocol并引入
            arg.protocolFactory(new TCompactProtocol.Factory());
            arg.transportFactory(new TFramedTransport.Factory());

            //创建处理器processor
            RPCBlockService.Processor<RPCBlockServiceImpl> processor = new RPCBlockService.Processor<>(new RPCBlockServiceImpl());
            arg.processorFactory(new TProcessorFactory(processor));

            TServer server = new THsHaServer(arg);
            System.out.println("Thrift PRCBlock 服务端启动成功");
            //暴露服务
            server.serve();
        }catch (TTransportException e) {
            e.printStackTrace();
        }
    }
}
