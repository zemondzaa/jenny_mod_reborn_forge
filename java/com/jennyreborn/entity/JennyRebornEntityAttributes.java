package com.jennyreborn.entity;

import com.jennyreborn.common.JennyRebornConstants;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.PathfinderMob;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = JennyRebornConstants.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public final class JennyRebornEntityAttributes {
    private JennyRebornEntityAttributes() {}

    @SubscribeEvent
    public static void register(EntityAttributeCreationEvent event) {
        event.put(JennyRebornEntityTypes.BEE.get(), PathfinderMob.createMobAttributes()
                .add(Attributes.MAX_HEALTH, 10.0)
                .add(Attributes.MOVEMENT_SPEED, 0.3)
                .build());
        event.put(JennyRebornEntityTypes.JENNY.get(), JennyNpcEntity.createAttributes().build());
    }
}
