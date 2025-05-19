package org.error1015.allcurioscanapplycursedenchantment;

import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.fml.common.Mod;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Mod.EventBusSubscriber(modid = AllCuriosCanApplyCursedEnchantment.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class Config {
    public static final ForgeConfigSpec.Builder builder = new ForgeConfigSpec.Builder();
    private static final Logger log = LoggerFactory.getLogger(Config.class);
    public static ForgeConfigSpec spec;

    public static ForgeConfigSpec.BooleanValue enable = builder.define("enable", true);

    static {
        spec = builder.build();
    }

    // @SubscribeEvent
    // public static void onLoad(final ModConfigEvent.Loading configEvent) {
    //     enable = builder.define("enable", true);
    // }
}