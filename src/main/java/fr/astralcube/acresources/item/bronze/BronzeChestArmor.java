package fr.astralcube.acresources.item.bronze;

import java.util.Map;
import java.util.Set;
import java.util.UUID;
import java.util.Map.Entry;
import java.util.function.Supplier;

import com.github.clevernucleus.dataattributes.api.DataAttributesAPI;
import com.github.clevernucleus.playerex.PlayerEx;
import com.github.clevernucleus.playerex.api.PlayerData;
import com.github.clevernucleus.playerex.client.PlayerExClient;
import com.google.common.collect.Multimap;

import dev.emi.trinkets.api.SlotReference;
import dev.emi.trinkets.api.Trinket;
import dev.emi.trinkets.mixin.PlayerInventoryMixin;
import fr.astralcube.acresources.ACResourcesMod;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.attribute.EntityAttribute;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.attribute.EntityAttributeModifier.Operation;
import net.minecraft.entity.player.PlayerAbilities;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.item.ItemStack;
import net.minecraft.server.ServerMetadata.Players;
import net.minecraft.util.Identifier;

public class BronzeChestArmor extends ArmorItem implements Trinket {
    public BronzeChestArmor(ArmorMaterial material, EquipmentSlot slot, Settings settings) {
        super(material, slot, settings);
    }

    @Override
    public void onEquip(ItemStack stack, SlotReference slot, LivingEntity entity) {
        // TODO Auto-generated method stub
        Trinket.super.onEquip(stack, slot, entity);
    }

    @Override
    public Multimap<EntityAttribute, EntityAttributeModifier> getAttributeModifiers(EquipmentSlot slot) {
        // TODO Auto-generated method stub
        var modifiers = super.getAttributeModifiers(slot);
        System.out.println(modifiers);
        for (Map.Entry<Identifier, UUID> entry : PlayerEx.MANAGER.modifiers.entrySet()) {
            Supplier<EntityAttribute> t = DataAttributesAPI.getAttribute(entry.getKey());
            System.out.println(t);
        }
        return modifiers;
    }
    @Override
    public void tick(ItemStack stack, SlotReference slot, LivingEntity entity) {
        // TODO Auto-generated method stub
        Trinket.super.tick(stack, slot, entity);
    }
    @Override
    public Multimap<EntityAttribute, EntityAttributeModifier> getModifiers(ItemStack stack, SlotReference slot,
            LivingEntity entity, UUID uuid) {
        // TODO Auto-generated method stub
        var modifiers = Trinket.super.getModifiers(stack, slot, entity, uuid);
        return modifiers;
    }
}
