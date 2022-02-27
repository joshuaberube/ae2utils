package net.jabinator1.ae2utils.menu.screens;

import com.mojang.blaze3d.systems.RenderSystem;

import net.jabinator1.ae2utils.menu.screens.handlers.BarrelScreenHandler;
import net.minecraft.client.gui.screen.ingame.HandledScreen;
import net.minecraft.client.render.GameRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class BarrelScreen extends HandledScreen<BarrelScreenHandler> {
  private static final Identifier TEXTURE = new Identifier("ae2utils", "textures/gui/barrel.png");

  public BarrelScreen(BarrelScreenHandler handler, PlayerInventory inventory, Text title) {
    super(handler, inventory, title);
  }

  @Override
  protected void drawBackground(MatrixStack matrices, float delta, int mouseX, int mouseY) {
    RenderSystem.setShader(GameRenderer::getPositionTexShader);
    RenderSystem.setShaderColor(1.0f, 1.0f, 1.0f, 1.0f);
    RenderSystem.setShaderTexture(0, TEXTURE);
    int x = (width - backgroundWidth) / 2;
    int y = (height - backgroundHeight) / 2;
    drawTexture(matrices, x, y, 0, 0, backgroundWidth, backgroundHeight);
  }

  @Override
  public void render(MatrixStack matrices, int mouseX, int mouseY, float delta) {
    renderBackground(matrices);
    super.render(matrices, mouseX, mouseY, delta);
    drawMouseoverTooltip(matrices, mouseX, mouseY);
  }

  @Override
  protected void init() {
    super.init();
    //center the title
    // titleX = (backgroundWidth - textRenderer.getWidth(title)) / 2;
  }
}
