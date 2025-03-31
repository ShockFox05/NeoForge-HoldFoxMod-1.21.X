package net.ShockFox05.HoldfoxMod.datagen;

import net.ShockFox05.HoldfoxMod.HoldfoxMod;
import net.ShockFox05.HoldfoxMod.block.ModBlocks;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.neoforged.neoforge.common.data.BlockTagsProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagProvider extends BlockTagsProvider {
    public ModBlockTagProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, HoldfoxMod.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {
        tag(BlockTags.MINEABLE_WITH_PICKAXE)
                .add(ModBlocks.FOX_ORE.get())
                .add(ModBlocks.FOX_DEEPSLATE_ORE.get())
                .add(ModBlocks.MAGIC_FOX_BLOCK.get());

        tag(BlockTags.NEEDS_STONE_TOOL)
                .add(ModBlocks.FOX_ORE.get())
                .add(ModBlocks.FOX_DEEPSLATE_ORE.get())
                .add(ModBlocks.MAGIC_FOX_BLOCK.get());

        tag(BlockTags.FENCES).add(ModBlocks.FOX_FENCE.get());
        tag(BlockTags.FENCE_GATES).add(ModBlocks.FOX_FENCE_GATE.get());
        tag(BlockTags.WALLS).add(ModBlocks.FOX_WALL.get());
    }
}
