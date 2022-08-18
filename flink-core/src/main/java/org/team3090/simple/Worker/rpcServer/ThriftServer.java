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
//    private static int port;
//    private static int port = 8899;

    public void runServer(int port){
        /*
        四个步骤进行server端的编写
        1.创建Transport
        2.为Transport创建Protocol
        3.为Protocol创建Processor
        4.创建Server并启动
         */
        //设置服务器端口  TNonblockingServerSocket-非堵塞服务模型，可以多线程响应客户端请求
        try {
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
