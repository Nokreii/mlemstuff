package net.mlem.stuff;

import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.Inventories;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.screen.NamedScreenHandlerFactory;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.text.LiteralText;
import net.minecraft.text.Text;
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;
import java.util.Random;

public class LightningChannelerBlockEntity extends BlockEntity implements NamedScreenHandlerFactory, ImplementedInventory {
    private final DefaultedList<ItemStack> inventory =
            DefaultedList.ofSize(3, ItemStack.EMPTY);

    public LightningChannelerBlockEntity(BlockPos pos, BlockState state) {
        super(ModBlockEntities.LIGHTNING_CHANNELER_BLOCK_ENTITY, pos, state);
    }

    @Override
    public Text getDisplayName() {
        return new LiteralText("Lightning Channeler");
    }

    @Nullable
    @Override
    public ScreenHandler createMenu(int syncId, PlayerInventory inv, PlayerEntity player) {
        return new LightningChannelerScreenHandler(syncId, inv, this);
    }

    @Override
    public DefaultedList<ItemStack> getItems() {
        return inventory;
    }

    @Override
    public void readNbt(NbtCompound nbt) {
        super.readNbt(nbt);
        Inventories.readNbt(nbt, inventory);
    }

    @Override
    public void writeNbt(NbtCompound nbt) {
        Inventories.writeNbt(nbt, inventory);
        super.writeNbt(nbt);
    }

    public static void tick(World world, BlockPos pos, BlockState state, LightningChannelerBlockEntity entity) {
        if(hasRecipe(entity) && world.isReceivingRedstonePower(pos) && hasNotReachedStackLimit(entity)) {
            craftItem(entity);

            if(!world.isClient()) {
                EntityType.LIGHTNING_BOLT.spawn((ServerWorld) world, null, null, null, pos,
                        SpawnReason.TRIGGERED, true, true);
            }
        }

        if(hasRecipeChargedSword(entity) && world.isReceivingRedstonePower(pos) && hasNotReachedStackLimit(entity)) {
            craftItemChargedSword(entity);

            if(!world.isClient()) {
                EntityType.LIGHTNING_BOLT.spawn((ServerWorld) world, null, null, null, pos,
                        SpawnReason.TRIGGERED, true, true);
            }
        }

        if(hasRecipeChargedSword(entity) && world.isReceivingRedstonePower(pos) && hasNotReachedStackLimit(entity)) {
            repairChargedSword(entity);

            if(!world.isClient()) {
                EntityType.LIGHTNING_BOLT.spawn((ServerWorld) world, null, null, null, pos,
                        SpawnReason.TRIGGERED, true, true);
            }
        }

        if(hasRecipeOreRandom(entity) && world.isReceivingRedstonePower(pos) && hasNotReachedStackLimit(entity)) {
            craftItemOreRandom(entity);

            if(!world.isClient()) {
                EntityType.LIGHTNING_BOLT.spawn((ServerWorld) world, null, null, null, pos,
                        SpawnReason.TRIGGERED, true, true);
            }
        }

        if(hasRecipeOreFortune(entity) && world.isReceivingRedstonePower(pos) && hasNotReachedStackLimit(entity)) {
            craftItemOreFortune(entity);

            if(!world.isClient()) {
                EntityType.LIGHTNING_BOLT.spawn((ServerWorld) world, null, null, null, pos,
                        SpawnReason.TRIGGERED, true, true);
            }
        }

        if(hasRecipeLuckOre(entity) && world.isReceivingRedstonePower(pos) && hasNotReachedStackLimit(entity)) {
            craftItemLuckOre(entity);

            if(!world.isClient()) {
                EntityType.LIGHTNING_BOLT.spawn((ServerWorld) world, null, null, null, pos,
                        SpawnReason.TRIGGERED, true, true);
            }
        }

        if(world.isThundering() && hasNotReachedStackLimit(entity)) {
            craftCobble(entity);

            if(!world.isClient()) {
                EntityType.LIGHTNING_BOLT.spawn((ServerWorld) world, null, null, null, pos,
                        SpawnReason.TRIGGERED, true, true);
            }
        }
    }

    private static void craftItem(LightningChannelerBlockEntity entity) {
        entity.removeStack(0, 16);
        entity.removeStack(1, 16);

        entity.setStack(2, new ItemStack(MlemStuff.ChargedGem, entity.getStack(2).getCount() + 1));
    }

