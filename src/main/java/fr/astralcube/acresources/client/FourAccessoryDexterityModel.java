package fr.astralcube.acresources.client;

import net.minecraft.client.model.Dilation;
import net.minecraft.client.model.ModelData;
import net.minecraft.client.model.ModelPart;
import net.minecraft.client.model.ModelPartBuilder;
import net.minecraft.client.model.ModelPartData;
import net.minecraft.client.model.ModelTransform;
import net.minecraft.client.model.TexturedModelData;
import net.minecraft.client.render.entity.model.BipedEntityModel;
import net.minecraft.entity.LivingEntity;

public class FourAccessoryDexterityModel extends BipedEntityModel<LivingEntity> {
    
    public FourAccessoryDexterityModel(ModelPart root) {
        super(root);
        this.setVisible(false);
		this.body.visible = true;
    }
    
	public static TexturedModelData getTexturedModelData() {
		ModelData modelData = BipedEntityModel.getModelData(Dilation.NONE, 0f);
		ModelPartData modelPartData = modelData.getRoot();
		ModelPartData body = modelPartData.addChild("body", ModelPartBuilder.create().uv(0, 16).cuboid(3f, -1f, -3f, 1f, 1f, 6f), ModelTransform.NONE);
		body.addChild("body2", ModelPartBuilder.create().uv(0, 16).cuboid(-4f, -1f, -3f, 1f, 1f, 6f), ModelTransform.NONE);
		body.addChild("body3", ModelPartBuilder.create().uv(0, 16).cuboid(-3f, -1f, 2f, 6f, 1f, 1f), ModelTransform.NONE);
		body.addChild("body4", ModelPartBuilder.create().uv(0, 16).cuboid(-3f, 0f, -3f, 1f, 1f, 1f), ModelTransform.NONE);
		body.addChild("body5", ModelPartBuilder.create().uv(0, 16).cuboid(-2f, 1f, -3f, 1f, 1f, 1f), ModelTransform.NONE);
		body.addChild("body6", ModelPartBuilder.create().uv(0, 16).cuboid(-1f, 2f, -3f, 1f, 1f, 1f), ModelTransform.NONE);
		body.addChild("body7", ModelPartBuilder.create().uv(0, 16).cuboid(0f, 2f, -3f, 1f, 1f, 1f), ModelTransform.NONE);
		body.addChild("body8", ModelPartBuilder.create().uv(0, 16).cuboid(1f, 1f, -3f, 1f, 1f, 1f), ModelTransform.NONE);
		body.addChild("body9", ModelPartBuilder.create().uv(0, 16).cuboid(2f, 0f, -3f, 1f, 1f, 1f), ModelTransform.NONE);
		body.addChild("body10", ModelPartBuilder.create().uv(0, 16).cuboid(3f, -1f, -3f, 1f, 1f, 1f), ModelTransform.NONE);
		body.addChild("body11", ModelPartBuilder.create().uv(0, 16).cuboid(-2f, 3f, -3f, 4f, 2f, 1f), ModelTransform.NONE);
		body.addChild("body12", ModelPartBuilder.create().uv(0, 16).cuboid(-1f, 5f, -3f, 2f, 1f, 1f), ModelTransform.NONE);
		return TexturedModelData.of(modelData, 64, 64);
	}
    
}
