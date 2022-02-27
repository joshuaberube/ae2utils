package net.jabinator1.ae2utils.block.custom;

import net.jabinator1.ae2utils.entity.block.BarrelBlockEntity;
import net.minecraft.block.Block;
import net.minecraft.block.BlockRenderType;
import net.minecraft.block.BlockState;
import net.minecraft.block.BlockWithEntity;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.screen.NamedScreenHandlerFactory;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.state.StateManager.Builder;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.state.property.DirectionProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.state.property.Property;
import net.minecraft.util.ActionResult;
import net.minecraft.util.BlockRotation;
import net.minecraft.util.Hand;
import net.minecraft.util.ItemScatterer;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.World;

public class BarrelBlock extends BlockWithEntity {
  public static final DirectionProperty FACING = Properties.FACING;
  public static final BooleanProperty OPEN = Properties.OPEN;

  public BarrelBlock(Settings settings) {
    super(settings);
    this.setDefaultState(getStateManager().getDefaultState()
      .with(OPEN, false)
      .with(FACING, Direction.NORTH)
    );
  }

  @Override
  public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
    if (world.isClient) return ActionResult.SUCCESS;

    NamedScreenHandlerFactory screenHandlerFactory = state.createScreenHandlerFactory(world, pos);

    BlockEntity blockEntity = world.getBlockEntity(pos);
    if (blockEntity instanceof BarrelBlockEntity) {
      player.openHandledScreen(screenHandlerFactory);
    }

    
    return ActionResult.CONSUME;
  }

  @Override
  @SuppressWarnings("deprecation")
  public void onStateReplaced(BlockState state, World world, BlockPos pos, BlockState newState, boolean moved) {
    if (state.getBlock() != newState.getBlock()) {
      BlockEntity blockEntity = world.getBlockEntity(pos);
      if (blockEntity instanceof BarrelBlockEntity) {
        ItemScatterer.spawn(world, pos, (BarrelBlockEntity)blockEntity);
        world.updateComparators(pos, this);
      }
      super.onStateReplaced(state, world, pos, newState, moved);
    }
  }

  @Override
  public BlockEntity createBlockEntity(BlockPos pos, BlockState state) {
    return new BarrelBlockEntity(pos, state);
  }

  @Override
  public BlockRenderType getRenderType(BlockState state) {
    return BlockRenderType.MODEL;
  }

  // @Override
  // public void onPlaced(World world, BlockPos pos, BlockState state, LivingEntity placer, ItemStack itemStack) {
  //   if (itemStack.hasCustomName()) {
  //     BlockEntity blockEntity = world.getBlockEntity(pos);
  //     if (blockEntity instanceof BarrelBlockEntity) {
  //       ((BarrelBlockEntity)blockEntity).setCustomName(itemStack.getName());
  //     }
  //   }
  // }

  @Override
  public boolean hasComparatorOutput(BlockState state) {
    return true;
  }

  @Override
  public int getComparatorOutput(BlockState state, World world, BlockPos pos) {
    return ScreenHandler.calculateComparatorOutput(world.getBlockEntity(pos));
  }

  @Override
  public BlockState rotate(BlockState state, BlockRotation rotation) {
    return (BlockState)state.with(FACING, rotation.rotate((Direction)state.get(FACING)));
  }

  @Override
  protected void appendProperties(Builder<Block, BlockState> builder) {
    builder.add(new Property[]{FACING, OPEN});
  }
  
  @Override
  public BlockState getPlacementState(ItemPlacementContext ctx) {
    return (BlockState)this.getDefaultState()
    .with(FACING, ctx.getPlayerLookDirection().getOpposite());
  };
}
