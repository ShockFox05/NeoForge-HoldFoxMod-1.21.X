package net.ShockFox05.HoldfoxMod.item;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Items;

public class ModFoodProperties {
    public static final FoodProperties EMERALD_APPLE = new FoodProperties.Builder()
            .nutrition(4)
            .saturationModifier(1.5F)
            .effect(() -> new MobEffectInstance(MobEffects.HEALTH_BOOST, 6000, 2), 1f)
            .effect(() -> new MobEffectInstance(MobEffects.REGENERATION, 600, 0), 1f)
            .effect(() -> new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 100, 0), .1f)
            .effect(() -> new MobEffectInstance(MobEffects.LUCK, 3600, 1), .3f)
            .effect(() -> new MobEffectInstance(MobEffects.SATURATION, 40, 0), 1f)
            .effect(() -> new MobEffectInstance(MobEffects.DAMAGE_BOOST, 600, 0), 1f)
            .effect(() -> new MobEffectInstance(MobEffects.DAMAGE_BOOST, 1200, 1), .2f)
            .build();
    //Food

    public static final FoodProperties FOX_ESSENCE_IN_A_BOTTLE = new FoodProperties.Builder()
            .effect(() -> new MobEffectInstance(MobEffects.LUCK, 12000,2), 1f)
            .effect(() -> new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 12000, 1), 1f)
            .effect(() -> new MobEffectInstance(MobEffects.REGENERATION, 400, 0), 1f)
            .effect(() -> new MobEffectInstance(MobEffects.HEAL, 1, 1), .5f)
            .alwaysEdible()
            .usingConvertsTo(Items.GLASS_BOTTLE)
            .build();

    //Drink
}
