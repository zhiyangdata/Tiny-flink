package org.team3090.simple.Socket;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;


/**
 * @Author ds666
 * @Date 2022/8/20 20:45
 * @Version 1.0
 */
public class ServerThread extends Thread{
    public int port;
    Map<String, Integer> wordMap = new TreeMap<>();


    public Map<String, Integer> getWordMap() {
        return wordMap;
    }

    public void setWordMap(Map<String, Integer> wordMap) {
        this.wordMap = wordMap;
    }

    public int getPort() {
        return port;
    }
    public void setPort(int port) {
        this.port = port;
    }
    //重写run方法
    @Override
    public void run() {
        try {
            int serverport = this.port;
            ServerSocket ss = new ServerSocket(serverport);
            Socket s = ss.accept();
            System.out.println("监听在端口号："+ serverport);
            //打开输入流
            InputStream is = s.getInputStream();
            DataInputStream dis = new DataInputStream(is);
            //打开输出流
            OutputStream os = s.getOutputStream();
            DataOutputStream dos = new DataOutputStream(os);
            while(true) {
                String msg = dis.readUTF();
//                System.out.println(msg);   //控制台打印测试
//                Scanner sc = new Scanner(System.in);
//                String str = sc.next();
//                //Todo：添加数据处理代码
                dos.writeUTF(msg);    //读入的数据发出数据
                System.out.println(msg);
//
            }
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }


    }

//    public static void main(String[] args) {
//        //创建继承Thread类的对象调用start方法来启动线程
//        MyThread mythread = new MyThread ();
//        MyThread .start();
//    }
}