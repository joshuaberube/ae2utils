package net.jabinator1.ae2utils.menu;

import net.fabricmc.fabric.api.client.screenhandler.v1.ScreenRegistry;
import net.jabinator1.ae2utils.AE2UtilsModClient;
import net.jabinator1.ae2utils.menu.screens.BarrelScreen;
import net.jabinator1.ae2utils.util.Constants;

public class ModScreens {

  //to get this to work, you'd have to override .register function
  // private static ScreenRegistry registerScreenHandler(ScreenHandler screenHandler, Screen screen) {
  //   ScreenRegistry.register(screenHandler, Factory<screenHandler, screen>);
  // }
  
  public static void registerModScreens() {
    AE2UtilsModClient.CLIENT_LOGGER.info("Registering ModScreens on Client for " + Constants.MOD_ID);
    ScreenRegistry.register(ModScreenHandlers.BARREL_SCREEN_HANDLER, BarrelScreen::new);
  }
}
