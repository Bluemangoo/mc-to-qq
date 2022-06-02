package net.bluemangoo.mctoqq;

import net.bluemangoo.commands.mctoqq;
import net.bluemangoo.data.Properties;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Objects;

public final class McToQQ extends JavaPlugin {
    @Override
    public void onEnable() {
        Properties.readProperties();
        SendMsg.log("[mcToQQ] 插件已启用！");
        //指令
        Objects.requireNonNull(getCommand("mctoqq")).setExecutor(new mctoqq());
        //Objects.requireNonNull(getCommand("mtq")).setExecutor(new mctoqq());
    }

    @Override
    public void onDisable() {
        SendMsg.log("[mcToQQ] 插件已禁用！");
    }
}