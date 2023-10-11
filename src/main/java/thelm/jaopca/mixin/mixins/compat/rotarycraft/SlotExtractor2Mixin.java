package thelm.jaopca.mixin.mixins.compat.rotarycraft;

import Reika.RotaryCraft.Auxiliary.SlotExtractor2;
import com.gtnewhorizon.mixinextras.injector.ModifyReturnValue;
import net.minecraft.item.ItemStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import thelm.jaopca.compat.rotarycraft.recipes.RotaryCraftRecipeHandler;

@Mixin(value = SlotExtractor2.class, remap = false)
public class SlotExtractor2Mixin {

	@ModifyReturnValue(method = "isItemValid", at = @At("RETURN"))
	private boolean modifyIsItemValid(boolean original, ItemStack stack) {
		return original || RotaryCraftRecipeHandler.isExtractorDust(stack);
	}
}
