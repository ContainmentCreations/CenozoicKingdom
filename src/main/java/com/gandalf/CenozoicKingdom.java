package com.gandalf;

import com.gandalf.config.ModConfigs;
import com.gandalf.entity.ModBlockEntities;
import com.gandalf.recipe.ModRecipes;
import com.gandalf.screen.AnalyzerScreen;
import com.gandalf.screen.ModScreenHandlers;
import com.gandalf.screen.SynthetizerScreen;
import com.gandalf.util.ModRegistries;
import com.gandalf.world.feature.ModConfiguredFeatures;
import com.gandalf.world.gen.ModWorldGen;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.screenhandler.v1.ScreenRegistry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import software.bernie.geckolib3.GeckoLib;

public class CenozoicKingdom implements ModInitializer {
	public static final String MOD_ID = "cenozoic_kingdom";

	// This logger is used to write text to the console and the log file.
	// It is considered best practice to use your mod id as the logger's name.
	// That way, it's clear which mod wrote info, warnings, and errors.
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		// This code runs as soon as Minecraft is in a mod-load-ready state.
		// However, some things (like resources) may still be uninitialized.
		// Proceed with mild caution.
		ModConfiguredFeatures.registerConfiguredFeatures();
		ModBlocks.registerModBlocks();


		LOGGER.info("Hello Fabric world!");
		ModItems.registerModItems();
		ModBlockEntities.registerAllBlockEntities();

		ScreenRegistry.register(ModScreenHandlers.ANALYZER_SCREEN_HANDLER, AnalyzerScreen::new);
		ScreenRegistry.register(ModScreenHandlers.SYNTHETIZER_SCREEN_HANDLER, SynthetizerScreen::new);

		ModWorldGen.generateModWorldGen();

		ModRecipes.registerRecipes();
		ModRegistries.registerModStuffs();

		ModConfigs.registerConfigs();

		GeckoLib.initialize();
	}
}
