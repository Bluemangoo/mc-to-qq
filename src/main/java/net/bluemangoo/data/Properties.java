package net.bluemangoo.data;

import net.bluemangoo.mctoqq.SendMsg;
import org.apache.commons.lang.StringUtils;
import org.bukkit.ChatColor;
import org.yaml.snakeyaml.Yaml;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashMap;

public class Properties {
    public static String server_ip;
    public static int server_port;
    public static HashMap<String, Object> settings = new HashMap<>();

    public static void readProperties(){
        String path = System.getProperty("user.dir") + "/plugins/mcToQQ/socket.yml";
        if (StringUtils.isNotEmpty(path)) {
            Yaml yaml;
            yaml = new Yaml();
            try {
                settings = yaml.load(new FileReader(path));
                SendMsg.log(String.valueOf(settings));
                server_ip = (String) settings.get("server_ip");
                SendMsg.log(server_ip);
                server_port = (int) settings.get("server_port");
                SendMsg.config(server_ip + " " + server_port);
                SendMsg.config(ChatColor.GREEN + "[McToQQ] socket.yml 文件读取成功!");
            } catch (FileNotFoundException e) {
                SendMsg.error(ChatColor.RED + "[McToQQ] socket.yml 文件读取失败:");
                SendMsg.error(String.valueOf(e));
            }
        }
    }
}
