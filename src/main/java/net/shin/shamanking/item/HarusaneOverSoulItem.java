
package net.shin.shamanking.item;

import net.shin.shamanking.procedures.HarusaneOverSoulToolInInventoryTickProcedure;
import net.shin.shamanking.ShamankingModElements;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.world.World;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.item.SwordItem;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.Item;
import net.minecraft.item.IItemTier;
import net.minecraft.entity.Entity;

import java.util.Map;
import java.util.HashMap;

@ShamankingModElements.ModElement.Tag
public class HarusaneOverSoulItem extends ShamankingModElements.ModElement {
	@ObjectHolder("shamanking:harusane_over_soul")
	public static final Item block = null;
	public HarusaneOverSoulItem(ShamankingModElements instance) {
		super(instance, 3);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new SwordItem(new IItemTier() {
			public int getMaxUses() {
				return 100;
			}

			public float getEfficiency() {
				return 4f;
			}

			public float getAttackDamage() {
				return 18f;
			}

			public int getHarvestLevel() {
				return 1;
			}

			public int getEnchantability() {
				return 2;
			}

			public Ingredient getRepairMaterial() {
				return Ingredient.EMPTY;
			}
		}, 3, 1f, new Item.Properties().group(ItemGroup.COMBAT)) {
			@Override
			public void inventoryTick(ItemStack itemstack, World world, Entity entity, int slot, boolean selected) {
				super.inventoryTick(itemstack, world, entity, slot, selected);
				double x = entity.getPosX();
				double y = entity.getPosY();
				double z = entity.getPosZ();
				{
					Map<String, Object> $_dependencies = new HashMap<>();
					$_dependencies.put("entity", entity);
					HarusaneOverSoulToolInInventoryTickProcedure.executeProcedure($_dependencies);
				}
			}
		}.setRegistryName("harusane_over_soul"));
	}
}
