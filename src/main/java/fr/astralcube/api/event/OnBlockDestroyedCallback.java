package fr.astralcube.api.event;

import net.fabricmc.fabric.api.event.Event;
import net.fabricmc.fabric.api.event.EventFactory;
import net.minecraft.block.Block;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.ActionResult;

public interface OnBlockDestroyedCallback {
    Event<OnBlockDestroyedCallback> EVENT = EventFactory.createArrayBacked(OnBlockDestroyedCallback.class,
        (listeners) -> (player, block) -> {
            for (OnBlockDestroyedCallback listener : listeners) {
                ActionResult result = listener.interact(player, block);

                if(result != ActionResult.PASS) {
                    return result;
                }
            }

        return ActionResult.PASS;
    });

    ActionResult interact(PlayerEntity player, Block block);
}
