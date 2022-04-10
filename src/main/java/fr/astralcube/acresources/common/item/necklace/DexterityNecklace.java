package fr.astralcube.acresources.common.item.necklace;

import java.util.UUID;

import com.github.clevernucleus.playerex.api.ExAPI;
import com.google.common.collect.ImmutableMultimap;
import com.google.common.collect.Multimap;

import dev.emi.trinkets.api.SlotAttributes;
import dev.emi.trinkets.api.SlotReference;
import dev.emi.trinkets.api.SlotType;
import dev.emi.trinkets.api.TrinketItem;
import dev.emi.trinkets.api.client.TrinketRenderer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.model.BipedEntityModel;
import net.minecraft.client.render.entity.model.EntityModel;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.attribute.EntityAttribute;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.attribute.EntityAttributeModifier.Operation;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.ItemStack;
import net.minecraft.world.gen.feature.OreConfiguredFeatures;

public class DexterityNecklace extends TrinketItem{
	// public class DexterityNecklace extends TrinketItem implements TrinketRenderer{

    private Multimap<EntityAttribute, EntityAttributeModifier> modifiers;

    public DexterityNecklace(Settings settings) {
        super(settings);
        //TODO Auto-generated constructor stub
    }
    
    @Override
    public void onEquip(ItemStack stack, SlotReference slot, LivingEntity entity) {
        // SlotAttributes.addSlotModifier(modifiers, slot, UUID.randomUUID(), 5D, Operation.ADDITION);
    }



	// @Override
	// @Environment(EnvType.CLIENT)
	// public void render(ItemStack stack, SlotReference slotReference, EntityModel<? extends LivingEntity> contextModel, MatrixStack matrices, VertexConsumerProvider vertexConsumers, int light, LivingEntity entity, float limbAngle, float limbDistance, float tickDelta, float animationProgress, float headYaw, float headPitch) {
	// 	BipedEntityModel<LivingEntity> model = this.getModel();
	// 	model.setAngles(entity, limbAngle, limbDistance, animationProgress, animationProgress, headPitch);
	// 	model.animateModel(entity, limbAngle, limbDistance, tickDelta);
	// 	TrinketRenderer.followBodyRotations(entity, model);
	// 	VertexConsumer vertexConsumer = vertexConsumers.getBuffer(model.getLayer(TEXTURE));
	// 	model.render(matrices, vertexConsumer, light, OverlayTexture.DEFAULT_UV, 1, 1, 1, 1);
	// }
	
	@Override
	public Multimap<EntityAttribute, EntityAttributeModifier> getModifiers(ItemStack stack, SlotReference slot, LivingEntity entity, UUID uuid) {
		Multimap<EntityAttribute, EntityAttributeModifier> modifiers = super.getModifiers(stack, slot, entity, uuid);
		EntityAttributeModifier speedModifier = new EntityAttributeModifier(uuid, "acressources:movement_speed", 0.4, EntityAttributeModifier.Operation.MULTIPLY_TOTAL);
        EntityAttributeModifier dexterityModifier = new EntityAttributeModifier(uuid, "acressources", 5, Operation.ADDITION);
		modifiers.put(EntityAttributes.GENERIC_MOVEMENT_SPEED, speedModifier);
		modifiers.put(ExAPI.DEXTERITY.get(), dexterityModifier);
		return modifiers;
	}
}
