package com.jennyreborn.common.gecko;

import software.bernie.geckolib.animatable.GeoEntity;
import software.bernie.geckolib.animation.AnimationController;
import software.bernie.geckolib.animation.PlayState;
import software.bernie.geckolib.animation.RawAnimation;

public final class RebornGeckoAnimationControllers {
    private RebornGeckoAnimationControllers() {}

    public static <T extends GeoEntity> AnimationController<T> simpleLoop(T self, RawAnimation loop) {
        return new AnimationController<>(self, "main", 0, state -> {
            state.getController().setAnimation(loop);
            return PlayState.CONTINUE;
        });
    }
}
