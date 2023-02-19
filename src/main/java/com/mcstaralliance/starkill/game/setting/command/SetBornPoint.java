package com.mcstaralliance.starkill.game.setting.command;


import com.mcstaralliance.starkill.StarKill;
import com.mcstaralliance.starkill.game.before.Room;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;

import java.util.List;

/**
 * @Author: RiceTofu123
 * @Date: 2023-02-15
 * @Discription: the command for op to set the game's born points
 * */
public class SetBornPoint implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {

        if(commandSender instanceof ConsoleCommandSender) {
            commandSender.sendMessage("this command can only used by player!");
            return false;
        }

        List<String> stringList = StarKill.config.getStringList("born-points");
        Player player = (Player) commandSender;
        Location location = player.getLocation();
        stringList.add(location.getX()+":"+location.getY()+":"+location.getZ());
        StarKill.config.set("born-points",stringList);
        player.sendMessage("你成功设置了一个出生点:"+stringList.get(stringList.size()-1));
        return true;
    }

}
