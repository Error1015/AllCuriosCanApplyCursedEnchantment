package org.error1015.allcurioscanapplycursedenchantment.mixin;

import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraftforge.common.extensions.IForgeEnchantment;
import org.error1015.allcurioscanapplycursedenchantment.Config;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import top.theillusivec4.curios.api.type.capability.ICurioItem;

@Mixin(Enchantment.class)
public abstract class CurseEnchantmentMixin implements IForgeEnchantment {
    @Shadow
    public abstract boolean canApplyAtEnchantingTable(ItemStack stack);

    /**
     * @author Error1015
     * @reason Allow curse enchantments to apply to curios
     */
    @Overwrite
    public boolean canEnchant(ItemStack pStack) {
        Enchantment enchantment = (Enchantment) (Object) this;
        if (Config.enable.get() && enchantment != null && enchantment.isCurse()) {
            // 如果物品是ICurioItem或者物品的标签中包含curios命名空间下的标签，则允许该物品使用该 enchantment
            if (pStack.getItem() instanceof ICurioItem || pStack.getTags().anyMatch(this::allCuriosCanApplyCursedEnchantment$handleCuriosTag)) {
                return true;
            }
        }
        return canApplyAtEnchantingTable(pStack);
    }

    @Unique
    private boolean allCuriosCanApplyCursedEnchantment$handleCuriosTag(TagKey<Item> itemTagKey) {
        return itemTagKey.location().getNamespace().equals("curios");
    }
}