package com.mcstaralliance.starkill.game.setting.command;

import com.mcstaralliance.starkill.StarKill;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;

import java.util.List;

public class ListBornPoint implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(sender instanceof ConsoleCommandSender) {
            sender.sendMessage("this command can only used by player!");
            return false;
        }

        List<String> stringList = StarKill.config.getStringList("born-points");
        sender.sendMessage("这是当前服务器已经设置了的出生点:");

        for (int i = 0; i < stringList.size(); i++) {
            String[] split = stringList.get(i).split(":");
            sender.sendMessage(i+"--->X:"+split[0]+"Y:"+split[1]+"Z:"+split[2]);
        }
        sender.sendMessage("你可以使用: tobornpoint <数字下标> 来传送到一个已经设置的出生点。");
        return true;
    }
}
