package fr.astralcube.acresources.common.item.belt;

import java.util.UUID;

import com.github.clevernucleus.playerex.api.ExAPI;
import com.google.common.collect.Multimap;

import dev.emi.trinkets.api.SlotAttributes;
import dev.emi.trinkets.api.SlotReference;
import dev.emi.trinkets.api.TrinketItem;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.attribute.EntityAttribute;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.attribute.EntityAttributeModifier.Operation;
import net.minecraft.item.ItemStack;

public class TwoAccessoryBelt extends TrinketItem {

    public TwoAccessoryBelt(Settings settings) {
        super(settings);
        //TODO Auto-generated constructor stub
    }
    

    @Override
    public Multimap<EntityAttribute, EntityAttributeModifier> getModifiers(ItemStack stack, SlotReference slot,
            LivingEntity entity, UUID uuid) {
        Multimap<EntityAttribute, EntityAttributeModifier> modifiers = super.getModifiers(stack, slot, entity, uuid);
        EntityAttributeModifier speedModifier = new EntityAttributeModifier(uuid, "acressources:movement_speed",
                -0.1, EntityAttributeModifier.Operation.MULTIPLY_TOTAL);
        EntityAttributeModifier dexterityModifier = new EntityAttributeModifier(uuid, "acressources", 5, Operation.ADDITION);
        modifiers.put(EntityAttributes.GENERIC_MOVEMENT_SPEED, speedModifier);
        modifiers.put(ExAPI.FREEZE_RESISTANCE.get(), dexterityModifier);
        SlotAttributes.addSlotModifier(modifiers, "legs/belt", uuid, 2, EntityAttributeModifier.Operation.ADDITION);
        return modifiers;
    }
}
