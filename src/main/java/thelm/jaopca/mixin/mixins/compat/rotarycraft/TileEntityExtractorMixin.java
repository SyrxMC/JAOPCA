package thelm.jaopca.mixin.mixins.compat.rotarycraft;

import Reika.DragonAPI.Interfaces.Registry.OreType;
import Reika.RotaryCraft.TileEntities.Processing.TileEntityExtractor;
import com.gtnewhorizon.mixinextras.injector.ModifyReturnValue;
import net.minecraft.item.ItemStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import thelm.jaopca.compat.rotarycraft.recipes.RotaryCraftRecipeHandler;

@Mixin(TileEntityExtractor.class)
public class TileEntityExtractorMixin {

	@ModifyReturnValue(method = "getOreType", at = @At("RETURN"), remap = false)
	private OreType modifyGetOreType(OreType original, ItemStack stack) {
		return original == null ? RotaryCraftRecipeHandler.getExtractorRecipe(stack) : original;
	}

	// The annotation processor is not working
	@ModifyReturnValue(method = {"isItemValidForSlot", "func_94041_b"}, at = @At("RETURN"), remap = false)
	private boolean modifyIsItemValidForSlot(boolean original, int slot, ItemStack stack) {
		return original ||
				slot == 0 && RotaryCraftRecipeHandler.isExtractorOre(stack) ||
				slot == 1 && RotaryCraftRecipeHandler.isExtractorDust(stack) ||
				slot == 2 && RotaryCraftRecipeHandler.isExtractorSlurry(stack) ||
				slot == 3 && RotaryCraftRecipeHandler.isExtractorSolution(stack);
	}
}
