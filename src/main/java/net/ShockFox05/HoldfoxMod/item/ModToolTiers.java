package net.ShockFox05.HoldfoxMod.item;

import net.ShockFox05.HoldfoxMod.util.ModTags;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.crafting.Ingredient;
import net.neoforged.neoforge.common.SimpleTier;

public class ModToolTiers {
    public static final Tier FOX = new SimpleTier(ModTags.Blocks.INCORRECT_FOR_FOX_TOOL,
            1400,7f, 3f, 22, () -> Ingredient.of(ModItems.HOLDFOX));

}
