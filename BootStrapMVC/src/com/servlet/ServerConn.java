package com.servlet;
import java.net.*;
import java.io.*;
/**
�ֻ��˴���
�ֻ�����Ϊ����������ȡ�Լ���ip��ַ������ʾ�Թ��ͻ�������
*/
public class ServerConn
{
    ServerConn()throws IOException
    {
        //��ӡ������IP��ַ
        InetAddress address=InetAddress.getLocalHost();
        System.out.println("������IP��ַ��"+address.getHostAddress());
        //
        // ����һ��ServerSocket�����ڼ����ͻ���Socket����������
        ServerSocket ss = new ServerSocket(30000);
        // ����ѭ�����Ͻ������Կͻ��˵�����
        while (true)
        {
            // ÿ�����ܵ��ͻ���Socket�����󣬷�������Ҳ��Ӧ����һ��Socket
            Socket s = ss.accept();
            // ��Socket��Ӧ���������װ��PrintStream
            PrintStream ps = new PrintStream(s.getOutputStream());
            // ������ͨIO����
            ps.println("���ã����������ӳɹ�");
            // �ر���������ر�Socket
            while(true) {
                BufferedReader br = new BufferedReader(new InputStreamReader(s.getInputStream()));
                String line = br.readLine();
                System.out.println("���Կͻ��˵����ݣ�" + line);
                //δ����ȡ���֤��Ϣ
                //��ȡ������Ϣ���������֤ģ�鴦��
                br=null;
            }

        }
    }
}