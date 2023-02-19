package com.mcstaralliance.starkill.utils;

import org.bukkit.Bukkit;

import java.util.logging.Logger;

/**
 * @Author: RiceTofu123
 * @Date: 2023-02-15
 * @Discription: the log class of this plugin
 * */
public class Log {

    private static Logger logger = Bukkit.getLogger();

    private static final String PREFIX = "[StarKill]:";


    public static void info(String msg){
        logger.info(PREFIX+msg);
    }

    public static void warn(String msg){
        logger.warning(PREFIX+msg);
    }

    public static void error(String msg){
        logger.severe(PREFIX+msg);
    }

}
