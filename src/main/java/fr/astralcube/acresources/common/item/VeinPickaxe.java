package fr.astralcube.acresources.common.item;

import fr.astralcube.acresources.common.block.TopazOreBlock;
import net.minecraft.block.Block;
import net.minecraft.datafixer.fix.ChunkPalettedStorageFix;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.item.PickaxeItem;
import net.minecraft.item.ToolItem;
import net.minecraft.item.ToolMaterial;
import net.minecraft.util.ActionResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.World;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class VeinPickaxe extends ToolItem  {
    public VeinPickaxe(ToolMaterial material, Settings settings) {
        super(material, settings);

    }


    @Override
    public ActionResult useOnBlock(ItemUsageContext context) {
        Block targetBlock = context.getWorld().getBlockState(context.getBlockPos()).getBlock();
        ArrayList<BlockPos> veins = getNeighboorBlocks(context.getWorld(), targetBlock, context.getBlockPos());
        veins.forEach(vein -> {
            System.out.println(vein);
            context.getWorld().removeBlock(vein, false);
        });
        return super.useOnBlock(context);
    }

    ArrayList<BlockPos> getNeighboorBlocks (World world, Block targetBlock, BlockPos blockPos ) {
        Block findBlock;
        ArrayList<BlockPos> toReturn = new ArrayList<BlockPos>();
        for (ChunkPalettedStorageFix.Facing face : ChunkPalettedStorageFix.Facing.values()) {
            if (face == ChunkPalettedStorageFix.Facing.NORTH) {
                Block currentBlock = world.getBlockState(blockPos.north()).getBlock();
                if (currentBlock.getTranslationKey().equals(targetBlock.getTranslationKey())) {
                    toReturn.add(blockPos.north());
                }
            } else if (face == ChunkPalettedStorageFix.Facing.SOUTH) {
                Block currentBlock = world.getBlockState(blockPos.south()).getBlock();
                if (currentBlock.getTranslationKey().equals(targetBlock.getTranslationKey())) {
                    toReturn.add(blockPos.south());
                }
            } else if (face == ChunkPalettedStorageFix.Facing.EAST) {
                Block currentBlock = world.getBlockState(blockPos.east()).getBlock();
                if (currentBlock.getTranslationKey().equals(targetBlock.getTranslationKey())) {
                    toReturn.add(blockPos.east());
                }
            } else if (face == ChunkPalettedStorageFix.Facing.WEST) {
                Block currentBlock = world.getBlockState(blockPos.west()).getBlock();
                if (currentBlock.getTranslationKey().equals(targetBlock.getTranslationKey())) {
                    toReturn.add(blockPos.west());
                }
            } else if (face == ChunkPalettedStorageFix.Facing.UP) {
                Block currentBlock = world.getBlockState(blockPos.up()).getBlock();
                if (currentBlock.getTranslationKey().equals(targetBlock.getTranslationKey())) {
                    toReturn.add(blockPos.up());
                }
            } else if (face == ChunkPalettedStorageFix.Facing.DOWN) {
                Block currentBlock = world.getBlockState(blockPos.down()).getBlock();
                if (currentBlock.getTranslationKey().equals(targetBlock.getTranslationKey())) {
                    toReturn.add(blockPos.down());
                }
            }
        }
        return toReturn;
    }
}
