package fr.astralcube.acresources.common.block;

import fr.astralcube.acresources.ACResourcesMod;
import fr.astralcube.acresources.common.item.ACItems;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.MapColor;
import net.minecraft.block.Material;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.item.BlockItem;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ACBlocks {

    public static final Block EXAMPLE_BLOCK = new Block(FabricBlockSettings.of(Material.METAL).strength(4.0f));

    public static final <T extends Block> T registerBlock (String blockName, T block) {
        Registry.register(Registry.ITEM, new Identifier(ACResourcesMod.MOD_ID, blockName), new BlockItem(block, new FabricItemSettings().group(ACItems.JEWELS_GROUP)));
        return Registry.register(Registry.BLOCK, new Identifier(ACResourcesMod.MOD_ID, blockName), block);
    }

    
    public static final BlockJumpPad JUMP_PAD_BLOCK = new BlockJumpPad(FabricBlockSettings.of(Material.SPONGE).strength(4.0f));
    public static final ChargeableBlock CHARGEABLE_BLOCK = new ChargeableBlock(FabricBlockSettings.of(Material.SPONGE).strength(4.0f));
    public static final TopazOreBlock TOPAZ_ORE_BLOCK = new TopazOreBlock();
    public static final DeepslateTopazOreBlock DEEPSLATE_TOPAZ_ORE_BLOCK = new DeepslateTopazOreBlock();
    public static final TopazBlock TOPAZ_BLOCK = new TopazBlock();
    
    public static BlockEntityType<ChargeableBlockEntity> CHARGEABLE_BLOCK_ENTITY;
    public static void init () {
        registerBlock("jump_pad_block", JUMP_PAD_BLOCK);
        registerBlock("chargeable_block", CHARGEABLE_BLOCK);
        registerBlock("topaz_ore", TOPAZ_ORE_BLOCK);
        registerBlock("deepslate_topaz_ore", DEEPSLATE_TOPAZ_ORE_BLOCK);
        registerBlock("topaz_block", TOPAZ_BLOCK);
        
        CHARGEABLE_BLOCK_ENTITY = Registry.register(Registry.BLOCK_ENTITY_TYPE, "acresources:chargeable_block_entity", FabricBlockEntityTypeBuilder.create(ChargeableBlockEntity::new, CHARGEABLE_BLOCK).build(null));
        // Registry.register(Registry.BLOCK, new Identifier("acresources", "example_block"), EXAMPLE_BLOCK);
    }
}