    private static boolean hasRecipe(LightningChannelerBlockEntity entity) {
        boolean hasItemInFirstSlot = entity.getStack(0).getItem() == Items.COBBLESTONE;
        boolean hasItemInSecondSlot = entity.getStack(1).getItem() == Items.COBBLESTONE;

        return hasItemInFirstSlot && hasItemInSecondSlot;
    }

    private static void craftItemChargedSword(LightningChannelerBlockEntity entity) {
        entity.removeStack(0, 24);
        entity.removeStack(1, 1);

        entity.setStack(2, new ItemStack(MlemStuff.ChargedSword, entity.getStack(2).getCount() + 1));
    }

    /*@Redirect("setDamage")
    private void whatever(ItemStack stack, int i) {
            stack.setDamage(10);
        }
    }*/

    private static boolean hasRecipeChargedSword(LightningChannelerBlockEntity entity) {
        boolean hasItemInFirstSlot = entity.getStack(0).getItem() == MlemStuff.ChargedGem;
        boolean hasItemInSecondSlot = entity.getStack(1).getItem() == Items.NETHERITE_SWORD;

        return hasItemInFirstSlot && hasItemInSecondSlot;
    }

    private static void repairChargedSword(LightningChannelerBlockEntity entity) {
        entity.removeStack(0, 8);
        entity.removeStack(1, 1);

        entity.setStack(2, new ItemStack(MlemStuff.ChargedSword, entity.getStack(2).getCount() + 1));
    }

    /*@Redirect("setDamage")
    private void whatever(ItemStack stack, int i) {
            stack.setDamage(10);
        }
    }*/

    private static boolean hasRecipeRepairChargedSword(LightningChannelerBlockEntity entity) {
        boolean hasItemInFirstSlot = entity.getStack(0).getItem() == MlemStuff.ChargedGem;
        boolean hasItemInSecondSlot = entity.getStack(1).getItem() == MlemStuff.ChargedSword;

        return hasItemInFirstSlot && hasItemInSecondSlot;
    }

    private static void craftItemOreRandom(LightningChannelerBlockEntity entity) {

        Random rn = new Random();
        int answer = rn.nextInt(8) + 1;
        if(answer==1){
            entity.removeStack(0, 8);
            entity.removeStack(1, 64);
            entity.setStack(2, new ItemStack(Items.ANCIENT_DEBRIS, entity.getStack(2).getCount() + 1));
        }

        if(answer==2){
            entity.removeStack(0, 8);
            entity.removeStack(1, 64);
            entity.setStack(2, new ItemStack(Items.DIAMOND_ORE, entity.getStack(2).getCount() + 1));
        }


        if(answer==3){
            entity.removeStack(0, 8);
            entity.removeStack(1, 64);
            entity.setStack(2, new ItemStack(Items.EMERALD_ORE, entity.getStack(2).getCount() + 1));
        }

        if(answer==4){
            entity.removeStack(0, 8);
            entity.removeStack(1, 64);
            entity.setStack(2, new ItemStack(Items.IRON_ORE, entity.getStack(2).getCount() + 1));
        }

        if(answer==5){
            entity.removeStack(0, 8);
            entity.removeStack(1, 64);
            entity.setStack(2, new ItemStack(Items.GOLD_ORE, entity.getStack(2).getCount() + 1));
        }

        if(answer==6){
            entity.removeStack(0, 8);
            entity.removeStack(1, 64);
            entity.setStack(2, new ItemStack(Items.LAPIS_ORE, entity.getStack(2).getCount() + 1));
        }

        if(answer==7){
            entity.removeStack(0, 8);
            entity.removeStack(1, 64);
            entity.setStack(2, new ItemStack(Items.COAL_ORE, entity.getStack(2).getCount() + 1));
        }

        if(answer==8){
            entity.removeStack(0, 8);
            entity.removeStack(1, 64);
            entity.setStack(2, new ItemStack(Items.REDSTONE_ORE, entity.getStack(2).getCount() + 1));
        }
    }


