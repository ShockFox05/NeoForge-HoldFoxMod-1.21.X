package net.ShockFox05.HoldfoxMod.block.custom;

import net.ShockFox05.HoldfoxMod.item.ModItems;
import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;

public class MagicFoxBlock extends Block {
    public MagicFoxBlock(Properties properties) {
        super(properties);
    }

    @Override
    protected InteractionResult useWithoutItem(BlockState state, Level level, BlockPos pos,
                                               Player player, BlockHitResult hitResult) {
        level.playSound(player, pos, SoundEvents.AMETHYST_CLUSTER_PLACE, SoundSource.BLOCKS, 1f, 1f);
        return InteractionResult.SUCCESS;
    }

    @Override
    public void stepOn(Level level, BlockPos pos, BlockState state, Entity entity) {
        if(entity instanceof ItemEntity itemEntity) {
            if (itemEntity.getItem().getItem() == Items.GOLD_INGOT) {
                // (ABOVE^) What item, turns into, (BELOW) What item
                itemEntity.setItem(new ItemStack(Items.DIAMOND, itemEntity.getItem().getCount()));
            }
        }

        if(entity instanceof ItemEntity itemEntity) {
            if (itemEntity.getItem().getItem() == Items.POPPY) {
                // (ABOVE^) What item, turns into, (BELOW) What item
                itemEntity.setItem(new ItemStack(Items.WITHER_ROSE, itemEntity.getItem().getCount()));
            }
        }
        if(entity instanceof ItemEntity itemEntity) {
            if(itemEntity.getItem().getItem() == ModItems.DEATH.get()) {
                // (ABOVE^) What item, turns into, (BELOW) What item
                itemEntity.setItem(new ItemStack(ModItems.HOLDFOX.get(), itemEntity.getItem().getCount()));
            }
        }


        super.stepOn(level, pos, state, entity);
    }
}
