package org.error1015.allcurioscanapplycursedenchantment;

import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;

@Mod(AllCuriosCanApplyCursedEnchantment.MODID)
public class AllCuriosCanApplyCursedEnchantment {
    public static final String MODID = "allcurioscanapplycursedenchantment";

    public AllCuriosCanApplyCursedEnchantment() {
        var modLoadingContext = ModLoadingContext.get();
        modLoadingContext.registerConfig(ModConfig.Type.COMMON, Config.spec);
    }
}