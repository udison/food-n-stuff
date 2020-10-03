package com.udison.foodnstuff;

import com.udison.foodnstuff.blocks.StandMixerBlock;
import com.udison.foodnstuff.util.RegistryHandler;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.RenderTypeLookup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod("foodnstuff")
public class FoodNStuff
{
  private static final Logger LOGGER = LogManager.getLogger();
  public static final String MOD_ID = "foodnstuff";

  public FoodNStuff() {
    FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);
    FMLJavaModLoadingContext.get().getModEventBus().addListener(this::doClientStuff);

    RegistryHandler.init();

    MinecraftForge.EVENT_BUS.register(this);
  }

  private void setup(final FMLCommonSetupEvent event) {  }

  private void doClientStuff(final FMLClientSetupEvent event) {
    RenderTypeLookup.setRenderLayer(RegistryHandler.STAND_MIXER.get(), RenderType.getCutout());
  }

  public static final ItemGroup TAB = new ItemGroup("foodnstuffTab") {
    @Override
    public ItemStack createIcon() {
      return new ItemStack(RegistryHandler.KITCHEN_KNIFE.get());
    }
  };
}
