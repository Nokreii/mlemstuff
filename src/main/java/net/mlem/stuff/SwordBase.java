package net.mlem.stuff;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.item.SwordItem;
import net.minecraft.item.ToolMaterial;

public class SwordBase extends SwordItem {
    protected SwordBase(ToolMaterial material) {
        super(material, 0, 0, new Settings().group(MlemStuff.ITEM_GROUP));
    }

}