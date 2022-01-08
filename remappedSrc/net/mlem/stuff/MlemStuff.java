package net.mlem.stuff;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.fabricmc.fabric.api.loot.v1.FabricLootPoolBuilder;
import net.fabricmc.fabric.api.loot.v1.event.LootTableLoadingCallback;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.*;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.*;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.provider.number.ConstantLootNumberProvider;
import net.minecraft.loot.provider.number.UniformLootNumberProvider;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.BuiltinRegistries;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.RegistryKey;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.YOffset;
import net.minecraft.world.gen.decorator.CountPlacementModifier;
import net.minecraft.world.gen.decorator.HeightRangePlacementModifier;
import net.minecraft.world.gen.decorator.SquarePlacementModifier;
import net.minecraft.world.gen.feature.*;

public class MlemStuff implements ModInitializer
{

    //Sets a group for my custom items
    public static final ItemGroup ITEM_GROUP = FabricItemGroupBuilder.build(
            new Identifier("mlemstuff", "general"),
            () -> new ItemStack(MlemStuff.JadeOreBlock));


    //creates classes that are able to be modified

    public static final Item PoopItem = new PoopItem(new Item.Settings().group(MlemStuff.ITEM_GROUP));

    public static final Item PoopBar = new PoopBar(new Item.Settings().group(MlemStuff.ITEM_GROUP)
            .food(new FoodComponent.Builder().hunger(5).saturationModifier(4).snack().meat().alwaysEdible()
                    .statusEffect(new StatusEffectInstance(StatusEffects.POISON, 40 * 2), 0.8f).build()));

    public static final Item JadeItem = new JadeItem(new Item.Settings().group(MlemStuff.ITEM_GROUP));

    public static final Item CheeseItem = new CheeseItem(new Item.Settings().group(MlemStuff.ITEM_GROUP)
            .food(new FoodComponent.Builder().hunger(6).saturationModifier(4).snack().meat().alwaysEdible().build()));

    public static final Block PoopBlock = new PoopBlock();

    public static final Block AltheaePot = new AltheaePot();

    public static final Block CurtainsWhite = new CurtainsWhite(FabricBlockSettings.copy(Blocks.OAK_FENCE));

    public static Block AltheaeFlower = new AltheaeFlower(FabricBlockSettings.copy(Blocks.DANDELION));

    public static final Block PotShelf = new PotShelf();

    public static final CropBlock AltheaeCrop = new AltheaeCrop(AbstractBlock.Settings.of(Material.PLANT)
            .nonOpaque().noCollision().ticksRandomly().breakInstantly().sounds(BlockSoundGroup.CROP));

    public static final Item AltheaeSeeds = new AliasedBlockItem(MlemStuff.AltheaeCrop, new Item.Settings()
            .group(MlemStuff.ITEM_GROUP));


    public static final Block JadeOreBlock = new JadeOreBlock(FabricBlockSettings.copy(Blocks.STONE));

    private static final ConfiguredFeature<?, ?> OVERWORLD_JADE_ORE_CONFIGURED_FEATURE = Feature.ORE
            .configure(new OreFeatureConfig(OreConfiguredFeatures.STONE_ORE_REPLACEABLES, MlemStuff.JadeOreBlock
                    .getDefaultState(), 9));

    public static PlacedFeature OVERWORLD_JADE_ORE_PLACED_FEATURE = OVERWORLD_JADE_ORE_CONFIGURED_FEATURE.withPlacement(
            CountPlacementModifier.of(6), // number of veins per chunk
            SquarePlacementModifier.of(), // spreading horizontally
            HeightRangePlacementModifier.uniform(YOffset.getBottom(), YOffset.fixed(64))); // height

    public static final Enchantment LifeSteal = Registry.register(
            Registry.ENCHANTMENT,
            new Identifier("mlemstuff", "life_steal_enchantment"),
            new LifeSteal());


    private static final Identifier GRASS_LOOT_TABLE_ID = Blocks.GRASS.getLootTableId();
    public static final ArmorMaterial Hats = new ArmorMaterialCloth();


