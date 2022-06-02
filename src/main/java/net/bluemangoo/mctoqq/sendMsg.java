package net.bluemangoo.mctoqq;

import org.bukkit.entity.Player;

import java.util.function.Supplier;

import static org.bukkit.Bukkit.getLogger;
import static org.bukkit.Bukkit.getServer;

public class SendMsg {

    /**
     * 输出至控制台;
     * 已经弃用，请使用 SendMsg.log(msg)
     * @param msg 发送的消息
     */
    @Deprecated
    public static void sendToConsole(String msg) {
        System.out.println(msg);
    }


    public static void sendToPlayer(Player target, String msg) {
        target.sendMessage(msg);
    }


    public static void broadcast(String msg) {
        getServer().broadcastMessage(msg);
    }

    /**
     * 输出至日志&控制台;
     * @param msg 发送的消息
     */
    public static void log(Supplier<String> msg) {
        getLogger().info(msg);
    }

    public static void error(Supplier<String> msg) {
        getLogger().severe(msg);
    }

    public static void config(Supplier<String> msg) {
        getLogger().config(msg);
    }

    public static void warn(Supplier<String> msg) {
        getLogger().warning(msg);
    }

    /**
     * 输出至日志&控制台;
     * @param msg 发送的消息
     */

    public static void log(String msg) {
        getLogger().info(msg);
    }

    public static void error(String msg) {
        getLogger().severe(msg);
    }

    public static void config(String msg) {
        getLogger().config(msg);
    }

    public static void warn(String msg) {
        getLogger().warning(msg);
    }
}