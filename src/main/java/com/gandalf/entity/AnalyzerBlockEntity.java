package com.gandalf.entity;

import com.gandalf.recipe.AnalyzerRecipe;
import com.gandalf.screen.AnalyzerScreenHandler;
import com.gandalf.util.ImplementedInventory;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.Inventories;
import net.minecraft.inventory.SimpleInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.screen.NamedScreenHandlerFactory;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.text.LiteralText;
import net.minecraft.text.Text;
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;


import java.util.Optional;
import net.minecraft.screen.PropertyDelegate;


public class AnalyzerBlockEntity extends BlockEntity implements NamedScreenHandlerFactory, ImplementedInventory {
    private ItemStack currentOutput = ItemStack.EMPTY;
    private final DefaultedList<ItemStack> inventory =
            DefaultedList.ofSize(13, ItemStack.EMPTY);

    protected final PropertyDelegate propertyDelegate;
    private int progress = 0;
    private int maxProgress = 100;



    public AnalyzerBlockEntity(BlockPos pos, BlockState state) {
        super(ModBlockEntities.ANALYZER, pos, state);

        this.propertyDelegate = new PropertyDelegate() {
            @Override
            public int get(int index) {
                return switch (index) {
                    case 0 -> AnalyzerBlockEntity.this.progress;
                    case 1 -> AnalyzerBlockEntity.this.maxProgress;
                    default -> 0;
                };
            }

            public void set(int index, int value) {
                switch (index) {
                    case 0:
                        AnalyzerBlockEntity.this.progress = value;
                        break;
                    case 1:
                        AnalyzerBlockEntity.this.maxProgress = value;
                        break;
                }
            }

            public int size() {
                return 4;
            }
        };
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
        nbt.putInt("analyzer.progress", progress);
    }

    @Override
    public void readNbt(NbtCompound nbt) {
        Inventories.readNbt(nbt, inventory);
        super.readNbt(nbt);
        progress = nbt.getInt("analyzer.progress");
    }

    public static void tick(World world, BlockPos pos, BlockState state, AnalyzerBlockEntity entity) {
        if (entity.progress == 0 && hasRecipe(entity)) {
            entity.selectCurrentOutput();
        }

        if (entity.hasValidCurrentOutput() && hasRecipe(entity)) {
            if (entity.progress >= entity.maxProgress) {
                craftItem(entity);
            } else if (hasRecipe(entity)){
                entity.progress++;
            }
        } else if (entity.progress > 0) {
            entity.progress = 0;
        }
    }

    private static boolean hasRecipe(AnalyzerBlockEntity entity) {
        World world = entity.world;
        SimpleInventory inventory = new SimpleInventory(entity.inventory.size());
        for (int i = 0; i < 9; i++) {
            inventory.setStack(i, entity.getStack(i));
        }

        assert world != null;
        Optional<AnalyzerRecipe> match = world.getRecipeManager()
            .getFirstMatch(AnalyzerRecipe.Type.INSTANCE, inventory, world);

        return match.isPresent() && canInsertItemIntoOutputSlot(entity, match.get().getOutput());
    }

    private static void craftItem(AnalyzerBlockEntity entity) {
        World world = entity.world;
        SimpleInventory inventory = new SimpleInventory(entity.inventory.size());
        for (int i = 0; i < 9; i++) {
            inventory.setStack(i, entity.getStack(i));
        }

        assert world != null;
        Optional<AnalyzerRecipe> match = world.getRecipeManager()
            .getFirstMatch(AnalyzerRecipe.Type.INSTANCE, inventory, world);


        if(match.isPresent()) {
            ItemStack result = entity.currentOutput.copy();
            for (int i = 0; i < 9; i++) {
                try {
                    if (match.get().getIngredients().get(0).test(entity.getStack(i)) && canInsertItemIntoOutputSlot(entity, result)) {
                        entity.removeStack(i, 1);
                        break;
                    }
                } catch (IndexOutOfBoundsException ignored) {}
            }

            for (int i = 9; i <= 12; i++) {
                ItemStack outputStack = entity.getStack(i);

                if (outputStack.isEmpty()) {
                    entity.setStack(i, result);
                    entity.resetProgress();
                    break;
                } else if (ItemStack.canCombine(outputStack, result) &&
                    outputStack.getCount() + result.getCount() <= outputStack.getMaxCount()) {
                    outputStack.increment(result.getCount());
                    entity.resetProgress();
                    break;
                }
            }
        }
    }

    private void resetProgress() {
        this.progress = 0;
    }

    private static boolean canInsertItemIntoOutputSlot(AnalyzerBlockEntity entity, ItemStack output) {
        for (int i = 9; i <= 12; i++) {
            ItemStack stack = entity.getStack(i);

            if (stack.isEmpty()) {
                return true;
            } else if (ItemStack.canCombine(stack, output) && stack.getCount() + output.getCount() <= stack.getMaxCount()) {
                return true;
            }
        }
        return false;
    }

    private void selectCurrentOutput() {
        World world = this.world;
        if (world == null) return;

        SimpleInventory inv = new SimpleInventory(this.inventory.size());
        for (int i = 0; i < 9; i++) {
            inv.setStack(i, this.getStack(i));
        }

        Optional<AnalyzerRecipe> match = world.getRecipeManager()
            .getFirstMatch(AnalyzerRecipe.Type.INSTANCE, inv, world);

        if (match.isPresent()) {
            ItemStack potentialOutput = match.get().craft(inv);
            if (canInsertItemIntoOutputSlot(this, potentialOutput)) {
                this.currentOutput = potentialOutput;
            } else {
                this.currentOutput = ItemStack.EMPTY;
            }
        } else {
            this.currentOutput = ItemStack.EMPTY;
        }
    }

    private boolean hasValidCurrentOutput() {
        return !this.currentOutput.isEmpty();
    }
}





