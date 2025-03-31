package net.ShockFox05.HoldfoxMod.datagen;

import net.ShockFox05.HoldfoxMod.HoldfoxMod;
import net.ShockFox05.HoldfoxMod.block.ModBlocks;
import net.ShockFox05.HoldfoxMod.block.custom.FoxLampBlock;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.client.model.generators.BlockStateProvider;
import net.neoforged.neoforge.client.model.generators.ConfiguredModel;
import net.neoforged.neoforge.client.model.generators.ModelFile;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.registries.DeferredBlock;

public class ModBlockStateProvider extends BlockStateProvider {
    public ModBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, HoldfoxMod.MOD_ID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        blockWithItem(ModBlocks.FOX_BLOCK);

        blockWithItem(ModBlocks.FOX_ORE);
        blockWithItem(ModBlocks.FOX_DEEPSLATE_ORE);

        blockWithItem(ModBlocks.MAGIC_FOX_BLOCK);

        stairsBlock(ModBlocks.FOX_STAIRS.get(), blockTexture(ModBlocks.FOX_BLOCK.get()));
        slabBlock(ModBlocks.FOX_SLAB.get(), blockTexture(ModBlocks.FOX_BLOCK.get()), blockTexture(ModBlocks.FOX_BLOCK.get()));

        buttonBlock(ModBlocks.FOX_BUTTON.get(), blockTexture(ModBlocks.FOX_BLOCK.get()));
        pressurePlateBlock(ModBlocks.FOX_PRESSURE_PLATE.get(), blockTexture(ModBlocks.FOX_BLOCK.get()));

        fenceBlock(ModBlocks.FOX_FENCE.get(), blockTexture(ModBlocks.FOX_BLOCK.get()));
        fenceGateBlock(ModBlocks.FOX_FENCE_GATE.get(), blockTexture(ModBlocks.FOX_BLOCK.get()));
        wallBlock(ModBlocks.FOX_WALL.get(), blockTexture(ModBlocks.FOX_BLOCK.get()));

        doorBlockWithRenderType(ModBlocks.FOX_DOOR.get(), modLoc("block/fox_door_bottom"), modLoc("block/fox_door_top"),"cutout");
        trapdoorBlockWithRenderType(ModBlocks.FOX_TRAPDOOR.get(), modLoc("block/fox_trapdoor"), true,"cutout");

        blockItem(ModBlocks.FOX_STAIRS);
        blockItem(ModBlocks.FOX_SLAB);
        blockItem(ModBlocks.FOX_PRESSURE_PLATE);
        blockItem(ModBlocks.FOX_FENCE_GATE);
        blockItem(ModBlocks.FOX_TRAPDOOR, "_bottom");

        customLamp();
    }

    private void customLamp() {
        getVariantBuilder(ModBlocks.FOX_LAMP.get()).forAllStates(state -> {
            if (state.getValue(FoxLampBlock.CLICKED)) {
                return new ConfiguredModel[]{new ConfiguredModel(models().cubeAll("fox_lamp_on",
                        ResourceLocation.fromNamespaceAndPath(HoldfoxMod.MOD_ID, "block/" + "fox_lamp_on")))};
            } else {
                return new ConfiguredModel[]{new ConfiguredModel(models().cubeAll("fox_lamp_off",
                        ResourceLocation.fromNamespaceAndPath(HoldfoxMod.MOD_ID, "block/" + "fox_lamp_off")))};
            }
        });

        simpleBlockItem(ModBlocks.FOX_LAMP.get(), models().cubeAll("fox_lamp_on",
                ResourceLocation.fromNamespaceAndPath(HoldfoxMod.MOD_ID, "block/" + "fox_lamp_on")));
    }


        private void blockWithItem(DeferredBlock<?> deferredBlock) {
        simpleBlockWithItem(deferredBlock.get(), cubeAll(deferredBlock.get()));
    }
    private void blockItem(DeferredBlock<?> deferredBlock) {
        simpleBlockItem(deferredBlock.get(), new ModelFile.UncheckedModelFile("holdfoxmodsf:block/" + deferredBlock.getId().getPath()));
    }

    private void blockItem(DeferredBlock<?> deferredBlock, String appendix) {
        simpleBlockItem(deferredBlock.get(), new ModelFile.UncheckedModelFile("holdfoxmodsf:block/" + deferredBlock.getId().getPath() + appendix));
    }
}
