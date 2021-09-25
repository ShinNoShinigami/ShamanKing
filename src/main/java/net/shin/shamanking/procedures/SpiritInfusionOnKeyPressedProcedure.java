package net.shin.shamanking.procedures;

import net.shin.shamanking.item.AmidamaruSpiritItem;
import net.shin.shamanking.ShamankingModVariables;
import net.shin.shamanking.ShamankingMod;

import net.minecraft.util.Hand;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;

import java.util.Map;

public class SpiritInfusionOnKeyPressedProcedure {
	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				ShamankingMod.LOGGER.warn("Failed to load dependency entity for procedure SpiritInfusionOnKeyPressed!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		if (((((entity.getCapability(ShamankingModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new ShamankingModVariables.PlayerVariables())).SpiritInfused)).equals("None"))) {
			if ((((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY)
					.getItem() == AmidamaruSpiritItem.block)) {
				if (entity instanceof LivingEntity) {
					ItemStack _setstack = (ItemStack.EMPTY);
					_setstack.setCount((int) 1);
					((LivingEntity) entity).setHeldItem(Hand.MAIN_HAND, _setstack);
					if (entity instanceof ServerPlayerEntity)
						((ServerPlayerEntity) entity).inventory.markDirty();
				}
				{
					boolean _setval = (boolean) (true);
					entity.getCapability(ShamankingModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.AmidamaruInUse = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				{
					String _setval = (String) "Amidamaru";
					entity.getCapability(ShamankingModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.SpiritInfused = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			}
		} else if (((((entity.getCapability(ShamankingModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new ShamankingModVariables.PlayerVariables())).SpiritInfused)).equals("Amidamaru"))) {
			if (entity instanceof LivingEntity) {
				ItemStack _setstack = new ItemStack(AmidamaruSpiritItem.block);
				_setstack.setCount((int) 1);
				((LivingEntity) entity).setHeldItem(Hand.MAIN_HAND, _setstack);
				if (entity instanceof ServerPlayerEntity)
					((ServerPlayerEntity) entity).inventory.markDirty();
			}
			{
				boolean _setval = (boolean) (false);
				entity.getCapability(ShamankingModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.AmidamaruInUse = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			{
				String _setval = (String) "None";
				entity.getCapability(ShamankingModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.SpiritInfused = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		} else {
			{
				String _setval = (String) "None";
				entity.getCapability(ShamankingModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.SpiritInfused = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		}
	}
}
