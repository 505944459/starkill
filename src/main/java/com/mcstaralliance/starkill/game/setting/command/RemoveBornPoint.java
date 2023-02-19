package com.mcstaralliance.starkill.game.setting.command;

import com.mcstaralliance.starkill.StarKill;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;

import java.util.List;

public class RemoveBornPoint implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(sender instanceof ConsoleCommandSender) {
            sender.sendMessage("this command can only used by player!");
            return false;
        }

        String arg = args[0];

        int index = -1;

        try{
            index = Integer.parseInt(arg);
        }catch (Exception e){
            sender.sendMessage("参数必须为一个数字!");
            return false;
        }

        List<String> stringList = StarKill.config.getStringList("born-points");
        if(index>=stringList.size()||index<0){
            sender.sendMessage("下标数字错误!请检查!");
            return false;
        }

        stringList.remove(index);

        StarKill.config.set("born-points",stringList);

        sender.sendMessage("删除成功!");

        return true;
    }
}
