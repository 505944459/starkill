package com.mcstaralliance.starkill.utils;

import com.mcstaralliance.starkill.core.room.Room;
import org.bukkit.entity.Player;

import java.util.Set;

/**
 * 作者：米豆腐
 * 日期：2023-02-26
 * 描述：插件统一的像玩家发送消息的处理类
 * */
public class Msg {

    private static String prefix = "§a[§b星域杀§a]§f";

    /**
     * 向玩家发送一条消息
     * @param player 目标玩家
     * @param msg 消息内容
     * */
    public static void send(Player player,String msg){
        player.sendMessage(prefix+msg);
    }

    /**
     * 向一个房间里的所有玩家发送消息
     * @param room 目标房间
     * @param msg 消息内容
     * */
    public static void send(Room room, String msg){
        Set<Player> players = room.getPlayers();
        players.forEach(p -> p.sendMessage(prefix+msg));
    }

}
