package fr.astralcube.acresources.common.block;

import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.world.BlockView;

public class BlockJumpPad extends Block {

    public BlockJumpPad(Settings settings) {
        super(settings);
        //TODO Auto-generated constructor stub
    }
    

    @Override
    public void onEntityLand(BlockView world, Entity entity) {
        // TODO Auto-generated method stub
        super.onEntityLand(world, entity);
        entity.changeLookDirection(0, 0);
    }
}
