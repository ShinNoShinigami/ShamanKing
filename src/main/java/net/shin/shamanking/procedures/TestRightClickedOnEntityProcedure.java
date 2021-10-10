package net.shin.shamanking.procedures;

import net.shin.shamanking.item.AmidamaruSpiritItem;
import net.shin.shamanking.gui.AmidamaruObtainGUIGui;
import net.shin.shamanking.ShamankingModVariables;
import net.shin.shamanking.ShamankingMod;

import net.minecraftforge.fml.network.NetworkHooks;

import net.minecraft.world.IWorld;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.Hand;
import net.minecraft.network.PacketBuffer;
import net.minecraft.item.ItemStack;
import net.minecraft.inventory.container.INamedContainerProvider;
import net.minecraft.inventory.container.Container;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.passive.TameableEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;

import java.util.Map;

import io.netty.buffer.Unpooled;

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
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				ShamankingMod.LOGGER.warn("Failed to load dependency x for procedure TestRightClickedOnEntity!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				ShamankingMod.LOGGER.warn("Failed to load dependency y for procedure TestRightClickedOnEntity!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				ShamankingMod.LOGGER.warn("Failed to load dependency z for procedure TestRightClickedOnEntity!");
			return;
		}
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				ShamankingMod.LOGGER.warn("Failed to load dependency world for procedure TestRightClickedOnEntity!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		Entity sourceentity = (Entity) dependencies.get("sourceentity");
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		IWorld world = (IWorld) dependencies.get("world");
		if ((((entity.getCapability(ShamankingModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new ShamankingModVariables.PlayerVariables())).AmidamaruUnlock) == (false))) {
			{
				Entity _ent = entity;
				if (_ent instanceof ServerPlayerEntity) {
					BlockPos _bpos = new BlockPos((int) x, (int) y, (int) z);
					NetworkHooks.openGui((ServerPlayerEntity) _ent, new INamedContainerProvider() {
						@Override
						public ITextComponent getDisplayName() {
							return new StringTextComponent("AmidamaruObtainGUI");
						}

						@Override
						public Container createMenu(int id, PlayerInventory inventory, PlayerEntity player) {
							return new AmidamaruObtainGUIGui.GuiContainerMod(id, inventory, new PacketBuffer(Unpooled.buffer()).writeBlockPos(_bpos));
						}
					}, _bpos);
				}
			}
		} else if ((((entity.getCapability(ShamankingModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new ShamankingModVariables.PlayerVariables())).AmidamaruUnlock) == (true))) {
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
				}
			}
		}
	}
}
