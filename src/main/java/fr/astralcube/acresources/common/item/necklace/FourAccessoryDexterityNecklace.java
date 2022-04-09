package fr.astralcube.acresources.common.item.necklace;

import java.util.UUID;

import com.github.clevernucleus.playerex.api.ExAPI;
import com.google.common.collect.Multimap;

import dev.emi.trinkets.api.SlotAttributes;
import dev.emi.trinkets.api.SlotReference;
import dev.emi.trinkets.api.TrinketItem;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.attribute.EntityAttribute;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.attribute.EntityAttributeModifier.Operation;
import net.minecraft.item.ItemStack;

public class FourAccessoryDexterityNecklace extends TrinketItem {

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
}
