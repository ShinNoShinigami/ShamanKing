package net.shin.shamanking.procedures;

import net.shin.shamanking.item.AmidamaruSpiritItem;
import net.shin.shamanking.entity.AmidamaruEntity;
import net.shin.shamanking.ShamankingModVariables;
import net.shin.shamanking.ShamankingMod;

import net.minecraftforge.items.ItemHandlerHelper;

import net.minecraft.world.IWorld;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.Entity;

import java.util.function.Function;
import java.util.Map;
import java.util.Comparator;

public class AmidamaruUnlockProcedure {
	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				ShamankingMod.LOGGER.warn("Failed to load dependency entity for procedure AmidamaruUnlock!");
			return;
		}
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				ShamankingMod.LOGGER.warn("Failed to load dependency world for procedure AmidamaruUnlock!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		IWorld world = (IWorld) dependencies.get("world");
		{
			boolean _setval = (boolean) (true);
			entity.getCapability(ShamankingModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
				capability.AmidamaruUnlock = _setval;
				capability.syncPlayerVariables(entity);
			});
		}
		if (entity instanceof PlayerEntity)
			((PlayerEntity) entity).closeScreen();
		if (entity instanceof PlayerEntity) {
			ItemStack _setstack = new ItemStack(AmidamaruSpiritItem.block);
			_setstack.setCount((int) 1);
			ItemHandlerHelper.giveItemToPlayer(((PlayerEntity) entity), _setstack);
		}
		if (!((Entity) world
				.getEntitiesWithinAABB(AmidamaruEntity.CustomEntity.class,
						new AxisAlignedBB((entity.getPosX()) - (4 / 2d), (entity.getPosY()) - (4 / 2d), (entity.getPosZ()) - (4 / 2d),
								(entity.getPosX()) + (4 / 2d), (entity.getPosY()) + (4 / 2d), (entity.getPosZ()) + (4 / 2d)),
						null)
				.stream().sorted(new Object() {
					Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
						return Comparator.comparing((Function<Entity, Double>) (_entcnd -> _entcnd.getDistanceSq(_x, _y, _z)));
					}
				}.compareDistOf((entity.getPosX()), (entity.getPosY()), (entity.getPosZ()))).findFirst().orElse(null)).world.isRemote())
			((Entity) world
					.getEntitiesWithinAABB(AmidamaruEntity.CustomEntity.class,
							new AxisAlignedBB((entity.getPosX()) - (4 / 2d), (entity.getPosY()) - (4 / 2d), (entity.getPosZ()) - (4 / 2d),
									(entity.getPosX()) + (4 / 2d), (entity.getPosY()) + (4 / 2d), (entity.getPosZ()) + (4 / 2d)),
							null)
					.stream().sorted(new Object() {
						Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
							return Comparator.comparing((Function<Entity, Double>) (_entcnd -> _entcnd.getDistanceSq(_x, _y, _z)));
						}
					}.compareDistOf((entity.getPosX()), (entity.getPosY()), (entity.getPosZ()))).findFirst().orElse(null)).remove();
	}
}
