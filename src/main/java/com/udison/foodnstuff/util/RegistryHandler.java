package com.udison.foodnstuff.util;

import com.udison.foodnstuff.items.BlockItemBase;
import com.udison.foodnstuff.items.ItemBase;
import com.udison.foodnstuff.items.ItemFoodBase;
import com.udison.foodnstuff.FoodNStuff;
import com.udison.foodnstuff.items.MeatBase;
import com.udison.foodnstuff.blocks.CuttingBoardBlock;
import com.udison.foodnstuff.blocks.KitchenCabGroundBlock;
import com.udison.foodnstuff.blocks.StandMixerBlock;
import com.udison.foodnstuff.blocks.StoveBlock;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class RegistryHandler {

  public static final DeferredRegister<Item> ITEMS = new DeferredRegister<>(ForgeRegistries.ITEMS, FoodNStuff.MOD_ID);
  public static final DeferredRegister<Block> BLOCKS = new DeferredRegister<>(ForgeRegistries.BLOCKS, FoodNStuff.MOD_ID);

  public static void init() {
    ITEMS.register(FMLJavaModLoadingContext.get().getModEventBus());
    BLOCKS.register(FMLJavaModLoadingContext.get().getModEventBus());
  }

  // Items
  public static final RegistryObject<Item> KITCHEN_KNIFE = ITEMS.register("kitchen_knife", ItemBase::new);
  public static final RegistryObject<Item> FOUET = ITEMS.register("fouet", ItemBase::new);

  // Blocks
  public static final RegistryObject<Block> STOVE = BLOCKS.register("stove", StoveBlock::new);
  public static final RegistryObject<Block> STAND_MIXER = BLOCKS.register("stand_mixer", StandMixerBlock::new);
  public static final RegistryObject<Block> KITCHEN_CAB_GROUND = BLOCKS.register("kitchen_cab_ground", KitchenCabGroundBlock::new);
  public static final RegistryObject<Block> CUTTING_BOARD = BLOCKS.register("cutting_board", CuttingBoardBlock::new);

  // Block Items
  public static final RegistryObject<Item> STOVE_ITEM = ITEMS.register("stove", () -> new BlockItemBase(STOVE.get()));
  public static final RegistryObject<Item> STAND_MIXER_ITEM = ITEMS.register("stand_mixer", () -> new BlockItemBase(STAND_MIXER.get()));
  public static final RegistryObject<Item> KITCHEN_CAB_GROUND_ITEM = ITEMS.register("kitchen_cab_ground", () -> new BlockItemBase(KITCHEN_CAB_GROUND.get()));
  public static final RegistryObject<Item> CUTTING_BOARD_ITEM = ITEMS.register("cutting_board", () -> new BlockItemBase(CUTTING_BOARD.get()));

  // FOODS
  // Steaks
  public static final RegistryObject<Item> STEAK_RAW_PRIMERIB = ITEMS.register("steak_raw_primerib", () -> new MeatBase(true, 3, 0.5f));
  public static final RegistryObject<Item> STEAK_PRIMERIB = ITEMS.register("steak_primerib", () -> new MeatBase(false, 8, 2.0f));

  // Veggies
  public static final RegistryObject<Item> YELLOW_ONION = ITEMS.register("yellow_onion", () -> new ItemFoodBase(true, 4, 1.0f));
  public static final RegistryObject<Item> RED_ONION = ITEMS.register("red_onion", () -> new ItemFoodBase(true, 4, 1.0f));

  // Dairy
  public static final RegistryObject<Item> BUTTER_BAR = ITEMS.register("butter_bar", () -> new ItemFoodBase(true, 2, 5.0f));

  // Seasoning
  public static final RegistryObject<Item> SALT = ITEMS.register("salt", ItemBase::new);
}