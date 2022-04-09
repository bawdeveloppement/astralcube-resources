package fr.astralcube.acresources.common.item.bronze;

import fr.astralcube.acresources.common.item.TierableSwordItem;
import net.minecraft.item.ToolMaterial;

public class BronzeSword extends TierableSwordItem {
    public BronzeSword(ToolMaterial toolMaterial, int attackDamage, float attackSpeed, float dexterity, Settings settings) {
        super(toolMaterial, attackDamage, attackSpeed, dexterity, settings);
    }
}
