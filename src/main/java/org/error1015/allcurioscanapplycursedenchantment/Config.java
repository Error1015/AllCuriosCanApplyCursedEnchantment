package org.error1015.allcurioscanapplycursedenchantment;

import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.config.ModConfigEvent;

@Mod.EventBusSubscriber(modid = AllCuriosCanApplyCursedEnchantment.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class Config {
    public static final ForgeConfigSpec.Builder builder = new ForgeConfigSpec.Builder();

    public static boolean enable;

    @SubscribeEvent
    public static void onLoad(final ModConfigEvent.Loading configEvent) {
        enable = builder.define("enable", true).get();
    }
}