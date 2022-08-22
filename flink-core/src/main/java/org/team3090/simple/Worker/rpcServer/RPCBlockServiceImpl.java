package org.team3090.simple.Worker.rpcServer;

//Sunlly0 2022.8.18
// thrift 服务接口的具体实现

//Sunlly0 2022.8.20
// 更新接口，增加 Push,Pull,Biside 三种接口
import org.team3090.simple.Worker.rpcClass.JsonString;
import org.team3090.simple.Worker.rpcClass.RPCBlockService;
import org.apache.thrift.TException;

public class RPCBlockServiceImpl implements RPCBlockService.Iface {

    // Todo:具体实现逻辑根据数据传输需求修改
    @Override
    //RPCBlockTransferPush: 客户端调用该函数，服务端接收到其发送的数据(结构体)，并打印具体的StreamResult
    //return：无返回值
    public void RPCBlockTransferPush(JsonString JsonString) throws TException{
        // 解析数据
        String upstreamResult=JsonString.StreamResult;
        // 打印 Client 端传输过来的结果数据
        System.out.println("push res:"+upstreamResult);
    }

    public JsonString RPCBlockTransferPull() throws TException{
        // 构建服务端将发送的数据
        JsonString jsonString=new JsonString();
        jsonString.StreamResult="test pull:123456";
        // 将数据作为返回值传递给客户端
        return jsonString;
    }

    public String RPCBlockTransferBiside(String str1) throws TException{
        // 构建服务端将发送的数据
        System.out.println(str1);
        String str2="test biside:1234567";
        // 将数据作为返回值传递给客户端
        return str2;
    }
}
