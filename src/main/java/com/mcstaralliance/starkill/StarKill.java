package com.mcstaralliance.starkill;

import com.mcstaralliance.starkill.game.before.command.*;
import com.mcstaralliance.starkill.game.setting.command.ListBornPoint;
import com.mcstaralliance.starkill.game.setting.command.SetBornPoint;
import com.mcstaralliance.starkill.game.setting.command.ToBornPoint;
import com.mcstaralliance.starkill.utils.Log;
import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

/**
 * main class
 * */
public class StarKill extends JavaPlugin {

    public static FileConfiguration config;

    @Override
    public void onEnable() {
        Log.info("StarKill is loading……");
        saveDefaultConfig();
        config = getConfig();

        // Registration command
        Bukkit.getPluginCommand("setBornPoint").setExecutor(new SetBornPoint());
        Bukkit.getPluginCommand("listBornPoint").setExecutor(new ListBornPoint());
        Bukkit.getPluginCommand("toBornPoint").setExecutor(new ToBornPoint());

        Bukkit.getPluginCommand("createRoom").setExecutor(new CreatRoom());
        Bukkit.getPluginCommand("deleteRoom").setExecutor(new DeleteRoom());

        Bukkit.getPluginCommand("join").setExecutor(new Join());
        Bukkit.getPluginCommand("quit").setExecutor(new Quit());
        Bukkit.getPluginCommand("startGame").setExecutor(new StartGame());

        Log.info("StarKill is enabled.");
    }

    @Override
    public void onDisable() {
        saveConfig();

    }
}
