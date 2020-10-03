package com.udison.foodnstuff.blocks;

import com.udison.foodnstuff.tileentity.CuttingBoardTileEntity;
import com.udison.foodnstuff.util.ModTileEntityTypes;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.HorizontalBlock;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.InventoryHelper;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.state.DirectionProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.util.Mirror;
import net.minecraft.util.Rotation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;
import net.minecraftforge.common.ToolType;

import javax.annotation.Nullable;

public class CuttingBoardBlock extends Block {

  private static final DirectionProperty FACING = HorizontalBlock.HORIZONTAL_FACING;

  private static final VoxelShape VS_NORTH = Block.makeCuboidShape(1, 0, 4, 15, 3, 14);
  private static final VoxelShape VS_EAST  = Block.makeCuboidShape(2, 0, 1, 12, 3, 15);
  private static final VoxelShape VS_SOUTH = Block.makeCuboidShape(1, 0, 2, 15, 3, 12);
  private static final VoxelShape VS_WEST  = Block.makeCuboidShape(4, 0, 1, 14, 3, 15);

  public CuttingBoardBlock() {
    super(Block.Properties.create(Material.WOOD)
            .hardnessAndResistance(2.0f, 1.5f)
            .sound(SoundType.WOOD)
            .harvestTool(ToolType.AXE)
            .harvestLevel(0)
    );
  }

  @Override
  public void onBlockPlacedBy(World worldIn, BlockPos pos, BlockState state, @Nullable LivingEntity placer, ItemStack stack) {
    System.out.println("teste");
    super.onBlockPlacedBy(worldIn, pos, state, placer, stack);
  }

  // Complicated Stuff

  @Override
  public boolean hasTileEntity() {
    return true;
  }

  @Override
  public TileEntity createTileEntity(BlockState state, IBlockReader world) {
    return ModTileEntityTypes.CUTTING_BOARD.get().create();
  }

  @Override
  public ActionResultType onBlockActivated(BlockState state, World worldIn, BlockPos pos, PlayerEntity player, Hand handIn, BlockRayTraceResult hit) {
    if(!worldIn.isRemote) {
      TileEntity tile = worldIn.getTileEntity(pos);

      if(tile instanceof CuttingBoardTileEntity) {
        // CONSUMIR ITEM DA MÃO DO JOGADOR E COLOCAR NO INVENTÁRIO DO BLOCO
        ItemStack item = player.getActiveItemStack();
        System.out.println(item.getDisplayName());
        return ActionResultType.SUCCESS;
      }
    }
    return ActionResultType.FAIL;
  }

  /*@Override
  public void onReplaced(BlockState state, World worldIn, BlockPos pos, BlockState newState, boolean isMoving) {
    if(state.getBlock() != newState.getBlock()) {
      TileEntity tile = worldIn.getTileEntity(pos);

      if(tile instanceof CuttingBoardTileEntity) {
        InventoryHelper.dropItems(worldIn, pos, (CuttingBoardTileEntity)tile.);
      }
    }
  }*/

  // Block Facing

  @Nullable
  @Override
  public BlockState getStateForPlacement(BlockItemUseContext context) {
    return this.getDefaultState().with(FACING, context.getPlacementHorizontalFacing().getOpposite());
  }

  @Override
  public BlockState rotate(BlockState state, Rotation rot) {
    return state.with(FACING, rot.rotate(state.get(FACING)));
  }

  @Override
  public BlockState mirror(BlockState state, Mirror mirrorIn) {
    return state.rotate(mirrorIn.toRotation(state.get(FACING)));
  }

  @Override
  protected void fillStateContainer(StateContainer.Builder<Block, BlockState> builder) {
    builder.add(FACING);
  }

  @Override
  public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
    switch (state.get(FACING)) {
      case NORTH:
        return VS_NORTH;
      case EAST:
        return VS_EAST;
      case SOUTH:
        return VS_SOUTH;
      case WEST:
        return VS_WEST;
      default:
        return VS_NORTH;
    }
  }

  // Shadow

  @Override
  public float getAmbientOcclusionLightValue(BlockState state, IBlockReader worldIn, BlockPos pos) {
    return 1.0f;
  }
}