package net.jabinator1.ae2utils;

import net.fabricmc.api.ModInitializer;
import net.jabinator1.ae2utils.block.ModBlocks;
import net.jabinator1.ae2utils.entity.ModBlockEntities;
import net.jabinator1.ae2utils.menu.ModScreenHandlers;
import net.jabinator1.ae2utils.util.Constants;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AE2UtilsMod implements ModInitializer {
	public static final Logger LOGGER = LoggerFactory.getLogger(Constants.MOD_ID);

	@Override
	public void onInitialize() {
		ModBlocks.registerModBlocks();
		ModBlockEntities.registerModBlockEntities();
		ModScreenHandlers.registerScreenHandlers();
	}
}
