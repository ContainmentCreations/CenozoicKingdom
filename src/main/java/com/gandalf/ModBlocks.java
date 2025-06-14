package com.gandalf;

import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ModBlocks {
    public static final Block PERMAFROST_BLOCK = registerBlock("permafrost_block",
            new Block(net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings.of(Material.STONE)
                    .strength(3.0f, 6.0f)
                    .requiresTool()
                    .sounds(BlockSoundGroup.GRAVEL)));

    public static final Block ANALYZER = registerBlock("analyzer",
            new AnalyzerBlock());


    public static final Block SYNTHETIZER = registerBlock("synthetizer",
            new SynthetizerBlock());


    private static Block registerBlock(String name, Block block) {
        return Registry.register(Registry.BLOCK, new Identifier(CenozoicKingdom.MOD_ID, name), block);
    }

    public static void registerModBlocks() {
        CenozoicKingdom.LOGGER.info("Registering Mod Blocks for " + CenozoicKingdom.MOD_ID);
    }
}

