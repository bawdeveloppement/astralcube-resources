package fr.astralcube.acresources.client;

import dev.emi.trinkets.api.client.TrinketRenderer;
import dev.emi.trinkets.api.client.TrinketRendererRegistry;
import fr.astralcube.acresources.common.item.ACItems;
import net.fabricmc.api.ClientModInitializer;

public class ACResourcesClientMod implements ClientModInitializer {

    @Override
    public void onInitializeClient() {
        // TODO Auto-generated method stub
		TrinketRendererRegistry.registerRenderer(ACItems.FOUR_ACCESSORY_DEXTERITY_NECKLACE, (TrinketRenderer) ACItems.FOUR_ACCESSORY_DEXTERITY_NECKLACE);
    }
    
}
