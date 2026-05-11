package com.jennyreborn.common;

import net.minecraft.resources.ResourceLocation;

/** Central ids and paths; keep {@link #MOD_ID} stable for existing assets and saves. */
public final class JennyRebornConstants {
    public static final String MOD_ID = "sexmod";

    public static final String ITEM_JENNY_REBORN_ICON = "jenny_reborn_icon";
    public static final String CREATIVE_TAB_MAIN = "main";

    public static final int CONFIG_DEFAULT_MAGIC_NUMBER = 42;

    public static ResourceLocation id(String path) {
        return ResourceLocation.fromNamespaceAndPath(MOD_ID, path);
    }

    private JennyRebornConstants() {}
}
