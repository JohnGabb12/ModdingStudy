package me.icedreem.item;

import net.minecraft.world.item.Item;

import java.util.function.Function;

public class Pencil extends CustomItem<Item> {

    public Pencil() {
        super(
                "pencil",          // item name
                Item::new,                  // item factory
                new Item.Properties()       // item settings
        );
    }

    @Override
    public String getItemName() {
        return "pencil";            // dynamic name if needed
    }

    @Override
    public Function<Item.Properties, Item> getItemFactory() {
        return props -> new Item(props) {
            // behaviour
        };
    }

    @Override
    public Item.Properties getItemSettings() {
        Item.Properties settings = super.getItemSettings();

        // change settings here

        return settings;
    }
}
