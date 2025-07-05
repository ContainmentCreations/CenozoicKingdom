package com.gandalf.util;

import com.gandalf.entity.ModEntities;
import com.gandalf.entity.animal.DodoEntity;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;

public class ModRegistries {
    public static void registerModStuffs() {
        registerAttributes();
    }

    private static void registerAttributes() {
        FabricDefaultAttributeRegistry.register(ModEntities.DODO, DodoEntity.setAttributes());
    }
}
