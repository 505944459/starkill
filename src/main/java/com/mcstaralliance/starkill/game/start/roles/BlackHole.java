package com.mcstaralliance.starkill.game.start.roles;

import com.mcstaralliance.starkill.game.start.Role;
import com.mcstaralliance.starkill.game.start.RoleType;
import org.bukkit.entity.Player;

/**
 *  with your teammates eat all the star
 * */
public class BlackHole implements Role {

    @Override
    public Player getPlayer() {
        return null;
    }

    @Override
    public RoleType getRoleType() {
        return RoleType.BAD;
    }
}
