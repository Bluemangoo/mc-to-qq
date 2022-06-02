/**
 * @Author: Bluemangoo
 * @date: 2022.04
 * @Copyright: 2022 Bluemangoo. All rights reserved.
 * @Description: socket server
 */
package net.bluemangoo.socket;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import net.bluemangoo.mctoqq.SendMsg;
import net.bluemangoo.socket.event.GetMSGServer;
import org.bukkit.ChatColor;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Collection;

class ClientMessage {
    private String QQ;
    private String Msg;
    private String Session;
    private String Name;

    public String getQQ() {
        return this.QQ;
    }

    public String getMsg() {
        return this.Msg;
    }

    public String getSession() {
        return this.Session;
    }

    public String getName() {
        return this.Name;
    }
}

public class Server {
    //private Thread serverThread;
    ArrayList<ConnectClient> connectClientList;
    private Collection<GetMSGServer> listeners;
    private Thread serverThread;

    public void run() {
        serverThread = new Thread(() -> {
            try {
                try (ServerSocket ss = new ServerSocket(3093)) {
                    SendMsg.log("启动服务器于3093端口");
                    while (true) {
                        Socket s = ss.accept();
                        SendMsg.log("客户端:" + s.getInetAddress() + "已连接到服务器");
                        BufferedReader br = new BufferedReader(new InputStreamReader(s.getInputStream()));
                        //读取客户端发送来的消息
                        String mess = br.readLine();
                        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(s.getOutputStream()));
                        String retMsg = "";
                        if (mess.startsWith("mtq-fb|send")) {//判断头，防止无意义消息
                            //send 发送信息 info 获取游戏/玩家信息(以后肯定做)
                            Gson gson = new GsonBuilder().create();
                            ClientMessage cm = gson.fromJson(mess, ClientMessage.class);
                            if (Long.parseLong(cm.getSession()) >= System.currentTimeMillis() + 15) {//判断传来的session是不是正确的
                                send(cm.getMsg(), cm.getQQ(), cm.getName());
                                retMsg = "Success";
                            }
                        } else {
                            retMsg = "Error";
                        }
                        bw.write(retMsg);
                        bw.flush();
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }

    public void start() {//运行socket线程
        serverThread.start();
    }

    public void stop(){
        serverThread=null;
    }

    public void send(String msg, String QQ, String name) {
        String Message;
        Message = ChatColor.GOLD + "[QQ]" + ChatColor.RESET + "<" + name + "> " + msg;
        SendMsg.broadcast(Message);
    }
}

