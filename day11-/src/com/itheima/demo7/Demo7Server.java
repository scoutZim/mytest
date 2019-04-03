package com.itheima.demo7;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Arrays;

public class Demo7Server {
    public static void main(String[] args) throws Exception {
        // 模拟网站服务器
        /*
            思路:
                1.创建一个ServerSocket对象
                2.使用ServerSocket调用accept(),等待连接,如果连接成功就会返回Socket对象
                3.通过Socket对象获取输入流,用来读取请求信息
                4.把获取到的输入流转换为字符缓冲输入流
                5.使用字符缓冲输入流读取第一行请求信息
                6.对获取到的第一行请求信息进行分割来获取请求网页的路径

                7.创建一个字节输入流对象,封装数据源文件
                  通过socket对象获取输出流
                8.使用字节输入流对象读取数据
                   8.1 创建一个字节数组,用来存储读取到的字节数据
                   8.2 创建一个int类型的变量,用来存储读取到的有效字节数
                9.循环读取,只要满足条件,就一直读取
                10.写出数据
                11.关闭流

         */

//        1.创建一个ServerSocket对象
        ServerSocket ss = new ServerSocket(6666);

        while(true){
//        2.使用ServerSocket调用accept(),等待连接,如果连接成功就会返回Socket对象
            Socket socket = ss.accept();

            new Thread(()->{
               try {
                   //        3.通过Socket对象获取输入流,用来读取请求信息
                   InputStream is = socket.getInputStream();

//        4.把获取到的输入流转换为字符缓冲输入流
                   BufferedReader br = new BufferedReader(new InputStreamReader(is));

//        5.使用字符缓冲输入流读取第一行请求信息
                   String line = br.readLine();

//        6.对获取到的第一行请求信息进行分割来获取请求网页的路径
                   String[] arr = line.split(" ");
                   String path = arr[1].substring(1);
                   System.out.println(path);


//        7.创建一个字节输入流对象,封装数据源文件
                   FileInputStream fis = new FileInputStream(path);
//        通过socket对象获取输出流
                   OutputStream os = socket.getOutputStream();

//        8.使用字节输入流对象读取数据
//        8.1 创建一个字节数组,用来存储读取到的字节数据
//        8.2 创建一个int类型的变量,用来存储读取到的有效字节数
                   byte[] bys = new byte[8192];
                   int len;

                   // 额外增加
                   // 写入HTTP协议响应头,固定写法
                   os.write("HTTP/1.1 200 OK\r\n".getBytes());
                   os.write("Content-Type:text/html\r\n".getBytes());
                   // 必须要写入空行,否则浏览器不解析
                   os.write("\r\n".getBytes());


//        9.循环读取,只要满足条件,就一直读取
                   while((len = fis.read(bys)) != -1){
//        10.写出数据
                       os.write(bys,0,len);
                   }

//        11.关闭流
                   os.close();
                   fis.close();
                   br.close();
                   socket.close();
               }catch (Exception e){

               }

            }).start();

        }

    }
}
