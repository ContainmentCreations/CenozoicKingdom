package com.gandalf.item;

import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SpawnEggItem;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableText;
import net.minecraft.util.Formatting;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class ModTooltipEntity extends SpawnEggItem {

    private final String tooltipKey;

    public ModTooltipEntity(EntityType<? extends MobEntity> type, int primaryColor, int secondaryColor, Settings settings, String tooltipKey) {
        super(type, primaryColor, secondaryColor, settings);
        this.tooltipKey = tooltipKey;
    }

    @Override
    public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
        tooltip.add(new TranslatableText(this.tooltipKey).formatted(Formatting.GRAY));
        super.appendTooltip(stack, world, tooltip, context);
    }
}


