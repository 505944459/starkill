package com.mcstaralliance.starkill.utils;


import org.bukkit.Bukkit;

import java.util.logging.Logger;

/**
 * 作者：米豆腐
 * 日期：2023-02-26
 * 描述：插件统一的日志类
 * */
public class Log {
    //日志记录对象
    private static Logger log = Bukkit.getLogger();

    //插件的日志记录头
    private static String prefix = "§a[§bStarKill§a]§f";

    /**
     * 普通信息
     * @param msg 信息
     * */
    public static void info(String msg){
        log.info(prefix+msg);
    }

    /**
     * 警告信息
     * @param msg 信息
     * */
    public static void warn(String msg){
        log.warning(prefix+msg);
    }

    /**
     * 错误信息
     * @param msg 信息
     * */
    public static void error(String msg){
        log.severe(prefix+msg);
    }

}
