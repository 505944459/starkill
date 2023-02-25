package com.mcstaralliance.starkill.core.listener;


import com.mcstaralliance.starkill.core.room.Room;
import com.mcstaralliance.starkill.core.room.RoomManager;
import com.mcstaralliance.starkill.core.room.RoomState;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerDropItemEvent;

/**
 * 作者: 米豆腐
 * 日期: 2023-02-26
 * 描述: 放置玩家扔掉菜单
 * */
public class PlayerThrow implements Listener {

    @EventHandler
    public void handler(PlayerDropItemEvent event){
        Player player = event.getPlayer();
        if(player.isOp())return;//是op跳过
        Room room = RoomManager.getPlayerRoomMap().get(player);
        if(room!=null&&room.getState().equals(RoomState.RUNNING))return;//游戏中，跳过
        event.setCancelled(true);
    }

}
