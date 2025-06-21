package net.ShockFox05.HoldfoxMod.datagen;

import net.ShockFox05.HoldfoxMod.HoldfoxMod;
import net.ShockFox05.HoldfoxMod.item.ModItems;
import net.ShockFox05.HoldfoxMod.util.ModTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class ModItemTagProvider extends ItemTagsProvider {
    public ModItemTagProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider,
                              CompletableFuture<TagLookup<Block>> blockTags, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, blockTags, HoldfoxMod.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {
        tag(ModTags.Items.TRANSFORMABLE_ITEMS)
                .add(Items.GOLD_INGOT);
        tag(ModTags.Items.HOLDFOXMOD_ITEMS)
                .add(ModItems.DEATH.get());
        tag(ItemTags.SWORDS)
                .add(ModItems.FOX_SWORD.get());
        tag(ItemTags.PICKAXES)
                .add(ModItems.FOX_PICKAXE.get());
        tag(ItemTags.SHOVELS)
                .add(ModItems.FOX_SHOVEL.get());
        tag(ItemTags.AXES)
                .add(ModItems.FOX_AXE.get());
        tag(ItemTags.HOES)
                .add(ModItems.FOX_HOE.get());
    }
}
