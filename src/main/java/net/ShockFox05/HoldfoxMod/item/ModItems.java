package net.ShockFox05.HoldfoxMod.item;

import net.ShockFox05.HoldfoxMod.HoldfoxMod;
import net.ShockFox05.HoldfoxMod.item.custom.FoxChiselItem;
import net.ShockFox05.HoldfoxMod.item.custom.FoxEssenceInABottleItem;
import net.ShockFox05.HoldfoxMod.item.custom.FuelItem;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
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
