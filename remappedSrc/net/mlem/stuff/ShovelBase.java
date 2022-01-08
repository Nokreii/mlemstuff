package net.mlem.stuff;

import net.minecraft.item.HoeItem;
import net.minecraft.item.ShovelItem;
import net.minecraft.item.ToolMaterial;

public class ShovelBase extends ShovelItem {
    protected ShovelBase(ToolMaterial material) {
        super(material, -4, 0, new Settings().group(MlemStuff.ITEM_GROUP));
    }
}