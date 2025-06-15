package com.gandalf.entity;

import com.gandalf.ModItems;
import com.gandalf.screen.SynthetizerScreenHandler;
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
import net.minecraft.text.TranslatableText;
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;
import java.util.List;
import java.util.Random;
import net.minecraft.screen.PropertyDelegate;
import net.minecraft.screen.ArrayPropertyDelegate;
import net.minecraft.util.Formatting;





public class SynthetizerBlockEntity extends BlockEntity implements NamedScreenHandlerFactory, ImplementedInventory {
    private static Item usedDNA;
    private static boolean modified;
    private static Item outputItem;
    private int processingTime = 0;
    private final DefaultedList<ItemStack> inventory =
            DefaultedList.ofSize(13, ItemStack.EMPTY);

    private static final List<WeightedItem> POSSIBLE_PZ_OUTPUTS = List.of(
            new WeightedItem(ModItems.DIMETRODON_DNA, 5),
            new WeightedItem(ModItems.EDAPHOSAURUS_DNA, 3),
            new WeightedItem(ModItems.CASEA_DNA, 2),
            new WeightedItem(ModItems.ARCHEOTHYRIS_DNA, 1),
            new WeightedItem(ModItems.EOTHYRIS_DNA, 2),
            new WeightedItem(ModItems.OPHIACODON_DNA, 1),
            new WeightedItem(Items.BONE, 16),
            new WeightedItem(Items.BEEF, 30),
            new WeightedItem(Items.BONE_MEAL, 40)
            // Add more
    );

    private static final List<WeightedItem> POSSIBLE_KZ_OUTPUTS = List.of(
            new WeightedItem(ModItems.SMILODON_DNA, 10),
            new WeightedItem(ModItems.MASTODON_DNA, 7),
            new WeightedItem(ModItems.MEGATHERIUM_DNA, 5),
            new WeightedItem(ModItems.KELENKEN_DNA, 4),
            new WeightedItem(ModItems.DOEDICURUS_DNA, 3),
            new WeightedItem(Items.BONE, 21),
            new WeightedItem(Items.BEEF, 20),
            new WeightedItem(Items.BONE_MEAL, 30)
            // Add more
    );

    private static final List<WeightedItem> POSSIBLE_MODERN_OUTPUTS = List.of(
            new WeightedItem(ModItems.DODO_DNA, 10),
            new WeightedItem(ModItems.AUROCHS_DNA, 8),
            new WeightedItem(ModItems.THYLACINE_DNA, 7),
            new WeightedItem(ModItems.PASSENGER_PIGEON_DNA, 6),
            new WeightedItem(ModItems.GREAT_AUK_DNA, 5),
            new WeightedItem(ModItems.STELLERS_SEA_COW_DNA, 4),
            new WeightedItem(ModItems.QUAGGA_DNA, 7),
            new WeightedItem(ModItems.MOA_DNA, 3),
            new WeightedItem(ModItems.HAASTS_EAGLE_DNA, 2),
            new WeightedItem(Items.BONE, 16),
            new WeightedItem(Items.BEEF, 16),
            new WeightedItem(Items.BONE_MEAL, 16)
            // Add more
    );


    public SynthetizerBlockEntity(BlockPos pos, BlockState state) {
        super(ModBlockEntities.SYNTHETIZER, pos, state);
    }

    @Override
    public DefaultedList<ItemStack> getItems() {
        return inventory;
    }

    @Override
    public Text getDisplayName() {
        return new LiteralText("Synthetizer");
    }

    @Nullable
    @Override
    public ScreenHandler createMenu(int syncId, PlayerInventory inv, PlayerEntity player) {
        return new SynthetizerScreenHandler(syncId, inv, this, this.propertyDelegate);
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

    public static void tick(World world, BlockPos pos, BlockState state, SynthetizerBlockEntity entity) {
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



    private static boolean hasValidInputs(SynthetizerBlockEntity entity) {
        for (int i = 0; i < 9; i++) {
            Item item = entity.getStack(i).getItem();
            if (item == ModItems.CENOZOIC_DNA || item == ModItems.PALEOZOIC_MAMMAL_DNA || item == ModItems.MODERN_DNA) {
                return true;
            }
        }
        return false;
    }

    private static final Random RANDOM = new Random();

    private static void craftRandomOutput(SynthetizerBlockEntity entity) {
        modified = false;

        checkSlots(entity);

        if (usedDNA == null) return;

        handleFail(entity);

        getRandomItem();

        setResult(entity);

        if (modified) {
            entity.markDirty();
        }
    }

    private static void checkSlots(SynthetizerBlockEntity entity) {
        usedDNA = null;
        for (int i = 0; i < 9; i++) {
            ItemStack stack = entity.getStack(i);
            if (!stack.isEmpty()) {
                Item item = stack.getItem();
                if (item == ModItems.MODERN_DNA || item == ModItems.CENOZOIC_DNA || item == ModItems.PALEOZOIC_MAMMAL_DNA) {
                    stack.decrement(1);
                    usedDNA = item;
                    modified = true;
                    break;
                }
            }
        }
    }

    private static void handleFail (SynthetizerBlockEntity entity) {
        // Chance for special item
        if (RANDOM.nextInt(100) < 10) {
            Item failedItem = RANDOM.nextBoolean() ? ModItems.MUTATED_GENOME : ModItems.DESTROYED_DNA;
            ItemStack failedOutput = new ItemStack(failedItem);

            for (int i = 9; i < 13; i++) {
                if (entity.getStack(i).isEmpty()) {
                    entity.setStack(i, failedOutput);
                    modified = true;
                    break;
                }
            }

            sendFailMessage(entity);

            if (modified) entity.markDirty();
        }
    }

    private static void sendFailMessage (SynthetizerBlockEntity entity) {
        // Message for player
        World world = entity.getWorld();
        if (world != null && !world.isClient) {
            BlockPos pos = entity.getPos();
            List<PlayerEntity> players = world.getNonSpectatingEntities(PlayerEntity.class, new net.minecraft.util.math.Box(pos).expand(5));

            for (PlayerEntity player : players) {
                player.sendMessage(
                    new TranslatableText("message.cenozoic_kingdom.sequence_failed").formatted(Formatting.RED),
                    false
                );
            }
        }
    }

    private static void getRandomItem () {
        // Item random pick
        List<WeightedItem> outputPool;
        if (usedDNA == ModItems.MODERN_DNA) {
            outputPool = POSSIBLE_MODERN_OUTPUTS;
        } else if (usedDNA == ModItems.CENOZOIC_DNA) {
            outputPool = POSSIBLE_KZ_OUTPUTS;
        } else if (usedDNA == ModItems.PALEOZOIC_MAMMAL_DNA) {
            outputPool = POSSIBLE_PZ_OUTPUTS;
        } else {
            return;
        }

        int totalWeight = outputPool.stream().mapToInt(w -> w.weight).sum();
        int r = RANDOM.nextInt(totalWeight);
        int cumulative = 0;

        outputItem = Items.AIR;
        for (WeightedItem wi : outputPool) {
            cumulative += wi.weight;
            if (r < cumulative) {
                outputItem = wi.item;
                break;
            }
        }
    }

    private static void setResult (SynthetizerBlockEntity entity) {
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

}

