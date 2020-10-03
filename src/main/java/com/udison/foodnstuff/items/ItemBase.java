package com.udison.foodnstuff.items;

import com.udison.foodnstuff.FoodNStuff;
import net.minecraft.item.Item;

public class ItemBase extends Item {

  public ItemBase() {
    super(new Item.Properties().group(FoodNStuff.TAB));
  }
}
