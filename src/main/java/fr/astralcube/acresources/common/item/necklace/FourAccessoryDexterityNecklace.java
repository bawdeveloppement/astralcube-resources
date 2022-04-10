package fr.astralcube.acresources.common.item.necklace;

import java.util.UUID;

import com.github.clevernucleus.playerex.api.ExAPI;
import com.google.common.collect.Multimap;

import dev.emi.trinkets.api.SlotAttributes;
import dev.emi.trinkets.api.SlotReference;
import dev.emi.trinkets.api.TrinketItem;
import dev.emi.trinkets.api.client.TrinketRenderer;
import fr.astralcube.acresources.ACResourcesMod;
import fr.astralcube.acresources.client.FourAccessoryDexterityModel;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.render.OverlayTexture;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.model.BipedEntityModel;
import net.minecraft.client.render.entity.model.EntityModel;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.attribute.EntityAttribute;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.attribute.EntityAttributeModifier.Operation;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;

public class FourAccessoryDexterityNecklace extends TrinketItem implements TrinketRenderer  {
	private static final Identifier TEXTURE = new Identifier(ACResourcesMod.MOD_ID, "textures/entity/trinket/hat.png");
	private BipedEntityModel<LivingEntity> model;


    public FourAccessoryDexterityNecklace(Settings settings) {
        super(settings);
        //TODO Auto-generated constructor stub
    }
    

    @Override
    public Multimap<EntityAttribute, EntityAttributeModifier> getModifiers(ItemStack stack, SlotReference slot,
            LivingEntity entity, UUID uuid) {
        Multimap<EntityAttribute, EntityAttributeModifier> modifiers = super.getModifiers(stack, slot, entity, uuid);
        EntityAttributeModifier dexterityModifier = new EntityAttributeModifier(uuid, "acressources:dexterity_modifier", 10, Operation.ADDITION);
        modifiers.put(ExAPI.DEXTERITY.get(), dexterityModifier);
        SlotAttributes.addSlotModifier(modifiers, "chest/necklace", uuid, 4, EntityAttributeModifier.Operation.ADDITION);
        return modifiers;
    }
	@Override
	@Environment(EnvType.CLIENT)
	public void render(ItemStack stack, SlotReference slotReference, EntityModel<? extends LivingEntity> contextModel, MatrixStack matrices, VertexConsumerProvider vertexConsumers, int light, LivingEntity entity, float limbAngle, float limbDistance, float tickDelta, float animationProgress, float headYaw, float headPitch) {
		BipedEntityModel<LivingEntity> model = this.getModel();
		model.setAngles(entity, limbAngle, limbDistance, animationProgress, animationProgress, headPitch);
		model.animateModel(entity, limbAngle, limbDistance, tickDelta);
		TrinketRenderer.followBodyRotations(entity, model);
		VertexConsumer vertexConsumer = vertexConsumers.getBuffer(model.getLayer(TEXTURE));
		model.render(matrices, vertexConsumer, light, OverlayTexture.DEFAULT_UV, 1, 1, 1, 1);
	}

	@Environment(EnvType.CLIENT)
	private BipedEntityModel<LivingEntity> getModel() {
		if (this.model == null) {
			// Vanilla 1.17 uses EntityModels, EntityModelLoader and EntityModelLayers
			this.model = new FourAccessoryDexterityModel(FourAccessoryDexterityModel.getTexturedModelData().createModel());
		}

		return this.model;
	}
}
