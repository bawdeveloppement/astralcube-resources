package fr.astralcube.acresources.common.item.bronze;


import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.ArmorMaterial;

public class BronzeChestArmor extends ArmorItem {

    
    public LivingEntity player;

    public BronzeChestArmor(ArmorMaterial material, EquipmentSlot slot, Settings settings) {
        super(material, slot, settings);
    }
}
