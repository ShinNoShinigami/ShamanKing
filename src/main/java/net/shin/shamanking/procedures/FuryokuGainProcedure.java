package net.shin.shamanking.procedures;

import net.shin.shamanking.ShamankingModVariables;
import net.shin.shamanking.ShamankingMod;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.entity.living.LivingDeathEvent;

import net.minecraft.world.World;
import net.minecraft.entity.Entity;

import java.util.Map;
import java.util.HashMap;

public class FuryokuGainProcedure {
	@Mod.EventBusSubscriber
	private static class GlobalTrigger {
		@SubscribeEvent
		public static void onEntityDeath(LivingDeathEvent event) {
			if (event != null && event.getEntity() != null) {
				Entity entity = event.getEntity();
				Entity sourceentity = event.getSource().getTrueSource();
				double i = entity.getPosX();
				double j = entity.getPosY();
				double k = entity.getPosZ();
				World world = entity.world;
				Map<String, Object> dependencies = new HashMap<>();
				dependencies.put("x", i);
				dependencies.put("y", j);
				dependencies.put("z", k);
				dependencies.put("world", world);
				dependencies.put("entity", entity);
				dependencies.put("sourceentity", sourceentity);
				dependencies.put("event", event);
				executeProcedure(dependencies);
			}
		}
	}
	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("sourceentity") == null) {
			if (!dependencies.containsKey("sourceentity"))
				ShamankingMod.LOGGER.warn("Failed to load dependency sourceentity for procedure FuryokuGain!");
			return;
		}
		Entity sourceentity = (Entity) dependencies.get("sourceentity");
		if ((((sourceentity.getCapability(ShamankingModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new ShamankingModVariables.PlayerVariables())).furyoku) < ((sourceentity
						.getCapability(ShamankingModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new ShamankingModVariables.PlayerVariables())).furyokumax))) {
			{
				double _setval = (double) (((sourceentity.getCapability(ShamankingModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new ShamankingModVariables.PlayerVariables())).furyoku) + 1);
				sourceentity.getCapability(ShamankingModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.furyoku = _setval;
					capability.syncPlayerVariables(sourceentity);
				});
			}
		}
	}
}
