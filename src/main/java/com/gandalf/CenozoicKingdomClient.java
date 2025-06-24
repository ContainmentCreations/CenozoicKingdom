package com.gandalf;

import com.gandalf.entity.ModEntities;
import com.gandalf.entity.client.DodoRenderer;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.fabricmc.api.ClientModInitializer;

public class CenozoicKingdomClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        EntityRendererRegistry.register(ModEntities.DODO, DodoRenderer::new);
    }
}
