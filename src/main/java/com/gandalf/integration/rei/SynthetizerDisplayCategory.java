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
import me.shedaniel.rei.api.common.util.EntryStacks;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableText;

import java.util.ArrayList;
import java.util.List;

public class SynthetizerDisplayCategory implements DisplayCategory {
    public static final CategoryIdentifier<SynthetizerDisplay> Synthetizer_DISPLAY = CategoryIdentifier.of(CenozoicKingdom.MOD_ID, "synthetizer_display");

    @Override
    public CategoryIdentifier getCategoryIdentifier() {
        return Synthetizer_DISPLAY;
    }

    @Override
    public Text getTitle() {
        return new TranslatableText("category.rei.synthetizer");
    }

    @Override
    public Renderer getIcon() {
        return EntryStacks.of(new ItemStack(ModBlocks.SYNTHETIZER));
    }

    @Override
    public List<Widget> setupDisplay(Display display, Rectangle bounds) {
        SynthetizerDisplay SynthetizerDisplay = (SynthetizerDisplay) display;
        List<Widget> widgets = new ArrayList<>();
        Point start = new Point(bounds.x + 10, bounds.y + 10);

        widgets.add(Widgets.createRecipeBase(bounds));

        widgets.add(Widgets.createSlot(new Point(start.x + 60, start.y - 5))
            .entries(SynthetizerDisplay.getInputEntries().get(0))
            .markInput());

        int outputX = start.x + 5;
        int outputY = start.y + 36;
        int width = 140;
        int interval = width / (SynthetizerDisplay.getOutputEntries().size() % 7);
        int index = SynthetizerDisplay.getOutputEntries().size() - 1;
        int heightIndex = 0;
        int heightInterval = 20;
        for (int i = 0; i < SynthetizerDisplay.getOutputEntries().size(); i++) {
            System.out.println(index);
            System.out.println(i);
            if (index > 7) {
                System.out.println("Big");
                for (int j = 0; j < 7; j++) {
                    widgets.add(Widgets.createSlot(new Point(outputX + ((130 / 7) * j), outputY - (heightIndex * heightInterval)))
                        .entries(SynthetizerDisplay.getOutputEntries().get(i + j))
                        .markOutput());
                }
                heightIndex ++;
                i += 7;
                index -= 7;
                System.out.println(index);
                System.out.println(i);
            }
            widgets.add(Widgets.createSlot(new Point(outputX + ((i % 7) * interval), outputY - (heightIndex * heightInterval)))
                .entries(SynthetizerDisplay.getOutputEntries().get(i))
                .markOutput());
            index--;
        }


        return widgets;
    }
}
