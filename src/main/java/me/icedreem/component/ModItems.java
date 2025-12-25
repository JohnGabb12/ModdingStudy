package me.icedreem.component;

import me.icedreem.ModdingStudy;
import me.icedreem.item.CustomItem;
import me.icedreem.item.Pencil;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.Item;

import java.util.function.Function;



public class ModItems {

    // Reusable Items
    public static final Item PENCIL = register(new Pencil());




    // Registers items
    public static <T extends Item> T register( CustomItem item ) {
        String name = item.getItemName();                                   // name ^[a-z_]+$
        Function<Item.Properties, T> itemFactory = item.getItemFactory();   // The constructor is Item(Item.Properties) thereof
        Item.Properties settings = item.getItemSettings();                  // Item.Properties as the settings

        /*
        Resource Key is a global unique Identifier
        It requires the Registry key of the class gonna be used.
        and the Identifer which is the mod namespace along with namespace.
        e.g. examplemod:item/exampleitem
        */
        ResourceKey<Item> resourceKey = ResourceKey.create(
                BuiltInRegistries.ITEM.key(),       // Registry key of Item class
                Identifier.fromNamespaceAndPath(    // Identifier
                        ModdingStudy.MOD_ID,    // namespace
                        name                    // item name
                )
        );

        /*
        .apply() is part of the Function class under jdk
        where it needs Item.Properties
        and sets the id using the Resource Key
        */
        T newItem = itemFactory.apply(
                settings.setId(         // Item.Properties then .setId
                        resourceKey     // Resource key
                )
        );

        // Register the item to the game
        Registry.register(
                BuiltInRegistries.ITEM,     // BuiltInRegistries uses the registry already registered
                resourceKey,                // Resource key
                newItem                     // item
        );

        // Return the item
        return newItem;
    }

    public static void initialize() {


    }
}
