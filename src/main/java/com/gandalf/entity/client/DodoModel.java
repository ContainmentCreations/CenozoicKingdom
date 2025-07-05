package com.gandalf.entity.client;

import com.gandalf.CenozoicKingdom;
import com.gandalf.entity.animal.DodoEntity;
import net.minecraft.util.Identifier;
import software.bernie.geckolib3.core.event.predicate.AnimationEvent;
import software.bernie.geckolib3.core.processor.IBone;
import software.bernie.geckolib3.model.AnimatedGeoModel;
import software.bernie.geckolib3.model.provider.data.EntityModelData;

public class DodoModel extends AnimatedGeoModel<DodoEntity> {
    @Override
    public Identifier getModelLocation(DodoEntity object) {
        return new Identifier(CenozoicKingdom.MOD_ID, "geo/dodo.geo.json");
    }

    @Override
    public Identifier getTextureLocation(DodoEntity object) {
        return new Identifier(CenozoicKingdom.MOD_ID, "textures/entity/dodo/dodo.png");
    }

    @Override
    public Identifier getAnimationFileLocation(DodoEntity animation) {
        return new Identifier(CenozoicKingdom.MOD_ID, "animations/dodo.animation.json");
    }

    @SuppressWarnings({ "unchecked", "rawtypes" })
    @Override
    public void setLivingAnimations(DodoEntity entity, Integer uniqueID, AnimationEvent customPredicate) {
        super.setLivingAnimations(entity, uniqueID, customPredicate);
        IBone head = this.getAnimationProcessor().getBone("head");

        EntityModelData extraData = (EntityModelData) customPredicate.getExtraDataOfType(EntityModelData.class).get(0);
        if (head != null) {
            head.setRotationX(extraData.headPitch * ((float) Math.PI / 180F));
            head.setRotationY(extraData.netHeadYaw * ((float) Math.PI / 180F));
        }
    }
}
