package net.bluemangoo.socket;

import net.bluemangoo.mctoqq.SendMsg;

import java.io.*;
import java.net.InetSocketAddress;
import java.net.Socket;

import static net.bluemangoo.data.Properties.server_ip;
import static net.bluemangoo.data.Properties.server_port;

public class Client {
    public static void test() {
        try {
            InputStream is;
            OutputStream os;
            Socket s = new Socket();
            try (s) {
                //连接服务器
                s.connect(new InetSocketAddress(server_ip, server_port), 5000);
                is = s.getInputStream();
                os = s.getOutputStream();
            }
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(os));
            SendMsg.log("os");
            //向服务器端发送一条消息
            Long Time = System.currentTimeMillis();
            String session = String.valueOf(Time);
            String testS = "mtq-fb|send{\"session\":\"" + session + "\",\"QQ\":\"670080772\",\"Msg\":\"Test\"},\"Name\":\"ZUZIE\"";
            bw.write(testS);
            SendMsg.log("write");
            //bw.flush();
            //SendMsg.sendToConsole("shutdownOutput");
            //s.shutdownOutput();
            //bw.close();

            //读取服务器返回的消息
            BufferedReader br = new BufferedReader(new InputStreamReader(is));
            SendMsg.log("is");
            String mess = br.readLine();
            SendMsg.log("readLine");
            SendMsg.log("[McToQQ] 服务器返回:" + mess);

            //一堆close
            br.close();
            is.close();
            bw.close();
            os.close();
            s.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}