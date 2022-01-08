package net.mlem.stuff;

import net.minecraft.item.AxeItem;
import net.minecraft.item.PickaxeItem;
import net.minecraft.item.ToolMaterial;

public class AxeBase extends AxeItem {
    protected AxeBase(ToolMaterial material) {
        super(material, +1, 0, new Settings().group(MlemStuff.ITEM_GROUP));
    }
}