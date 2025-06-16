package com.gandalf.block;

import com.gandalf.CenozoicKingdom;
import net.minecraft.block.Block;
import net.minecraft.tag.TagKey;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ModBlockTags {
    public static final TagKey<Block> FOSSIL_ORE_REPLACEABLES = TagKey.of(Registry.BLOCK_KEY, new Identifier(CenozoicKingdom.MOD_ID, "fossil_ore_replaceables"));
}
