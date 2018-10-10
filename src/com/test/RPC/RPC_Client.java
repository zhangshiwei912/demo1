package com.test.RPC;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class RPC_Client {
    public void hello(String name){

        ObjectOutputStream out = null;
        Socket socket = null;
        try {
            // 即将调用的接口名
            String interFaceName = "HelloWorldServiceImpl";
            // 即将调用的方法名
            String methodName = "hello";
            // 参数类型列表
            Class<?>[] arguments_types = {java.lang.String.class};
            // 参数
            Object[] arguments = {name};


            socket = new Socket("127.0.0.1", 8012);

            // 将调用的信息写入out
            out = new ObjectOutputStream(socket.getOutputStream());
            out.writeUTF(interFaceName);
            out.writeUTF(methodName);
            out.writeObject(arguments_types);
            out.writeObject(arguments);

            // 获取结果
            ObjectInputStream in = new ObjectInputStream(socket.getInputStream());
            Object result = in.readObject();

            System.out.println(result.toString());

        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            try {
                out.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args){
        RPC_Client c = new RPC_Client();
        c.hello("RPC");
    }
}
