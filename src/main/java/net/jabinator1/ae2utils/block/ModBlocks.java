package net.jabinator1.ae2utils.block;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.jabinator1.ae2utils.AE2UtilsMod;
import net.jabinator1.ae2utils.block.custom.BarrelBlock;
import net.jabinator1.ae2utils.item.ModItemGroup;
import net.jabinator1.ae2utils.util.Constants;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.util.registry.Registry;

public class ModBlocks {
  public static final Block BARREL = registerBlockAndBlockItem("barrel", new BarrelBlock(FabricBlockSettings.of(Material.METAL).strength(4.5f, 1f)));


  private static Block registerBlockAndBlockItem(String name, Block block) {
    Registry.register(Registry.ITEM, Constants.createId(name), new BlockItem(block, new FabricItemSettings().group(ModItemGroup.AE2UTILS)));
    return Registry.register(Registry.BLOCK, Constants.createId(name), block);
  }

  public static void registerModBlocks() {
    AE2UtilsMod.LOGGER.info("Registering ModBlocks for " + Constants.MOD_ID);
  }
}
