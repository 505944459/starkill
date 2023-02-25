package com.mcstaralliance.starkill.core.listener;

import com.mcstaralliance.starkill.core.room.Room;
import com.mcstaralliance.starkill.core.room.RoomManager;
import com.mcstaralliance.starkill.core.room.RoomState;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityPickupItemEvent;

/**
 * 作者: 米豆腐
 * 日期: 2023-02-26
 * 描述: 玩家扔掉物品判断
 * */
public class PlayerItemPick implements Listener {

    @EventHandler
    public void handler(EntityPickupItemEvent event){
        if(!(event.getEntity() instanceof Player))return;//不是玩家触发的，直接不判断
        Player player = (Player) event.getEntity();
        if(player.isOp())return;//是op跳过
        Room room = RoomManager.getPlayerRoomMap().get(player);
        if(room!=null&&room.getState().equals(RoomState.RUNNING))return;//游戏中，跳过
        event.setCancelled(true);
        //player.getInventory().remove(event.getItem().getItemStack());
    }

}
