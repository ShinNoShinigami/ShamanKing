package net.shin.shamanking.procedures;

import net.shin.shamanking.item.HarusaneOverSoulItem;
import net.shin.shamanking.ShamankingModVariables;
import net.shin.shamanking.ShamankingMod;

import net.minecraft.item.ItemStack;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.Entity;

import java.util.Map;

public class HarusaneOverSoulToolInInventoryTickProcedure {
	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				ShamankingMod.LOGGER.warn("Failed to load dependency entity for procedure HarusaneOverSoulToolInInventoryTick!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		if ((((entity.getCapability(ShamankingModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new ShamankingModVariables.PlayerVariables())).furyoku) > 0)) {
			{
				double _setval = (double) (((entity.getCapability(ShamankingModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new ShamankingModVariables.PlayerVariables())).furyoku) - 1);
				entity.getCapability(ShamankingModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.furyoku = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		} else {
			if (entity instanceof PlayerEntity) {
				ItemStack _stktoremove = new ItemStack(HarusaneOverSoulItem.block);
				((PlayerEntity) entity).inventory.func_234564_a_(p -> _stktoremove.getItem() == p.getItem(), (int) 1,
						((PlayerEntity) entity).container.func_234641_j_());
			}
		}
	}
}
