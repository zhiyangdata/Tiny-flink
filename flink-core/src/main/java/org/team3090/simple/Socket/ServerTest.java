package org.team3090.simple.Socket;

/**
 * @Author ds666
 * @Date 2022/8/20 23:54
 * @Version 1.0
 */
public class ServerTest {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        SocketServer socketServer = new SocketServer();
        socketServer.socketserver(8866);

    }
}
