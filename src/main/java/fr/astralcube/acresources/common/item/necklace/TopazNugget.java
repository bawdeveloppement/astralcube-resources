package fr.astralcube.acresources.common.item.necklace;

import java.util.UUID;

import com.github.clevernucleus.playerex.api.ExAPI;
import com.google.common.collect.Multimap;

import dev.emi.trinkets.api.SlotReference;
import dev.emi.trinkets.api.TrinketItem;
import fr.astralcube.acresources.common.item.ACItems;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.attribute.EntityAttribute;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.attribute.EntityAttributeModifier.Operation;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class TopazNugget extends Item {

    public TopazNugget() {
        super(new FabricItemSettings().group(ACItems.JEWELS_GROUP));
        //TODO Auto-generated constructor stub
    }
    
    
}
