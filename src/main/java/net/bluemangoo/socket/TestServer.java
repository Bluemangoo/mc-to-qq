package net.bluemangoo.socket;

import org.bukkit.event.Listener;

public class TestServer {
    public static void main(String[] args) {
        new Server().start();
    }

    static class TestListener implements Listener {

    }
}
