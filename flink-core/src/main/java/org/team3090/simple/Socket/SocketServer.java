package org.team3090.simple.Socket;

import java.util.Map;
import java.util.TreeMap;

/**
 * @Author ds666
 * @Date 2022/8/20 20:35
 * @Version 1.0
 */
public class SocketServer {

    public void socketserver(int post){
        Map<String, Integer> wordMap = new TreeMap<>();
        ServerThread serverThread = new ServerThread();
        serverThread.setPort(post);
        serverThread.start();

    }
}
