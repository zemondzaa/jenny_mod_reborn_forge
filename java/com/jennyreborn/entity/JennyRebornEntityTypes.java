package com.jennyreborn.entity;

import com.jennyreborn.common.JennyRebornConstants;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

/**
 * Deferred entity registration. Paths stay {@code sexmod:jenny}, {@code sexmod:bee}, … for save compatibility with
 * legacy worlds that used the same mod id.
 */
public final class JennyRebornEntityTypes {
    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES =
            DeferredRegister.create(Registries.ENTITY_TYPE, JennyRebornConstants.MOD_ID);

    public static final RegistryObject<EntityType<BeeNpcEntity>> BEE =
            ENTITY_TYPES.register(
                    "bee",
                    () -> EntityType.Builder.of(BeeNpcEntity::new, MobCategory.CREATURE)
                            .sized(0.5f, 0.6f)
                            .clientTrackingRange(8)
                            .updateInterval(1)
                            .build(JennyRebornConstants.MOD_ID + ":bee"));

    public static final RegistryObject<EntityType<JennyNpcEntity>> JENNY =
            ENTITY_TYPES.register(
                    "jenny",
                    () -> EntityType.Builder.of(JennyNpcEntity::new, MobCategory.CREATURE)
                            .sized(0.49f, 1.95f)
                            .eyeHeight(1.64f)
                            .clientTrackingRange(8)
                            .updateInterval(1)
                            .build(JennyRebornConstants.MOD_ID + ":jenny"));

    private JennyRebornEntityTypes() {}
}
