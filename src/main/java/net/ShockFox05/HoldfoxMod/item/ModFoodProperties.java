package net.ShockFox05.HoldfoxMod.item;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;

public class ModFoodProperties {
    public static final FoodProperties EMERALD_APPLE = new FoodProperties.Builder()
            .nutrition(4)
            .saturationModifier(1.5F)
            .effect(() -> new MobEffectInstance(MobEffects.HEALTH_BOOST, 400, 3), 1f)
            .build();

}
