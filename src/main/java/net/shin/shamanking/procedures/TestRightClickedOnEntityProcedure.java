package net.shin.shamanking.procedures;

import net.shin.shamanking.item.AmidamaruSpiritItem;
import net.shin.shamanking.ShamankingMod;

import net.minecraft.util.Hand;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.entity.passive.TameableEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;

import java.util.Map;

public class TestRightClickedOnEntityProcedure {
	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				ShamankingMod.LOGGER.warn("Failed to load dependency entity for procedure TestRightClickedOnEntity!");
			return;
		}
		if (dependencies.get("sourceentity") == null) {
			if (!dependencies.containsKey("sourceentity"))
				ShamankingMod.LOGGER.warn("Failed to load dependency sourceentity for procedure TestRightClickedOnEntity!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		Entity sourceentity = (Entity) dependencies.get("sourceentity");
		if ((((sourceentity instanceof LivingEntity) ? ((LivingEntity) sourceentity).getHeldItemMainhand() : ItemStack.EMPTY)
				.getItem() == (ItemStack.EMPTY).getItem())) {
			if ((((entity instanceof TameableEntity) ? ((TameableEntity) entity).getOwner() : null) == sourceentity)) {
				if (!entity.world.isRemote())
					entity.remove();
				if (sourceentity instanceof LivingEntity) {
					ItemStack _setstack = new ItemStack(AmidamaruSpiritItem.block);
					_setstack.setCount((int) 1);
					((LivingEntity) sourceentity).setHeldItem(Hand.MAIN_HAND, _setstack);
					if (sourceentity instanceof ServerPlayerEntity)
						((ServerPlayerEntity) sourceentity).inventory.markDirty();
				}
				((sourceentity instanceof LivingEntity) ? ((LivingEntity) sourceentity).getHeldItemMainhand() : ItemStack.EMPTY).getOrCreateTag()
						.putString("Spirit", "Amidamaru");
			}
		}
	}
}
