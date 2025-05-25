package com.TNTStudios.viceitems.client.renderer;

import com.TNTStudios.viceitems.item.CameraItem;
import net.minecraft.util.Identifier;
import software.bernie.geckolib.model.GeoModel;

public class CameraModel extends GeoModel<CameraItem> {
    @Override
    public Identifier getModelResource(CameraItem animatable) {
        return new Identifier("viceitems", "geo/cam.geo.json");
    }

    @Override
    public Identifier getTextureResource(CameraItem animatable) {
        return new Identifier("viceitems", "textures/item/cam.png");
    }

    @Override
    public Identifier getAnimationResource(CameraItem animatable) {
        return new Identifier("viceitems", "animations/cam.animation.json");
    }
}
