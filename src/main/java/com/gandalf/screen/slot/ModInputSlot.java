package com.gandalf.screen.slot;

import net.minecraft.block.entity.AbstractFurnaceBlockEntity;
import net.minecraft.inventory.Inventory;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.screen.slot.Slot;

import java.util.function.Predicate;

public class ModInputSlot extends Slot {
    private final Predicate<ItemStack> isValidItem;

    public ModInputSlot(Inventory inventory, int index, int x, int y, Predicate<ItemStack> isValidItem) {
        super(inventory, index, x, y);
        this.isValidItem = isValidItem;
    }

    @Override
    public boolean canInsert(ItemStack stack) {
        return isValidItem.test(stack);
    }
}

