package net.bluemangoo.socket;

import net.bluemangoo.mctoqq.sendMsg;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {
   static sendMsg sm = new sendMsg();
   public static void test() {
      try {
         InputStream is;
         OutputStream os;
         try (Socket s = new Socket("127.0.0.1", 3093)) {

            //构建IO
            is = s.getInputStream();
            os = s.getOutputStream();
         }//端口3093

         BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(os));
         //向服务器端发送一条消息
         Long Time = System.currentTimeMillis();
         String session = String.valueOf(Time);
         bw.write("mtq-fb|send{\"session\":\""+session+"\",\"QQ\":\"670080772\",\"Msg\":\"Test\"},\"Name\":\"ZUZIE\"");
         bw.flush();
         //读取服务器返回的消息
         BufferedReader br = new BufferedReader(new InputStreamReader(is));
         String mess = br.readLine();
         sm.sendToConsole("服务器返回:"+mess);
      } catch (IOException e) {
         e.printStackTrace();
      }
   }
}
