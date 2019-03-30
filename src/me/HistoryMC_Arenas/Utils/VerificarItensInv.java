package me.HistoryMC_Arenas.Utils;


import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class VerificarItensInv {
	
	
	public static boolean seContemItensEnchants(Player p) {
		Inventory inv = p.getInventory();
		for(ItemStack inven : inv.getContents()) {
			if((inven.getType().equals(Material.DIAMOND_HELMET) &&
			   (inven.getType().equals(Material.DIAMOND_CHESTPLATE) &&
			   (inven.getType().equals(Material.DIAMOND_LEGGINGS) &&
			   (inven.getType().equals(Material.DIAMOND_BOOTS)))))) {
				if(inven.containsEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL)) {
					if(inven.getEnchantmentLevel(Enchantment.PROTECTION_ENVIRONMENTAL) > 2) {
						return false;
					}
				}
			}
		}
		return true;
	}

}
