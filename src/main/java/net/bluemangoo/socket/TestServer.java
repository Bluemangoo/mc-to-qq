package net.bluemangoo.socket;

import org.bukkit.event.Listener;

public class TestServer {
    class TestListener implements Listener {

    }
    public static void main(String[] args) {
        new Server().start();
    }
}
