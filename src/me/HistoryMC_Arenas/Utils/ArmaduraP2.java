package me.HistoryMC_Arenas.Utils;

import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class ArmaduraP2 {

	public static boolean seArmaduraForP2(Player player, ItemStack item, Enchantment enchant, int level, int max) {
		ItemStack[] inv = player.getInventory().getContents();
		int slots = inv.length;

		for (int i = 0; i < slots; i++) {
			ItemStack contents = inv[i];
			if ((contents != null)
					&& (contents.getType().equals(item.getType()) && (contents.getEnchantments().containsKey(enchant))
							&& (contents.getEnchantmentLevel(Enchantment.PROTECTION_ENVIRONMENTAL) > level
									|| contents.getEnchantmentLevel(Enchantment.PROTECTION_ENVIRONMENTAL) > max))) {
				return true;
			}
		}
		return false;
	}
}
