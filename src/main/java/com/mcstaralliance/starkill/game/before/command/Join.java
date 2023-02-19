package com.mcstaralliance.starkill.game.before.command;

import com.mcstaralliance.starkill.game.before.Room;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;

public class Join implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        // start create a room and let game be ready state
        if(sender instanceof ConsoleCommandSender) {
            sender.sendMessage("this command can only used by player!");
            return false;
        }

        if(!Room.haveRoom()){
            sender.sendMessage("这个服务器没有被创建了的房间");
            return false;
        }

        if (!Room.getRoom().join((Player) sender)) {
            sender.sendMessage("加入房间失败!房间人数已满!");
            return false;
        }

        return true;
    }
}
