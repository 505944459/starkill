package com.mcstaralliance.starkill.core.room;

import lombok.Getter;
import org.bukkit.entity.Player;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 作者：米豆腐
 * 日期：2023-02-26
 * 描述：服务器的房间的管理类
 * */
public class RoomManager {

    //服务器存在的房间表
    @Getter
    private static Set<Room> rooms = new HashSet<>();

    //玩家所在房间的哈希映射
    @Getter
    private static Map<Player,Room> playerRoomMap = new HashMap<>();

    /**
     * 初始化方法
     * */
    public static boolean init(){


        return false;
    }


    /**
     * 将这个房间的配置保存为配置文件（下次会再加载）
     * */
    public static boolean saveConfig(Room room){



        return false;
    }

}
