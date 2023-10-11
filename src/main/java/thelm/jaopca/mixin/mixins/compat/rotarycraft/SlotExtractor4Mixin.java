package thelm.jaopca.mixin.mixins.compat.rotarycraft;

import Reika.RotaryCraft.Auxiliary.SlotExtractor4;
import com.gtnewhorizon.mixinextras.injector.ModifyReturnValue;
import net.minecraft.item.ItemStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import thelm.jaopca.compat.rotarycraft.recipes.RotaryCraftRecipeHandler;

@Mixin(value = SlotExtractor4.class, remap = false)
public class SlotExtractor4Mixin {

	@ModifyReturnValue(method = "isItemValid", at = @At("RETURN"))
	private boolean modifyIsItemValid(boolean original, ItemStack stack) {
		return original || RotaryCraftRecipeHandler.isExtractorSolution(stack);
	}
}
