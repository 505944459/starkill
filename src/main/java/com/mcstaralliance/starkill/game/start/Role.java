package com.mcstaralliance.starkill.game.start;

import org.bukkit.entity.Player;

/**
 * @Author: RiceTofu
 * @Date: 2023-02-16
 * @Description: Represent the characters in the game
 * */
public interface Role {

    /**
     * get the player that owned the role
     * */
    Player getPlayer();

    /**
     * get the role's type
     * */
    RoleType getRoleType();
}
