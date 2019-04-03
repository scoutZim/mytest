package com.itheima.demo3;

import java.net.Socket;

/*
TCP通信程序:
    两端通信时步骤：
        1. 服务端程序，需要事先启动，等待客户端的连接。
        2. 客户端主动连接服务器端，连接成功才能通信。服务端不可以主动连接客户端。

    在Java中，提供了两个类用于实现TCP通信程序：
        1. 客户端：java.net.Socket 类表示。创建Socket对象，向服务端发出连接请求，服务端响应请求，两者建立连接开始通信。
        2. 服务端：java.net.ServerSocket 类表示。创建ServerSocket对象，相当于开启一个服务，并等待客户端的连接。

    Socket 类：该类实现客户端套接字，套接字指的是两台设备之间通讯的端点
        构造方法
            - public Socket(String host, int port) :创建套接字对象并将其连接到指定主机上的指定端口号。
                                                    如果指定的host是null ，则相当于指定地址为回送地址。
        成员方法
            - public InputStream getInputStream() ： 返回此套接字的输入流。
            - public OutputStream getOutputStream() ： 返回此套接字的输出流。
            - public void close() ：关闭此套接字。
            - public void shutdownOutput() ： 禁用此套接字的输出流

     ServerSocket类：这个类实现了服务器套接字，该对象等待通过网络的请求。
         构造方法
            - public ServerSocket(int port) ：使用该构造方法在创建ServerSocket对象时，
                                              就可以将其绑定到一个指定的端口号上，参数port就是端口号
         成员方法
            - public Socket accept() ：侦听并接受连接，返回一个新的Socket对象，用于和客户端实现通信。
                                        该方法会一直阻塞直到建立连接
                          如果客户端没有发送请求或者没有和服务器连接成功,那么久会一直阻塞,如果连接成功,就返回Socket对象

案例:
案例1.客户端发送字符串数据给服务器
案例2.服务器回写字符串数据给客户端

案例3.客户端上传文件给服务器
案例4.服务器回写数据给客户端,告诉客户端上传成功

案例5.模拟浏览器访问网页,服务器返回网页数据给浏览器展示出来(服务器端的代码)
 */
public class Demo3 {
    public static void main(String[] args) throws Exception{
        Socket socket = new Socket("127.0.0.1",6666);
    }
}
