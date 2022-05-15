package net.bluemangoo.socket;

import net.bluemangoo.socket.event.GetMSGListener;
import net.bluemangoo.socket.event.GetMSGServer;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

public class TestServer {
    static class TestListener implements Listener {

    }
    public static void main(String[] args) {
        new Server().run();
        GetMSGListener listener= event -> System.out.println(event.getMsg());
    }
}
