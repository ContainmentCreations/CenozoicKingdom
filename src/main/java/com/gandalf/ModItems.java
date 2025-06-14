package com.gandalf;

import com.gandalf.item.ModTooltipBlockItem;
import com.gandalf.item.ModTooltipItem;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ModItems {

    // Items
    public static final Item FROZEN_BONE = registerItem("frozen_bone",
            new ModTooltipItem(new FabricItemSettings().maxCount(64), "tooltip.cenozoic_kingdom.frozen_bone"));

    public static final Item FROZEN_MEAT = registerItem("frozen_meat",
            new ModTooltipItem(new FabricItemSettings().maxCount(64), "tooltip.cenozoic_kingdom.frozen_meat"));

    public static final Item FROZEN_SKIN = registerItem("frozen_skin",
            new ModTooltipItem(new FabricItemSettings().maxCount(64), "tooltip.cenozoic_kingdom.frozen_skin"));

    public static final Item CENOZOIC_DNA = registerItem("cenozoic_dna",
            new ModTooltipItem(new FabricItemSettings().maxCount(64), "tooltip.cenozoic_kingdom.cenozoic_dna"));

    public static final Item MODERN_DNA = registerItem("modern_dna",
            new ModTooltipItem(new FabricItemSettings().maxCount(64), "tooltip.cenozoic_kingdom.modern_dna"));

    public static final Item PALEOZOIC_MAMMAL_DNA = registerItem("paleozoic_mammal_dna",
            new ModTooltipItem(new FabricItemSettings().maxCount(64), "tooltip.cenozoic_kingdom.paleozoic_mammal_dna"));

    public static final Item MUTATED_GENOME = registerItem("mutated_genome",
            new ModTooltipItem(new FabricItemSettings().maxCount(64), "tooltip.cenozoic_kingdom.mutated_genome"));

    public static final Item DESTROYED_DNA = registerItem("destroyed_dna",
            new ModTooltipItem(new FabricItemSettings().maxCount(64), "tooltip.cenozoic_kingdom.destroyed_dna"));

    public static final Item FOSSIL_BONE = registerItem("fossil_bone",
            new ModTooltipItem(new FabricItemSettings().maxCount(64), "tooltip.cenozoic_kingdom.fossil_bone"));

    public static final Item FOSSIL_SKIN = registerItem("fossil_skin",
            new ModTooltipItem(new FabricItemSettings().maxCount(64), "tooltip.cenozoic_kingdom.fossil_skin"));


    //DNAs
    //Paleozoic DNAs
    public static final Item DIMETRODON_DNA = registerItem("dimetrodon_dna",
            new ModTooltipItem(new FabricItemSettings().maxCount(64), "tooltip.cenozoic_kingdom.dimetrodon_dna"));

    public static final Item EDAPHOSAURUS_DNA = registerItem("edaphosaurus_dna",
            new ModTooltipItem(new FabricItemSettings().maxCount(64), "tooltip.cenozoic_kingdom.edaphosaurus_dna"));

    public static final Item CASEA_DNA = registerItem("casea_dna",
            new ModTooltipItem(new FabricItemSettings().maxCount(64), "tooltip.cenozoic_kingdom.casea_dna"));

    public static final Item ARCHEOTHYRIS_DNA = registerItem("archeothyris_dna",
            new ModTooltipItem(new FabricItemSettings().maxCount(64), "tooltip.cenozoic_kingdom.archeothyris_dna"));

    public static final Item EOTHYRIS_DNA = registerItem("eothyris_dna",
            new ModTooltipItem(new FabricItemSettings().maxCount(64), "tooltip.cenozoic_kingdom.eothyris_dna"));

    public static final Item OECISTHEUS_DNA = registerItem("oecistheus_dna",
            new ModTooltipItem(new FabricItemSettings().maxCount(64), "tooltip.cenozoic_kingdom.oecistheus_dna"));



    // Cenozoic DNA
    public static final Item SMILODON_DNA = registerItem("smilodon_dna",
            new ModTooltipItem(new FabricItemSettings().maxCount(64), "tooltip.cenozoic_kingdom.smilodon_dna"));

    public static final Item MASTODON_DNA = registerItem("mastodon_dna",
            new ModTooltipItem(new FabricItemSettings().maxCount(64), "tooltip.cenozoic_kingdom.mastodon_dna"));

    public static final Item MEGATHERIUM_DNA = registerItem("megatherium_dna",
            new ModTooltipItem(new FabricItemSettings().maxCount(64), "tooltip.cenozoic_kingdom.megatherium_dna"));

    public static final Item KELENKEN_DNA = registerItem("kelenken_dna",
            new ModTooltipItem(new FabricItemSettings().maxCount(64), "tooltip.cenozoic_kingdom.kelenken_dna"));

    public static final Item DOEDICURUS_DNA = registerItem("doedicurus_dna",
            new ModTooltipItem(new FabricItemSettings().maxCount(64), "tooltip.cenozoic_kingdom.doedicurus_dna"));




    // Modern Extinct DNA
    public static final Item DODO_DNA = registerItem("dodo_dna",
            new ModTooltipItem(new FabricItemSettings().maxCount(64), "tooltip.cenozoic_kingdom.dodo_dna"));

    public static final Item AUROCHS_DNA = registerItem("aurochs_dna",
            new ModTooltipItem(new FabricItemSettings().maxCount(64), "tooltip.cenozoic_kingdom.aurochs_dna"));

    public static final Item THYLACINE_DNA = registerItem("thylacine_dna",
            new ModTooltipItem(new FabricItemSettings().maxCount(64), "tooltip.cenozoic_kingdom.thylacine_dna"));

    public static final Item PASSENGER_PIGEON_DNA = registerItem("passenger_pigeon_dna",
            new ModTooltipItem(new FabricItemSettings().maxCount(64), "tooltip.cenozoic_kingdom.passenger_pigeon_dna"));

    public static final Item GREAT_AUK_DNA = registerItem("great_auk_dna",
            new ModTooltipItem(new FabricItemSettings().maxCount(64), "tooltip.cenozoic_kingdom.great_auk_dna"));

    public static final Item STELLERS_SEA_COW_DNA = registerItem("stellers_sea_cow_dna",
            new ModTooltipItem(new FabricItemSettings().maxCount(64), "tooltip.cenozoic_kingdom.stellers_sea_cow_dna"));

    public static final Item QUAGGA_DNA = registerItem("quagga_dna",
            new ModTooltipItem(new FabricItemSettings().maxCount(64), "tooltip.cenozoic_kingdom.quagga_dna"));

    public static final Item MOA_DNA = registerItem("moa_dna",
            new ModTooltipItem(new FabricItemSettings().maxCount(64), "tooltip.cenozoic_kingdom.moa_dna"));

    public static final Item HAASTS_EAGLE_DNA = registerItem("haasts_eagle_dna",
            new ModTooltipItem(new FabricItemSettings().maxCount(64), "tooltip.cenozoic_kingdom.haasts_eagle_dna"));



    //BlockItems
    public static final Item PERMAFROST_BLOCK_ITEM = registerItem("permafrost_block",
            new ModTooltipBlockItem(ModBlocks.PERMAFROST_BLOCK, new FabricItemSettings(), "tooltip.cenozoic_kingdom.permafrost_block"));

    public static final Item ANALYZER_ITEM = registerItem("analyzer",
            new ModTooltipBlockItem(ModBlocks.ANALYZER, new FabricItemSettings(), "tooltip.cenozoic_kingdom.analyzer"));

    public static final Item SYNTHETIZER_ITEM = registerItem("synthetizer",
            new ModTooltipBlockItem(ModBlocks.SYNTHETIZER, new FabricItemSettings(), "tooltip.cenozoic_kingdom.synthetizer"));


    // Creative Group
    // stacks.add(new ItemStack());
    public static final ItemGroup CENOZOIC_GROUP = FabricItemGroupBuilder.create(
                    new Identifier("cenozoic_kingdom", "cenozoic_group"))
            .icon(() -> new ItemStack(FROZEN_BONE))
            .appendItems(stacks -> {
                stacks.add(new ItemStack(FROZEN_BONE));
                stacks.add(new ItemStack(PERMAFROST_BLOCK_ITEM));
                stacks.add(new ItemStack(FROZEN_MEAT));
                stacks.add(new ItemStack(FROZEN_SKIN));
                stacks.add(new ItemStack(ANALYZER_ITEM));
                stacks.add(new ItemStack(CENOZOIC_DNA));
                stacks.add(new ItemStack(MODERN_DNA));
                stacks.add(new ItemStack(PALEOZOIC_MAMMAL_DNA));
                stacks.add(new ItemStack(SYNTHETIZER_ITEM));
                stacks.add(new ItemStack(MUTATED_GENOME));
                stacks.add(new ItemStack(DESTROYED_DNA));
                stacks.add(new ItemStack(DIMETRODON_DNA));
                stacks.add(new ItemStack(EDAPHOSAURUS_DNA));
                stacks.add(new ItemStack(CASEA_DNA));
                stacks.add(new ItemStack(ARCHEOTHYRIS_DNA));
                stacks.add(new ItemStack(EOTHYRIS_DNA));
                stacks.add(new ItemStack(OECISTHEUS_DNA));
                stacks.add(new ItemStack(SMILODON_DNA));
                stacks.add(new ItemStack(MASTODON_DNA));
                stacks.add(new ItemStack(MEGATHERIUM_DNA));
                stacks.add(new ItemStack(KELENKEN_DNA));
                stacks.add(new ItemStack(DOEDICURUS_DNA));
                stacks.add(new ItemStack(DODO_DNA));
                stacks.add(new ItemStack(AUROCHS_DNA));
                stacks.add(new ItemStack(THYLACINE_DNA));
                stacks.add(new ItemStack(PASSENGER_PIGEON_DNA));
                stacks.add(new ItemStack(GREAT_AUK_DNA));
                stacks.add(new ItemStack(STELLERS_SEA_COW_DNA));
                stacks.add(new ItemStack(QUAGGA_DNA));
                stacks.add(new ItemStack(MOA_DNA));
                stacks.add(new ItemStack(HAASTS_EAGLE_DNA));
                stacks.add(new ItemStack(FOSSIL_BONE));
                stacks.add(new ItemStack(FOSSIL_SKIN));
            })
            .build();

    private static Item registerItem(String name, Item item) {
        return Registry.register(Registry.ITEM, new Identifier(CenozoicKingdom.MOD_ID, name), item);
    }

    public static void registerModItems() {
        CenozoicKingdom.LOGGER.info("Registering Mod Items for " + CenozoicKingdom.MOD_ID);
    }
}

