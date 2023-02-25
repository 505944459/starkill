package com.mcstaralliance.starkill.core.listener;

import com.mcstaralliance.starkill.core.gui.PlayerSpawnGui;
import com.mcstaralliance.starkill.core.room.RoomManager;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

/**
 * 作者：米豆腐
 * 日期：2023-02-26
 * 描述：触发菜单
 * */
public class PlayerItemClick implements Listener {

    @EventHandler
    public void handler(PlayerInteractEvent event){
        ItemStack item = event.getItem();
        if(item==null)return;//空物品
        if(item.getItemMeta()==null)return;//空meta
        Player player = event.getPlayer();
        switch (item.getItemMeta().getDisplayName()){
            case "§a菜单":{
                if(RoomManager.getPlayerRoomMap().get(player)==null){
                    // 主城菜单 开辟新线程打开以防止卡服
                    new Thread(() -> {
                        PlayerSpawnGui.open(player);
                    }).start();
                }else {
                    // 房间菜单

                }
            }


        }

    }

}
