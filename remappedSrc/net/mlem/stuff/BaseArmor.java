package net.mlem.stuff;

import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.*;

public class BaseArmor extends ArmorItem {
    public BaseArmor(ArmorMaterial material, EquipmentSlot slot) {
        super(material, slot, new Item.Settings().group(MlemStuff.ITEM_GROUP));
    }
}