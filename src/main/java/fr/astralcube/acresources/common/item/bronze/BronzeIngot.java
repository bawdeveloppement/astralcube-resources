package fr.astralcube.acresources.common.item.bronze;

import java.util.List;

import net.minecraft.client.item.TooltipContext;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableText;
import net.minecraft.world.World;

public class BronzeIngot extends Item {

    public BronzeIngot(Settings settings) {
        super(settings);
    }

    

    @Override
    public void appendTooltip(ItemStack stack, World world, List<Text> tooltip, TooltipContext context) {
        tooltip.add(new TranslatableText(""));
        super.appendTooltip(stack, world, tooltip, context);
    }
}
