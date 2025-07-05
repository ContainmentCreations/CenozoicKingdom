package com.gandalf.integration.rei;

import com.gandalf.CenozoicKingdom;
import com.gandalf.ModBlocks;
import me.shedaniel.math.Point;
import me.shedaniel.math.Rectangle;
import me.shedaniel.rei.api.client.gui.Renderer;
import me.shedaniel.rei.api.client.gui.widgets.Widget;
import me.shedaniel.rei.api.client.gui.widgets.Widgets;
import me.shedaniel.rei.api.client.registry.display.DisplayCategory;
import me.shedaniel.rei.api.common.category.CategoryIdentifier;
import me.shedaniel.rei.api.common.display.Display;
import me.shedaniel.rei.api.common.entry.EntryIngredient;
import me.shedaniel.rei.api.common.util.EntryStacks;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableText;

import java.util.ArrayList;
import java.util.List;

public class AnalyzerDisplayCategory implements DisplayCategory {
    public static final CategoryIdentifier<AnalyzerDisplay> ANALYZER_DISPLAY = CategoryIdentifier.of(CenozoicKingdom.MOD_ID, "analyzer_display");

    @Override
    public CategoryIdentifier getCategoryIdentifier() {
        return ANALYZER_DISPLAY;
    }

    @Override
    public Text getTitle() {
        return new TranslatableText("category.rei.analyzer");
    }

    @Override
    public Renderer getIcon() {
        return EntryStacks.of(new ItemStack(ModBlocks.ANALYZER));
    }

    @Override
    public List<Widget> setupDisplay(Display display, Rectangle bounds) {
        AnalyzerDisplay analyzerDisplay = (AnalyzerDisplay) display;
        List<Widget> widgets = new ArrayList<>();
        Point start = new Point(bounds.x + 10, bounds.y + 10);

        widgets.add(Widgets.createRecipeBase(bounds));

        widgets.add(Widgets.createSlot(new Point(start.x + 50, start.y + 10))
            .entries(analyzerDisplay.getInputEntries().get(0))
            .markInput());

        int outputX = start.x + 5;
        int outputY = start.y + 30;
        int width = 130;
        int interval = width / analyzerDisplay.getOutputEntries().size();
        int index = 0;
        for (EntryIngredient outputEntry : analyzerDisplay.getOutputEntries()) {
            widgets.add(Widgets.createSlot(new Point(outputX + (index * interval), outputY))
                .entries(outputEntry)
                .markOutput());
            index++;
        }


        return widgets;
    }
}
