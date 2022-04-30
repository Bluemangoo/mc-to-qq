package net.bluemangoo.socket;

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
   public static void Trun() {
      try {
         Socket s = new Socket("127.0.0.1",3093);//端口3093
         
         //构建IO
         InputStream is = s.getInputStream();
         OutputStream os = s.getOutputStream();
         
         BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(os));
         //向服务器端发送一条消息
         bw.write("Test,服务器应返回此消息,Test");
         bw.flush();
         
         //读取服务器返回的消息
         BufferedReader br = new BufferedReader(new InputStreamReader(is));
         String mess = br.readLine();
         System.out.println("服务器返回:"+mess);
      } catch (IOException e) {
         e.printStackTrace();
      }
   }
}
