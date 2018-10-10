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

                // 从socket获取信息
                ObjectInputStream input = new ObjectInputStream(socket.getInputStream());
                // 获取消息的顺序要与客户端添加的顺序一致
                String interface_name = input.readUTF(); // 请求调用的接口名称
                System.out.println("调用的服务为：" + interface_name);
                String method_name = input.readUTF();  // 请求调用的方法名称
                System.out.println("调用的方法为：" + method_name);
                Class<?>[] parameterType = (Class<?>[]) input.readObject();  // 被调用方法的参数类型列表
                Object[] arguments = (Object[]) input.readObject();  // 客户端传过来的参数列表
                System.out.println("参数列表为 : " + Arrays.toString(arguments));

                // 根据得到的被调用接口名称得到Server的Class
                Class<?> service_Interface_Class = Class.forName(interface_name);
                // 根据方法名称和参数类型得到Server的method
                Method method = service_Interface_Class.getMethod(method_name, parameterType);
                // 服务实例化
                Object service = service_Interface_Class.newInstance();
                // 反射执行这个方法
                Object result = method.invoke(service, arguments);

                // 写回处理结果
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
