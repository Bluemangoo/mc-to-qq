package net.bluemangoo.mctoqq;

import org.bukkit.entity.Player;

import static org.bukkit.Bukkit.getServer;

public class sendMsg {
    public void sendToConsole(String msg){
        System.out.println(msg);
    }
    public void sendToPlayer(Player target, String msg){
        target.sendMessage(msg);
    }
    public void broadcast(String msg){
        getServer().broadcastMessage(msg);
    }
}
