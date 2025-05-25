package com.TNTStudios.viceitems.client.renderer;

import com.TNTStudios.viceitems.item.CameraItem;
import software.bernie.geckolib.renderer.GeoItemRenderer;

public class CameraRenderer extends GeoItemRenderer<CameraItem> {
    public CameraRenderer() {
        super(new CameraModel());
    }
}
