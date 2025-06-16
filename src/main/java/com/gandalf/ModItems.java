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

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ModItems {
    public static Map<String, Item> normalItems = new HashMap<>();
    public static Map<String, Item> paleozoicDNAs = new HashMap<>();
    public static Map<String, Item> cenozoicDNAs = new HashMap<>();
    public static Map<String, Item> modernExtinctDNAs = new HashMap<>();

    private static void registerNormalItems() {
        List<String> normalItemIdentifiers = new ArrayList<>() {{
            add("frozen_bone");
            add("frozen_meat");
            add("frozen_skin");
            add("cenozoic_dna");
            add("modern_dna");
            add("paleozoic_mammal_dna");
            add("mutated_genome");
            add("destroyed_dna");
            add("fossil_bone");
            add("fossil_skin");
        }};
        for (String normalItemIdentifier : normalItemIdentifiers) {
            Item normalItem = registerItem(normalItemIdentifier,
                new ModTooltipItem(new FabricItemSettings().maxCount(64), "tooltip.cenozoic_kingdom." + normalItemIdentifier));
            normalItems.put(normalItemIdentifier, normalItem);
        }
    }

    private static void registerDNAs () {
        registerPaleozoicDNAs();
        registerCenozoicDNAs();
        registerModernExtinctDNAs();
    }

    private static void registerPaleozoicDNAs() {
        List<String> paleozoicDNAIdentifiers = new ArrayList<>() {{
            add("dimetrodon_dna");
            add("edaphosaurus_dna");
            add("casea_dna");
            add("archeothyris_dna");
            add("eothyris_dna");
            add("ophiacodon_dna");

        }};
        for (String paleozoicDNAIdentifier : paleozoicDNAIdentifiers) {
            Item paleozoicDNA = registerItem(paleozoicDNAIdentifier,
                new ModTooltipItem(new FabricItemSettings().maxCount(64), "tooltip.cenozoic_kingdom." + paleozoicDNAIdentifier));
            paleozoicDNAs.put(paleozoicDNAIdentifier, paleozoicDNA);
        }
    }

    private static void registerCenozoicDNAs() {
        List<String> cenozoicDNAIdentifiers = new ArrayList<>() {{
            add("smilodon_dna");
            add("mastodon_dna");
            add("megatherium_dna");
            add("kelenken_dna");
            add("doedicurus_dna");
        }};
        for (String cenozoicDNAIdentifier : cenozoicDNAIdentifiers) {
            Item cenozoicDNA = registerItem(cenozoicDNAIdentifier,
                new ModTooltipItem(new FabricItemSettings().maxCount(64), "tooltip.cenozoic_kingdom." + cenozoicDNAIdentifier));
            cenozoicDNAs.put(cenozoicDNAIdentifier, cenozoicDNA);
        }
    }

    private static void registerModernExtinctDNAs() {
        List<String> modernExtinctDNAIdentifiers = new ArrayList<>() {{
            add("dodo_dna");
            add("aurochs_dna");
            add("thylacine_dna");
            add("passenger_pigeon_dna");
            add("great_auk_dna");
            add("stellers_sea_cow_dna");
            add("quagga_dna");
            add("moa_dna");
            add("haasts_eagle_dna");
        }};
        for (String modernExtinctDNAIdentifier : modernExtinctDNAIdentifiers) {
            Item modernExtinctDNA = registerItem(modernExtinctDNAIdentifier,
                new ModTooltipItem(new FabricItemSettings().maxCount(64), "tooltip.cenozoic_kingdom." + modernExtinctDNAIdentifier));
            modernExtinctDNAs.put(modernExtinctDNAIdentifier, modernExtinctDNA);
        }
    }

    //BlockItems
    public static final Item PERMAFROST_BLOCK_ITEM = registerItem("permafrost_block",
            new ModTooltipBlockItem(ModBlocks.PERMAFROST_BLOCK, new FabricItemSettings(), "tooltip.cenozoic_kingdom.permafrost_block"));

    public static final Item ANALYZER_ITEM = registerItem("analyzer",
            new ModTooltipBlockItem(ModBlocks.ANALYZER, new FabricItemSettings(), "tooltip.cenozoic_kingdom.analyzer"));

    public static final Item SYNTHETIZER_ITEM = registerItem("synthetizer",
            new ModTooltipBlockItem(ModBlocks.SYNTHETIZER, new FabricItemSettings(), "tooltip.cenozoic_kingdom.synthetizer"));

    public static final Item FOSSIL_ORE_ITEM = registerItem("fossil_ore",
        new ModTooltipBlockItem(ModBlocks.FOSSIL_ORE, new FabricItemSettings(), "tooltip.cenozoic_kingdom.fossil_ore"));


    // Creative Group
    // stacks.add(new ItemStack());
    public static final ItemGroup CENOZOIC_GROUP = FabricItemGroupBuilder.create(
                    new Identifier("cenozoic_kingdom", "cenozoic_group"))
            .icon(() -> new ItemStack(normalItems.get("frozen_bone")))
            .appendItems(stacks -> {
                stacks.add(new ItemStack(normalItems.get("frozen_bone")));
                stacks.add(new ItemStack(PERMAFROST_BLOCK_ITEM));
                stacks.add(new ItemStack(normalItems.get("frozen_meat")));
                stacks.add(new ItemStack(normalItems.get("frozen_skin")));
                stacks.add(new ItemStack(ANALYZER_ITEM));
                stacks.add(new ItemStack(normalItems.get("cenozoic_dna")));
                stacks.add(new ItemStack(normalItems.get("modern_dna")));
                stacks.add(new ItemStack(normalItems.get("paleozoic_mammal_dna")));
                stacks.add(new ItemStack(SYNTHETIZER_ITEM));
                stacks.add(new ItemStack(normalItems.get("mutated_genome")));
                stacks.add(new ItemStack(normalItems.get("destroyed_dna")));
                stacks.add(new ItemStack(paleozoicDNAs.get("dimetrodon_dna")));
                stacks.add(new ItemStack(paleozoicDNAs.get("edaphosaurus_dna")));
                stacks.add(new ItemStack(paleozoicDNAs.get("casea_dna")));
                stacks.add(new ItemStack(paleozoicDNAs.get("archeothyris_dna")));
                stacks.add(new ItemStack(paleozoicDNAs.get("eothyris_dna")));
                stacks.add(new ItemStack(paleozoicDNAs.get("ophiacodon_dna")));
                stacks.add(new ItemStack(cenozoicDNAs.get("smilodon_dna")));
                stacks.add(new ItemStack(cenozoicDNAs.get("mastodon_dna")));
                stacks.add(new ItemStack(cenozoicDNAs.get("megatherium_dna")));
                stacks.add(new ItemStack(cenozoicDNAs.get("kelenken_dna")));
                stacks.add(new ItemStack(cenozoicDNAs.get("doedicurus_dna")));
                stacks.add(new ItemStack(modernExtinctDNAs.get("dodo_dna")));
                stacks.add(new ItemStack(modernExtinctDNAs.get("aurochs_dna")));
                stacks.add(new ItemStack(modernExtinctDNAs.get("thylacine_dna")));
                stacks.add(new ItemStack(modernExtinctDNAs.get("passenger_pigeon_dna")));
                stacks.add(new ItemStack(modernExtinctDNAs.get("great_auk_dna")));
                stacks.add(new ItemStack(modernExtinctDNAs.get("stellers_sea_cow_dna")));
                stacks.add(new ItemStack(modernExtinctDNAs.get("quagga_dna")));
                stacks.add(new ItemStack(modernExtinctDNAs.get("moa_dna")));
                stacks.add(new ItemStack(modernExtinctDNAs.get("haasts_eagle_dna")));
                stacks.add(new ItemStack(normalItems.get("fossil_bone")));
                stacks.add(new ItemStack(normalItems.get("fossil_skin")));
                stacks.add(new ItemStack(FOSSIL_ORE_ITEM));
            })
            .build();

    private static Item registerItem(String name, Item item) {
        return Registry.register(Registry.ITEM, new Identifier(CenozoicKingdom.MOD_ID, name), item);
    }

    public static void registerModItems() {
        CenozoicKingdom.LOGGER.info("Registering Mod Items for " + CenozoicKingdom.MOD_ID);
        registerNormalItems();
        registerDNAs();
    }
}

