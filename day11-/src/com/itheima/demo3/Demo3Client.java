package com.itheima.demo3;

import java.io.OutputStream;
import java.net.Socket;

public class Demo3Client {
    public static void main(String[] args) throws Exception{
        // 客户端
        // 1.创建一个Socket对象,代表客户端,请求连接
        Socket socket = new Socket("127.0.0.1",6666);
        // 2.使用socket对象获取输出流对象
        OutputStream os = socket.getOutputStream();
        // 3.使用输出流对象写出数据
        os.write("服务器,你好呀,我是客户端啊".getBytes());
        // 4.关闭流,释放资源
        os.close();
        socket.close();
    }
}
