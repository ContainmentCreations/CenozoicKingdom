package com.gandalf.entity.client;

import com.gandalf.CenozoicKingdom;
import com.gandalf.entity.animal.DodoEntity;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.util.Identifier;
import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;

public class DodoRenderer extends GeoEntityRenderer<DodoEntity> {
    public DodoRenderer(EntityRendererFactory.Context ctx) {
        super(ctx, new DodoModel());
    }

    @Override
    public Identifier getTextureLocation(DodoEntity instance) {
        return new Identifier(CenozoicKingdom.MOD_ID, "textures/entity/dodo/dodo.png");
    }
}
