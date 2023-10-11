package thelm.jaopca.mixin.plugin;

import cpw.mods.fml.relauncher.FMLLaunchHandler;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public enum Mixin {

    //
    // IMPORTANT: Do not make any references to any mod from this file. This file is loaded quite early on and if
    // you refer to other mods you load them as well. The consequence is: You can't inject any previously loaded classes!
    // Exception: Tags.java, as long as it is used for Strings only!
    //

    // Replace with your own mixins:
    ExtractorHandlerMixin("compat.rotarycraft.ExtractorHandlerMixin", Side.BOTH, TargetedMod.ROTARYCRAFT),
    ExtractorHandlerRecipeMixin("compat.rotarycraft.ExtractorHandlerRecipeMixin", Side.BOTH, TargetedMod.ROTARYCRAFT),
    RecipesExtractorMixin("compat.rotarycraft.RecipesExtractorMixin", Side.BOTH, TargetedMod.ROTARYCRAFT),
    SlotExtractor1Mixin("compat.rotarycraft.SlotExtractor1Mixin", Side.BOTH, TargetedMod.ROTARYCRAFT),
    SlotExtractor2Mixin("compat.rotarycraft.SlotExtractor2Mixin", Side.BOTH, TargetedMod.ROTARYCRAFT),
    SlotExtractor3Mixin("compat.rotarycraft.SlotExtractor3Mixin", Side.BOTH, TargetedMod.ROTARYCRAFT),
    SlotExtractor4Mixin("compat.rotarycraft.SlotExtractor4Mixin", Side.BOTH, TargetedMod.ROTARYCRAFT),
    TileEntityExtractorMixin("compat.rotarycraft.TileEntityExtractorMixin", Side.BOTH, TargetedMod.ROTARYCRAFT);


    public final String mixinClass;
    public final HashSet<TargetedMod> targetedMods;
    private final Side side;

    Mixin(String mixinClass, Side side, TargetedMod... targetedMods) {
        this.mixinClass = mixinClass;
        this.targetedMods = new HashSet<>(Arrays.asList(targetedMods));
        this.side = side;
    }


    public boolean shouldLoad(List<TargetedMod> loadedMods) {
        return (side == Side.BOTH
                || side == Side.SERVER && FMLLaunchHandler.side().isServer()
                || side == Side.CLIENT && FMLLaunchHandler.side().isClient())
                && new HashSet<>(loadedMods).containsAll(targetedMods);
    }
}

enum Side {
    BOTH,
    CLIENT,
    SERVER
}
