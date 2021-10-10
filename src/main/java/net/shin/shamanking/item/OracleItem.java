
package net.shin.shamanking.item;

import net.shin.shamanking.itemgroup.ShamanKingItemGroup;
import net.shin.shamanking.ShamankingModElements;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.item.Rarity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.block.BlockState;

@ShamankingModElements.ModElement.Tag
public class OracleItem extends ShamankingModElements.ModElement {
	@ObjectHolder("shamanking:oracle")
	public static final Item block = null;
	public OracleItem(ShamankingModElements instance) {
		super(instance, 29);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new ItemCustom());
	}
	public static class ItemCustom extends Item {
		public ItemCustom() {
			super(new Item.Properties().group(ShamanKingItemGroup.tab).maxStackSize(64).rarity(Rarity.COMMON));
			setRegistryName("oracle");
		}

		@Override
		public int getItemEnchantability() {
			return 0;
		}

		@Override
		public int getUseDuration(ItemStack itemstack) {
			return 0;
		}

		@Override
		public float getDestroySpeed(ItemStack par1ItemStack, BlockState par2Block) {
			return 1F;
		}
	}
}
