/**
 * @Author: Bluemangoo
 * @date: 2022.04
 * @Copyright: 2022 Bluemangoo. All rights reserved.
 * @Description: socket server
 */
package net.bluemangoo.socket;

import net.bluemangoo.socket.event.GetMSGListener;
import net.bluemangoo.socket.event.GetMSGServer;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;

public class Server{

    private Collection<GetMSGServer> listeners;

    Thread serverThread;
    ArrayList<ConnectClient> connectClientList;

    public void run(){
        serverThread=new Thread(new Runnable() {
            @Override
            public void run() {

            }
        });
        serverThread.start();
    }
    public void stop(){
        serverThread=null;
    }
    public boolean send(String msg,ConnectClient client){
        return false;
    }

//    public void run() {
//        try {
//            ServerSocket ss = new ServerSocket(3093);
//            System.out.println("启动服务器于3093端口");
//            Socket s = ss.accept();
//            System.out.println("客户端:"+s.getInetAddress().getLocalHost()+"已连接到服务器");
//
//            BufferedReader br = new BufferedReader(new InputStreamReader(s.getInputStream()));
//            //读取客户端发送来的消息
//            String mess = br.readLine();
//            System.out.println("客户端："+mess);
//            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(s.getOutputStream()));
//            bw.write(mess+"\n");
//            bw.flush();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }

    /**
     * 添加事件
     *
     * @param listener
     *   addListener
     */
    public void addListener(GetMSGServer listener) {
        if (listeners == null) {
            listeners = new HashSet<>();
        }
        listeners.add(listener);
    }

    /**
     * 触发事件
     */
    protected void msgGet(Message msg) {
        if (listeners == null)
            return;
        GetMSGServer event = new GetMSGServer(msg);
        notifyListeners(event);
    }
    /**
     * 通知所有的Listener
     */
    private void notifyListeners(GetMSGServer event) {
        for (GetMSGServer getMSGServer : listeners) {
            GetMSGListener listener = (GetMSGListener) getMSGServer;
            listener.getMSGEvent(event);
        }
    }
}
