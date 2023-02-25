package com.mcstaralliance.starkill.core.listener;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.inventory.meta.ItemMeta;

/**
 * 作者: 米豆腐
 * 日期: 2023-02-26
 * 描述: 玩家加入事件监听
 * */
public class PlayerJoin implements Listener {

    @EventHandler
    public void handler(PlayerJoinEvent event){
        Player player = event.getPlayer();

        // 清空玩家的库存
        PlayerInventory inventory = player.getInventory();
        inventory.clear();

        // 重新设置玩家的库存
        // 玩家菜单
        ItemStack menu = new ItemStack(Material.CLOCK);
        ItemMeta menuItemMeta = menu.getItemMeta();
        menuItemMeta.setDisplayName("§a菜单");
        menu.setItemMeta(menuItemMeta);
        inventory.setItem(0,menu);
        // 管理员菜单
        if (!player.isOp())return;
        ItemStack adminMenu = new ItemStack(Material.RECOVERY_COMPASS);
        ItemMeta adminMenuItemMeta = adminMenu.getItemMeta();
        adminMenuItemMeta.setDisplayName("§b管理员菜单");
        adminMenu.setItemMeta(adminMenuItemMeta);
        inventory.setItem(8,adminMenu);
    }

}
