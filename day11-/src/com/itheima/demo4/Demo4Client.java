package com.itheima.demo4;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class Demo4Client {
    public static void main(String[] args) throws Exception{
        // 客户端
        // 1.创建一个Socket对象,代表客户端,请求连接
        Socket socket = new Socket("127.0.0.1",6666);
        // 2.使用socket对象获取输出流对象
        OutputStream os = socket.getOutputStream();
        // 3.使用输出流对象写出数据
        os.write("服务器,你好呀,我是客户端啊".getBytes());

        // 接收服务器回写的数据

        // 4.使用socket对象获取输入流对象
        InputStream is = socket.getInputStream();
        // 5.使用输入流对象读取数据
        byte[] bys = new byte[1024];
        int len = is.read(bys);
        System.out.println("服务器回写的数据是:"+new String(bys,0,len));

        // 6.关闭流释放资源
        is.close();
        os.close();
        socket.close();
    }
}
