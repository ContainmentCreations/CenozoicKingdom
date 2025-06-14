package com.gandalf.item;

import net.minecraft.block.Block;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.item.BlockItem;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableText;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class ModTooltipBlockItem extends BlockItem {
    private final String translationKey;

    public ModTooltipBlockItem(Block block, Settings settings, String tooltipTranslationKey) {
        super(block, settings);
        this.translationKey = tooltipTranslationKey;
    }

    @Override
    public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
        tooltip.add(new TranslatableText(translationKey));
    }
}

