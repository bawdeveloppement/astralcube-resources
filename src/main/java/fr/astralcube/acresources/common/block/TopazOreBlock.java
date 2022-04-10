package fr.astralcube.acresources.common.block;

import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.MapColor;
import net.minecraft.block.Material;

public class TopazOreBlock extends Block {

    public TopazOreBlock() {
        super((FabricBlockSettings.of(Material.STONE, MapColor.GRAY).strength(3.0f, 3.0f).luminance(2)));
    }
}
