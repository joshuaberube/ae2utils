package net.jabinator1.ae2utils;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.jabinator1.ae2utils.menu.ModScreens;
import net.jabinator1.ae2utils.util.Constants;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Environment(EnvType.CLIENT)
public class AE2UtilsModClient implements ClientModInitializer {
  public static final Logger CLIENT_LOGGER = LoggerFactory.getLogger(Constants.MOD_ID);

  @Override
  public void onInitializeClient() {
    ModScreens.registerModScreens();
  }
}
