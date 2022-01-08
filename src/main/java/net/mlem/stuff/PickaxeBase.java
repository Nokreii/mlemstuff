package net.mlem.stuff;

import net.minecraft.item.*;

public class PickaxeBase extends PickaxeItem{
    protected PickaxeBase(ToolMaterial material) {
        super(material, -5, 0, new Item.Settings().group(MlemStuff.ITEM_GROUP));
    }
}