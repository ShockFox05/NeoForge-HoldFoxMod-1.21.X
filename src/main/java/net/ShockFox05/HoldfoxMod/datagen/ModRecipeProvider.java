package net.ShockFox05.HoldfoxMod.datagen;

import net.ShockFox05.HoldfoxMod.HoldfoxMod;
import net.ShockFox05.HoldfoxMod.block.ModBlocks;
import net.ShockFox05.HoldfoxMod.item.ModItems;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.*;
import net.minecraft.world.level.ItemLike;
import net.neoforged.neoforge.common.Tags;
import net.neoforged.neoforge.common.conditions.IConditionBuilder;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class ModRecipeProvider extends RecipeProvider implements IConditionBuilder {
    public ModRecipeProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries);
    }

    @Override
    protected void buildRecipes(RecipeOutput recipeOutput) {
        ShapedRecipeBuilder.shaped(RecipeCategory.FOOD, ModItems.EMERALD_APPLE.get())
                .pattern("EEE")
                .pattern("EAE")
                .pattern("EEE")
                .define('E', Items.EMERALD)
                .define('A', Items.APPLE)
                .unlockedBy("has_apple", has(Items.APPLE)).save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.FOX_CHISEL.get())
                .pattern("  H")
                .pattern(" C ")
                .pattern("S  ")
                .define('H', ModItems.HOLDFOX)
                .define('C', Items.COPPER_INGOT)
                .define('S', Items.STICK)
                .unlockedBy("has_holdfox", has(ModItems.HOLDFOX)).save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.FOX_BLOCK.get())
                .pattern("BBB")
                .pattern("BBB")
                .pattern("BBB")
                .define('B', ModItems.HOLDFOX.get())
                .unlockedBy("has_holdfox", has(ModItems.HOLDFOX)).save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.MAGIC_FOX_BLOCK.get())
                .pattern(" A ")
                .pattern("ABA")
                .pattern(" A ")
                .define('B', ModItems.HOLDFOX.get())
                .define('A', Items.AMETHYST_BLOCK)
                .unlockedBy("has_holdfox", has(ModItems.HOLDFOX)).save(recipeOutput);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.MAGIC_FOX_BLOCK.get())
                .pattern(" A ")
                .pattern("ABA")
                .pattern(" A ")
                .define('B', ModItems.HOLDFOX.get())
                .define('A', ModItems.FIRE_ESSENCE.get())
                .unlockedBy("has_holdfox", has(ModItems.HOLDFOX)).save(recipeOutput, "holdfoxmodsf:extra_recipe_example");

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.HOLDFOX.get(),9)
                .requires(ModBlocks.FOX_BLOCK)
                .unlockedBy("has_fox_block", has(ModBlocks.FOX_BLOCK)).save(recipeOutput);

        oreSmelting(recipeOutput,List.of(ModItems.HOLDFOX), RecipeCategory.MISC,ModItems.DEATH.get(),.7f,200,"death");
        oreBlasting(recipeOutput,List.of(ModItems.HOLDFOX), RecipeCategory.MISC, ModItems.DEATH.get(),.7f,100,"death");
        oreSmelting(recipeOutput,List.of(ModBlocks.FOX_ORE), RecipeCategory.MISC, ModItems.HOLDFOX.get(),.7f,200,"holdfox");
        oreBlasting(recipeOutput,List.of(ModBlocks.FOX_ORE), RecipeCategory.MISC, ModItems.HOLDFOX.get(),.7f,100,"holdfox");
        oreSmelting(recipeOutput,List.of(ModBlocks.FOX_DEEPSLATE_ORE), RecipeCategory.MISC, ModItems.HOLDFOX.get(),1.4f,200,"holdfox");
        oreBlasting(recipeOutput,List.of(ModBlocks.FOX_DEEPSLATE_ORE), RecipeCategory.MISC, ModItems.HOLDFOX.get(),1.4f,100,"holdfox");

        stairBuilder(ModBlocks.FOX_STAIRS.get(), Ingredient.of(ModItems.HOLDFOX)).group("holdfox")
                .unlockedBy("has_holdfox", has(ModItems.HOLDFOX)).save(recipeOutput);
        slab(recipeOutput, RecipeCategory.BUILDING_BLOCKS, ModBlocks.FOX_SLAB.get(), ModItems.HOLDFOX.get());

        buttonBuilder(ModBlocks.FOX_BUTTON.get(), Ingredient.of(ModItems.HOLDFOX)).group("holdfox")
                .unlockedBy("has_holdfox", has(ModItems.HOLDFOX)).save(recipeOutput);
        pressurePlate(recipeOutput, ModBlocks.FOX_PRESSURE_PLATE.get(), ModItems.HOLDFOX.get());

        fenceBuilder(ModBlocks.FOX_FENCE.get(), Ingredient.of(ModItems.HOLDFOX)).group("holdfox")
                .unlockedBy("has_holdfox", has(ModItems.HOLDFOX)).save(recipeOutput);
        fenceGateBuilder(ModBlocks.FOX_FENCE_GATE.get(), Ingredient.of(ModItems.HOLDFOX)).group("holdfox")
                .unlockedBy("has_holdfox", has(ModItems.HOLDFOX)).save(recipeOutput);
        wall(recipeOutput, RecipeCategory.BUILDING_BLOCKS, ModBlocks.FOX_WALL.get(), ModItems.HOLDFOX.get());

        doorBuilder(ModBlocks.FOX_DOOR.get(), Ingredient.of(ModItems.HOLDFOX)).group("holdfox")
                .unlockedBy("has_holdfox", has(ModItems.HOLDFOX)).save(recipeOutput);
        trapdoorBuilder(ModBlocks.FOX_TRAPDOOR.get(), Ingredient.of(ModItems.HOLDFOX)).group("holdfox")
                .unlockedBy("has_holdfox", has(ModItems.HOLDFOX)).save(recipeOutput);

    }
    protected static void oreSmelting(RecipeOutput recipeOutput, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult,
                                      float pExperience, int pCookingTime, String pGroup) {
        oreCooking(recipeOutput, RecipeSerializer.SMELTING_RECIPE, SmeltingRecipe::new, pIngredients, pCategory, pResult,
                pExperience, pCookingTime, pGroup, "_from_smelting");
    }

    protected static void oreBlasting(RecipeOutput recipeOutput, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult,
                                      float pExperience, int pCookingTime, String pGroup) {
        oreCooking(recipeOutput, RecipeSerializer.BLASTING_RECIPE, BlastingRecipe::new, pIngredients, pCategory, pResult,
                pExperience, pCookingTime, pGroup, "_from_blasting");
    }

    protected static <T extends AbstractCookingRecipe> void oreCooking(RecipeOutput recipeOutput, RecipeSerializer<T> pCookingSerializer, AbstractCookingRecipe.Factory<T> factory,
                                                                       List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTime, String pGroup, String pRecipeName) {
        for(ItemLike itemlike : pIngredients) {
            SimpleCookingRecipeBuilder.generic(Ingredient.of(itemlike), pCategory, pResult, pExperience, pCookingTime, pCookingSerializer, factory).group(pGroup).unlockedBy(getHasName(itemlike), has(itemlike))
                    .save(recipeOutput, HoldfoxMod.MOD_ID + ":" + getItemName(pResult) + pRecipeName + "_" + getItemName(itemlike));
        }
    }
}
