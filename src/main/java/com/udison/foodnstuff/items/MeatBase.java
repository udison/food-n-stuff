package com.udison.foodnstuff.items;

import com.udison.foodnstuff.util.Marbling;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.Style;
import net.minecraft.world.World;

import javax.annotation.Nullable;
import java.util.List;

public class MeatBase extends ItemFoodBase {

  public MeatBase(boolean isRaw, int hunger, float saturation) {
    super(isRaw, hunger, saturation);
  }

  @Override
  public ActionResult<ItemStack> onItemRightClick(World worldIn, PlayerEntity playerIn, Hand handIn) {
    /*ItemStack stack = playerIn.getActiveItemStack();

    addInformation(stack, worldIn, stack.getTooltip(playerIn, ITooltipFlag.TooltipFlags.NORMAL), ITooltipFlag.TooltipFlags.NORMAL);

    if (stack.hasTag()) {
      if(stack.getTag().contains("marbling")) {
        playerIn.sendMessage(new StringTextComponent(stack.getTag().getString("marbling")));
      }
    }*/

    return super.onItemRightClick(worldIn, playerIn, handIn);
  }

  @Override
  public boolean onDroppedByPlayer(ItemStack item, PlayerEntity player) {
    CompoundNBT nbt;

    player.sendMessage(new StringTextComponent(item.getDisplayName().getFormattedText() + " dropped!"));

    if(!item.hasTag()) {
      nbt = new CompoundNBT();
    }
    else {
      nbt = item.getTag();
    }

    if (!nbt.contains("marbling")) {
      nbt.putString("marbling", generateMarbling().toString());
      item.setTag(nbt);
      addInformation(item, player.world, item.getTooltip(player, ITooltipFlag.TooltipFlags.NORMAL), ITooltipFlag.TooltipFlags.NORMAL);
    }

    // Test
    player.sendMessage(new StringTextComponent(
      item.getDisplayName().getFormattedText() + (item.hasTag() ? " has " : " do not has") + "a tag. So, marbling is " + (item.hasTag() ? item.getTag().getString("marbling") : " null")));

    return true;
  }

  private Marbling generateMarbling() {
    double rand = Math.random();
    Marbling marbling;

    if(rand < 0.1)
      return Marbling.POOR;
    else if(rand < 0.25)
      return Marbling.BAD;
    else if(rand < 0.70)
      return Marbling.NORMAL;
    else if(rand < 0.85)
      return Marbling.GOOD;
    else if(rand < 0.95)
      return Marbling.VERY_GOOD;
    else
      return Marbling.EXTREME;
  }

  @Override
  public void addInformation(ItemStack stack, @Nullable World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
    if(stack.hasTag()) {
      if(stack.getTag().contains("marbling")) {
        Marbling marbling = Marbling.valueOf(stack.getTag().getString("marbling"));

        Style style = new Style();
        style.setColor(marbling.getColor());
        tooltip.add(new StringTextComponent("Marbling: " + marbling.getMarbling()).setStyle(style));
      }
    }
  }
}
