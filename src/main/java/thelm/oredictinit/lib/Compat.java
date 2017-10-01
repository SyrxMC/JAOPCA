package thelm.oredictinit.lib;

import net.minecraftforge.fml.common.Loader;
import thelm.oredictinit.api.OreDictInitApi;
import thelm.oredictinit.compat.CompatCalculator;
import thelm.oredictinit.compat.CompatDraconicEvolution;
import thelm.oredictinit.compat.CompatExtremeReactors;
import thelm.oredictinit.compat.CompatGalacticraftCore;
import thelm.oredictinit.compat.CompatGalacticraftPlanets;
import thelm.oredictinit.compat.CompatMekanism;
import thelm.oredictinit.compat.CompatMinecraft;
import thelm.oredictinit.compat.CompatNamingNonsense;
import thelm.oredictinit.compat.CompatNuclearCraft;
import thelm.oredictinit.compat.CompatQuark;
import thelm.oredictinit.compat.CompatRFTools;
import thelm.oredictinit.compat.CompatTheBetweenlands;

public class Compat {

	public static void init() {
		OreDictInitApi.ORE_DICT_COMPAT_LIST.add(new CompatMinecraft());
		OreDictInitApi.ORE_DICT_COMPAT_LIST.add(new CompatNamingNonsense());
		if(Loader.isModLoaded("Mekanism")) {
			OreDictInitApi.ORE_DICT_COMPAT_LIST.add(new CompatMekanism());
		}
		if(Loader.isModLoaded("draconicevolution")) {
			OreDictInitApi.ORE_DICT_COMPAT_LIST.add(new CompatDraconicEvolution());
		}
		if(Loader.isModLoaded("galacticraftcore")) {
			OreDictInitApi.ORE_DICT_COMPAT_LIST.add(new CompatGalacticraftCore());
		}
		if(Loader.isModLoaded("galacticraftplanets")) {
			OreDictInitApi.ORE_DICT_COMPAT_LIST.add(new CompatGalacticraftPlanets());
		}
		if(Loader.isModLoaded("nuclearcraft")) {
			OreDictInitApi.ORE_DICT_COMPAT_LIST.add(new CompatNuclearCraft());
		}
		if(Loader.isModLoaded("thebetweenlands")) {
			OreDictInitApi.ORE_DICT_COMPAT_LIST.add(new CompatTheBetweenlands());
		}
		if(Loader.isModLoaded("calculator")) {
			OreDictInitApi.ORE_DICT_COMPAT_LIST.add(new CompatCalculator());
		}
		if(Loader.isModLoaded("bigreactors")) {
			OreDictInitApi.ORE_DICT_COMPAT_LIST.add(new CompatExtremeReactors());
		}
		if(Loader.isModLoaded("quark")) {
			OreDictInitApi.ORE_DICT_COMPAT_LIST.add(new CompatQuark());
		}
		if(Loader.isModLoaded("rftools")) {
			OreDictInitApi.ORE_DICT_COMPAT_LIST.add(new CompatRFTools());
		}
	}
}
