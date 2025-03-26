package net.ShockFox05.HoldfoxMod.util;

import net.ShockFox05.HoldfoxMod.HoldfoxMod;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

public class ModTags {
    public static class Blocks {

        public static final TagKey<Block> HOLDFOXMOD_BLOCKS = createTag("holdfoxmodsf_Blocks");

        private static TagKey<Block> createTag(String name) {
            return BlockTags.create(ResourceLocation.fromNamespaceAndPath(HoldfoxMod.MOD_ID, name));
        }
    }

    public static class Items {

        public static final TagKey<Item> TRANSFORMABLE_ITEMS = createTag("transformable_items");
        public static final TagKey<Item> HOLDFOXMOD_ITEMS = createTag("holdfoxmodsf_items");

        private static TagKey<Item> createTag(String name) {
            return ItemTags.create(ResourceLocation.fromNamespaceAndPath(HoldfoxMod.MOD_ID, name));
        }
    }
}
