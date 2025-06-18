package com.gandalf.recipe;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import net.minecraft.inventory.SimpleInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.recipe.*;
import net.minecraft.util.Identifier;
import net.minecraft.util.JsonHelper;
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.World;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class SynthetizerRecipe implements Recipe<SimpleInventory> {
    private final Identifier id;
    private final List<ItemStack> outputs;
    private final DefaultedList<Ingredient> recipeItems;

    public SynthetizerRecipe(Identifier id, List<ItemStack> outputs, DefaultedList<Ingredient> recipeItems) {
        this.id = id;
        this.outputs = outputs;
        this.recipeItems = recipeItems;
    }

    @Override
    public boolean matches(SimpleInventory inventory, World world) {
        for (int i = 0; i < 9; i++) {
            if (recipeItems.get(0).test(inventory.getStack(i))) {
                return true;
            }
        }
        return false;
    }

    @Override
    public ItemStack craft(SimpleInventory inventory) {
        Random random = new Random();
        return outputs.get(random.nextInt(outputs.size())).copy();
    }

    @Override
    public boolean fits(int width, int height) {
        return true;
    }

    @Override
    public ItemStack getOutput() {
        Random random = new Random();
        return outputs.get(random.nextInt(outputs.size())).copy();
    }

    public List<ItemStack> getAllOutputs() {
        return outputs;
    }

    @Override
    public Identifier getId() {
        return id;
    }

    @Override
    public RecipeSerializer<?> getSerializer() {
        return Serializer.INSTANCE;
    }

    @Override
    public RecipeType<?> getType() {
        return Type.INSTANCE;
    }

    @Override
    public DefaultedList<Ingredient> getIngredients() {
        return recipeItems;
    }

    public static class Type implements RecipeType<SynthetizerRecipe> {
        private Type() { }
        public static final Type INSTANCE = new Type();
        public static final String ID = "synthetizer";
    }

    public static class Serializer implements RecipeSerializer<SynthetizerRecipe> {
        public static final Serializer INSTANCE = new Serializer();
        public static final String ID = "synthetizer";

        @Override
        public SynthetizerRecipe read(Identifier id, JsonObject json) {
            DefaultedList<Ingredient> inputs = DefaultedList.ofSize(1, Ingredient.EMPTY);
            JsonArray results = JsonHelper.getArray(json, "results");
            JsonArray ingredients = JsonHelper.getArray(json, "ingredients");
            List<ItemStack> outputs = new ArrayList<>();
            for (JsonElement element : results) {
                JsonObject resultObj = element.getAsJsonObject();
                Item item = Registry.ITEM.get(new Identifier(JsonHelper.getString(resultObj, "item")));
                int weight = JsonHelper.getInt(resultObj, "weight", 1);
                for (int i = 0; i < weight; i++) {
                    outputs.add(new ItemStack(item));
                }
            }
            for (int i = 0; i < inputs.size(); i++) {
                inputs.set(i, Ingredient.fromJson(ingredients.get(i)));
            }
            return new SynthetizerRecipe(id, outputs, inputs);
        }

        @Override
        public SynthetizerRecipe read(Identifier id, PacketByteBuf buf) {
            DefaultedList<Ingredient> inputs = DefaultedList.ofSize(1, Ingredient.EMPTY);
            for (int i = 0; i < inputs.size(); i++) {
                inputs.set(i, Ingredient.fromPacket(buf));
            }
            int size = buf.readInt();
            List<ItemStack> outputs = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                outputs.add(buf.readItemStack());
            }
            return new SynthetizerRecipe(id, outputs, inputs);
        }

        @Override
        public void write(PacketByteBuf buf, SynthetizerRecipe recipe) {
            for (Ingredient ing : recipe.getIngredients()) {
                ing.write(buf);
            }

            buf.writeInt(recipe.outputs.size());
            for (ItemStack output : recipe.outputs) {
                buf.writeItemStack(output);
            }
        }
    }
}
