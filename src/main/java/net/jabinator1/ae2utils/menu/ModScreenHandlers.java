package net.jabinator1.ae2utils.menu;

import net.fabricmc.fabric.api.screenhandler.v1.ScreenHandlerRegistry;
import net.jabinator1.ae2utils.AE2UtilsMod;
import net.jabinator1.ae2utils.menu.screens.handlers.BarrelScreenHandler;
import net.jabinator1.ae2utils.util.Constants;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.screen.ScreenHandlerType;

public class ModScreenHandlers {
  public static final ScreenHandlerType<BarrelScreenHandler> BARREL_SCREEN_HANDLER = registerScreenHandler("barrel_block", BarrelScreenHandler::new);

  private static final <T extends ScreenHandler> ScreenHandlerType<T> registerScreenHandler(String blockName, ScreenHandlerRegistry.SimpleClientHandlerFactory<T> factory) {
    return ScreenHandlerRegistry.registerSimple(Constants.createId(blockName), factory);
  }
  
  public static void registerScreenHandlers() {
    AE2UtilsMod.LOGGER.info("Registering ModScreenHandlers for " + Constants.MOD_ID);
  }
}
