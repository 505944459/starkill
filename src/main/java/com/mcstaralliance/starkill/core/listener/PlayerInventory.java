package com.mcstaralliance.starkill.core.listener;

import com.mcstaralliance.starkill.core.room.Room;
import com.mcstaralliance.starkill.core.room.RoomManager;
import com.mcstaralliance.starkill.core.room.RoomState;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

/**
 * 作者：米豆腐
 * 日期：2023-02-26
 * 描述：放置玩家改变自己的库存
 * */
public class PlayerInventory implements Listener {

    @EventHandler
    public void handler(InventoryClickEvent event){
        if((event.getInventory() instanceof org.bukkit.inventory.PlayerInventory))return;
        Room room = RoomManager.getPlayerRoomMap().get((Player) event.getWhoClicked());
        if(room!=null&&room.getState().equals(RoomState.RUNNING))return;//玩家处在游戏中，则不阻止这次改变
        if(event.getWhoClicked().isOp())return;//是OP，则不阻止这次改变
        event.setCancelled(true);
    }

}
