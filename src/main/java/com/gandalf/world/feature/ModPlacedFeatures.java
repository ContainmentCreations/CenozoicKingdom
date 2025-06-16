package com.gandalf.world.feature;

import net.minecraft.util.registry.RegistryEntry;
import net.minecraft.world.gen.YOffset;
import net.minecraft.world.gen.feature.PlacedFeature;
import net.minecraft.world.gen.feature.PlacedFeatures;
import net.minecraft.world.gen.placementmodifier.HeightRangePlacementModifier;

public class ModPlacedFeatures {
    public static final RegistryEntry<PlacedFeature> PERMAFROST_ORE_PLACED = PlacedFeatures.register("permafrost_ore_placed",
            ModConfiguredFeatures.PERMAFROST_ORE, ModOreFeatures.modifiersWithCount(15,
                    HeightRangePlacementModifier.trapezoid(YOffset.aboveBottom(32), YOffset.aboveBottom(96))));

    public static final RegistryEntry<PlacedFeature> FOSSIL_ORE_PLACED = PlacedFeatures.register("fossil_ore_placed",
        ModConfiguredFeatures.FOSSIL_ORE, ModOreFeatures.modifiersWithCount(15,
            HeightRangePlacementModifier.trapezoid(YOffset.fixed(32), YOffset.aboveBottom(96))));
}
