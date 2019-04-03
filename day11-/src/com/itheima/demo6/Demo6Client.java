package com.itheima.demo6;
/*
案例3.客户端上传文件给服务器

 */

import java.io.FileInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class Demo6Client {
    public static void main(String[] args) throws Exception{

        // 2. 【客户端】输出流，写出文件数据到服务端
        // 2.1 创建Socket对象,请求连接
        Socket socket = new Socket("127.0.0.1",6666);
        // 2.2 通过socket对象获取输出流对象,
        OutputStream os = socket.getOutputStream();

        // 1. 【客户端】输入流，从硬盘读取文件数据到程序中。
        // 1.1 创建一个字节输入流对象,封装数据源文件
        FileInputStream fis = new FileInputStream("day11\\a.jpg");

        // 1.2 创建一个字节数组,用来存储读取到的字节数据
        //     创建一个int类型的变量,用来存储读取到的有效字节数
        byte[] bys = new byte[8192];
        int len;

        // 1.3 循环读取数据,只要满足条件,就一直读取
        while((len = fis.read(bys)) != -1){
        // 2.3 写出数据
            os.write(bys,0,len);
        }
        // 客户端在等待服务器回写的数据
        // 禁用套接字
        socket.shutdownOutput();// 告诉服务器不糊再写数据了

        // 接收服务器回写的数据
        // 通过Socket对象获取输入流对象
        InputStream is = socket.getInputStream();
        // 使用输入流对象读取数据
        byte[] bytes = new byte[1024];
        int len2 = is.read(bytes);
        System.out.println("服务器回写的数据是:"+new String(bytes,0,len2));

        // 3. 关闭流,释放资源
        is.close();
        fis.close();
        os.close();
        socket.close();
    }
}
