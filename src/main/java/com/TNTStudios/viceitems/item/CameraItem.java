package com.TNTStudios.viceitems.item;

import net.minecraft.item.Item;
import software.bernie.geckolib.animatable.GeoItem;
import software.bernie.geckolib.animatable.client.RenderProvider;
import software.bernie.geckolib.core.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.core.animation.AnimatableManager;
import software.bernie.geckolib.core.animation.AnimationController;
import software.bernie.geckolib.core.animation.RawAnimation;
import software.bernie.geckolib.core.object.PlayState;
import software.bernie.geckolib.util.GeckoLibUtil;

import java.util.function.Consumer;
import java.util.function.Supplier;

public class CameraItem extends Item implements GeoItem {

    // Animación que se reproducirá en loop para mantenerla activa
    private static final RawAnimation IDLE = RawAnimation.begin().thenLoop("a");

    // Cache para las instancias animadas de GeckoLib
    private final AnimatableInstanceCache cache = GeckoLibUtil.createInstanceCache(this);

    // Proveedor de render (usa tipo Object por restricciones de GeckoLib)
    private final Supplier<Object> renderProvider = GeoItem.makeRenderer(this);

    public CameraItem(Settings settings) {
        super(settings);
    }

    // Registro del renderer en GeckoLib, pasando el tipo correcto (Object)
    @Override
    public void createRenderer(Consumer<Object> consumer) {
        consumer.accept(renderProvider.get());
    }

    // Método requerido por GeoItem, también retorna Supplier<Object>
    @Override
    public Supplier<Object> getRenderProvider() {
        return renderProvider;
    }

    // Controlador de animación que reproduce el idle en loop
    @Override
    public void registerControllers(AnimatableManager.ControllerRegistrar controllers) {
        controllers.add(new AnimationController<>(this, "controller", 0, state -> {
            state.setAnimation(IDLE);
            return PlayState.CONTINUE;
        }));
    }

    // Cache necesario para el manejo de instancias animadas
    @Override
    public AnimatableInstanceCache getAnimatableInstanceCache() {
        return cache;
    }
}
