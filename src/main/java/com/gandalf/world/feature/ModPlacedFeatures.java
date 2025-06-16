package com.gandalf.world.feature;

import net.minecraft.util.registry.RegistryEntry;
import net.minecraft.world.gen.YOffset;
import net.minecraft.world.gen.feature.PlacedFeature;
import net.minecraft.world.gen.feature.PlacedFeatures;
import net.minecraft.world.gen.placementmodifier.HeightRangePlacementModifier;

public class ModPlacedFeatures {
    public static final RegistryEntry<PlacedFeature> PERMAFROST_SURFACE_PLACED = PlacedFeatures.register("permafrost_surface_placed",
            ModConfiguredFeatures.SURFACE_PERMAFROST_ORE, ModOreFeatures.modifiersWithCount(15,
                    HeightRangePlacementModifier.trapezoid(YOffset.fixed(64), YOffset.aboveBottom(128))));

    public static final RegistryEntry<PlacedFeature> FOSSIL_ORE_PLACED = PlacedFeatures.register("fossil_ore_placed",
        ModConfiguredFeatures.FOSSIL_ORE, ModOreFeatures.modifiersWithCount(15,
            HeightRangePlacementModifier.trapezoid(YOffset.fixed(32), YOffset.aboveBottom(96))));

    public static final RegistryEntry<PlacedFeature> PERMAFROST_STONE_PLACED = PlacedFeatures.register("permafrost_stone_placed",
            ModConfiguredFeatures.STONE_PERMAFROST_ORE, ModOreFeatures.modifiersWithCount(5,
                    HeightRangePlacementModifier.trapezoid(YOffset.fixed(30), YOffset.fixed(60))));

    public static final RegistryEntry<PlacedFeature> PERMAFROST_DEEP_PLACED = PlacedFeatures.register("permafrost_deep_placed",
            ModConfiguredFeatures.DEEP_PERMAFROST_ORE, ModOreFeatures.modifiersWithCount(4,
                    HeightRangePlacementModifier.trapezoid(YOffset.BOTTOM, YOffset.fixed(0))));
}
