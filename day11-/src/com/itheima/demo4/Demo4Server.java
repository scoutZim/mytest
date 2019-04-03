package com.itheima.demo4;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Demo4Server {
    public static void main(String[] args) throws Exception{
        // 服务端 假设服务的的端口号 6666
        // 1.创建一个ServerSocket对象,代表服务器
        ServerSocket ss = new ServerSocket(6666);
        // 2.等待连接
        Socket socket = ss.accept();// 返回socket对象
        // 3.使用socket对象获取输入流,用来读取客户端写出的数据
        InputStream is = socket.getInputStream();
        // 4.使用输入流读取数据
        byte[] bys = new byte[1024];
        int len = is.read(bys);
        System.out.println("客户端发送过来的数据是:"+new String(bys,0,len));

        // 回写数据

        // 5.使用socket对象获取输出流
        OutputStream os = socket.getOutputStream();
        // 6.使用输出流写出数据
        os.write("客户端,我已经接收到你发送过来的数据啦!".getBytes());
        // 7.关闭流,释放资源
        os.close();
        is.close();
        socket.close();

    }
}
