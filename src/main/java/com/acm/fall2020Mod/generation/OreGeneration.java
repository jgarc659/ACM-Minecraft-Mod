package com.acm.fall2020Mod.generation;

import com.acm.fall2020Mod.util.RegistryHandler;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.OreFeatureConfig;
import net.minecraft.world.gen.placement.ConfiguredPlacement;
import net.minecraft.world.gen.placement.CountRangeConfig;
import net.minecraft.world.gen.placement.Placement;
import net.minecraftforge.registries.ForgeRegistries;

public class OreGeneration {
    public static void generateOre() {
        for (Biome biome : ForgeRegistries.BIOMES ) {
            ConfiguredPlacement orePlacementConfiguration = Placement.COUNT_RANGE.configure
                    (new CountRangeConfig(10, 5, 5, 25));

            biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.ORE.withConfiguration
                    (new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE,
                            RegistryHandler.SKITTLES_BLOCK.get().getDefaultState(), 10))
                    .withPlacement(orePlacementConfiguration));
        }
    }
}