    //adds the items into the game with ID's
    @Override
    public void onInitialize(){
        Registry.register(Registry.ITEM, new Identifier("mlemstuff", "poop_item"), PoopItem);
        Registry.register(Registry.ITEM, new Identifier("mlemstuff", "poop_bar"), PoopBar);
        Registry.register(Registry.ITEM, new Identifier("mlemstuff", "jade_item"), JadeItem);
        Registry.register(Registry.BLOCK, new Identifier("mlemstuff","altheae_crop"), AltheaeCrop);
        Registry.register(Registry.ITEM, new Identifier("mlemstuff","altheae_seeds"), AltheaeSeeds);
        Registry.register(Registry.ITEM, new Identifier("mlemstuff", "cheese_item"), CheeseItem);

        Registry.register(Registry.BLOCK, new Identifier("mlemstuff","altheae_pot"), AltheaePot);
        Registry.register(Registry.ITEM, new Identifier("mlemstuff", "altheae_pot"),
                new BlockItem(AltheaePot, new Item.Settings().group(MlemStuff.ITEM_GROUP)));

        Registry.register(Registry.BLOCK, new Identifier("mlemstuff","curtains_white"), CurtainsWhite);
        Registry.register(Registry.ITEM, new Identifier("mlemstuff", "curtains_white"),
                new BlockItem(CurtainsWhite, new Item.Settings().group(MlemStuff.ITEM_GROUP)));

        Registry.register(Registry.BLOCK, new Identifier("mlemstuff","altheae_flower"), AltheaeFlower);
        Registry.register(Registry.ITEM, new Identifier("mlemstuff", "altheae_flower"),
                new BlockItem(AltheaeFlower, new Item.Settings().group(MlemStuff.ITEM_GROUP)
                        .food(new FoodComponent.Builder().hunger(2).saturationModifier(6).snack().meat().alwaysEdible().build())));

        Registry.register(Registry.BLOCK, new Identifier("mlemstuff","pot_shelf"), PotShelf);
        Registry.register(Registry.ITEM, new Identifier("mlemstuff", "pot_shelf"),
                new BlockItem(PotShelf, new Item.Settings().group(MlemStuff.ITEM_GROUP)));

        Registry.register(Registry.BLOCK, new Identifier("mlemstuff","poop_block"), PoopBlock);
        Registry.register(Registry.ITEM, new Identifier("mlemstuff", "poop_block"),
                new BlockItem(PoopBlock, new Item.Settings().group(MlemStuff.ITEM_GROUP)));

        Registry.register(Registry.BLOCK, new Identifier("mlemstuff","jade_ore_block"), JadeOreBlock);
        Registry.register(Registry.ITEM, new Identifier("mlemstuff", "jade_ore_block"),
                new BlockItem(JadeOreBlock, new Item.Settings().group(MlemStuff.ITEM_GROUP)));

        Registry.register(BuiltinRegistries.CONFIGURED_FEATURE,
                new Identifier("mlemstuff", "jade_ore_block"), OVERWORLD_JADE_ORE_CONFIGURED_FEATURE);
        Registry.register(BuiltinRegistries.PLACED_FEATURE, new Identifier("mlemstuff", "jade_ore_block"),
                OVERWORLD_JADE_ORE_PLACED_FEATURE);
        BiomeModifications.addFeature(BiomeSelectors.foundInOverworld(), GenerationStep.Feature.UNDERGROUND_ORES,
                RegistryKey.of(Registry.PLACED_FEATURE_KEY,
                        new Identifier("mlemstuff", "jade_ore_block")));

        BlockRenderLayerMap.INSTANCE.putBlocks(RenderLayer.getCutout(), AltheaeCrop);
        BlockRenderLayerMap.INSTANCE.putBlocks(RenderLayer.getCutout(), AltheaePot);
        BlockRenderLayerMap.INSTANCE.putBlocks(RenderLayer.getCutout(), AltheaeFlower);
        BlockRenderLayerMap.INSTANCE.putBlocks(RenderLayer.getCutout(), PotShelf);
        BlockRenderLayerMap.INSTANCE.putBlocks(RenderLayer.getCutout(), CurtainsWhite);

        Registry.register(Registry.ITEM, new Identifier("mlemstuff", "jade_pickaxe"), new PickaxeBase(new ToolMaterialJade()));
        Registry.register(Registry.ITEM, new Identifier("mlemstuff", "jade_axe"), new AxeBase(new ToolMaterialJade()));
        Registry.register(Registry.ITEM, new Identifier("mlemstuff", "jade_shovel"), new ShovelBase(new ToolMaterialJade()));
        Registry.register(Registry.ITEM, new Identifier("mlemstuff", "jade_hoe"), new HoeBase(new ToolMaterialJade()));
        Registry.register(Registry.ITEM, new Identifier("mlemstuff", "jade_glaive"), new SwordBase(new ToolMaterialJade()));

        Registry.register(Registry.ITEM, new Identifier("mlemstuff", "blood_sword"), new SwordBase(new ToolMaterialBlood()));

        Registry.register(Registry.ITEM, new Identifier("mlemstuff", "nacho_hat"), new BaseArmor(Hats, EquipmentSlot.HEAD));




        LootTableLoadingCallback.EVENT.register((resourceManager, lootManager, id, table, setter) -> {
            if (GRASS_LOOT_TABLE_ID.equals(id)) {
                FabricLootPoolBuilder poolBuilder = FabricLootPoolBuilder.builder()
                        .rolls(UniformLootNumberProvider.create(-0,1))
                        .with(ItemEntry.builder(MlemStuff.AltheaeSeeds));

                table.pool(poolBuilder);
            }
        });
    }


}

