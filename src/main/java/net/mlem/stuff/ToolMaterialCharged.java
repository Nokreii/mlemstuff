package net.mlem.stuff;

import net.minecraft.item.ToolMaterial;
import net.minecraft.recipe.Ingredient;

public class ToolMaterialCharged implements ToolMaterial {
    public static final ToolMaterial INSTANCE = new ToolMaterialCharged();

    @Override
    public int getDurability() {
        return 4096;
    }

    @Override
    public float getMiningSpeedMultiplier() {
        return 10;
    }

    @Override
    public float getAttackDamage() {
        return 16f;
    }

    @Override
    public int getMiningLevel() {
        return 4;
    }

    @Override
    public int getEnchantability() {
        return 64;
    }

    @Override
    public Ingredient getRepairIngredient() {
        return null;
    }

    /*@Override
    public Ingredient getRepairIngredient() {
        return Ingredient.ofItems(MlemStuff.JadeItem);
    }*/
}
