package com.mcstaralliance.starkill.game.before.command;

import com.mcstaralliance.starkill.game.before.Room;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;

/**
 * @Author: RiceTofu123
 * @Date: 2023-02-15
 * @Discription: the command for op to creat a room,after use this,game into the ready state(can't use setting commands now)
 * */
public class CreatRoom implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] args) {
        // start create a room and let game be ready state
        if(sender instanceof ConsoleCommandSender) {
            sender.sendMessage("this command can only used by player!");
            return false;
        }

        if(Room.haveRoom()){
            // there is already a room
            sender.sendMessage("已经存在一个被创建了的房间，你可以使用: deleteroom 来删除它");
            return false;
        }

        if(args==null||args.length==0){
            sender.sendMessage("参数缺少!");
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

        if(index<0){
            sender.sendMessage("参数必须为一个正整数");
            return false;
        }

        Room.createRoom("default",index);

        return true;
    }
}
