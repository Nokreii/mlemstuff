package net.mlem.stuff;

import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.*;

public class AltheaePot extends Block {
    public AltheaePot() {super(FabricBlockSettings.of(Material.WOOL).hardness(0.4f).resistance(0.1f).nonOpaque());}
}
