package fr.astralcube.acresources.common.item;

import java.util.Arrays;

import org.apache.http.config.RegistryBuilder;

import fr.astralcube.acresources.ACResourcesMod;
import fr.astralcube.acresources.common.item.bronze.BronzeChestArmor;
import fr.astralcube.acresources.common.item.bronze.BronzeIngot;
import fr.astralcube.acresources.common.item.bronze.BronzeRing;
import fr.astralcube.acresources.common.item.bronze.BronzeSword;
import fr.astralcube.acresources.common.item.necklace.DexterityNecklace;
import fr.astralcube.acresources.common.item.necklace.DexterityNugget;
import fr.astralcube.acresources.common.item.necklace.FourAccessoryDexterityNecklace;
import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.block.Blocks;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.ArmorMaterials;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.item.PotionItem;
import net.minecraft.potion.Potion;
import net.minecraft.potion.Potions;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public final class ACItems {

    public static final <T extends Item> T registerItem  (String itemName, T item) {
        return Registry.register(Registry.ITEM, new Identifier(ACResourcesMod.MOD_ID, itemName), item);
    }

	public static final ItemGroup JEWELS_GROUP = FabricItemGroupBuilder.build(
		new Identifier(ACResourcesMod.MOD_ID, "jewels"),
		() -> new ItemStack(Blocks.COBBLESTONE));

    public static Item FOUR_ACCESSORY_DEXTERITY_NECKLACE;
    
    public static void init () {
        registerItem("dexterity_necklace", new DexterityNecklace(new FabricItemSettings().group(JEWELS_GROUP).maxCount(1)));
        registerItem("bronze_sword", new BronzeChestArmor(ArmorMaterials.DIAMOND, EquipmentSlot.CHEST, new FabricItemSettings().group(JEWELS_GROUP)));
        FOUR_ACCESSORY_DEXTERITY_NECKLACE = registerItem("four_accessory_dexterity_necklace", new FourAccessoryDexterityNecklace(new FabricItemSettings().group(JEWELS_GROUP).maxCount(1)));
        registerItem("dexterity_nugget", new DexterityNugget(new FabricItemSettings().group(JEWELS_GROUP).maxCount(1)));

        registerItem("small_health_potion", new HealthPotionItem(4.0F));
        registerItem("medium_health_potion", new HealthPotionItem(6.0F));
        registerItem("large_health_potion", new HealthPotionItem(8.0F));
    }
}



