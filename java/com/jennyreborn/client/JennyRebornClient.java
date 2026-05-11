package com.jennyreborn.client;

import com.jennyreborn.common.JennyRebornConstants;
import com.jennyreborn.entity.JennyRebornEntityTypes;
import com.mojang.logging.LogUtils;
import net.minecraft.client.Minecraft;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import org.slf4j.Logger;

@Mod.EventBusSubscriber(modid = JennyRebornConstants.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public final class JennyRebornClient {
    private static final Logger LOGGER = LogUtils.getLogger();

    private JennyRebornClient() {}

    @SubscribeEvent
    public static void registerRenderers(EntityRenderersEvent.RegisterRenderers event) {
        event.registerEntityRenderer(JennyRebornEntityTypes.BEE.get(), BeeNpcRenderer::new);
        event.registerEntityRenderer(JennyRebornEntityTypes.JENNY.get(), JennyNpcRenderer::new);
    }

    @SubscribeEvent
    public static void onClientSetup(FMLClientSetupEvent event) {
        LOGGER.info("Jenny Reborn client setup");
        LOGGER.info("Minecraft user: {}", Minecraft.getInstance().getUser().getName());
    }
}
