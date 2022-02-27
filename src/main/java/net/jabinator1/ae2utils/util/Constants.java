package net.jabinator1.ae2utils.util;

import net.minecraft.util.Identifier;

public class Constants {
  public static final String MOD_ID = "ae2utils";

  public static Identifier createId(String path) {
    return new Identifier(MOD_ID, path);
  }
}
