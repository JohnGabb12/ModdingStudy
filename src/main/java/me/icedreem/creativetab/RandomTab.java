package me.icedreem.creativetab;

import me.icedreem.component.ModItems;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;

import java.util.List;

public class RandomTab extends CustomCreativeTab{
    public RandomTab() {
        super(
                new ItemStack(ModItems.PENCIL),
                "random-tab",
                List.of(
                        ModItems.PENCIL
                )
        );
    }
}
