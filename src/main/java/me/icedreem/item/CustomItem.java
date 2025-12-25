package me.icedreem.item;

import net.minecraft.world.item.Item;

import java.util.function.Function;

public class CustomItem<T extends Item> {
    public String itemName;                 // name ^[a-z_]+$
    public Function itemFactory;            // The constructor is Item(Item.Properties) thereof
    public Item.Properties itemSettings;    // Item.Properties as the settings

    public CustomItem(
            String itemName,
            Function<Item.Properties, T> itemFactory,
            Item.Properties itemSettings
    ) {
        this.itemName = itemName;
        this.itemFactory = itemFactory;
        this.itemSettings = itemSettings;
    }

    // getters can be overridden
    public String getItemName() {
        return itemName;
    }

    public Function<Item.Properties, T> getItemFactory() {
        return itemFactory;
    }

    public Item.Properties getItemSettings() {
        return itemSettings;
    }
}
