package com.gandalf.recipe;

import com.gandalf.CenozoicKingdom;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ModRecipes {
    public static void registerRecipes() {
        Registry.register(Registry.RECIPE_SERIALIZER, new Identifier(CenozoicKingdom.MOD_ID, AnalyzerRecipe.Serializer.ID),
            AnalyzerRecipe.Serializer.INSTANCE);
        Registry.register(Registry.RECIPE_TYPE, new Identifier(CenozoicKingdom.MOD_ID, AnalyzerRecipe.Type.ID),
            AnalyzerRecipe.Type.INSTANCE);

        Registry.register(Registry.RECIPE_SERIALIZER, new Identifier(CenozoicKingdom.MOD_ID, SynthetizerRecipe.Serializer.ID),
            SynthetizerRecipe.Serializer.INSTANCE);
        Registry.register(Registry.RECIPE_TYPE, new Identifier(CenozoicKingdom.MOD_ID, SynthetizerRecipe.Type.ID),
            SynthetizerRecipe.Type.INSTANCE);
    }
}
