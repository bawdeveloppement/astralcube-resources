package fr.astralcube.acresources.common.item;

import java.util.List;
import java.util.Random;
import java.util.function.Supplier;

import com.github.clevernucleus.playerex.PlayerEx;
import com.github.clevernucleus.playerex.api.ExAPI;
import com.github.clevernucleus.playerex.api.PlayerData;

import fr.astralcube.acresources.ACResourcesMod;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.attribute.EntityAttribute;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SwordItem;
import net.minecraft.item.ToolItem;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.sound.SoundCategory;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableText;
import net.minecraft.util.Formatting;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;

public class StatPotionItem extends Item {

    private final Supplier<EntityAttribute> targetAttribute; 
    private final double attributeValue;
	private final String attributeName;

    public StatPotionItem(Supplier<EntityAttribute> eAttribute, double amount, String atName) {
        super((new Item.Settings()).maxCount(1).group(ACItems.JEWELS_GROUP));
        this.targetAttribute = eAttribute;
        this.attributeValue = amount;
		this.attributeName = atName;
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
					
					world.addParticle(ParticleTypes.ENCHANT, livingEntity.getParticleX(1.0D), livingEntity.getRandomBodyY() + 0.5D, livingEntity.getParticleZ(1.0D), d, e, f);
				}
			} else {
                PlayerData pData = ExAPI.INSTANCE.get((ServerPlayerEntity) user);
				EntityAttribute et = this.targetAttribute.get();
				System.out.println(et.getTranslationKey());
				System.out.println(this.targetAttribute.toString());
                pData.add(et, this.attributeValue);
				itemStack.decrement(1);
			}
			return TypedActionResult.success(itemStack);
		}
		return TypedActionResult.fail(itemStack);
    }
    

	@Override
	public void appendTooltip(ItemStack stack, World world, List<Text> tooltip, TooltipContext context) {
		// TODO Auto-generated method stub
		tooltip.add(new TranslatableText("blank"));
		tooltip.add(new TranslatableText("item.acresources.when_its_dunk"));
		tooltip.add(new TranslatableText("item.acresources.stat_x_of_x", Double.toString(this.attributeValue), new TranslatableText("playerex.attribute.name."+this.attributeName)).formatted(Formatting.BLUE));
	}
}
