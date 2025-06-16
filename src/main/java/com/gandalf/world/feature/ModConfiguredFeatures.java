package com.gandalf.world.feature;

import com.gandalf.CenozoicKingdom;
import com.gandalf.ModBlocks;
import com.gandalf.block.ModBlockTags;
import net.minecraft.structure.rule.RuleTest;
import net.minecraft.structure.rule.TagMatchRuleTest;
import net.minecraft.util.registry.RegistryEntry;
import net.minecraft.world.gen.feature.*;

import java.util.List;

public class ModConfiguredFeatures {
    public static final List<OreFeatureConfig.Target> SURFACE_PERMAFROST_ORES = List.of(
            OreFeatureConfig.createTarget(OreConfiguredFeatures.STONE_ORE_REPLACEABLES,
                    ModBlocks.SURFACE_PERMAFROST_BLOCK.getDefaultState())
    );

    public static final RegistryEntry<ConfiguredFeature<OreFeatureConfig, ?>> SURFACE_PERMAFROST_ORE =
            ConfiguredFeatures.register("surface_permafrost_ore", Feature.ORE,
                    new OreFeatureConfig(SURFACE_PERMAFROST_ORES, 16));

    public static final RuleTest FOSSIL_ORE_REPLACEABLES = new TagMatchRuleTest(ModBlockTags.FOSSIL_ORE_REPLACEABLES);

    public static final List<OreFeatureConfig.Target> FOSSIL_ORES = List.of(
        OreFeatureConfig.createTarget(FOSSIL_ORE_REPLACEABLES,
            ModBlocks.FOSSIL_ORE.getDefaultState())
    );

    public static final RegistryEntry<ConfiguredFeature<OreFeatureConfig, ?>> FOSSIL_ORE =
        ConfiguredFeatures.register("fossil_ore", Feature.ORE,
            new OreFeatureConfig(FOSSIL_ORES, 9));

    public static final List<OreFeatureConfig.Target> STONE_PERMAFROST_ORES = List.of(
            OreFeatureConfig.createTarget(OreConfiguredFeatures.STONE_ORE_REPLACEABLES,
                    ModBlocks.STONE_PERMAFROST_BLOCK.getDefaultState())
    );

    public static final RegistryEntry<ConfiguredFeature<OreFeatureConfig, ?>> STONE_PERMAFROST_ORE =
            ConfiguredFeatures.register("stone_permafrost_ore", Feature.ORE,
                    new OreFeatureConfig(STONE_PERMAFROST_ORES, 12));

    public static final List<OreFeatureConfig.Target> DEEP_PERMAFROST_ORES = List.of(
            OreFeatureConfig.createTarget(OreConfiguredFeatures.DEEPSLATE_ORE_REPLACEABLES,
                    ModBlocks.DEEP_PERMAFROST_BLOCK.getDefaultState())
    );

    public static final RegistryEntry<ConfiguredFeature<OreFeatureConfig, ?>> DEEP_PERMAFROST_ORE =
            ConfiguredFeatures.register("deep_permafrost_ore", Feature.ORE,
                    new OreFeatureConfig(DEEP_PERMAFROST_ORES, 9));

    public static void registerConfiguredFeatures() {
        System.out.println("Registering ModConfiguredFeatures for " + CenozoicKingdom.MOD_ID);
    }
}
