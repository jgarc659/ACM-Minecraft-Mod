package com.acm.fall2020Mod.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraftforge.common.ToolType;

public class SkittlesBlock extends Block {

    public SkittlesBlock() {
        super(Block.Properties.create(Material.ROCK)
            .hardnessAndResistance(0.3f, 0.3f)
                .sound(SoundType.STONE)
                .harvestLevel(0)
                .harvestTool(ToolType.PICKAXE)
        );
    }

}
