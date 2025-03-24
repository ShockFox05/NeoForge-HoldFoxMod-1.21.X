package net.ShockFox05.HoldfoxMod.item;

import net.ShockFox05.HoldfoxMod.HoldfoxMod;
import net.ShockFox05.HoldfoxMod.item.custom.FoxChiselItem;
import net.ShockFox05.HoldfoxMod.item.custom.FoxEssenceInABottleItem;
import net.ShockFox05.HoldfoxMod.item.custom.FuelItem;
import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(HoldfoxMod.MOD_ID);

    public static final DeferredItem<Item> HOLDFOX = ITEMS.register("holdfox",
            () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> DEATH = ITEMS.register("death",
            () -> new Item(new Item.Properties()));
    //basic items

    public static final DeferredItem<Item> FOX_CHISEL = ITEMS.register("fox_chisel",
            () -> new FoxChiselItem(new Item.Properties().durability(32)));
    public static final DeferredItem<Item> FIRE_ESSENCE = ITEMS.register("fire_essence",
            () -> new FuelItem(new Item.Properties(),900));
    public static final DeferredItem<Item> UNSTABLE_FIRE = ITEMS.register("unstable_fire",
            () -> new Item(new Item.Properties()));

    //"advanced items"

    public static final DeferredItem<Item> EMERALD_APPLE = ITEMS.register("emerald_apple",
            () -> new Item(new Item.Properties().food(ModFoodProperties.EMERALD_APPLE)));
    public static final DeferredItem<Item> FOX_ESSENCE_IN_A_BOTTLE = ITEMS.register("fox_essence_in_a_bottle",
            () -> new FoxEssenceInABottleItem(new Item.Properties().food(ModFoodProperties.FOX_ESSENCE_IN_A_BOTTLE)));
    //Consumables

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
