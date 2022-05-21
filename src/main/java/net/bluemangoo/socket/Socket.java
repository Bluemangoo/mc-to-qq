package net.bluemangoo.socket;

public class Socket {
    private static Server server;//存储socket Server对象
    public static Server getServer(){
        if(server == null){
            server=new Server();
        }
        return server;
    }
}