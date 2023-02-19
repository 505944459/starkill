package com.mcstaralliance.starkill.game.setting.command;

import com.mcstaralliance.starkill.StarKill;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerTeleportEvent;

import java.util.List;

public class ToBornPoint implements CommandExecutor {
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

        String[] split = stringList.get(index).split(":");

        Player player = (Player) sender;

        Location location = player.getLocation();

        location.setX(Double.valueOf(split[0]));
        location.setY(Double.valueOf(split[1]));
        location.setZ(Double.valueOf(split[2]));

        player.teleport(location, PlayerTeleportEvent.TeleportCause.ENDER_PEARL);

        player.sendMessage("咻~~传送成功");

        return true;
    }
}
