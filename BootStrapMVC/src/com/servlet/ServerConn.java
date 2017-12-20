package com.servlet;
import java.net.*;
import java.io.*;
/**
手机端代码
手机端作为服务器，获取自己的ip地址，并显示以供客户端连接
*/
public class ServerConn
{
    ServerConn()throws IOException
    {
        //打印本机的IP地址
        InetAddress address=InetAddress.getLocalHost();
        System.out.println("本机的IP地址是"+address.getHostAddress());
        //
        // 创建一个ServerSocket，用于监听客户端Socket的连接请求
        ServerSocket ss = new ServerSocket(30000);
        // 采用循环不断接受来自客户端的请求
        while (true)
        {
            // 每当接受到客户端Socket的请求，服务器端也对应产生一个Socket
            Socket s = ss.accept();
            // 将Socket对应的输出流包装成PrintStream
            PrintStream ps = new PrintStream(s.getOutputStream());
            // 进行普通IO操作
            ps.println("您好，服务器连接成功");
            // 关闭输出流，关闭Socket
            while(true) {
                BufferedReader br = new BufferedReader(new InputStreamReader(s.getInputStream()));
                String line = br.readLine();
                System.out.println("来自客户端的数据：" + line);
                //未来读取身份证信息
                //读取到的信息交由身份验证模块处理
                br=null;
            }

        }
    }
}