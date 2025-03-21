package net.ShockFox05.HoldfoxMod.item;

import net.ShockFox05.HoldfoxMod.HoldfoxMod;
import net.ShockFox05.HoldfoxMod.item.custom.FoxChiselItem;
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
    //"advanced items"

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
