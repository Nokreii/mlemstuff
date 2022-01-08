package net.mlem.stuff;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentTarget;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;

public class LifeSteal extends Enchantment {
    public LifeSteal() {
        super(Rarity.UNCOMMON, EnchantmentTarget.WEAPON, new EquipmentSlot[]{EquipmentSlot.MAINHAND});
    }

    @Override
    public int getMinPower(int level) {
        return 2;
    }
    @Override
    public int getMaxLevel() {
        return 3;
    }
    @Override
    public void onTargetDamaged(LivingEntity user, Entity target, int level) {
        if(target instanceof LivingEntity) {
            //((LivingEntity) target).addStatusEffect(new StatusEffectInstance(StatusEffects.INSTANT_HEALTH, 20 * 2 * level, level - 1));
            user.heal(1f);
        }

        super.onTargetDamaged(user, target, level);
    }
}
