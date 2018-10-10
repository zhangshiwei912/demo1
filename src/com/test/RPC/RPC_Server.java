package com.test.RPC;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Method;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Arrays;

public class RPC_Server {
    public static void main(String[] args){
        ServerSocket ss = null;
        Socket socket = null;
        ObjectOutputStream out  = null;
        try {
            ss = new ServerSocket(8012);
            while(true){
                System.out.println("----Server Start!-----");
                socket = ss.accept();

                // ��socket��ȡ��Ϣ
                ObjectInputStream input = new ObjectInputStream(socket.getInputStream());
                // ��ȡ��Ϣ��˳��Ҫ��ͻ�����ӵ�˳��һ��
                String interface_name = input.readUTF(); // ������õĽӿ�����
                System.out.println("���õķ���Ϊ��" + interface_name);
                String method_name = input.readUTF();  // ������õķ�������
                System.out.println("���õķ���Ϊ��" + method_name);
                Class<?>[] parameterType = (Class<?>[]) input.readObject();  // �����÷����Ĳ��������б�
                Object[] arguments = (Object[]) input.readObject();  // �ͻ��˴������Ĳ����б�
                System.out.println("�����б�Ϊ : " + Arrays.toString(arguments));

                // ���ݵõ��ı����ýӿ����Ƶõ�Server��Class
                Class<?> service_Interface_Class = Class.forName(interface_name);
                // ���ݷ������ƺͲ������͵õ�Server��method
                Method method = service_Interface_Class.getMethod(method_name, parameterType);
                // ����ʵ����
                Object service = service_Interface_Class.newInstance();
                // ����ִ���������
                Object result = method.invoke(service, arguments);

                // д�ش�����
                out = new ObjectOutputStream(socket.getOutputStream());
                out.writeObject(result);

            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            try {
                out.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            if (ss != null){
                try {
                    ss.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                ss = null;
            }
        }
    }
}
