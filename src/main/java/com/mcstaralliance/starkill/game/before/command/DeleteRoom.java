package com.mcstaralliance.starkill.game.before.command;

import com.mcstaralliance.starkill.game.before.Room;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;

/**
 * @Author: RiceTofu123
 * @Date: 2023-02-15
 * @Description: the command for op to delete a room,after use this,game into the setting state
 * */
public class DeleteRoom implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(sender instanceof ConsoleCommandSender) {
            sender.sendMessage("this command can only used by player!");
            return false;
        }

        if (Room.removeRoom()) {
            sender.sendMessage("删除房间成功!");
        }else {
            sender.sendMessage("删除房间失败，可能是不存在一个未开始游戏的房间");
            return false;
        }

        return true;
    }
}
