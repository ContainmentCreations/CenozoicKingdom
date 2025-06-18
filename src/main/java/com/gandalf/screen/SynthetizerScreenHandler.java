package com.gandalf.screen;

import com.gandalf.ModItems;
import com.gandalf.screen.slot.ModInputSlot;
import com.gandalf.screen.slot.ModResultSlot;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.Inventory;
import net.minecraft.inventory.SimpleInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.screen.ArrayPropertyDelegate;
import net.minecraft.screen.PropertyDelegate;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.screen.slot.Slot;

import java.util.function.Predicate;


public class SynthetizerScreenHandler extends ScreenHandler {
    private final Inventory inventory;
    private final PropertyDelegate propertyDelegate;

    public SynthetizerScreenHandler(int syncId, PlayerInventory playerInventory) {
        this(syncId, playerInventory, new SimpleInventory(13), new ArrayPropertyDelegate(4));
    }

    public SynthetizerScreenHandler(int syncId, PlayerInventory playerInventory, Inventory inventory, PropertyDelegate delegate) {
        super(ModScreenHandlers.SYNTHETIZER_SCREEN_HANDLER, syncId);
        checkSize(inventory, 13);
        this.inventory = inventory;
        inventory.onOpen(playerInventory.player);
        this.addProperties(delegate);
        this.propertyDelegate = delegate;
        Predicate<ItemStack> validInput = stack -> stack.getItem() == ModItems.normalItems.get("cenozoic_dna") || stack.getItem() == ModItems.normalItems.get("modern_dna") || stack.getItem() == ModItems.normalItems.get("paleozoic_dna");
        //
        this.addSlot(new ModInputSlot(inventory, 0, 20, 17, validInput));
        this.addSlot(new ModInputSlot(inventory, 1, 20, 35, validInput));
        this.addSlot(new ModInputSlot(inventory, 2, 20, 53, validInput));
        this.addSlot(new ModInputSlot(inventory, 3, 38, 17, validInput));
        this.addSlot(new ModInputSlot(inventory, 4, 38, 35, validInput));
        this.addSlot(new ModInputSlot(inventory, 5, 38, 53, validInput));
        this.addSlot(new ModInputSlot(inventory, 6, 56, 17, validInput));
        this.addSlot(new ModInputSlot(inventory, 7, 56, 35, validInput));
        this.addSlot(new ModInputSlot(inventory, 8, 56, 53, validInput));

        this.addSlot(new ModResultSlot(inventory, 9, 115, 21));
        this.addSlot(new ModResultSlot(inventory, 10, 111, 53));
        this.addSlot(new ModResultSlot(inventory, 11, 129, 53));
        this.addSlot(new ModResultSlot(inventory, 12, 147, 53));


        addPlayerInventory(playerInventory);
        addPlayerHotbar(playerInventory);
    }

    @Override
    public boolean canUse(PlayerEntity player) {
        return this.inventory.canPlayerUse(player);
    }

    @Override
    public ItemStack transferSlot(PlayerEntity player, int index) {
        ItemStack newStack = ItemStack.EMPTY;
        Slot slot = this.slots.get(index);

        if (slot != null && slot.hasStack()) {
            ItemStack originalStack = slot.getStack();
            newStack = originalStack.copy();

            if (index < 13) {
                if (!this.insertItem(originalStack, 13, this.slots.size(), true)) {
                    return ItemStack.EMPTY;
                }
            } else {
                if (originalStack.getItem() == ModItems.normalItems.get("cenozoic_dna") ||
                        originalStack.getItem() == ModItems.normalItems.get("modern_dna") ||
                        originalStack.getItem() == ModItems.normalItems.get("paleozoic_dna")) {

                    if (!this.insertItem(originalStack, 0, 9, false)) {
                        return ItemStack.EMPTY;
                    }
                } else {
                    return ItemStack.EMPTY;
                }
            }

            if (originalStack.isEmpty()) {
                slot.setStack(ItemStack.EMPTY);
            } else {
                slot.markDirty();
            }
        }

        return newStack;
    }



    private void addPlayerInventory(PlayerInventory playerInventory) {
        for (int i = 0; i < 3; ++i) {
            for (int l = 0; l < 9; ++l) {
                this.addSlot(new Slot(playerInventory, l + i * 9 + 9, 8 + l * 18, 84 + i * 18));
            }
        }
    }

    private void addPlayerHotbar(PlayerInventory playerInventory) {
        for (int i = 0; i < 9; ++i) {
            this.addSlot(new Slot(playerInventory, i, 8 + i * 18, 142));
        }
    }

    public int getScaledProgress() {
        int progress = this.propertyDelegate.get(0);
        int maxProgress = this.propertyDelegate.get(1);
        int arrowWidth = 23;

        return maxProgress != 0 && progress != 0 ? progress * arrowWidth / maxProgress : 0;
    }

    public boolean isCrafting() {
        return this.propertyDelegate.get(0) > 0;
    }

}
