package net.ShockFox05.HoldfoxMod.datagen;

import net.ShockFox05.HoldfoxMod.block.ModBlocks;
import net.ShockFox05.HoldfoxMod.item.ModItems;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.ApplyBonusCount;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;

import java.util.Set;

public class ModBlockLootTableProvider extends BlockLootSubProvider {

    protected ModBlockLootTableProvider(HolderLookup.Provider registries) {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags(), registries);
    }

    @Override
    protected void generate() {
        dropSelf(ModBlocks.FOX_BLOCK.get());
        dropSelf(ModBlocks.MAGIC_FOX_BLOCK.get());

        add(ModBlocks.FOX_ORE.get(),
                block -> createMultipleOreDrops(ModBlocks.FOX_ORE.get(), ModItems.HOLDFOX.get(),1,3));
        add(ModBlocks.FOX_DEEPSLATE_ORE.get(),
                block -> createMultipleOreDrops(ModBlocks.FOX_DEEPSLATE_ORE.get(), ModItems.HOLDFOX.get(), 2,5));
        dropSelf(ModBlocks.FOX_STAIRS.get());
        add(ModBlocks.FOX_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.FOX_SLAB.get()));
        dropSelf(ModBlocks.FOX_PRESSURE_PLATE.get());
        dropSelf(ModBlocks.FOX_BUTTON.get());
        dropSelf(ModBlocks.FOX_FENCE.get());
        dropSelf(ModBlocks.FOX_FENCE_GATE.get());
        dropSelf(ModBlocks.FOX_WALL.get());
        add(ModBlocks.FOX_DOOR.get(),
                block -> createDoorTable(ModBlocks.FOX_DOOR.get()));
        dropSelf(ModBlocks.FOX_TRAPDOOR.get());

    }

    protected LootTable.Builder createMultipleOreDrops(Block pBlock, Item item, float minDrops, float maxDrops) {
        HolderLookup.RegistryLookup<Enchantment> registrylookup = this.registries.lookupOrThrow(Registries.ENCHANTMENT);
        return this.createSilkTouchDispatchTable(pBlock,
                this.applyExplosionDecay(pBlock, LootItem.lootTableItem(item)
                        .apply(SetItemCountFunction.setCount(UniformGenerator.between(minDrops, maxDrops)))
                        .apply(ApplyBonusCount.addOreBonusCount(registrylookup.getOrThrow(Enchantments.FORTUNE)))));
    }

    @Override
    protected Iterable<Block> getKnownBlocks() {
        return ModBlocks.BLOCKS.getEntries().stream().map(Holder::value)::iterator;
    }
}
