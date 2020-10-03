package com.udison.foodnstuff.util;

import com.udison.foodnstuff.tileentity.CuttingBoardTileEntity;
import net.minecraft.tileentity.TileEntityType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModTileEntityTypes {

  public static final DeferredRegister<TileEntityType<?>> TILE_ENTITY_TYPES = new DeferredRegister<>(ForgeRegistries.TILE_ENTITIES, "foodnstuff");

  public static final RegistryObject<TileEntityType<CuttingBoardTileEntity>> CUTTING_BOARD = TILE_ENTITY_TYPES.register(
          "cutting_board",
          () -> TileEntityType.Builder.create(CuttingBoardTileEntity::new, RegistryHandler.CUTTING_BOARD.get()).build(null)
  );

}
