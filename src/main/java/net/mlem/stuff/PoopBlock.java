package net.mlem.stuff;

import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Material;

//modifies the class
public class PoopBlock extends Block {

    public PoopBlock(){
        super(FabricBlockSettings.of(Material.WOOL).hardness(0.4f).resistance(0.1f));
    }
}
