package net.ShockFox05.HoldfoxMod.item.custom;

import net.ShockFox05.HoldfoxMod.block.ModBlocks;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;

import java.util.List;
import java.util.Map;


public class FoxChiselItem extends Item {

    private static final Map<Block, Block> CHISEL_MAP =
            //Map <Block, Block>, means <What?, To What?>
            Map.of(
                    Blocks.STONE, Blocks.STONE_BRICKS,
                    Blocks.END_STONE, Blocks.END_STONE_BRICKS,
                    Blocks.DEEPSLATE, Blocks.DEEPSLATE_BRICKS,
                    Blocks.GOLD_BLOCK, Blocks.IRON_BLOCK,
                    Blocks.IRON_BLOCK, Blocks.STONE,
                    Blocks.NETHERRACK, ModBlocks.FOX_BLOCK.get(),
                    ModBlocks.FOX_ORE.get(), ModBlocks.FOX_DEEPSLATE_ORE.get(),
                    ModBlocks.FOX_DEEPSLATE_ORE.get(), ModBlocks.FOX_ORE.get()
            );
    //List.of Map<Block, Block>

    public FoxChiselItem(Properties properties) {
        super(properties);
    }

    @Override
    public InteractionResult useOn(UseOnContext context) {
        Level level = context.getLevel();
        Block clickedBlock = level.getBlockState(context.getClickedPos()).getBlock();

        if(CHISEL_MAP.containsKey(clickedBlock)) {
            //If is not client side, If is server side.
            if(!level.isClientSide()) {
                level.setBlockAndUpdate(context.getClickedPos(), CHISEL_MAP.get(clickedBlock).defaultBlockState());

                context.getItemInHand().hurtAndBreak(1, ((ServerLevel) level), context.getPlayer(),
                        item -> context.getPlayer().onEquippedItemBroken(item, EquipmentSlot.MAINHAND));

                level.playSound(null,context.getClickedPos(), SoundEvents.GRINDSTONE_USE, SoundSource.BLOCKS);
            }

        }

        return InteractionResult.SUCCESS;
    }

    @Override
    public void appendHoverText(ItemStack stack, TooltipContext context, List<Component> tooltipComponents, TooltipFlag tooltipFlag) {
        if(Screen.hasShiftDown()) {
            tooltipComponents.add(Component.translatable("tooltip.holdfoxmodsf.fox_chisel_item.shift_down"));
        } else {
            tooltipComponents.add(Component.translatable("tooltip.holdfoxmodsf.fox_chisel_item"));
        }

        super.appendHoverText(stack, context, tooltipComponents, tooltipFlag);
    }
}
