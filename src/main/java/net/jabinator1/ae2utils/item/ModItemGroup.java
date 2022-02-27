package net.jabinator1.ae2utils.item;

import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.jabinator1.ae2utils.block.ModBlocks;
import net.jabinator1.ae2utils.util.Constants;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;

public class ModItemGroup {
  public static final ItemGroup AE2UTILS = FabricItemGroupBuilder.build(Constants.createId("ae2utils"), () -> new ItemStack(ModBlocks.BARREL));
}
