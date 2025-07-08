package com.gandalf.integration.rei;

import com.gandalf.CenozoicKingdom;
import com.gandalf.recipe.AnalyzerRecipe;
import me.shedaniel.rei.api.common.category.CategoryIdentifier;
import me.shedaniel.rei.api.common.display.Display;
import me.shedaniel.rei.api.common.entry.EntryIngredient;
import me.shedaniel.rei.api.common.util.EntryIngredients;
import net.minecraft.item.ItemStack;

import java.util.*;

public class AnalyzerDisplay implements Display {

    private final List<EntryIngredient> inputEntries;
    private final List<EntryIngredient> outputEntries;
    private final Optional<String> recipeId;
    private final List<ItemStack> outputs;

    public AnalyzerDisplay(AnalyzerRecipe recipe) {
        this.inputEntries = Collections.singletonList(EntryIngredients.of(recipe.getIngredients().get(0).getMatchingStacks()[0]));
        this.outputs = new ArrayList<>(new HashSet<>(recipe.getAllOutputs()));
        this.outputEntries = new ArrayList<>();
        for (ItemStack output : outputs) {
            if (!outputEntries.contains(EntryIngredients.of(output.getItem()))) {
                this.outputEntries.add(EntryIngredients.of(output.getItem()));
            }
        }
        this.recipeId = Optional.ofNullable(recipe.getId().toString());
    }

    @Override
    public List<EntryIngredient> getInputEntries() {
        return inputEntries;
    }

    @Override
    public List<EntryIngredient> getOutputEntries() {
        return outputEntries;
    }

    @Override
    public CategoryIdentifier<?> getCategoryIdentifier() {
        return CategoryIdentifier.of(CenozoicKingdom.MOD_ID, "analyzer_display");
    }
}
