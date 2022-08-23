package org.team3090.simple.Socket;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
/**
 * @Author ds666
 * @Date 2022/8/20 23:34
 * @Version 1.0
 */
public class SocketClient {
    public Queue<String> queue = new LinkedList<String>();

    public Queue<String> getQueue() {
        return queue;
    }
    public void setQueue(Queue<String> queue) {
        this.queue = queue;
    }

    public void socketclient(String host, int post) {
        try {
            Socket s = new Socket(host, post);
//            //打开输出流
//            OutputStream os = s.getOutputStream();
//            DataOutputStream dos = new DataOutputStream(os);
            //打开输入流
            InputStream is = s.getInputStream();
            DataInputStream dis = new DataInputStream(is);
            while (true) {
//                Scanner sc = new Scanner(System.in);
//                String str = sc.next();
//                dos.writeUTF(str);
                String msg = dis.readUTF();
                queue.add(msg);


//                System.out.println("收到服务端的信息：" + msg);
            }
        } catch (UnknownHostException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
