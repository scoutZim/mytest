package com.itheima.demo5;

import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Demo5Server {
    public static void main(String[] args) throws Exception{
        // 1. 【服务端】输入流，读取文件数据到服务端程序。
        // 1.1 创建ServerSocket对象,
        ServerSocket ss = new ServerSocket(6666);

        while (true){
            // 1.2 使用ServerSocket对象调用accept()方法,等待连接,连接成功会得到socket对象
            Socket socket = ss.accept();

            new Thread(()->{
                try {
                    // 1.3 使用socket对象获取输入流对象,
                    InputStream is = socket.getInputStream();

                    // 2. 【服务端】输出流，写出文件数据到服务器硬盘中
                    // 2.1 创建一个字节输出流对象,封装目的地文件
                    FileOutputStream fos = new FileOutputStream("day11\\"+System.currentTimeMillis()+".jpg");

                    // 1.4 使用输入流对象读取数据
                    // 1.5 定义一个字节数组,用来存储读取到的字节数据
                    //      定义一个int类型的变量,用来存储读取到的有效字节数
                    byte[] bys = new byte[8192];
                    int len;

                    // 1.6 循环读取数据
                    while ((len = is.read(bys)) != -1){
                        // 2.2 使用输出流对象写出数据
                        fos.write(bys,0,len);
                    }

                    // 3.关闭流,释放资源
                    fos.close();
                    is.close();
                    socket.close();
                }catch (Exception e){

                }
            }).start();
        }
    }
}
