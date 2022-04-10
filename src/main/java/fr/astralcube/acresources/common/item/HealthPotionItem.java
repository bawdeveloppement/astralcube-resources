package fr.astralcube.acresources.common.item;

import java.util.Random;

import dev.emi.trinkets.api.Trinket;
import dev.emi.trinkets.api.TrinketItem;
import fr.astralcube.acresources.ACResourcesMod;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.StackReference;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.item.PotionItem;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.potion.Potions;
import net.minecraft.screen.slot.Slot;
import net.minecraft.sound.SoundCategory;
import net.minecraft.util.ClickType;
import net.minecraft.world.World;

public class HealthPotionItem extends PotionItem implements Trinket {
    private final float amount;
    
    public HealthPotionItem(final float amount) {
        super((new Item.Settings()).maxCount(1).group(ItemGroup.BREWING));
        //TODO Auto-generated constructor stub
        this.amount = amount;
    }
    
	@Override
	public void inventoryTick(ItemStack itemStack, World world, Entity entity, int slot, boolean selected) {
		// if(entity == null || !(entity instanceof LivingEntity)) return;
		
		// final LivingEntity livingEntity = (LivingEntity)entity;
		// final Random random = new Random();
		
		// if(world.isClient) {
		// 	world.playSound(livingEntity.getX(), livingEntity.getY(), livingEntity.getZ(), ACResourcesMod.POTION_USE_EVENT, SoundCategory.NEUTRAL, 0.75F, 1.0F, true);
			
		// 	for(int i = 0; i < 6; i++) {
		// 		double d = random.nextGaussian() * 0.02D;
		// 		double e = random.nextGaussian() * 0.02D;
		// 		double f = random.nextGaussian() * 0.02D;
				
		// 		world.addParticle(ParticleTypes.HEART, livingEntity.getParticleX(1.0D), livingEntity.getRandomBodyY() + 0.5D, livingEntity.getParticleZ(1.0D), d, e, f);
		// 	}
		// } else {
		// 	livingEntity.heal(this.amount);
		// 	itemStack.decrement(1);
		// }

	}

	

	@Override
	public boolean onClicked(ItemStack stack, ItemStack otherStack, Slot slot, ClickType clickType, PlayerEntity player,
			StackReference cursorStackReference) {
		// TODO Auto-generated method stub
		
		final LivingEntity livingEntity = (LivingEntity)player;
		final Random random = new Random();

		if (clickType == ClickType.RIGHT) {
			if (player.getWorld().isClient()) {
				player.getWorld().playSound(livingEntity.getX(), livingEntity.getY(), livingEntity.getZ(), ACResourcesMod.POTION_USE_EVENT, SoundCategory.NEUTRAL, 0.75F, 1.0F, true);
				
				for(int i = 0; i < 6; i++) {
					double d = random.nextGaussian() * 0.02D;
					double e = random.nextGaussian() * 0.02D;
					double f = random.nextGaussian() * 0.02D;
					
					player.getWorld().addParticle(ParticleTypes.HEART, livingEntity.getParticleX(1.0D), livingEntity.getRandomBodyY() + 0.5D, livingEntity.getParticleZ(1.0D), d, e, f);
				}
			} else {
				livingEntity.heal(this.amount);
				stack.decrement(1);
			}
		}
		return super.onClicked(stack, otherStack, slot, clickType, player, cursorStackReference);
	}
}
