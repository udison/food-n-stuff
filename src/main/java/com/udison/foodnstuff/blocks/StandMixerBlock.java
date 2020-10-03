package com.udison.foodnstuff.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.HorizontalBlock;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.state.StateContainer;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;
import net.minecraftforge.common.ToolType;

import javax.annotation.Nullable;

public class StandMixerBlock extends HorizontalBlock {

  private static final VoxelShape SHAPE_NORTH = Block.makeCuboidShape(2.0d,  0.0d, 4.0d,  15.0d, 13.0d, 12.0d);
  private static final VoxelShape SHAPE_EAST  = Block.makeCuboidShape(12.0d, 0.0d, 15.0d, 4.0d,  13.0d, 2.0d);
  private static final VoxelShape SHAPE_SOUTH = Block.makeCuboidShape(15.0d, 0.0d, 12.0d, 2.0d,  13.0d, 4.0d);
  private static final VoxelShape SHAPE_WEST  = Block.makeCuboidShape(4.0d,  0.0d, 2.0d,  12.0d, 13.0d, 15.0d);

  public StandMixerBlock() {
    super(Block.Properties.create(Material.IRON)
            .hardnessAndResistance(2.0f, 4.0f)
            .harvestLevel(1)
            .sound(SoundType.METAL)
            .harvestTool(ToolType.PICKAXE)
            .notSolid()
    );
  }


  @Override
  public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
    switch (state.get(HORIZONTAL_FACING)) {
      case NORTH:
        return SHAPE_NORTH;
      case EAST:
        return SHAPE_EAST;
      case SOUTH:
        return SHAPE_SOUTH;
      case WEST:
        return SHAPE_WEST;
      default:
        return SHAPE_NORTH;
    }
  }

  private static Direction getFacingFromEntity(BlockPos clickedBlock, LivingEntity entity) {
    Vec3d vec = entity.getPositionVec();

    return Direction.getFacingFromVector((float) (vec.x - clickedBlock.getX()), 0.0f, (float) (vec.z - clickedBlock.getZ()));
  }

  @Override
  public void onBlockPlacedBy(World worldIn, BlockPos pos, BlockState state, @Nullable LivingEntity placer, ItemStack stack) {
    if(placer != null) {
      worldIn.setBlockState(pos, state.with(BlockStateProperties.HORIZONTAL_FACING, getFacingFromEntity(pos, placer)));
    }
  }

  @Override
  protected void fillStateContainer(StateContainer.Builder<Block, BlockState> builder) {
    builder.add(BlockStateProperties.HORIZONTAL_FACING);
  }
}
