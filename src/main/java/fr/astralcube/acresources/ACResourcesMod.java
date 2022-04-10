package fr.astralcube.acresources;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.GlowLichenBlock;
import net.minecraft.block.OreBlock;
import net.minecraft.block.entity.FurnaceBlockEntity;
import net.minecraft.client.gui.screen.ingame.FurnaceScreen;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.item.ToolMaterials;
import net.minecraft.recipe.Recipe;
import net.minecraft.recipe.SmeltingRecipe;
import net.minecraft.screen.FurnaceScreenHandler;
import net.minecraft.screen.slot.FurnaceOutputSlot;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.BuiltinRegistries;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.RegistryKey;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.YOffset;
import net.minecraft.world.gen.decorator.BiomePlacementModifier;
import net.minecraft.world.gen.decorator.CountPlacementModifier;
import net.minecraft.world.gen.decorator.HeightRangePlacementModifier;
import net.minecraft.world.gen.decorator.PlacementModifier;
import net.minecraft.world.gen.decorator.SquarePlacementModifier;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.ConfiguredFeatures;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.FeatureConfig;
import net.minecraft.world.gen.feature.OreConfiguredFeatures;
import net.minecraft.world.gen.feature.OreFeatureConfig;
import net.minecraft.world.gen.feature.OrePlacedFeatures;
import net.minecraft.world.gen.feature.PlacedFeature;
import net.minecraft.world.gen.feature.PlacedFeatures;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import fr.astralcube.acresources.common.block.ACBlocks;
import fr.astralcube.acresources.common.item.ACItems;

public class ACResourcesMod implements ModInitializer {
	// This logger is used to write text to the console and the log file.
	// It is considered best practice to use your mod id as the logger's name.
	// That way, it's clear which mod wrote info, warnings, and errors.
	public static final String MOD_ID = "acresources";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	public static final SoundEvent POTION_USE_EVENT = new SoundEvent(new Identifier(MOD_ID, "potion_use"));

    public static final <T extends Block> T registerBlock  (String itemName, T item) {
        return Registry.register(Registry.BLOCK, new Identifier(MOD_ID, itemName), item);
    }

    public static <FC extends FeatureConfig> ConfiguredFeature<FC, ?> registerConfiguredFeature(String id, ConfiguredFeature<FC, ?> configuredFeature) {
        return Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, new Identifier(MOD_ID, id), configuredFeature);
	}
	
    private static List<PlacementModifier> modifiers(PlacementModifier countModifier, PlacementModifier heightModifier) {
        return List.of(countModifier, SquarePlacementModifier.of(), heightModifier, BiomePlacementModifier.of());
    }

    private static List<PlacementModifier> modifiersWithCount(int count, PlacementModifier heightModifier) {
        return modifiers(CountPlacementModifier.of(count), heightModifier);
    }

    public static PlacedFeature registerPlacedFeature(String id, PlacedFeature feature) {
        return Registry.register(BuiltinRegistries.PLACED_FEATURE, new Identifier(MOD_ID, id), feature);
    }

    public static final List<OreFeatureConfig.Target> TOPAZ_ORES = List.of(OreFeatureConfig.createTarget(OreConfiguredFeatures.STONE_ORE_REPLACEABLES, ACBlocks.TOPAZ_ORE_BLOCK.getDefaultState()), OreFeatureConfig.createTarget(OreConfiguredFeatures.DEEPSLATE_ORE_REPLACEABLES, ACBlocks.TOPAZ_ORE_BLOCK.getDefaultState()));
    public static final ConfiguredFeature<?, ?> ORE_TOPAZ = registerConfiguredFeature("ore_topaz", Feature.ORE.configure(new OreFeatureConfig(TOPAZ_ORES, 9)));
    public static final PlacedFeature ORE_TOPAZ_UPPER = registerPlacedFeature("ore_topaz_upper", ORE_TOPAZ.withPlacement(modifiersWithCount(90, HeightRangePlacementModifier.trapezoid(YOffset.fixed(80), YOffset.fixed(384)))));
    public static final PlacedFeature ORE_TOPAZ_MIDDLE = registerPlacedFeature("ore_topaz_middle", ORE_TOPAZ.withPlacement(modifiersWithCount(10, HeightRangePlacementModifier.trapezoid(YOffset.fixed(-24), YOffset.fixed(56)))));
    public static final PlacedFeature ORE_TOPAZ_SMALL = registerPlacedFeature("ore_topaz_small", ORE_TOPAZ.withPlacement(modifiersWithCount(10, HeightRangePlacementModifier.uniform(YOffset.getBottom(), YOffset.fixed(72)))));
    
	@Override
	public void onInitialize() {
		// ACItems.registerItems();
		ACBlocks.init();
		ACItems.init();
		BiomeModifications.addFeature(BiomeSelectors.all(), GenerationStep.Feature.UNDERGROUND_ORES, BuiltinRegistries.PLACED_FEATURE.getKey(ORE_TOPAZ_UPPER).orElseThrow());
		BiomeModifications.addFeature(BiomeSelectors.all(), GenerationStep.Feature.UNDERGROUND_ORES, BuiltinRegistries.PLACED_FEATURE.getKey(ORE_TOPAZ_MIDDLE).orElseThrow());
		BiomeModifications.addFeature(BiomeSelectors.all(), GenerationStep.Feature.UNDERGROUND_ORES, BuiltinRegistries.PLACED_FEATURE.getKey(ORE_TOPAZ_SMALL).orElseThrow());
		LOGGER.info("Hello Fabric world!");
	}
}
