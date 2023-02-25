package com.mcstaralliance.starkill.core.gui;

import com.mcstaralliance.starkill.utils.Msg;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.inventory.Inventory;

/**
 * 作者：米豆腐
 * 日期：2023-02-26
 * 描述：玩家在主城时打开的菜单及菜单事件监听
 * */
public class PlayerSpawnGui implements Listener {
    public static void open(Player player){
        Msg.send(player,"你打开了菜单");
        Inventory inv = Bukkit.createInventory(player,6*9);
        // 绘制边界线


    }

}
