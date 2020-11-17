package com.acm.fall2020Mod.util;

import com.acm.fall2020Mod.AcmMinecraftMod;
import com.acm.fall2020Mod.blocks.BlockItemBase;
import com.acm.fall2020Mod.blocks.SkittlesBlock;
import com.acm.fall2020Mod.items.ItemBase;
import com.acm.fall2020Mod.items.SkittlesItemBase;
import com.acm.fall2020Mod.tools.ModItemTier;
import net.minecraft.block.Block;
import net.minecraft.item.*;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class RegistryHandler {
    public static final DeferredRegister<Item> ITEMS = new DeferredRegister<>(ForgeRegistries.ITEMS, AcmMinecraftMod.MOD_ID);
    public static final DeferredRegister<Block> BLOCKS = new DeferredRegister<>(ForgeRegistries.BLOCKS, AcmMinecraftMod.MOD_ID);

    public static void init() {
        ITEMS.register(FMLJavaModLoadingContext.get().getModEventBus());
        BLOCKS.register(FMLJavaModLoadingContext.get().getModEventBus());
    }

    // Items
    public static final RegistryObject<Item> PHONE = ITEMS.register("phone", ItemBase::new);
    public static final RegistryObject<Item> LAPTOP = ITEMS.register("laptop", ItemBase::new);
    public static final RegistryObject<Item> GUITAR = ITEMS.register("guitar", ItemBase::new);
    public static final RegistryObject<Item> ACM_LOGO = ITEMS.register("acm_logo", ItemBase::new);

    public static final RegistryObject<Item> GREEN_APPLE_SKITTLES = ITEMS.register("green_apple_skittles", ItemBase::new);
    public static final RegistryObject<Item> STRAWBERRY_SKITTLES = ITEMS.register("strawberry_skittles", ItemBase::new);
    public static final RegistryObject<Item> GRAPE_SKITTLES = ITEMS.register("grape_skittles", ItemBase::new);
    public static final RegistryObject<Item> LEMON_SKITTLES = ITEMS.register("lemon_skittles", ItemBase::new);
    public static final RegistryObject<Item> ORANGE_SKITTLES = ITEMS.register("orange_skittles", ItemBase::new);

    public static final RegistryObject<Item> SKITTLES = ITEMS.register("skittles", SkittlesItemBase::new);

    // Blocks
    public static final RegistryObject<Block> SKITTLES_BLOCK = BLOCKS.register("skittles_block", SkittlesBlock::new);

    // BlockItems
    public static final RegistryObject<Item> SKITTLES_BLOCK_ITEM = ITEMS.register("skittles_block", () -> new BlockItemBase(SKITTLES_BLOCK.get()));

    // Tools
    public static final RegistryObject<SwordItem> SKITTLES_SWORD = ITEMS.register("skittles_sword", () ->
            new SwordItem(ModItemTier.SKITTLES, 5, -3.0f, new Item.Properties().group(AcmMinecraftMod.TAB)));

    public static final RegistryObject<PickaxeItem> SKITTLES_PICKAXE = ITEMS.register("skittles_pickaxe", () ->
            new PickaxeItem(ModItemTier.SKITTLES, 1, -2.4f, new Item.Properties().group(AcmMinecraftMod.TAB)));

    public static final RegistryObject<ShovelItem> SKITTLES_SHOVEL = ITEMS.register("skittles_shovel", () ->
            new ShovelItem(ModItemTier.SKITTLES, 1, -3.0f, new Item.Properties().group(AcmMinecraftMod.TAB)));

    public static final RegistryObject<AxeItem> SKITTLES_AXE = ITEMS.register("skittles_axe", () ->
            new AxeItem(ModItemTier.SKITTLES, 5, -3.0f, new Item.Properties().group(AcmMinecraftMod.TAB)));

    public static final RegistryObject<HoeItem> SKITTLES_HOE = ITEMS.register("skittles_hoe", () ->
            new HoeItem(ModItemTier.SKITTLES,-1.0f, new Item.Properties().group(AcmMinecraftMod.TAB)));

}
