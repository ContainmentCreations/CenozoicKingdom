package com.gandalf.world.feature;

import com.gandalf.CenozoicKingdom;
import com.gandalf.ModBlocks;
import net.minecraft.util.registry.RegistryEntry;
import net.minecraft.world.gen.feature.*;

import java.util.List;

public class ModConfiguredFeatures {
    public static final List<OreFeatureConfig.Target> OVERWORLD_PERMAFROST_ORES = List.of(
            OreFeatureConfig.createTarget(OreConfiguredFeatures.STONE_ORE_REPLACEABLES,
                    ModBlocks.PERMAFROST_BLOCK.getDefaultState())
    );

    public static final RegistryEntry<ConfiguredFeature<OreFeatureConfig, ?>> PERMAFROST_ORE =
            ConfiguredFeatures.register("permafrost_ore", Feature.ORE,
                    new OreFeatureConfig(OVERWORLD_PERMAFROST_ORES, 20));

    public static void registerConfiguredFeatures() {
        System.out.println("Registering ModConfiguredFeatures for " + CenozoicKingdom.MOD_ID);
    }
}
