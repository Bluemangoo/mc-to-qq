package net.bluemangoo.mctoqq;

import org.bukkit.entity.Player;

import java.util.function.Supplier;

import static org.bukkit.Bukkit.getLogger;
import static org.bukkit.Bukkit.getServer;

public class SendMsg {
    public static void sendToConsole(String msg) {
        //getLogger().info(msg);
        System.out.println(msg);
    }
    public static void sendToPlayer(Player target, String msg) {
        target.sendMessage(msg);
    }
    public static void broadcast(String msg) {
        getServer().broadcastMessage(msg);
    }

    public static void info(Supplier<String> msg){
        getLogger().info(msg);
    }
    public static void error(Supplier<String> msg){
        getLogger().severe(msg);
    }
    public static void config(Supplier<String> msg){
        getLogger().config(msg);
    }
    public static void warn(Supplier<String> msg){
        getLogger().warning(msg);
    }
    public static void info(String msg){
        getLogger().info(msg);
    }
    public static void error(String msg){
        getLogger().severe(msg);
    }
    public static void config(String msg){
        getLogger().config(msg);
    }
    public static void warn(String msg){
        getLogger().warning(msg);
    }
}