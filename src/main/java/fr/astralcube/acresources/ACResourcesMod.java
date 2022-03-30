package fr.astralcube.acresources;

import net.fabricmc.api.ModInitializer;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ToolMaterials;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import fr.astralcube.acresources.item.ACItems;

public class ACResourcesMod implements ModInitializer {
	// This logger is used to write text to the console and the log file.
	// It is considered best practice to use your mod id as the logger's name.
	// That way, it's clear which mod wrote info, warnings, and errors.
	public static final String MOD_ID = "acresources";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

    public static final <T extends Block> T registerBlock  (String itemName, T item) {
        return Registry.register(Registry.BLOCK, new Identifier(MOD_ID, itemName), item);
    }

	@Override
	public void onInitialize() {
		new ACItems();
		LOGGER.info("Hello Fabric world!");
	}
}
