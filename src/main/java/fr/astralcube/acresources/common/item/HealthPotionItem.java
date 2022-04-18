package fr.astralcube.acresources.common.item;

import java.util.Random;

import fr.astralcube.acresources.ACResourcesMod;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.sound.SoundCategory;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;

public class HealthPotionItem extends Item {
    private final float amount;
    
    public HealthPotionItem(final float amount) {
        super((new Item.Settings()).maxCount(1).group(ItemGroup.BREWING));
        //TODO Auto-generated constructor stub
        this.amount = amount;
    }

	@Override
	public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
		// TODO Auto-generated method stub
		ItemStack itemStack = user.getStackInHand(hand);
		if(user == null || !(user instanceof LivingEntity)) return TypedActionResult.fail(itemStack);

		if (hand.compareTo(Hand.MAIN_HAND) == 0) {
		
			final LivingEntity livingEntity = (LivingEntity)user;
			final Random random = new Random();
			
			if(world.isClient) {
				world.playSound(livingEntity.getX(), livingEntity.getY(), livingEntity.getZ(), ACResourcesMod.POTION_USE_EVENT, SoundCategory.NEUTRAL, 0.75F, 1.0F, true);
				
				for(int i = 0; i < 6; i++) {
					double d = random.nextGaussian() * 0.02D;
					double e = random.nextGaussian() * 0.02D;
					double f = random.nextGaussian() * 0.02D;
					
					world.addParticle(ParticleTypes.HEART, livingEntity.getParticleX(1.0D), livingEntity.getRandomBodyY() + 0.5D, livingEntity.getParticleZ(1.0D), d, e, f);
				}
			} else {
				livingEntity.heal(this.amount);
				itemStack.decrement(1);
			}
			return TypedActionResult.success(itemStack);
		}
		return TypedActionResult.fail(itemStack);
	}
}
