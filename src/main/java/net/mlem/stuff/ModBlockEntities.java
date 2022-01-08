package net.mlem.stuff;

import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ModBlockEntities {
    public static BlockEntityType<LightningChannelerBlockEntity> LIGHTNING_CHANNELER_BLOCK_ENTITY;

    public static void registerBlockEntities() {
        LIGHTNING_CHANNELER_BLOCK_ENTITY =
                Registry.register(Registry.BLOCK_ENTITY_TYPE, new Identifier("mlemstuff", "lightning_channeler"),
                        FabricBlockEntityTypeBuilder.create(LightningChannelerBlockEntity::new,
                                ModBlocks.LIGHTNING_CHANNELER_BLOCK).build(null));
    }
}