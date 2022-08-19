package org.team3090.simple.Worker.rpcServer;

//Sunlly0 2022.8.18
// thrift 服务接口的具体实现

import org.team3090.simple.Worker.rpcClass.JsonString;
import org.team3090.simple.Worker.rpcClass.RPCBlockService;
import org.apache.thrift.TException;

public class RPCBlockServiceImpl implements RPCBlockService.Iface {

    @Override
    //RPCBlockTransfer: 客户端调用该函数，服务端接收到其发送的数据(结构体)，并打印具体的upstreamResult
    //return：如果接收到的字符串不为null ，返回给客户端true，否则返回false
    public boolean RPCBlockTransfer(JsonString JsonString) throws TException{
        // 解析数据
        String upstreamResult=JsonString.upstreamResult;
        // 打印 Client 端传输过来的结果数据
        System.out.println("res:"+upstreamResult);
        if(upstreamResult != null ){
            return true;
        }
        else{
            return false;
        }
    }
}
