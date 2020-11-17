package com.acm.fall2020Mod.blocks;

import com.acm.fall2020Mod.AcmMinecraftMod;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;

public class BlockItemBase extends BlockItem {
    public BlockItemBase(Block block) {
        super(block, new Item.Properties().group(AcmMinecraftMod.TAB));
    }
}
