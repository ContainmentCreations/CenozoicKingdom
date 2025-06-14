package com.gandalf;

import com.gandalf.entity.ModBlockEntities;
import com.gandalf.screen.AnalyzerScreen;
import com.gandalf.screen.ModScreenHandlers;
import com.gandalf.screen.SynthetizerScreen;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.screenhandler.v1.ScreenRegistry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

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

		LOGGER.info("Hello Fabric world!");
		ModItems.registerModItems();
		ModBlocks.registerModBlocks();
		ModBlockEntities.registerAllBlockEntities();

		ScreenRegistry.register(ModScreenHandlers.ANALYZER_SCREEN_HANDLER, AnalyzerScreen::new);
		ScreenRegistry.register(ModScreenHandlers.SYNTHETIZER_SCREEN_HANDLER, SynthetizerScreen::new);
	}
}
