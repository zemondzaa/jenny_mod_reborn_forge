package com.jennyreborn.common.gecko;

import software.bernie.geckolib.animation.RawAnimation;

/** Keys must match {@code assets/sexmod/animations/entity/*.animation.json}. */
public final class RebornGeckoAnimations {
    private RebornGeckoAnimations() {}

    public static final class Jenny {
        public static final String IDLE_KEY = "animation.jenny.idle";

        public static RawAnimation idleLoop() {
            return RawAnimation.begin().thenLoop(IDLE_KEY);
        }

        private Jenny() {}
    }

    public static final class Bee {
        public static final String IDLE_KEY = "animation.bee.idle";

        public static RawAnimation idleLoop() {
            return RawAnimation.begin().thenLoop(IDLE_KEY);
        }

        private Bee() {}
    }
}
