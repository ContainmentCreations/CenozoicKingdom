package com.gandalf.item;

import net.minecraft.client.item.TooltipContext;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableText;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class ModTooltipItem extends Item {
    private final String translationKey;

    public ModTooltipItem(Settings settings, String tooltipTranslationKey) {
        super(settings);
        this.translationKey = tooltipTranslationKey;
    }

    @Override
    public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
        tooltip.add(new TranslatableText(translationKey));
    }
}

