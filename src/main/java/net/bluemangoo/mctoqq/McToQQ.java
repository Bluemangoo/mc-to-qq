package net.bluemangoo.mctoqq;

import net.bluemangoo.commands.mctoqq;
import net.bluemangoo.data.Properties;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.IOException;
import java.util.Objects;

public final class McToQQ extends JavaPlugin {
    @Override
    public void onEnable() {
        try {
            Properties.readProperties();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        SendMsg.sendToConsole("[mcToQQ] 插件已启用！");
        //指令
        Objects.requireNonNull(getCommand("mctoqq")).setExecutor(new mctoqq());
        //Objects.requireNonNull(getCommand("mtq")).setExecutor(new mctoqq());
    }

    @Override
    public void onDisable() {
        SendMsg.sendToConsole("[mcToQQ] 插件已禁用！");
    }
}