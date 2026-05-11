package com.jennyreborn.client;

import com.jennyreborn.common.JennyRebornConstants;
import com.jennyreborn.entity.BeeNpcEntity;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.DefaultedEntityGeoModel;
import software.bernie.geckolib.renderer.GeoEntityRenderer;

public final class BeeNpcRenderer extends GeoEntityRenderer<BeeNpcEntity> {
    public BeeNpcRenderer(EntityRendererProvider.Context ctx) {
        super(ctx, new DefaultedEntityGeoModel<>(ResourceLocation.fromNamespaceAndPath(JennyRebornConstants.MOD_ID, "bee")));
    }
}
