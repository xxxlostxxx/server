package server;


import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class ServerDemo {

    /**
     * 读取数据
     *
     * @param socket
     */
    public void handler(Socket socket) {
        try {
            byte[] bytes = new byte[1024];
            InputStream inputStream = socket.getInputStream();
            OutputStream out = socket.getOutputStream();


            while (true) {
                out.write("404 -xxxxx\n".getBytes());
                out.flush();
                //读取数据（阻塞）
                int read = inputStream.read(bytes);
                if (read != -1) {
                    System.out.println(new String(bytes, 0, read));
                } else {
                    break;
                }

            }
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            System.out.println("socket关闭");
            try {
                socket.close();

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
