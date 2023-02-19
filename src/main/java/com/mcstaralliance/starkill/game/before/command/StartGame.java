package com.mcstaralliance.starkill.game.before.command;

import com.mcstaralliance.starkill.StarKill;
import com.mcstaralliance.starkill.game.before.Room;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerTeleportEvent;

import java.util.List;
import java.util.Random;
import java.util.Set;

public class StartGame implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(sender instanceof ConsoleCommandSender) {
            sender.sendMessage("this command can only used by player!");
            return false;
        }

        if(!Room.haveRoom()){
            sender.sendMessage("这个服务器没有一个已经被创建了的房间!");
            return false;
        }

        Room room = Room.getRoom();

        Room.removeRoom();

        // 分配身份地点
        Set<Player> players = room.getPlayers();
        List<String> stringList = StarKill.config.getStringList("born-points");

        players.forEach(p ->{
            int i = new Random().nextInt(stringList.size());
            String[] split = stringList.get(i).split(":");

            Location location = p.getLocation();

            location.setX(Double.valueOf(split[0]));
            location.setY(Double.valueOf(split[1]));
            location.setZ(Double.valueOf(split[2]));

            p.teleport(location, PlayerTeleportEvent.TeleportCause.ENDER_PEARL);
            p.sendMessage("游戏开始，你的身份是???，enjoy the game!");
        });


        return true;
    }
}
