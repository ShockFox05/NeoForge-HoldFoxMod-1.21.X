package net.ShockFox05.HoldfoxMod.datagen;

import net.ShockFox05.HoldfoxMod.HoldfoxMod;
import net.ShockFox05.HoldfoxMod.block.ModBlocks;
import net.ShockFox05.HoldfoxMod.item.ModItems;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.client.model.generators.ItemModelProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.registries.DeferredBlock;

public class ModItemModelProvider extends ItemModelProvider {
    public ModItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, HoldfoxMod.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        basicItem(ModItems.HOLDFOX.get());
        basicItem(ModItems.DEATH.get());

        basicItem(ModItems.FOX_CHISEL.get());
        basicItem(ModItems.FIRE_ESSENCE.get());
        basicItem(ModItems.UNSTABLE_FIRE.get());

        basicItem(ModItems.EMERALD_APPLE.get());
        basicItem(ModItems.FOX_ESSENCE_IN_A_BOTTLE.get());

        buttonItem(ModBlocks.FOX_BUTTON, ModBlocks.FOX_BLOCK);
        fenceItem(ModBlocks.FOX_FENCE, ModBlocks.FOX_BLOCK);
        wallItem(ModBlocks.FOX_WALL, ModBlocks.FOX_BLOCK);

        basicItem(ModBlocks.FOX_DOOR.asItem());
    }

    public void buttonItem(DeferredBlock<?> block, DeferredBlock<Block> baseBlock) {
        this.withExistingParent(block.getId().getPath(), mcLoc("block/button_inventory"))
                .texture("texture",  ResourceLocation.fromNamespaceAndPath(HoldfoxMod.MOD_ID,
                        "block/" + baseBlock.getId().getPath()));
    }

    public void fenceItem(DeferredBlock<?> block, DeferredBlock<Block> baseBlock) {
        this.withExistingParent(block.getId().getPath(), mcLoc("block/fence_inventory"))
                .texture("texture",  ResourceLocation.fromNamespaceAndPath(HoldfoxMod.MOD_ID,
                        "block/" + baseBlock.getId().getPath()));
    }

    public void wallItem(DeferredBlock<?> block, DeferredBlock<Block> baseBlock) {
        this.withExistingParent(block.getId().getPath(), mcLoc("block/wall_inventory"))
                .texture("wall", ResourceLocation.fromNamespaceAndPath(HoldfoxMod.MOD_ID,
                        "block/" + baseBlock.getId().getPath()));
    }
}
