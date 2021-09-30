/**
 * The code of this mod element is always locked.
 *
 * You can register new events in this class too.
 *
 * If you want to make a plain independent class, create it using
 * Project Browser -> New... and make sure to make the class
 * outside net.shin.shamanking as this package is managed by MCreator.
 *
 * If you change workspace package, modid or prefix, you will need
 * to manually adapt this file to these changes or remake it.
 *
 * This class will be added in the mod root package.
*/
package net.shin.shamanking;
import java.util.List;
import java.util.Map;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.player.AbstractClientPlayerEntity;
import net.minecraft.client.renderer.entity.IEntityRenderer;
import net.minecraft.client.renderer.entity.LivingRenderer;
import net.minecraft.client.renderer.entity.PlayerRenderer;
import net.minecraft.client.renderer.entity.layers.LayerRenderer;
import net.minecraft.client.renderer.entity.model.PlayerModel;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.fml.common.ObfuscationReflectionHelper;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.server.FMLServerStartingEvent;

@Tag
public class LoadLayers extends ShamankingModElements.ModElement {
  public LoadLayers(ShamankingModElements instance) {
    super(instance, 64);
  }
  
  public void initElements() {}
  
  public void init(FMLCommonSetupEvent event) {}
  
  public void serverLoad(FMLServerStartingEvent event) {}
  
  @OnlyIn(Dist.CLIENT)
  public void clientLoad(FMLClientSetupEvent event) {
    Map<String, PlayerRenderer> playerSkinMap = Minecraft.func_71410_x().func_175598_ae().getSkinMap();
    addPlayerLayers(playerSkinMap.get("default"));
    addPlayerLayers(playerSkinMap.get("slim"));
  }
  
  @OnlyIn(Dist.CLIENT)
  public static void addPlayerLayers(PlayerRenderer renderer) {
    List<LayerRenderer<AbstractClientPlayerEntity, PlayerModel<AbstractClientPlayerEntity>>> layers = (List<LayerRenderer<AbstractClientPlayerEntity, PlayerModel<AbstractClientPlayerEntity>>>)ObfuscationReflectionHelper.getPrivateValue(LivingRenderer.class, renderer, "field_177097_h");
    if (layers != null) {
    	layers.add(new <>((IEntityRenderer<AbstractClientPlayerEntity, PlayerModel<AbstractClientPlayerEntity>>)renderer));
    }
  }
}
