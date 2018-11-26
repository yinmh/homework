package org.ymh.internet;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(5000);
        System.out.println("服务器已启动,等待连接");
        int count =1;
        while (true) {
            count++;
            synchronized (Server.class){
                int finalCount = count;
                new Thread(()-> {
                    try {
                        Socket socket = serverSocket.accept();
                        System.out.println("第"+ finalCount +"个客户机已经连接");
                        respond(socket);

                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }).start();
            }
            }
        }

    public static void respond(Socket socket) throws IOException {
        OutputStream out = socket.getOutputStream();
        InputStream in = socket.getInputStream();
        int len =0;
        byte[] bytes = new byte[1024];
        while ((len=in.read(bytes))!=-1){
            String s = new String(bytes, 0, len, "utf-8");
            System.out.println("客户端请求："+s);
            out.write(("服务器响应"+s).getBytes());
        }

    }
}
