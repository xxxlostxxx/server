package server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author youzhu@dian.so
 * @version 1.0.0
 * @Date 2018-09-06
 * @Copyright 北京伊电园网络科技有限公司 2016-2018 © 版权所有 京ICP备17000101号
 */
public class ClientDemo {


    public static void main(String[] args) throws IOException {
        ServerDemo serverDemo = new ServerDemo();
        //创建线程池
        ExecutorService newCachedThreadPool = Executors.newCachedThreadPool();
        //创建socket服务，监听10101端口
        ServerSocket serverSocket = new ServerSocket(10101);
        System.out.println("服务器启动！");
        while(true){
            //获取一个套接字（阻塞）
            final Socket socket = serverSocket.accept();
            System.out.println("来了一个新的客户端！");
            /*newCachedThreadPool.execute(new Runnable() {
                @Override
                public void run() {
                    //业务处理
                    serverDemo.handler(socket);
                }
            });*/

            serverDemo.handler(socket);
        }
    }



}
