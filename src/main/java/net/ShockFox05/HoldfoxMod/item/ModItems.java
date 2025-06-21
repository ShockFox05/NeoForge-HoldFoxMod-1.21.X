package net.ShockFox05.HoldfoxMod.item;

import net.ShockFox05.HoldfoxMod.HoldfoxMod;
import net.ShockFox05.HoldfoxMod.item.custom.FoxChiselItem;
import net.ShockFox05.HoldfoxMod.item.custom.FoxEssenceInABottleItem;
import net.ShockFox05.HoldfoxMod.item.custom.FuelItem;
import net.ShockFox05.HoldfoxMod.item.custom.HammerItem;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.*;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.List;

public class ModItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(HoldfoxMod.MOD_ID);

    public static final DeferredItem<Item> HOLDFOX = ITEMS.register("holdfox",
            () -> new Item(new Item.Properties()){
                @Override
                public void appendHoverText(ItemStack stack, TooltipContext context, List<Component> tooltipComponents, TooltipFlag tooltipFlag) {
                    tooltipComponents.add(Component.translatable("tooltip.holdfoxmodsf.holdfox"));
                    super.appendHoverText(stack, context, tooltipComponents, tooltipFlag);
                }
            });
    public static final DeferredItem<Item> DEATH = ITEMS.register("death",
            () -> new Item(new Item.Properties()){
                @Override
                public void appendHoverText(ItemStack stack, TooltipContext context, List<Component> tooltipComponents, TooltipFlag tooltipFlag) {
                    tooltipComponents.add(Component.translatable("tooltip.holdfoxmodsf.death"));
                    super.appendHoverText(stack, context, tooltipComponents, tooltipFlag);
                }
            });
    //basic items

    public static final DeferredItem<Item> FOX_CHISEL = ITEMS.register("fox_chisel",
            () -> new FoxChiselItem(new Item.Properties().durability(32)));

    public static final DeferredItem<Item> FIRE_ESSENCE = ITEMS.register("fire_essence",
            () -> new FuelItem(new Item.Properties(),500){
                @Override
                public void appendHoverText(ItemStack stack, TooltipContext context, List<Component> tooltipComponents, TooltipFlag tooltipFlag) {
                    tooltipComponents.add(Component.translatable("tooltip.holdfoxmodsf.fire_essence"));
                    super.appendHoverText(stack, context, tooltipComponents, tooltipFlag);
                }
            });
    public static final DeferredItem<Item> UNSTABLE_FIRE = ITEMS.register("unstable_fire",
            () -> new Item(new Item.Properties()){
        @Override
                public void appendHoverText(ItemStack stack, TooltipContext context, List<Component> tooltipComponents, TooltipFlag tooltipFlag) {
                    tooltipComponents.add(Component.translatable("tooltip.holdfoxmodsf.unstable_fire"));
                    super.appendHoverText(stack, context, tooltipComponents, tooltipFlag);
                }
            });

    public static final DeferredItem<SwordItem> FOX_SWORD = ITEMS.register("fox_sword",
            () -> new SwordItem(ModToolTiers.FOX, new Item.Properties()
                    .attributes(SwordItem.createAttributes(ModToolTiers.FOX, 6, -2.4F))));
    public static final DeferredItem<PickaxeItem> FOX_PICKAXE = ITEMS.register("fox_pickaxe",
            () -> new PickaxeItem(ModToolTiers.FOX, new Item.Properties()
                    .attributes(PickaxeItem.createAttributes(ModToolTiers.FOX, 1.0f, -2.8F))));
    public static final DeferredItem<ShovelItem> FOX_SHOVEL = ITEMS.register("fox_shovel",
            () -> new ShovelItem(ModToolTiers.FOX, new Item.Properties()
                    .attributes(ShovelItem.createAttributes(ModToolTiers.FOX, 1.5f, -3.0F))));
    public static final DeferredItem<AxeItem> FOX_AXE = ITEMS.register("fox_axe",
            () -> new AxeItem(ModToolTiers.FOX, new Item.Properties()
                    .attributes(AxeItem.createAttributes(ModToolTiers.FOX, 5.5f, -3.2F))));
    public static final DeferredItem<HoeItem> FOX_HOE = ITEMS.register("fox_hoe",
            () -> new HoeItem(ModToolTiers.FOX, new Item.Properties()
                    .attributes(HoeItem.createAttributes(ModToolTiers.FOX, 0F, -3.0F))));

    public static final DeferredItem<HammerItem> FOX_HAMMER = ITEMS.register("fox_hammer",
            () -> new HammerItem(ModToolTiers.FOX, new Item.Properties()
                    .attributes(HammerItem.createAttributes(ModToolTiers.FOX, 7.0F, -3.5F))));

    //"advanced items"

    public static final DeferredItem<Item> EMERALD_APPLE = ITEMS.register("emerald_apple",
            () -> new Item(new Item.Properties().food(ModFoodProperties.EMERALD_APPLE)){
        @Override
                public void appendHoverText(ItemStack stack, TooltipContext context, List<Component> tooltipComponents, TooltipFlag tooltipFlag) {
            if (Screen.hasControlDown()) {
                tooltipComponents.add(Component.translatable("tooltip.holdfoxmodsf.emerald_apple.ctrl_down"));
            } else
            {
                tooltipComponents.add(Component.translatable("tooltip.holdfoxmodsf.emerald_apple"));
            }
                    super.appendHoverText(stack, context, tooltipComponents, tooltipFlag);
                }
            });
    public static final DeferredItem<Item> FOX_ESSENCE_IN_A_BOTTLE = ITEMS.register("fox_essence_in_a_bottle",
            () -> new FoxEssenceInABottleItem(new Item.Properties().food(ModFoodProperties.FOX_ESSENCE_IN_A_BOTTLE)){
        @Override
                public void appendHoverText(ItemStack stack, TooltipContext context, List<Component> tooltipComponents, TooltipFlag tooltipFlag) {
            if (Screen.hasShiftDown()) {
                tooltipComponents.add(Component.translatable("tooltip.holdfoxmodsf.fox_essence_in_a_bottle.shift_down"));
            } else
            {
                tooltipComponents.add(Component.translatable("tooltip.holdfoxmodsf.fox_essence_in_a_bottle"));
            }
                    super.appendHoverText(stack, context, tooltipComponents, tooltipFlag);
                }
            });
    //Consumables

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
