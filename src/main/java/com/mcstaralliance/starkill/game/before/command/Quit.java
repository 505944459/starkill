package com.mcstaralliance.starkill.game.before.command;

import com.mcstaralliance.starkill.game.before.Room;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;

public class Quit implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if(sender instanceof ConsoleCommandSender) {
            sender.sendMessage("this command can only used by player!");
            return false;
        }

        if(!Room.haveRoom()){
            sender.sendMessage("这个服务器还没有一个创建了的房间!");
            return false;
        }

        if(Room.getRoom().quit((Player) sender)){
           sender.sendMessage("退出房间成功!");
        }else sender.sendMessage("你还没有加入过房间");

        return true;
    }
}
