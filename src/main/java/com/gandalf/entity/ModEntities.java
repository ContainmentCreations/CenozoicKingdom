package com.gandalf.entity;

import com.gandalf.CenozoicKingdom;
import com.gandalf.entity.animal.DodoEntity;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ModEntities {
    public static final EntityType<DodoEntity> DODO = Registry.register(
            Registry.ENTITY_TYPE, new Identifier(CenozoicKingdom.MOD_ID, "dodo"),
            FabricEntityTypeBuilder.create(SpawnGroup.CREATURE, DodoEntity::new)
                    .dimensions(EntityDimensions.fixed(0.4f, 0.3f)).build()
    );
}
