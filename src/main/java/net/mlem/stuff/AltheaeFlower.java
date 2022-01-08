package net.mlem.stuff;

import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Blocks;
import net.minecraft.block.Material;
import net.minecraft.block.PlantBlock;

public class AltheaeFlower extends PlantBlock {
    protected AltheaeFlower(Settings settings) {
        super(FabricBlockSettings.copy(Blocks.DANDELION).nonOpaque().noCollision());

    }
}
