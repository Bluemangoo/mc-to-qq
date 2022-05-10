package net.bluemangoo.socket;

public class Socket {
    private static Server server;
    public static Server getServer(){
        if(server==null){
            server=new Server();
        }
        return server;
    }
}