    private static boolean hasRecipeOreRandom(LightningChannelerBlockEntity entity) {
        boolean hasItemInFirstSlot = entity.getStack(0).getItem() == MlemStuff.ChargedGem;
        boolean hasItemInSecondSlot = entity.getStack(1).getItem() == Items.STONE;

        return hasItemInFirstSlot && hasItemInSecondSlot;
    }

    private static boolean hasRecipeOreFortune(LightningChannelerBlockEntity entity) {
        boolean hasItemInFirstSlot = entity.getStack(0).getItem() == MlemStuff.ChargedGem;
        boolean hasItemInSecondSlot = entity.getStack(1).getItem() == MlemStuff.FortuneModule;

        return hasItemInFirstSlot && hasItemInSecondSlot;
    }



    private static void craftItemOreFortune(LightningChannelerBlockEntity entity) {

        Random rn = new Random();
        int answer = rn.nextInt(8) + 1;

        if(answer==1){
            entity.removeStack(0, 10);
            entity.removeStack(1, 0);
            entity.setStack(2, new ItemStack(Items.ANCIENT_DEBRIS, entity.getStack(2).getCount() + 2));
        }

        if(answer==2){
            entity.removeStack(0, 10);
            entity.removeStack(1, 0);
            entity.setStack(2, new ItemStack(Items.DIAMOND_ORE, entity.getStack(2).getCount() + 2));
        }


        if(answer==3){
            entity.removeStack(0, 10);
            entity.removeStack(1, 0);
            entity.setStack(2, new ItemStack(Items.EMERALD_ORE, entity.getStack(2).getCount() + 2));
        }

        if(answer==4){
            entity.removeStack(0, 10);
            entity.removeStack(1, 0);
            entity.setStack(2, new ItemStack(Items.IRON_ORE, entity.getStack(2).getCount() + 3));
        }

        if(answer==5){
            entity.removeStack(0, 10);
            entity.removeStack(1, 0);
            entity.setStack(2, new ItemStack(Items.GOLD_ORE, entity.getStack(2).getCount() + 3));
        }

        if(answer==6){
            entity.removeStack(0, 10);
            entity.removeStack(1, 0);
            entity.setStack(2, new ItemStack(Items.LAPIS_ORE, entity.getStack(2).getCount() + 3));
        }

        if(answer==7){
            entity.removeStack(0, 10);
            entity.removeStack(1, 0);
            entity.setStack(2, new ItemStack(Items.COAL_ORE, entity.getStack(2).getCount() + 3));
        }

        if(answer==8){
            entity.removeStack(0, 10);
            entity.removeStack(1, 0);
            entity.setStack(2, new ItemStack(Items.REDSTONE_ORE, entity.getStack(2).getCount() + 3));
        }
    }

    private static boolean hasRecipeLuckOre(LightningChannelerBlockEntity entity) {
        boolean hasItemInFirstSlot = entity.getStack(0).getItem() == MlemStuff.ChargedGem;
        boolean hasItemInSecondSlot = entity.getStack(1).getItem() == MlemStuff.LuckModule;

        return hasItemInFirstSlot && hasItemInSecondSlot;
    }



    private static void craftItemLuckOre(LightningChannelerBlockEntity entity) {

        Random rn = new Random();
        int answer = rn.nextInt(8) + 1;

        if(answer==1){
            entity.removeStack(0, 8);
            entity.removeStack(1, 0);
            entity.setStack(2, new ItemStack(Items.ANCIENT_DEBRIS, entity.getStack(2).getCount() + 1));
        }

        if(answer==2){
            entity.removeStack(0, 8);
            entity.removeStack(1, 0);
            entity.setStack(2, new ItemStack(Items.DIAMOND_ORE, entity.getStack(2).getCount() + 1));
        }


        if(answer==3){
            entity.removeStack(0, 8);
            entity.removeStack(1, 0);
            entity.setStack(2, new ItemStack(Items.EMERALD_ORE, entity.getStack(2).getCount() + 1));
        }

    }

    private static void craftCobble(LightningChannelerBlockEntity entity) {
        entity.setStack(2, new ItemStack(Items.COBBLESTONE, entity.getStack(2).getCount() + 1));
    }

    private static boolean hasNotReachedStackLimit(LightningChannelerBlockEntity entity) {
        return entity.getStack(2).getCount() < entity.getStack(2).getMaxCount();
    }
}
