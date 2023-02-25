package com.mcstaralliance.starkill.core.room;

import com.mcstaralliance.starkill.utils.Msg;
import lombok.Data;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.Player;

import java.util.List;
import java.util.Set;

/**
 * 作者：米豆腐
 * 日期: 2023-02-26
 * 描述: 代表一个游戏房间
 * */
@Data
public class Room {

    //房间的唯一id
    private Integer id;

    //房间的名字
    private String name;

    //房间的lore描述
    private List<String> lore;

    //房间的最大人数
    private Integer maxPlayer;

    //房间的玩家列表
    private Set<Player> players;

    //房间的状态
    private RoomState state;

    //房间的等待房间的世界
    private World waitWorld;

    //房间的等待房间的位置
    private Location waitLocation;

    //房间的地图的世界
    private World gameWorld;

    //房间的地图的出生点
    private List<Location> bornLocations;

    /**
     * 玩家加入房间的方法调用
     * @param player 玩家对象
     * @return 是否成功
     * */
    public synchronized boolean join(Player player){
        //判断玩家是否已经在房间中
        if (RoomManager.getPlayerRoomMap().containsKey(player)) {
            Msg.send(player,"加入房间失败!你已经加入了一个房间？");
            return false;
        }

        //玩家已满或已经加入则无法加入
        if(players.size()==maxPlayer) {
            Msg.send(player,"加入房间失败!房间已经满员!");
            return false;
        }
        //将玩家添加进房间
        players.add(player);
        RoomManager.getPlayerRoomMap().put(player,this);//添加玩家表记录
        // TODO 将玩家传送至等待房间？？？
        player.teleport(waitLocation);


        return true;
    }

    /**
     * 玩家退出房间的方法调用
     * @param player 玩家对象
     * @return 是否成功
     * */
    public synchronized boolean quit(Player player){
        if(!players.contains(player))return true;

        //TODO 将玩家传送回到主城？？？



        RoomManager.getPlayerRoomMap().remove(player);//删除玩家表记录
        return players.remove(player);
    }

    /**
     * 游戏开始的方法调用
     * */
    public boolean start(){


        return false;
    }

}
