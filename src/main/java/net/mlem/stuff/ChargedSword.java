package net.mlem.stuff;

import net.minecraft.item.SwordItem;
import net.minecraft.item.ToolMaterial;

public class ChargedSword extends SwordItem {
    public ChargedSword(ToolMaterialCharged toolMaterial, int attackDamage, float attackSpeed, Settings settings) {
        super(toolMaterial, attackDamage, attackSpeed, settings);
    }
}
