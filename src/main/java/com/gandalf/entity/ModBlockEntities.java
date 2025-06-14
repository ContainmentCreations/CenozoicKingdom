package com.gandalf.entity;

import com.gandalf.CenozoicKingdom;
import com.gandalf.ModBlocks;
import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ModBlockEntities {
    public static BlockEntityType<AnalyzerBlockEntity> ANALYZER;
    public static BlockEntityType<SynthetizerBlockEntity> SYNTHETIZER;

    public static void registerAllBlockEntities() {
        ANALYZER = Registry.register(Registry.BLOCK_ENTITY_TYPE,
                new Identifier(CenozoicKingdom.MOD_ID, "analyzer"),
                FabricBlockEntityTypeBuilder.create(AnalyzerBlockEntity::new,
                        ModBlocks.ANALYZER).build(null));
        SYNTHETIZER = Registry.register(Registry.BLOCK_ENTITY_TYPE,
                new Identifier(CenozoicKingdom.MOD_ID, "synthetizer"),
                FabricBlockEntityTypeBuilder.create(SynthetizerBlockEntity::new,
                        ModBlocks.SYNTHETIZER).build(null));
    }
}
