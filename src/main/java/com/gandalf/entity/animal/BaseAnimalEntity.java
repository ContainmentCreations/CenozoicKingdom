/* package com.gandalf.entity.animal;

import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.ai.goal.Goal;
import net.minecraft.entity.ai.goal.LookAroundGoal;
import net.minecraft.entity.ai.goal.WanderAroundFarGoal;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.world.World;

public class BaseAnimalEntity extends AnimalEntity {

    public BaseAnimalEntity(EntityType<? extends AnimalEntity> type, World world) {
        super(type, world);
    }

    //Sets AI goals - walking and idling
    @Override
    protected void initGoals() {
        //idling
        this.goalSelector.add(0, new LookAroundGoal(this));
        //walking
        this.goalSelector.add(1, new WanderAroundFarGoal(this, 1.0));
    }

    //Basic entity attributes
    public static DefaultAttributeContainer.Builder createAttributes() {
        return AnimalEntity.createMobAttributes()
                .add(EntityAttributes.GENERIC_MAX_HEALTH, 10.0)
                .add(EntityAttributes.GENERIC_MOVEMENT_SPEED, 0.2);
    }
} */
