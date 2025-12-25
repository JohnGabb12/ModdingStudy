package me.icedreem;

import me.icedreem.component.ModCreativeTabs;
import me.icedreem.component.ModItems;
import net.fabricmc.api.ModInitializer;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ModdingStudy implements ModInitializer {
	public static final String MOD_ID = "modding-study";
	public static final Logger LOGGER = LogManager.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		ModItems.initialize();
		ModCreativeTabs.initialize();
		LOGGER.info("Hello Fabric world!");
	}
}