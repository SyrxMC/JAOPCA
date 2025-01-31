package thelm.jaopca.api.fluids;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraftforge.fluids.Fluid;
import thelm.jaopca.api.blocks.IBlockProvider;
import thelm.jaopca.api.items.IItemProvider;
import thelm.jaopca.api.materialforms.IMaterialFormInfo;

public interface IFluidInfo extends IMaterialFormInfo, IFluidProvider, IBlockProvider, IItemProvider {

	IMaterialFormFluid getMaterialFormFluid();

	IMaterialFormFluidBlock getMaterialFormFluidBlock();

	IMaterialFormBucketItem getMaterialFormBucketItem();

	@Override
	default Fluid asFluid() {
		return getMaterialFormFluid().asFluid();
	}

	@Override
	default Block asBlock() {
		return getMaterialFormFluidBlock().asBlock();
	}

	@Override
	default Item asItem() {
		return getMaterialFormBucketItem().asItem();
	}

	@Override
	default IMaterialFormFluid getMaterialForm() {
		return getMaterialFormFluid();
	}
}
