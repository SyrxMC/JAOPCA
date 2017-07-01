package thelm.jaopca;

import java.io.File;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.ModMetadata;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import thelm.jaopca.ore.OreFinder;
import thelm.jaopca.oredictinit.OreDictInit;
import thelm.jaopca.proxy.CommonProxy;
import thelm.jaopca.registry.RegistryCore;
import thelm.jaopca.utils.JAOPCAConfig;
import thelm.jaopca.utils.JAOPCAEventHandler;

@Mod(
		modid = JAOPCA.MOD_ID,
		name = "JAOPCA",
		version = JAOPCA.VERSION,
		dependencies = "after:*"
		)
public class JAOPCA {
	public static final String MOD_ID = "jaopca";
	public static final String VERSION = "1.11.2-1.1.18";
	@Instance(JAOPCA.MOD_ID)
	public static JAOPCA core;
	@SidedProxy(clientSide = "thelm.jaopca.proxy.ClientProxy", serverSide = "thelm.jaopca.proxy.CommonProxy", modId = JAOPCA.MOD_ID)
	public static CommonProxy proxy;
	public static ModMetadata metadata;

	@EventHandler
	public void firstMovement(FMLPreInitializationEvent event) {
		metadata = event.getModMetadata();
		metadata.autogenerated = false;
		metadata.modId = MOD_ID;
		metadata.version = VERSION;
		metadata.name = "Just A Ore Processing Compatibility Attempt";
		metadata.credits = "Idea taken from AOBD by ganymedes01";
		metadata.authorList.add("TheLMiffy1111");
		metadata.description = "A mod that aims to make mods with ore processing support more ores.";

		OreDictInit.instance.preInit(event);

		MinecraftForge.EVENT_BUS.register(new JAOPCAEventHandler());

		JAOPCAConfig.init(new File(event.getModConfigurationDirectory(), "JAOPCA.cfg"));
		OreFinder.findOres();
		RegistryCore.preInit();
	}

	@EventHandler
	public void secondMovement(FMLInitializationEvent event) {
		proxy.initBlockColors();
		proxy.initItemColors();

		RegistryCore.init();
	}

	@EventHandler
	public void thirdMovement(FMLPostInitializationEvent event) {
		RegistryCore.postInit();
	}
}
