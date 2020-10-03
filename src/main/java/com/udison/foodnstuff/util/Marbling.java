package com.udison.foodnstuff.util;

import net.minecraft.util.text.TextFormatting;

public enum Marbling {
  POOR("POOR", 0.25f, TextFormatting.DARK_RED),
  BAD("BAD", 0.75f, TextFormatting.RED),
  NORMAL("NORMAL", 1f, TextFormatting.GRAY),
  GOOD("GOOD", 1.2f, TextFormatting.YELLOW),
  VERY_GOOD("VERY GOOD", 1.35f, TextFormatting.AQUA),
  EXTREME("EXTREME", 1.65f, TextFormatting.LIGHT_PURPLE);

  private String marbling;
  private float satMultiplier;
  private TextFormatting color;

  private Marbling(String marbling, float satMultiplier, TextFormatting color) {
    this.marbling = marbling;
    this.satMultiplier = satMultiplier;
    this.color = color;
  }

  public String getMarbling() {
    return marbling;
  }

  public float getSatMultiplier() {
    return satMultiplier;
  }

  public TextFormatting getColor() {
    return color;
  }
}
