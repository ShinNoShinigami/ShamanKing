package net.shin.shamanking.procedures;

import net.shin.shamanking.item.AmidamaruSpiritItem;
import net.shin.shamanking.entity.AmidamaruEntity;
import net.shin.shamanking.ShamankingModVariables;
import net.shin.shamanking.ShamankingMod;

import net.minecraft.world.server.ServerWorld;
import net.minecraft.world.World;
import net.minecraft.world.IWorld;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.passive.TameableEntity;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.MobEntity;
import net.minecraft.entity.ILivingEntityData;
import net.minecraft.entity.Entity;

import java.util.function.Function;
import java.util.Map;
import java.util.Comparator;

public class AmidamaruSpiritRightClickedInAirProcedure {
	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				ShamankingMod.LOGGER.warn("Failed to load dependency entity for procedure AmidamaruSpiritRightClickedInAir!");
			return;
		}
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				ShamankingMod.LOGGER.warn("Failed to load dependency world for procedure AmidamaruSpiritRightClickedInAir!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		IWorld world = (IWorld) dependencies.get("world");
		if (world instanceof ServerWorld) {
			Entity entityToSpawn = new AmidamaruEntity.CustomEntity(AmidamaruEntity.entity, (World) world);
			entityToSpawn.setLocationAndAngles((entity.getPosX()), (entity.getPosY()), (entity.getPosZ()), world.getRandom().nextFloat() * 360F, 0);
			if (entityToSpawn instanceof MobEntity)
				((MobEntity) entityToSpawn).onInitialSpawn((ServerWorld) world, world.getDifficultyForLocation(entityToSpawn.getPosition()),
						SpawnReason.MOB_SUMMONED, (ILivingEntityData) null, (CompoundNBT) null);
			world.addEntity(entityToSpawn);
		}
		if ((((Entity) world
				.getEntitiesWithinAABB(AmidamaruEntity.CustomEntity.class,
						new AxisAlignedBB((entity.getPosX()) - (1 / 2d), (entity.getPosY()) - (1 / 2d), (entity.getPosZ()) - (1 / 2d),
								(entity.getPosX()) + (1 / 2d), (entity.getPosY()) + (1 / 2d), (entity.getPosZ()) + (1 / 2d)),
						null)
				.stream().sorted(new Object() {
					Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
						return Comparator.comparing((Function<Entity, Double>) (_entcnd -> _entcnd.getDistanceSq(_x, _y, _z)));
					}
				}.compareDistOf((entity.getPosX()), (entity.getPosY()), (entity.getPosZ()))).findFirst().orElse(null)) instanceof TameableEntity)
				&& (entity instanceof PlayerEntity)) {
			((TameableEntity) ((Entity) world
					.getEntitiesWithinAABB(AmidamaruEntity.CustomEntity.class,
							new AxisAlignedBB((entity.getPosX()) - (1 / 2d), (entity.getPosY()) - (1 / 2d), (entity.getPosZ()) - (1 / 2d),
									(entity.getPosX()) + (1 / 2d), (entity.getPosY()) + (1 / 2d), (entity.getPosZ()) + (1 / 2d)),
							null)
					.stream().sorted(new Object() {
						Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
							return Comparator.comparing((Function<Entity, Double>) (_entcnd -> _entcnd.getDistanceSq(_x, _y, _z)));
						}
					}.compareDistOf((entity.getPosX()), (entity.getPosY()), (entity.getPosZ()))).findFirst().orElse(null))).setTamed(true);
			((TameableEntity) ((Entity) world
					.getEntitiesWithinAABB(AmidamaruEntity.CustomEntity.class,
							new AxisAlignedBB((entity.getPosX()) - (1 / 2d), (entity.getPosY()) - (1 / 2d), (entity.getPosZ()) - (1 / 2d),
									(entity.getPosX()) + (1 / 2d), (entity.getPosY()) + (1 / 2d), (entity.getPosZ()) + (1 / 2d)),
							null)
					.stream().sorted(new Object() {
						Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
							return Comparator.comparing((Function<Entity, Double>) (_entcnd -> _entcnd.getDistanceSq(_x, _y, _z)));
						}
					}.compareDistOf((entity.getPosX()), (entity.getPosY()), (entity.getPosZ()))).findFirst().orElse(null)))
							.setTamedBy((PlayerEntity) entity);
		}
		{
			boolean _setval = (boolean) (true);
			entity.getCapability(ShamankingModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
				capability.AmidamaruUnlock = _setval;
				capability.syncPlayerVariables(entity);
			});
		}
		if (entity instanceof PlayerEntity) {
			ItemStack _stktoremove = new ItemStack(AmidamaruSpiritItem.block);
			((PlayerEntity) entity).inventory.func_234564_a_(p -> _stktoremove.getItem() == p.getItem(), (int) 1,
					((PlayerEntity) entity).container.func_234641_j_());
		}
	}
}
