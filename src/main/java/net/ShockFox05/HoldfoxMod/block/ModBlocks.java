package net.ShockFox05.HoldfoxMod.block;

import net.ShockFox05.HoldfoxMod.HoldfoxMod;
import net.ShockFox05.HoldfoxMod.block.custom.MagicFoxBlock;
import net.ShockFox05.HoldfoxMod.item.ModItems;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraft.world.level.block.state.properties.WoodType;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;



public class ModBlocks {
    public static final DeferredRegister.Blocks BLOCKS =
            DeferredRegister.createBlocks(HoldfoxMod.MOD_ID);

    public static final DeferredBlock<Block> FOX_BLOCK = registerBlock("fox_block",
            () -> new Block(BlockBehaviour.Properties.of()
                    .strength(.125f).sound(SoundType.SWEET_BERRY_BUSH)));

    public static final DeferredBlock<Block> FOX_ORE = registerBlock("fox_ore",
            () -> new DropExperienceBlock(UniformInt.of(2,4),
                    BlockBehaviour.Properties.of().strength(3f).requiresCorrectToolForDrops().sound(SoundType.STONE)));
    public static final DeferredBlock<Block> FOX_DEEPSLATE_ORE = registerBlock("fox_deepslate_ore",
            () -> new DropExperienceBlock(UniformInt.of(3,6),
                    BlockBehaviour.Properties.of().strength(4f).requiresCorrectToolForDrops().sound(SoundType.DEEPSLATE)));
    //basic blocks

    public static final DeferredBlock<Block> MAGIC_FOX_BLOCK = registerBlock("magic_fox_block",
            () -> new MagicFoxBlock(BlockBehaviour.Properties.of().strength(2f).requiresCorrectToolForDrops().sound(SoundType.AMETHYST_CLUSTER)));
    //"advanced blocks"

    public static final DeferredBlock<StairBlock> FOX_STAIRS = registerBlock("fox_stairs",
    () -> new StairBlock(ModBlocks.FOX_BLOCK.get().defaultBlockState(),
            BlockBehaviour.Properties.of().strength(2f)));
    public static final DeferredBlock<SlabBlock> FOX_SLAB = registerBlock("fox_slab",
    () -> new SlabBlock(BlockBehaviour.Properties.of().strength(2f)));

    public static final DeferredBlock<PressurePlateBlock> FOX_PRESSURE_PLATE = registerBlock("fox_pressure_plate",
    () -> new PressurePlateBlock(BlockSetType.IRON, BlockBehaviour.Properties.of().strength(2f)));
    public static final DeferredBlock<ButtonBlock> FOX_BUTTON = registerBlock("fox_button",
    () -> new ButtonBlock(BlockSetType.IRON, 30, BlockBehaviour.Properties.of().strength(2f).noCollission()));

    public static final DeferredBlock<FenceBlock> FOX_FENCE = registerBlock("fox_fence",
    () -> new FenceBlock(BlockBehaviour.Properties.of().strength(2f)));
    public static final DeferredBlock<FenceGateBlock> FOX_FENCE_GATE = registerBlock("fox_fence_gate",
    () -> new FenceGateBlock(WoodType.ACACIA, BlockBehaviour.Properties.of().strength(2f)));
    public static final DeferredBlock<WallBlock> FOX_WALL = registerBlock("fox_wall",
    () -> new WallBlock(BlockBehaviour.Properties.of().strength(2f)));

    public static final DeferredBlock<DoorBlock> FOX_DOOR = registerBlock("fox_door",
    () -> new DoorBlock(BlockSetType.WARPED, BlockBehaviour.Properties.of().strength(2f).noOcclusion()));
    public static final DeferredBlock<TrapDoorBlock> FOX_TRAPDOOR = registerBlock("fox_trapdoor",
    () -> new TrapDoorBlock(BlockSetType.WARPED, BlockBehaviour.Properties.of().strength(2f).noOcclusion()));

    //non-full blocks
    private static <T extends Block> DeferredBlock<T> registerBlock(String name, Supplier<T> block) {
        DeferredBlock<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    private static <T extends Block> void registerBlockItem(String name, DeferredBlock<T> block) {
        ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }

}
