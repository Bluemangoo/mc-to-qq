package net.bluemangoo.mctoqq;

import org.bukkit.plugin.java.JavaPlugin;

public final class McToQQ extends JavaPlugin {
    sendMsg sm = new sendMsg();
    @Override
    public void onEnable(){
        sm.sendToConsole("[mcToQQ] 插件已启用！");
        //指令
        getCommand("mctoqq").setExecutor(new McToQQ());
        getCommand("mtq").setExecutor(new McToQQ());//别名

    }
    @Override
    public void onDisable(){
        sm.sendToConsole("[mcToQQ] 插件已禁用！");
    }
}