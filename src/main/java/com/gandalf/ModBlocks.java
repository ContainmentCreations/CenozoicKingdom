package com.gandalf;

import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ModBlocks {
    public static final Block SURFACE_PERMAFROST_BLOCK = registerBlock("surface_permafrost_block",
            new Block(net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings.of(Material.STONE)
                    .strength(3.0f, 6.0f)
                    .requiresTool()
                    .sounds(BlockSoundGroup.GRAVEL)));

    public static final Block STONE_PERMAFROST_BLOCK = registerBlock("stone_permafrost_block",
            new Block(net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings.of(Material.STONE)
                    .strength(3.0f, 6.0f)
                    .requiresTool()
                    .sounds(BlockSoundGroup.GRAVEL)));

    public static final Block DEEP_PERMAFROST_BLOCK = registerBlock("deep_permafrost_block",
            new Block(net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings.of(Material.DENSE_ICE)
                    .strength(3.0f, 6.0f)
                    .requiresTool()
                    .sounds(BlockSoundGroup.GLASS)));

    public static final Block ANALYZER = registerBlock("analyzer",
            new AnalyzerBlock());


    public static final Block SYNTHETIZER = registerBlock("synthetizer",
            new SynthetizerBlock());

    public static final Block FOSSIL_ORE = registerBlock("fossil_ore",
        new Block(FabricBlockSettings.of(Material.STONE)
            .strength(3.0f, 6.0f)
            .requiresTool()
            .sounds(BlockSoundGroup.GRAVEL)));


    private static Block registerBlock(String name, Block block) {
        return Registry.register(Registry.BLOCK, new Identifier(CenozoicKingdom.MOD_ID, name), block);
    }

    public static void registerModBlocks() {
        CenozoicKingdom.LOGGER.info("Registering Mod Blocks for " + CenozoicKingdom.MOD_ID);
    }
}

