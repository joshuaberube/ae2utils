package net.jabinator1.ae2utils.entity;

import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.jabinator1.ae2utils.AE2UtilsMod;
import net.jabinator1.ae2utils.block.ModBlocks;
import net.jabinator1.ae2utils.entity.block.BarrelBlockEntity;
import net.jabinator1.ae2utils.util.Constants;
import net.minecraft.block.Block;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.util.registry.Registry;

public class ModBlockEntities {
  public static BlockEntityType<BarrelBlockEntity> BARREL_BLOCK_ENTITY = registerBlockEntity("barrel", BarrelBlockEntity::new, ModBlocks.BARREL);

  private static <T extends BlockEntity> BlockEntityType<T> registerBlockEntity(String name, FabricBlockEntityTypeBuilder.Factory<T> factory, Block block) {
    return Registry.register(
      Registry.BLOCK_ENTITY_TYPE,
      Constants.createId(name + "_block_entity"),
      FabricBlockEntityTypeBuilder.create(factory, block).build(null)
    );
  }


  public static void registerModBlockEntities() {
    AE2UtilsMod.LOGGER.info("Registering ModBlockEntities for ", Constants.MOD_ID);
  }
}
