package com.mcstaralliance.starkill.game.start.roles;

import com.mcstaralliance.starkill.game.start.Role;
import com.mcstaralliance.starkill.game.start.RoleType;
import org.bukkit.entity.Player;

/**
 * a normal role,no skills,the only duty is to alive and find all the black hole
 * */
public class Star implements Role {

    @Override
    public Player getPlayer() {
        return null;
    }

    @Override
    public RoleType getRoleType() {
        return RoleType.GOOD;
    }
}
