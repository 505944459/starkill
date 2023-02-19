package com.mcstaralliance.starkill.game.before;

import com.mcstaralliance.starkill.utils.Log;
import lombok.Data;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

/**
 * @Author: RiceTofu123
 * @Date: 2023-02-15
 * @Discription: the class to record the in room players
 * */
@Data
public class Room {

    // the name of the room
    private String name;

    // the players of this room
    private Set<Player> players;

    // max player of this room
    private Integer maxPlayer;

    // the serve room
    private static Room room;


    /**
     * the method to judge whether there is a room
     * */
    public static boolean haveRoom(){
        return room!=null;
    }

    /**
     * the method to get a room
     * */
    public static Room getRoom(){
        return room;
    }

    /**
     * the method use to create a room
     * */
    public static Room createRoom(String name,int maxPlayer){
        if(haveRoom()){
            return null;
        }
        Room a = new Room();
        a.setName(name);
        a.setPlayers(new HashSet<>(maxPlayer));
        a.maxPlayer = maxPlayer;
        room = a;

        // send all player message
        Collection<? extends Player> players = Bukkit.getOnlinePlayers();
        players.forEach(player -> player.sendMessage("一个游戏房间被创建!你可以使用: /join 加入这个房间!"));

        return room;
    }

    /**
     * the method use to remove a room
     * */
    public static boolean removeRoom(){
        if(!haveRoom())return false;

        getRoom().players.forEach(p -> p.sendMessage("当前房间被解散"));

        room = null;

        return true;
    }

    /**
     * player join the room
     * */
    public boolean join(Player player){

        if(players.size()<maxPlayer){
            players.add(player);
            player.sendMessage("你成功加入了一个房间!当前人数:"+players.size()+"/"+maxPlayer);
            player.sendMessage("你可以通过:/quit来退出房间");
        }else {
            player.sendMessage("房间人数已满!");
            return false;
        }

        players.forEach(p ->{
            if(p != player) p.sendMessage("当前房间人数:"+players.size()+"/"+maxPlayer);
        });

        // if the count to the max,game will be start after 10 seconds
        if(players.size()==maxPlayer){
            players.forEach(p -> p.sendMessage("当前房间人数已满，正在等待开始游戏。"));
        }

        return true;
    }

    /**
     * player quit the room
     * */
    public boolean quit(Player player){
        if(players.contains(player)){
            players.remove(player);

            players.forEach(p ->{
                if(p != player) p.sendMessage("当前房间人数:"+players.size()+"/"+maxPlayer);
            });

            return true;
        }
        return false;
    }

}
