package me.icedreem.creativetab;

import me.icedreem.ModdingStudy;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;

import java.util.List;

public class CustomCreativeTab {
    public String name;
    public ItemStack icon;
    public String title;
    public List<Item> items;

    public CustomCreativeTab(
        ItemStack icon,
        String title,
        List<Item> items
    ) {
        this.icon = icon;
        this.title = title;
        this.items = items;
    }

    public String getName() {
        return this.title;
    }

    public ItemStack getIcon() {
        return this.icon;
    }

    public Component getTitle() {
        return Component.translatable(
                ModdingStudy.MOD_ID + "." + this.title
        );
    }

    public List<Item> getItems() {
        return this.items;
    }
}
