package net.shin.shamanking.procedures;

import net.shin.shamanking.ShamankingMod;

import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.entity.passive.TameableEntity;
import net.minecraft.entity.Entity;

import java.util.Map;
import java.util.Collections;

public class SpiritMoveProcedure {
	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				ShamankingMod.LOGGER.warn("Failed to load dependency entity for procedure SpiritMove!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		{
			Entity _ent = entity;
			_ent.setPositionAndUpdate(((((entity instanceof TameableEntity) ? ((TameableEntity) entity).getOwner() : null).getPosX()) + 2),
					((((entity instanceof TameableEntity) ? ((TameableEntity) entity).getOwner() : null).getPosY()) + 1),
					((((entity instanceof TameableEntity) ? ((TameableEntity) entity).getOwner() : null).getPosZ()) + 1));
			if (_ent instanceof ServerPlayerEntity) {
				((ServerPlayerEntity) _ent).connection.setPlayerLocation(
						((((entity instanceof TameableEntity) ? ((TameableEntity) entity).getOwner() : null).getPosX()) + 2),
						((((entity instanceof TameableEntity) ? ((TameableEntity) entity).getOwner() : null).getPosY()) + 1),
						((((entity instanceof TameableEntity) ? ((TameableEntity) entity).getOwner() : null).getPosZ()) + 1), _ent.rotationYaw,
						_ent.rotationPitch, Collections.emptySet());
			}
		}
	}
}
