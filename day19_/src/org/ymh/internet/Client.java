package org.ymh.internet;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class Client {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("localhost",5000);
        OutputStream out = socket.getOutputStream();
        InputStream in = socket.getInputStream();
        out.write("hello".getBytes());
        int len =0;
        byte[] bytes = new byte[1024];
        while ((len=in.read(bytes))!=-1) {
            String s = new String(bytes, 0, len, "utf-8");
            System.out.println("服务器响应：" + s);
        }
    }
}
