package org.team3090.simple.Socket;

/**
 * @Author ds666
 * @Date 2022/8/20 23:40
 * @Version 1.0
 */
public class ClientTest {
    public static void main(String[] args) {
        SocketClient socketClient = new SocketClient();
        socketClient.socketclient("127.0.0.1", 8866);
    }
}
