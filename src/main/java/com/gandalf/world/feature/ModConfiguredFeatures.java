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
    public static final List<OreFeatureConfig.Target> OVERWORLD_PERMAFROST_ORES = List.of(
            OreFeatureConfig.createTarget(OreConfiguredFeatures.STONE_ORE_REPLACEABLES,
                    ModBlocks.PERMAFROST_BLOCK.getDefaultState())
    );

    public static final RegistryEntry<ConfiguredFeature<OreFeatureConfig, ?>> PERMAFROST_ORE =
            ConfiguredFeatures.register("permafrost_ore", Feature.ORE,
                    new OreFeatureConfig(OVERWORLD_PERMAFROST_ORES, 20));

    public static final RuleTest FOSSIL_ORE_REPLACEABLES = new TagMatchRuleTest(ModBlockTags.FOSSIL_ORE_REPLACEABLES);

    public static final List<OreFeatureConfig.Target> FOSSIL_ORES = List.of(
        OreFeatureConfig.createTarget(FOSSIL_ORE_REPLACEABLES,
            ModBlocks.FOSSIL_ORE.getDefaultState())
    );

    public static final RegistryEntry<ConfiguredFeature<OreFeatureConfig, ?>> FOSSIL_ORE =
        ConfiguredFeatures.register("fossil_ore", Feature.ORE,
            new OreFeatureConfig(FOSSIL_ORES, 20));

    public static void registerConfiguredFeatures() {
        System.out.println("Registering ModConfiguredFeatures for " + CenozoicKingdom.MOD_ID);
    }
}
