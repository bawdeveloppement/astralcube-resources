package fr.astralcube.acresources.common.item;


import com.github.clevernucleus.playerex.api.ExAPI;

import fr.astralcube.acresources.ACResourcesMod;
import fr.astralcube.acresources.common.item.necklace.DexterityGemItem;
import fr.astralcube.acresources.common.item.necklace.DexterityNecklace;
import fr.astralcube.acresources.common.item.necklace.TopazNugget;
import fr.astralcube.acresources.common.item.necklace.FourAccessoryDexterityNecklace;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.*;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public final class ACItems {


    public static Item FOUR_ACCESSORY_DEXTERITY_NECKLACE;
    
    public static void register () {
        registerItem("dexterity_necklace", new DexterityNecklace(new FabricItemSettings().group(JEWELS_GROUP).maxCount(1)));
        FOUR_ACCESSORY_DEXTERITY_NECKLACE = registerItem("four_accessory_dexterity_necklace", new FourAccessoryDexterityNecklace(new FabricItemSettings().group(JEWELS_GROUP).maxCount(1)));
        registerItem("topaz_nugget", new TopazNugget());
        registerItem("topaz_ingot", new TopazIngotItem());
        registerItem("dexterity_gem", new DexterityGemItem(new FabricItemSettings().group(JEWELS_GROUP).maxCount(1)));
        // registerItem("vein_pickaxe", new VeinPickaxe(ToolMaterials.NETHERITE, new FabricItemSettings().group(JEWELS_GROUP).maxCount(1)));

        registerItem("small_constitution_potion", new StatPotionItem(ExAPI.CONSTITUTION, 1 , "constitution"));
        registerItem("medium_constitution_potion", new StatPotionItem(ExAPI.CONSTITUTION, 5, "constitution"));
        registerItem("large_constitution_potion", new StatPotionItem(ExAPI.CONSTITUTION, 10, "constitution"));

        registerItem("small_strength_potion", new StatPotionItem(ExAPI.STRENGTH, 1 , "strength"));
        registerItem("medium_strength_potion", new StatPotionItem(ExAPI.STRENGTH, 5, "strength"));
        registerItem("large_strength_potion", new StatPotionItem(ExAPI.STRENGTH, 10, "strength"));
        
        registerItem("small_dexterity_potion", new StatPotionItem(ExAPI.DEXTERITY, 1 , "dexterity"));
        registerItem("medium_dexterity_potion", new StatPotionItem(ExAPI.DEXTERITY, 5, "dexterity"));
        registerItem("large_dexterity_potion", new StatPotionItem(ExAPI.DEXTERITY, 10, "dexterity"));
        
        registerItem("small_intelligence_potion", new StatPotionItem(ExAPI.INTELLIGENCE, 1 , "intelligence"));
        registerItem("medium_intelligence_potion", new StatPotionItem(ExAPI.INTELLIGENCE, 5, "intelligence"));
        registerItem("large_intelligence_potion", new StatPotionItem(ExAPI.INTELLIGENCE, 10, "intelligence"));
        
        registerItem("small_luckiness_potion", new StatPotionItem(ExAPI.LUCKINESS, 1 , "luckiness"));
        registerItem("medium_luckiness_potion", new StatPotionItem(ExAPI.LUCKINESS, 5, "luckiness"));
        registerItem("large_luckiness_potion", new StatPotionItem(ExAPI.LUCKINESS, 10, "luckiness"));
    }

    public static final <T extends Item> T registerItem  (String itemName, T item) {
        return Registry.register(Registry.ITEM, new Identifier(ACResourcesMod.MOD_ID, itemName), item);
    }

	public static final ItemGroup JEWELS_GROUP = FabricItemGroupBuilder.build(
		new Identifier(ACResourcesMod.MOD_ID, "jewels"),
		() -> new ItemStack(ACItems.FOUR_ACCESSORY_DEXTERITY_NECKLACE));

}



