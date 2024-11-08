package net.graypikachu.testmod;

import net.fabricmc.api.ModInitializer;

import net.graypikachu.testmod.block.ModBlocks;
import net.graypikachu.testmod.item.ModItems;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
//Very important comment1212121
public class TestMod implements ModInitializer {
	public static final String MOD_ID = "testmod";

	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		ModItems.registerModItems();
		ModBlocks.registerModBlocks();
	}
}