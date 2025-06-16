package com.gandalf.world.gen;

import com.gandalf.world.feature.ModPlacedFeatures;
import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.minecraft.tag.BiomeTags;
import net.minecraft.world.gen.GenerationStep;

public class ModOreGeneration {
    public static void generateOres() {
        System.out.println("✔️ Generating Permafrost Ore in snowy biomes...");
        BiomeModifications.addFeature(BiomeSelectors.tag(BiomeTags.IS_TAIGA),
                GenerationStep.Feature.UNDERGROUND_ORES, ModPlacedFeatures.PERMAFROST_ORE_PLACED.getKey().get());
        System.out.println("✔️ Generating Fossil Ore...");
        BiomeModifications.addFeature(BiomeSelectors.foundInOverworld(),
            GenerationStep.Feature.UNDERGROUND_ORES, ModPlacedFeatures.FOSSIL_ORE_PLACED.getKey().get());
    }
}



