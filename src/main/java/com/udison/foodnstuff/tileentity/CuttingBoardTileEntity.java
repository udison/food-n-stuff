package com.udison.foodnstuff.tileentity;

import com.udison.foodnstuff.util.ModTileEntityTypes;
import net.minecraft.tileentity.ITickableTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityType;

public class CuttingBoardTileEntity extends TileEntity implements ITickableTileEntity {


  public CuttingBoardTileEntity(final TileEntityType<?> tileEntityTypeIn) {
    super(tileEntityTypeIn);
  }

  public CuttingBoardTileEntity() {
    this(ModTileEntityTypes.CUTTING_BOARD.get());
  }

  @Override
  public void tick() {
    if(world.isRemote) {
      System.out.println("CuttingBoardTileEntity.tick");
    }
  }
}
