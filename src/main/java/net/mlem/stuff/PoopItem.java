package net.mlem.stuff;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;

//modifies the class
public class PoopItem extends Item {
    public PoopItem(Settings settings) {
        super(settings);
    }


    //makes the item have a noise when right clicked
    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity playerEntity, Hand hand) {
        playerEntity.playSound(SoundEvents.BLOCK_HONEY_BLOCK_PLACE, 1.0F, 4.0F);
        return TypedActionResult.success(playerEntity.getStackInHand(hand));
    }
}
