package com.mcstaralliance.starkill.core.room;

/**
 * 作者：米豆腐
 * 日期：2023-02-26
 * 描述：房间的状态信息枚举
 * */
public enum RoomState {
    FREE,//空闲的，可以加入
    FULL,//满员的，无法加入
    RUNNING//正在进行游戏的，无法加入
}
