package com.jennyreborn.network;

import com.jennyreborn.common.JennyRebornConstants;
import net.minecraft.resources.ResourceLocation;

/** Reserved channel ids; wire payloads here as the port grows. */
public final class JennyRebornNetworkChannels {
    public static final ResourceLocation MAIN = JennyRebornConstants.id("main");

    private JennyRebornNetworkChannels() {}
}
