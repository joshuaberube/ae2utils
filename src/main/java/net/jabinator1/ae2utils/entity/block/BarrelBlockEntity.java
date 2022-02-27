package net.jabinator1.ae2utils.entity.block;

import net.jabinator1.ae2utils.entity.ModBlockEntities;
import net.jabinator1.ae2utils.inventory.DefaultInventory;
import net.jabinator1.ae2utils.menu.screens.handlers.BarrelScreenHandler;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.Inventories;
// import net.minecraft.inventory.SidedInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.screen.NamedScreenHandlerFactory;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableText;
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.util.math.BlockPos;

public class BarrelBlockEntity extends BlockEntity implements DefaultInventory, NamedScreenHandlerFactory {
  static final int numOfRows = 3;
  public static final int inventorySize = 9 * numOfRows;
  private final DefaultedList<ItemStack> inventory = DefaultedList.ofSize(inventorySize, ItemStack.EMPTY);

  public BarrelBlockEntity(BlockPos pos, BlockState state) {
    super(ModBlockEntities.BARREL_BLOCK_ENTITY, pos, state);
  }

  @Override
  public DefaultedList<ItemStack> getItems() {
    return inventory;
  }

  @Override
  public ScreenHandler createMenu(int syncId, PlayerInventory playerInventory, PlayerEntity player) {
    return new BarrelScreenHandler(syncId, playerInventory, this);
  }

  @Override
  public Text getDisplayName() {
    return new TranslatableText(getCachedState().getBlock().getTranslationKey());
  }

  @Override
  public void readNbt(NbtCompound nbt) {
    super.readNbt(nbt);
    Inventories.readNbt(nbt, inventory);
  }

  @Override
  public void writeNbt(NbtCompound nbt) {
    super.writeNbt(nbt);
    Inventories.writeNbt(nbt, inventory);
  }
}
