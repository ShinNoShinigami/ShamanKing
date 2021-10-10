package net.shin.shamanking.procedures;

import net.shin.shamanking.item.OracleItem;
import net.shin.shamanking.ShamankingMod;

import net.minecraft.item.ItemStack;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;

import java.util.Map;

public class GUIButtonDisplayProcedure {
	public static boolean executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				ShamankingMod.LOGGER.warn("Failed to load dependency entity for procedure GUIButtonDisplay!");
			return false;
		}
		Entity entity = (Entity) dependencies.get("entity");
		if (((((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY).getItem() == OracleItem.block)
				|| (((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemOffhand() : ItemStack.EMPTY)
						.getItem() == OracleItem.block))) {
			return (true);
		}
		return (false);
	}
}
