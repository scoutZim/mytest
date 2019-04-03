package com.itheima.demo1;

import java.io.PrintStream;

/*
缓冲流\高效流:
    字节缓冲流:BufferedInputStream,BufferedOutputStream
    字符缓冲流:BufferedReader,BufferedWriter
        额外功能:
            public String readLine(); 读取一行数据
            public void newLine();根据系统自动换行
转换流:
    InputStreamReader: 字节流通向字符流的桥梁
        构造方法:
            public InputStreamReader(InputStream is); 使用平台默认的编码,idea默认编码是utf-8
            public InputStreamReader(InputStream is,String charset); 指定编码读取数据

    OutputStreamWriter: 字符流通向字节流的桥梁
        构造方法:
            public OutputStreamWriter(OutputStream os);// 使用平台默认编码写出数据
            public OutputStreamWriter(OutputStream os,String charset);// 指定编码写出数据

序列化\反序列化流:
    序列化: 把对象 转换为 二进制数据
        ObjectOutputStream:    writeObject(); 写出对象

    反序列化: 把二进制数据 转换为 对象
        ObjectInputStream:   readObject();读取对象


打印流:
    PrintStream:
        构造方法:
            public PrintStream(String path);

        如果想要更改系统的打印目的地:
            System中的 setOut(PrintStream ps) 修改打印目的地
 */
public class Demo1 {
    public static void main(String[] args) throws Exception{
        PrintStream ps = new PrintStream("day11\\a.txt");
        ps.println("111");

        System.setOut(ps);
        System.out.println("哈哈,你好啊");
    }
}
