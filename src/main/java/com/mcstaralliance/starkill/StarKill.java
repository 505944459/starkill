package com.mcstaralliance.starkill;

import com.mcstaralliance.starkill.core.listener.*;
import com.mcstaralliance.starkill.utils.Log;
import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

/**
 * 作者: 米豆腐
 * 日期: 2023-02-26
 * 描述: 插件的主类，插件加载的入口
 * */
public class StarKill extends JavaPlugin {

    public static FileConfiguration config;

    @Override
    public void onEnable() {
        long start = System.currentTimeMillis();//用于插件启动耗时统计
        Log.info("插件正在启动中……");

        // 默认的监听器注册
        Bukkit.getPluginManager().registerEvents(new PlayerInventory(),this);//放置背包点击
        Bukkit.getPluginManager().registerEvents(new PlayerJoin(),this);//玩家加入
        Bukkit.getPluginManager().registerEvents(new PlayerThrow(),this);//玩家扔物品
        Bukkit.getPluginManager().registerEvents(new PlayerItemPick(),this);//玩家拾取物品
        Bukkit.getPluginManager().registerEvents(new PlayerItemClick(),this);//玩家打开菜单


        Log.info("插件启动成功！耗时："+(System.currentTimeMillis()-start)+"毫秒！");
    }

    @Override
    public void onDisable() {
        saveConfig();

    }
}
