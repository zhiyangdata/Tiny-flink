namespace java thrift.generated1

typedef i16 short
typedef i32 int
typedef i64 long
typedef bool boolean
typedef string String

//传输的对象
struct JsonString {
    1:optional String StreamResult;
}

//提供的服务
service RPCBlockService{

    void RPCBlockTransferPush(1:required JsonString JsonString)

    JsonString RPCBlockTransferPull()

    String RPCBlockTransferBiside(1: String content)
}

