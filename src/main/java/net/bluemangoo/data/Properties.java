package net.bluemangoo.data;

import net.bluemangoo.mctoqq.SendMsg;
import org.apache.commons.lang.StringUtils;
import org.bukkit.ChatColor;
import org.yaml.snakeyaml.Yaml;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

import static org.bukkit.Bukkit.getLogger;

public class Properties {
    public static String server_ip;
    public static int server_port;
    public static HashMap<String,Object> properties = new HashMap();
    public static void readProperties() throws IOException {
        String path = System.getProperty("user.dir")+"/plugins/mcToQQ/socket.yml";
        if(StringUtils.isNotEmpty(path)){
            Yaml yaml;
            yaml = new Yaml();
            try {
                properties = yaml.load(new FileReader(path));
                SendMsg.sendToConsole(String.valueOf(properties));
                server_ip = (String) properties.get("server_ip");
                SendMsg.info(server_ip);
                server_port = (int) properties.get("server_port");
                SendMsg.config(server_ip+" "+server_port);
                SendMsg.config(ChatColor.GREEN+"[McToQQ] socket.yml 文件读取成功!");
            } catch(FileNotFoundException e) {
                SendMsg.error(ChatColor.RED+"[McToQQ] socket.yml 文件读取失败:");
                SendMsg.error(String.valueOf(e));
            }
        }
    }
}
