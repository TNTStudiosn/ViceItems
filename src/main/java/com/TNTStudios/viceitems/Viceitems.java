package com.TNTStudios.viceitems;

import com.TNTStudios.viceitems.item.CameraItem;
import net.fabricmc.api.ModInitializer;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class Viceitems implements ModInitializer {

    public static final Item CAMERA_ITEM = Registry.register(
            Registries.ITEM,
            new Identifier("viceitems", "camara"),
            new CameraItem(new Item.Settings())
    );

    @Override
    public void onInitialize() {
        // Aquí se registran los ítems
    }
}
