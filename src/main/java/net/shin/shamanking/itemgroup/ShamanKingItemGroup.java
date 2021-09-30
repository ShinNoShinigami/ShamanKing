
package net.shin.shamanking.itemgroup;

import net.shin.shamanking.item.AmidamaruSpiritItem;
import net.shin.shamanking.ShamankingModElements;

import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemGroup;

@ShamankingModElements.ModElement.Tag
public class ShamanKingItemGroup extends ShamankingModElements.ModElement {
	public ShamanKingItemGroup(ShamankingModElements instance) {
		super(instance, 15);
	}

	@Override
	public void initElements() {
		tab = new ItemGroup("tabshaman_king") {
			@OnlyIn(Dist.CLIENT)
			@Override
			public ItemStack createIcon() {
				return new ItemStack(AmidamaruSpiritItem.block);
			}

			@OnlyIn(Dist.CLIENT)
			public boolean hasSearchBar() {
				return false;
			}
		};
	}
	public static ItemGroup tab;
}
