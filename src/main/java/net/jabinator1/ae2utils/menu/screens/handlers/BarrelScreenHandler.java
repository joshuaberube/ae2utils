package net.jabinator1.ae2utils.menu.screens.handlers;

import net.jabinator1.ae2utils.entity.block.BarrelBlockEntity;
import net.jabinator1.ae2utils.menu.ModScreenHandlers;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.Inventory;
import net.minecraft.inventory.SimpleInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.screen.slot.Slot;

public class BarrelScreenHandler extends ScreenHandler {
  private final Inventory inventory;

  public BarrelScreenHandler(int syncId, PlayerInventory playerInventory) {
    this(syncId, playerInventory, new SimpleInventory(BarrelBlockEntity.inventorySize));
  }

  public BarrelScreenHandler(int syncId, PlayerInventory playerInventory, Inventory inventory) {
    super(ModScreenHandlers.BARREL_SCREEN_HANDLER, syncId);
    checkSize(inventory, BarrelBlockEntity.inventorySize);
    this.inventory = inventory;

    inventory.onOpen(playerInventory.player);
    int m;
    int l;
    int numOfRows = BarrelBlockEntity.inventorySize / 9; // 3
    int slotSize = 18;
    int xOffset = 8;
    int initialYOffset = 17;
    int distanceBetweenInventoryAndPlayerInventory = 13;
    int secondaryYOffset = initialYOffset + distanceBetweenInventoryAndPlayerInventory + (slotSize * numOfRows); // 84
    int thirdYOffset = 142;

    //Barrel Inventory top left is 0, 0
    for (m = 0; m < numOfRows; ++m) {
      for (l = 0; l < 9; ++l) {
        this.addSlot(new Slot(inventory, l + m * 9, xOffset + l * slotSize, initialYOffset + m * slotSize));
      }
    }
    //The player inventory
    for (m = 0; m < 3; ++m) {
      for (l = 0; l < 9; ++l) {
        this.addSlot(new Slot(playerInventory, l + m * 9 + 9, xOffset + l * slotSize, secondaryYOffset + m * slotSize));
      }
    }
    //The player Hotbar
    for (m = 0; m < 9; ++m) {
      this.addSlot(new Slot(playerInventory, m, xOffset + m * slotSize, thirdYOffset));
    }
  }


  @Override
  public boolean canUse(PlayerEntity player) {
    return this.inventory.canPlayerUse(player);
  }

  @Override
  public ItemStack transferSlot(PlayerEntity player, int invSlot) {
    ItemStack newStack = ItemStack.EMPTY;
    Slot slot = this.slots.get(invSlot);
    if (slot != null && slot.hasStack()) {
      ItemStack originalStack = slot.getStack();
      newStack = originalStack.copy();
      if (invSlot < this.inventory.size()) {
        if (!this.insertItem(originalStack, this.inventory.size(), this.slots.size(), true)) {
          return ItemStack.EMPTY;
        }
      } else if (!this.insertItem(originalStack, 0, this.inventory.size(), false)) {
        return ItemStack.EMPTY;
      }

      if (originalStack.isEmpty()) {
        slot.setStack(ItemStack.EMPTY);
      } else {
        slot.markDirty();
      }
    }

    return newStack;
  }
}
