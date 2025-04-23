package org.error1015.allcurioscanapplycursedenchantment.mixin;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraftforge.common.extensions.IForgeEnchantment;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import top.theillusivec4.curios.api.type.capability.ICurioItem;

@Mixin(Enchantment.class)
public abstract class CurseEnchantmentMixin implements IForgeEnchantment {
    @Inject(method = "canEnchant", at = @At("HEAD"), cancellable = true)
    public void allowCurseToCurios(ItemStack pStack, CallbackInfoReturnable<Boolean> cir) {
        Enchantment enchantment = (Enchantment) (Object) this;
        if (pStack.getItem() instanceof ICurioItem && enchantment.isCurse()) {
            cir.setReturnValue(true);
        }
    }
}