package fr.astralcube.acresources.item;

import fr.astralcube.acresources.ACResourcesMod;
import fr.astralcube.acresources.item.bronze.BronzeChestArmor;
import fr.astralcube.acresources.item.bronze.BronzeIngot;
import fr.astralcube.acresources.item.bronze.BronzeSword;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.block.Blocks;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public final class ACItems {

    public ACItems () {}

    public static final <T extends Item> T registerItem  (String itemName, T item) {
        return Registry.register(Registry.ITEM, new Identifier(ACResourcesMod.MOD_ID, itemName), item);
    }

	public static final ItemGroup ITEM_GROUP = FabricItemGroupBuilder.build(
		new Identifier(ACResourcesMod.MOD_ID, "items"),
		() -> new ItemStack(Blocks.COBBLESTONE));

    // Bronze Items
    public static final Item BRONZE_INGOT = registerItem("bronze_ingot", new BronzeIngot(new FabricItemSettings().group(ItemGroup.MATERIALS)));
    public static final Item BRONZE_CHEST_ARMOR = registerItem("bronze_chest_sword", new BronzeChestArmor(ACArmorMaterials.BRONZE, EquipmentSlot.CHEST, new FabricItemSettings().group(ItemGroup.COMBAT)));
}
