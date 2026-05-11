package com.jennyreborn.common;

import com.jennyreborn.entity.JennyRebornEntityTypes;
import com.mojang.logging.LogUtils;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.SpawnEggItem;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import org.slf4j.Logger;

@Mod(JennyRebornConstants.MOD_ID)
public final class JennyRebornMod {
    private static final Logger LOGGER = LogUtils.getLogger();

    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, JennyRebornConstants.MOD_ID);
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, JennyRebornConstants.MOD_ID);

    public static final RegistryObject<Item> TAB_ICON = ITEMS.register(
            JennyRebornConstants.ITEM_JENNY_REBORN_ICON,
            () -> new Item(new Item.Properties()
                    .food(new FoodProperties.Builder().alwaysEdible().nutrition(1).saturationModifier(2f).build())));

    public static final RegistryObject<Item> BEE_SPAWN_EGG = ITEMS.register(
            "bee_spawn_egg",
            () -> new SpawnEggItem(
                    JennyRebornEntityTypes.BEE.get(), 0xffe066, 0x2d5016, new Item.Properties()));

    public static final RegistryObject<Item> JENNY_SPAWN_EGG = ITEMS.register(
            "jenny_spawn_egg",
            () -> new SpawnEggItem(
                    JennyRebornEntityTypes.JENNY.get(), 0xf0c0c0, 0x4a3728, new Item.Properties()));

    public static final RegistryObject<CreativeModeTab> MAIN_TAB = CREATIVE_MODE_TABS.register(
            JennyRebornConstants.CREATIVE_TAB_MAIN,
            () -> CreativeModeTab.builder()
                    .withTabsBefore(CreativeModeTabs.COMBAT)
                    .icon(() -> TAB_ICON.get().getDefaultInstance())
                    .displayItems((parameters, output) -> {
                        output.accept(TAB_ICON.get());
                        output.accept(BEE_SPAWN_EGG.get());
                        output.accept(JENNY_SPAWN_EGG.get());
                    })
                    .build());

    public JennyRebornMod(FMLJavaModLoadingContext context) {
        IEventBus modBus = context.getModEventBus();
        modBus.addListener(this::commonSetup);
        modBus.addListener(this::addCreative);
        ITEMS.register(modBus);
        CREATIVE_MODE_TABS.register(modBus);
        JennyRebornEntityTypes.ENTITY_TYPES.register(modBus);
        MinecraftForge.EVENT_BUS.register(this);
        context.registerConfig(ModConfig.Type.COMMON, JennyRebornConfig.SPEC);
        LOGGER.info("Jenny Reborn ({}) loading", JennyRebornConstants.MOD_ID);
    }

    private void commonSetup(final FMLCommonSetupEvent event) {
        LOGGER.info("Common setup");
        if (JennyRebornConfig.logDirtBlock) {
            LOGGER.info("DIRT BLOCK >> {}", ForgeRegistries.BLOCKS.getKey(Blocks.DIRT));
        }
        LOGGER.info("{}{}", JennyRebornConfig.magicNumberIntroduction, JennyRebornConfig.magicNumber);
        JennyRebornConfig.items.forEach(item -> LOGGER.info("ITEM >> {}", item));
    }

    private void addCreative(BuildCreativeModeTabContentsEvent event) {
        if (event.getTabKey() == CreativeModeTabs.INGREDIENTS) {
            event.accept(TAB_ICON);
            event.accept(BEE_SPAWN_EGG);
            event.accept(JENNY_SPAWN_EGG);
        }
    }

    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event) {
        LOGGER.info("Server starting — NPC entity types: bee, jenny");
    }
}
