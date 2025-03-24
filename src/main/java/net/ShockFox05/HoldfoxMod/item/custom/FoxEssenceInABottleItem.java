package net.ShockFox05.HoldfoxMod.item.custom;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.UseAnim;

public class FoxEssenceInABottleItem extends Item
    {
        public FoxEssenceInABottleItem(Item.Properties properties) {
        super(properties);
        }

        @Override
        public UseAnim getUseAnimation(ItemStack stack) {
        return UseAnim.DRINK;
        }

    }
