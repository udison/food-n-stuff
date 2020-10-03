package com.udison.foodnstuff.Items;

import com.udison.foodnstuff.FoodNStuff;
import net.minecraft.item.Food;
import net.minecraft.item.Item;

import javax.annotation.Nullable;

public class ItemFoodBase extends Item {

  boolean isRaw;
  int hunger;
  float saturation;

  public ItemFoodBase(boolean isRaw, int hunger, float saturation) {
    super(new Item.Properties()
            .group(FoodNStuff.TAB)
            .food(new Food.Builder()
                    .hunger(hunger)
                    .saturation(saturation)
                    .build()
            )
    );

    this.isRaw = isRaw;
    this.hunger = (isRaw) ? hunger : hunger * 3;
    this.saturation = saturation;
  }

  @Nullable
  @Override
  public Food getFood() {
    return new Food.Builder().hunger(hunger).saturation(saturation).build();
  }
}
