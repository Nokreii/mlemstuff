package net.mlem.stuff;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ModBlocks {

    public static final Block LIGHTNING_CHANNELER_BLOCK = registerBlock("lightning_channeler",
            new LightningChannelerBlock(FabricBlockSettings.of(Material.METAL)));

    public static void registerModBlocks() {
        System.out.println("Registering ModBlocks for " + "mlemstuff");
    }

    private static Block registerBlock(String name, Block block){
        registerBlockItem(name, block);
        return Registry.register(Registry.BLOCK, new Identifier("mlemstuff", name), block);
    }

    private static Item registerBlockItem(String name, Block block) {
        return Registry.register(Registry.ITEM, new Identifier("mlemstuff", name),
                new BlockItem(block, new FabricItemSettings().group(MlemStuff.ITEM_GROUP)));
    }
}
