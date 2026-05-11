package com.jennyreborn.api;

import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;

/**
 * Extension point for NPC primary-use (right-click) handling. Implementations return {@link
 * InteractionResult#PASS} when they do not apply.
 */
@FunctionalInterface
public interface NpcPrimaryInteractionPlugin {
    InteractionResult tryPrimaryInteract(Player player, InteractionHand hand, Entity target);
}
