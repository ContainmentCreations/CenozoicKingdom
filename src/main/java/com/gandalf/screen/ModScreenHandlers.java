package com.gandalf.screen;

import com.gandalf.CenozoicKingdom;
import net.fabricmc.fabric.api.screenhandler.v1.ScreenHandlerRegistry;
import net.minecraft.screen.ScreenHandlerType;
import net.minecraft.util.Identifier;

public class ModScreenHandlers {
    public static ScreenHandlerType<AnalyzerScreenHandler> ANALYZER_SCREEN_HANDLER =
            ScreenHandlerRegistry.registerSimple(new Identifier(CenozoicKingdom.MOD_ID, "analyzer"),
                    AnalyzerScreenHandler::new);
    public static ScreenHandlerType<SynthetizerScreenHandler> SYNTHETIZER_SCREEN_HANDLER =
            ScreenHandlerRegistry.registerSimple(new Identifier(CenozoicKingdom.MOD_ID, "synthetizer"),
                    SynthetizerScreenHandler::new);
}
