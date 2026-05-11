package com.jennyreborn.client;

import com.jennyreborn.common.JennyRebornConstants;
import com.jennyreborn.entity.JennyNpcEntity;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.DefaultedEntityGeoModel;
import software.bernie.geckolib.renderer.GeoEntityRenderer;

public final class JennyNpcRenderer extends GeoEntityRenderer<JennyNpcEntity> {
    public JennyNpcRenderer(EntityRendererProvider.Context ctx) {
        super(ctx, new DefaultedEntityGeoModel<>(ResourceLocation.fromNamespaceAndPath(JennyRebornConstants.MOD_ID, "jenny")));
    }
}
