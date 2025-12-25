package me.icedreem.component;

import me.icedreem.ModdingStudy;
import me.icedreem.creativetab.CustomCreativeTab;
import me.icedreem.creativetab.RandomTab;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;

import java.util.List;

public class ModCreativeTabs {

    public static final CreativeModeTab RANDOM_TAB = register(new RandomTab());

    public static CreativeModeTab register(
            CustomCreativeTab itemGroup
    ) {
        String name = itemGroup.getName();
        ItemStack icon = itemGroup.getIcon();
        Component title = itemGroup.getTitle();
        List<Item> items = itemGroup.getItems();

        ResourceKey<CreativeModeTab> resourceKey = ResourceKey.create(
                BuiltInRegistries.CREATIVE_MODE_TAB.key(),
                Identifier.fromNamespaceAndPath(
                        ModdingStudy.MOD_ID,
                        name
                )
        );

        CreativeModeTab newItemGroup = FabricItemGroup.builder()
                .icon(() -> icon)
                .title(title)
                .build();

        Registry.register(
                BuiltInRegistries.CREATIVE_MODE_TAB,
                resourceKey,
                newItemGroup
        );

        ItemGroupEvents
                .modifyEntriesEvent(resourceKey)
                .register(
                        ig -> {
                                for (Item i : items) {
                                    ig.accept(i);
                                }
                        }
                );

        return newItemGroup;
    }

    public static void initialize() {
    }
}
