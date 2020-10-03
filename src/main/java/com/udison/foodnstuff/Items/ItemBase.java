package com.udison.foodnstuff.Items;

import com.udison.foodnstuff.FoodNStuff;
import net.minecraft.item.Item;

public class ItemBase extends Item {

  public ItemBase() {
    super(new Item.Properties().group(FoodNStuff.TAB));
  }
}
