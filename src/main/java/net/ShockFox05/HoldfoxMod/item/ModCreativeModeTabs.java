package net.ShockFox05.HoldfoxMod.item;

import net.ShockFox05.HoldfoxMod.HoldfoxMod;
import net.ShockFox05.HoldfoxMod.block.ModBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class ModCreativeModeTabs {
    public static final DeferredRegister<CreativeModeTab> CRAETIVE_MODE_TAB =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, HoldfoxMod.MOD_ID);

    public static final Supplier<CreativeModeTab> HOLDFOX_ITEMS_TAB = CRAETIVE_MODE_TAB.register("holdfox_items_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.HOLDFOX.get()))
                    .title(Component.translatable("creativetab.holdfoxmodsf.holdfox_items"))
                    .displayItems((itemDisplayParameters, output) -> {
                        output.accept(ModItems.HOLDFOX.get());
                        output.accept(ModItems.DEATH.get());
                        //basic items

                        output.accept(ModItems.FOX_CHISEL.get());
                        output.accept(ModItems.FOX_SWORD.get());
                        output.accept(ModItems.FOX_PICKAXE.get());
                        output.accept(ModItems.FOX_SHOVEL.get());
                        output.accept(ModItems.FOX_AXE.get());
                        output.accept(ModItems.FOX_HOE.get());
                        output.accept(ModItems.FOX_HAMMER.get());
                        //"advanced items"

                        output.accept(ModItems.EMERALD_APPLE.get());
                        output.accept(ModItems.FOX_ESSENCE_IN_A_BOTTLE.get());
                        //Consumables

                        output.accept(ModItems.FIRE_ESSENCE.get());
                        output.accept(ModItems.UNSTABLE_FIRE.get());
                        //Fuels
                    }).build());

    public static final Supplier<CreativeModeTab> HOLDFOX_BLOCKS_TAB = CRAETIVE_MODE_TAB.register("holdfox_blocks_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModBlocks.FOX_ORE.get()))
                    .withTabsBefore(ResourceLocation.fromNamespaceAndPath(HoldfoxMod.MOD_ID, "holdfox_items_tab"))
                    .title(Component.translatable("creativetab.holdfoxmodsf.holdfox_blocks"))
                    .displayItems((itemDisplayParameters, output) -> {
                        output.accept(ModBlocks.FOX_BLOCK.get());
                        output.accept(ModBlocks.FOX_ORE.get());
                        output.accept(ModBlocks.FOX_DEEPSLATE_ORE.get());
                        //basic blocks

                        output.accept(ModBlocks.MAGIC_FOX_BLOCK.get());
                        //"advanced blocks"

                        output.accept(ModBlocks.FOX_STAIRS.get());
                        output.accept(ModBlocks.FOX_SLAB.get());

                        output.accept(ModBlocks.FOX_PRESSURE_PLATE.get());
                        output.accept(ModBlocks.FOX_BUTTON.get());

                        output.accept(ModBlocks.FOX_FENCE.get());
                        output.accept(ModBlocks.FOX_FENCE_GATE.get());
                        output.accept(ModBlocks.FOX_FENCE_GATE.get());

                        output.accept(ModBlocks.FOX_DOOR.get());
                        output.accept(ModBlocks.FOX_TRAPDOOR.get());

                        output.accept(ModBlocks.FOX_LAMP.get());

                    }).build());


    public static void register(IEventBus eventBus) {
        CRAETIVE_MODE_TAB.register(eventBus);
    }
}
