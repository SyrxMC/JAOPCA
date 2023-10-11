package thelm.jaopca.mixin.mixins.compat.rotarycraft;

import Reika.RotaryCraft.Auxiliary.RecipeManagers.RecipesExtractor;
import com.gtnewhorizon.mixinextras.injector.ModifyReturnValue;
import net.minecraft.item.ItemStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import thelm.jaopca.compat.rotarycraft.recipes.RotaryCraftRecipeHandler;

@Mixin(RecipesExtractor.class)
public class RecipesExtractorMixin {

	@ModifyReturnValue(method = "getExtractionResult", at = @At("RETURN"), remap = false)
	private ItemStack modifyGetExtractionResult(ItemStack original, ItemStack item) {
		return original == null ? RotaryCraftRecipeHandler.getExtractorResult(item) : original;
	}
}
