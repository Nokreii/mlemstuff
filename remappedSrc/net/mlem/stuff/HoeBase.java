package net.mlem.stuff;

import net.minecraft.item.HoeItem;
import net.minecraft.item.PickaxeItem;
import net.minecraft.item.ToolMaterial;

public class HoeBase extends HoeItem {
    protected HoeBase(ToolMaterial material) {
        super(material, -8, 0, new Settings().group(MlemStuff.ITEM_GROUP));
    }
}