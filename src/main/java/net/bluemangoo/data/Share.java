package net.bluemangoo.data;

import net.bluemangoo.socket.Server;

public class Share{
    private static Server server;//存储socket Server对象

    public static Server getServer() {
        if (server == null) {
            server = new Server();
        }
        return server;
    }
}
