package net.shin.shamanking.procedures;

import net.shin.shamanking.ShamankingModVariables;
import net.shin.shamanking.ShamankingMod;

import net.minecraft.entity.passive.TameableEntity;
import net.minecraft.entity.Entity;

import java.util.Map;

public class Spirit1FollowProcedure {
	public static boolean executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				ShamankingMod.LOGGER.warn("Failed to load dependency entity for procedure Spirit1Follow!");
			return false;
		}
		Entity entity = (Entity) dependencies.get("entity");
		if ((((((entity instanceof TameableEntity) ? ((TameableEntity) entity).getOwner() : null)
				.getCapability(ShamankingModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new ShamankingModVariables.PlayerVariables())).Spirit1Follow) == (true))) {
			return (true);
		}
		return (false);
	}
}
