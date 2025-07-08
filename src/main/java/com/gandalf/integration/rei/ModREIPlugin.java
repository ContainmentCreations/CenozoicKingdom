package com.gandalf.integration.rei;

import com.gandalf.ModBlocks;
import com.gandalf.recipe.AnalyzerRecipe;
import com.gandalf.recipe.SynthetizerRecipe;
import me.shedaniel.rei.api.client.plugins.REIClientPlugin;
import me.shedaniel.rei.api.client.registry.category.CategoryRegistry;
import me.shedaniel.rei.api.client.registry.display.DisplayRegistry;
import me.shedaniel.rei.api.common.util.EntryStacks;

public class ModREIPlugin implements REIClientPlugin {
    @Override
    public void registerDisplays(DisplayRegistry registry) {
        registry.registerFiller(AnalyzerRecipe.class, AnalyzerDisplay::new);

        registry.registerFiller(SynthetizerRecipe.class, SynthetizerDisplay::new);
    }

    @Override
    public void registerCategories(CategoryRegistry registry) {
        registry.add(new AnalyzerDisplayCategory());
        registry.addWorkstations(AnalyzerDisplayCategory.ANALYZER_DISPLAY, EntryStacks.of(ModBlocks.ANALYZER));

        registry.add(new SynthetizerDisplayCategory());
        registry.addWorkstations(SynthetizerDisplayCategory.Synthetizer_DISPLAY, EntryStacks.of(ModBlocks.SYNTHETIZER));
    }
}
