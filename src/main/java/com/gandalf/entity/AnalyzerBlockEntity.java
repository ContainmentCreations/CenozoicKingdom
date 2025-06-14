package com.gandalf.entity;

import com.gandalf.ModItems;
import com.gandalf.screen.AnalyzerScreenHandler;
import com.gandalf.util.ImplementedInventory;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.Inventories;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.screen.NamedScreenHandlerFactory;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.text.LiteralText;
import net.minecraft.text.Text;
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;


import java.util.List;
import java.util.Random;
import net.minecraft.screen.PropertyDelegate;
import net.minecraft.screen.ArrayPropertyDelegate;




public class AnalyzerBlockEntity extends BlockEntity implements NamedScreenHandlerFactory, ImplementedInventory {
    private int processingTime = 0;
    private final DefaultedList<ItemStack> inventory =
            DefaultedList.ofSize(13, ItemStack.EMPTY);

    private static final List<WeightedItem> POSSIBLE_OUTPUTS_FROZEN = List.of(
            new WeightedItem(ModItems.CENOZOIC_DNA, 10),
            new WeightedItem(ModItems.MODERN_DNA, 15),
            new WeightedItem(ModItems.DESTROYED_DNA, 5),
            new WeightedItem(Items.BEEF, 30),
            new WeightedItem(Items.ICE, 20),
            new WeightedItem(Items.SAND, 20)
    );

    private static final List<WeightedItem> POSSIBLE_OUTPUTS_FOSSIL = List.of(
            new WeightedItem(ModItems.PALEOZOIC_MAMMAL_DNA, 20),
            new WeightedItem(ModItems.DESTROYED_DNA, 20),
            new WeightedItem(Items.BEEF, 30),
            new WeightedItem(Items.BONE, 20),
            new WeightedItem(Items.BONE_MEAL, 10)
    );



    public AnalyzerBlockEntity(BlockPos pos, BlockState state) {
        super(ModBlockEntities.ANALYZER, pos, state);
    }

    @Override
    public DefaultedList<ItemStack> getItems() {
        return inventory;
    }

    @Override
    public Text getDisplayName() {
        return new LiteralText("Analyzer");
    }

    @Nullable
    @Override
    public ScreenHandler createMenu(int syncId, PlayerInventory inv, PlayerEntity player) {
        return new AnalyzerScreenHandler(syncId, inv, this, this.propertyDelegate);
    }

    @Override
    protected void writeNbt(NbtCompound nbt) {
        super.writeNbt(nbt);
        Inventories.writeNbt(nbt, inventory);
    }

    @Override
    public void readNbt(NbtCompound nbt) {
        Inventories.readNbt(nbt, inventory);
        super.readNbt(nbt);
    }

    public static void tick(World world, BlockPos pos, BlockState state, AnalyzerBlockEntity entity) {
        if (world.isClient) return;

        if (hasValidInputs(entity)) {
            entity.processingTime++;
            entity.propertyDelegate.set(0, entity.processingTime);
            entity.propertyDelegate.set(1, 100);

            if (entity.processingTime >= 100) {
                craftRandomOutput(entity);
                entity.processingTime = 0;
                entity.propertyDelegate.set(0, 0);
            }
        } else {
            if (entity.processingTime != 0) {
                entity.processingTime = 0;
                entity.propertyDelegate.set(0, 0);
            }
        }
    }



    private static boolean hasValidInputs(AnalyzerBlockEntity entity) {
        for (int i = 0; i < 9; i++) {
            Item item = entity.getStack(i).getItem();
            if (item == ModItems.FROZEN_SKIN || item == ModItems.FROZEN_MEAT || item == ModItems.FROZEN_BONE || item == ModItems.FOSSIL_SKIN || item == ModItems.FOSSIL_BONE) {
                return true;
            }
        }
        return false;
    }

    private static final Random RANDOM = new Random();

    private static void craftRandomOutput(AnalyzerBlockEntity entity) {
        boolean modified = false;
        Item usedItem = null;
        boolean isFossil = false;

        for (int i = 0; i < 9; i++) {
            ItemStack stack = entity.getStack(i);
            if (!stack.isEmpty()) {
                Item item = stack.getItem();
                if (item == ModItems.FROZEN_BONE || item == ModItems.FROZEN_MEAT || item == ModItems.FROZEN_SKIN) {
                    stack.decrement(1);
                    usedItem = item;
                    isFossil = false;
                    modified = true;
                    break;
                } else if (item == ModItems.FOSSIL_BONE || item == ModItems.FOSSIL_SKIN) {
                    stack.decrement(1);
                    usedItem = item;
                    isFossil = true;
                    modified = true;
                    break;
                }
            }
        }

        if (usedItem == null) return;

        List<WeightedItem> outputPool = isFossil ? POSSIBLE_OUTPUTS_FOSSIL : POSSIBLE_OUTPUTS_FROZEN;

        int totalWeight = outputPool.stream().mapToInt(w -> w.weight).sum();
        int r = RANDOM.nextInt(totalWeight);
        int cumulative = 0;

        Item outputItem = Items.AIR;
        for (WeightedItem wi : outputPool) {
            cumulative += wi.weight;
            if (r < cumulative) {
                outputItem = wi.item;
                break;
            }
        }

        ItemStack output = new ItemStack(outputItem);

        for (int i = 9; i < 13; i++) {
            ItemStack current = entity.getStack(i);
            if (current.isEmpty()) {
                entity.setStack(i, output);
                modified = true;
                break;
            } else if (ItemStack.canCombine(current, output) && current.getCount() < current.getMaxCount()) {
                current.increment(1);
                modified = true;
                break;
            }
        }

        if (modified) {
            entity.markDirty();
        }
    }



    private final PropertyDelegate propertyDelegate = new ArrayPropertyDelegate(2);
    public PropertyDelegate getPropertyDelegate() {
        return propertyDelegate;
    }

    private static class WeightedItem {
        public final Item item;
        public final int weight;

        public WeightedItem(Item item, int weight) {
            this.item = item;
            this.weight = weight;
        }
    }

    private static Item rollWeightedOutput(List<WeightedItem> outputs) {
        int totalWeight = outputs.stream().mapToInt(w -> w.weight).sum();
        int roll = RANDOM.nextInt(totalWeight);
        int cumulative = 0;

        for (WeightedItem item : outputs) {
            cumulative += item.weight;
            if (roll < cumulative) {
                return item.item;
            }
        }

        return outputs.get(outputs.size() - 1).item; // Fallback
    }


}





