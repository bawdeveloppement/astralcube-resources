package fr.astralcube.acresources.client;

import fr.astralcube.acresources.ACResourcesMod;
import net.minecraft.client.model.Dilation;
import net.minecraft.client.model.ModelData;
import net.minecraft.client.model.ModelPart;
import net.minecraft.client.model.ModelPartBuilder;
import net.minecraft.client.model.ModelPartData;
import net.minecraft.client.model.ModelTransform;
import net.minecraft.client.model.TexturedModelData;
import net.minecraft.client.render.entity.model.BipedEntityModel;
import net.minecraft.entity.LivingEntity;
import net.minecraft.util.Identifier;

public class FourAccessoryDexterityModel extends BipedEntityModel<LivingEntity> {
    
    public FourAccessoryDexterityModel(ModelPart root) {
        super(root);
        this.setVisible(false);
        this.head.visible = true;
    }
    
	public static TexturedModelData getTexturedModelData() {
		ModelData modelData = BipedEntityModel.getModelData(Dilation.NONE, 0f);
		ModelPartData modelPartData = modelData.getRoot();
		ModelPartData head = modelPartData.addChild("head", ModelPartBuilder.create().uv(0, 0)
				.cuboid(-4f, -16f, -4f, 8f, 8f, 8f), ModelTransform.NONE);
		head.addChild("brim", ModelPartBuilder.create().uv(0, 16)
				.cuboid(-5f, -9f, -5f, 10f, 1f, 10f), ModelTransform.NONE);
		return TexturedModelData.of(modelData, 64, 32);
	}
    
}
