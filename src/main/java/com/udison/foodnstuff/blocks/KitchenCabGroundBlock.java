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
import net.minecraft.world.World;
import net.minecraftforge.common.ToolType;

import javax.annotation.Nullable;

public class KitchenCabGroundBlock extends HorizontalBlock {

  public KitchenCabGroundBlock() {
    super(Block.Properties.create(Material.WOOD)
            .hardnessAndResistance(2.0f, 4.0f)
            .harvestLevel(0)
            .sound(SoundType.WOOD)
            .harvestTool(ToolType.AXE)
    );
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
