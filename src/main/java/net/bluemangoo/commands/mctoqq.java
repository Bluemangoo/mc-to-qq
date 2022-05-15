package net.bluemangoo.commands;

import net.bluemangoo.mctoqq.sendMsg;
import net.bluemangoo.socket.Client;
import net.bluemangoo.socket.Server;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import static org.bukkit.Bukkit.getServer;

public class mctoqq implements CommandExecutor {
    sendMsg sm = new sendMsg();
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] args) {
        if(commandSender instanceof Player && commandSender.isOp()){//输入这条指令的是OP(cmd)还是普通玩家
            // mctoqq run
            // mctoqq stop
            //目前这两个
            if(args.length==1){
                String Ret = "成功执行此命令！";
                switch (args[0].toLowerCase()){
                    case "run" : new Server().run();
                    Ret= "Socket已运行"; 
                    break;
                    case "stop" : new Server().stop();
                    Ret= "Socket已停止"; 
                    break;
                    case "test" : Client.test();
                    Ret= "开始测试，请查看控制台";
                    sm.sendToConsole(Ret);
                    break;
                }
                commandSender.sendMessage(ChatColor.GREEN+Ret);
            }else{
                commandSender.sendMessage(ChatColor.RED+"语法错误！");
            }
        }else{
            commandSender.sendMessage(ChatColor.RED+"该指令仅允许OP执行！");
        }
        return false;
    }
}
