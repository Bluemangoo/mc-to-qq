package net.bluemangoo.commands;

import net.bluemangoo.data.Share;
import net.bluemangoo.mctoqq.SendMsg;
import net.bluemangoo.socket.Client;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.Objects;

public class mctoqq implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] args) {
        //输入这条指令的是OP(cmd)还是普通玩家
        if ((commandSender instanceof Player && commandSender.isOp()) || (commandSender.equals(commandSender.getServer().getConsoleSender()))) {
            // mctoqq run
            // mctoqq stop
            // mctoqq test
            //目前这两个
            if (args.length == 1 || (!Objects.equals(args[0], "run") && !Objects.equals(args[0], "stop") && !Objects.equals(args[0], "test"))) {
                String Ret = "成功执行此命令！";
                switch (args[0].toLowerCase()) {
                    case "run": {
                        Share.getServer().start();
                        Ret = "[McToQQ] Socket已运行";
                        break;
                    }
                    case "stop": {
                        Share.getServer().stop();
                        Ret = "[McToQQ] Socket已停止";
                        break;
                    }
                    case "test": {
                        Client.test();
                        Ret = "[McToQQ] 开始测试，请查看控制台";
                        break;
                    }
                }
                SendMsg.log(Ret);
                commandSender.sendMessage(ChatColor.GREEN + Ret);
            } else {
                commandSender.sendMessage(ChatColor.RED + "[McToQQ] 语法错误！");
            }
        } else {
            commandSender.sendMessage(ChatColor.RED + "[McToQQ] 该指令仅允许OP执行！");
        }
        return false;
    }
}
