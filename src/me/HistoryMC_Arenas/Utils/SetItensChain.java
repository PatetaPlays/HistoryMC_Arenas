package me.HistoryMC_Arenas.Utils;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class SetItensChain {
	
	
	public static void SetarItensChain(Player p) {
		
		p.getEquipment().setHelmet(new ItemStack(Material.CHAINMAIL_HELMET));
		p.getEquipment().setChestplate(new ItemStack(Material.CHAINMAIL_CHESTPLATE));
		p.getEquipment().setLeggings(new ItemStack(Material.CHAINMAIL_LEGGINGS));
		p.getEquipment().setBoots(new ItemStack(Material.CHAINMAIL_BOOTS));
		p.getInventory().setItem(0, new ItemStack(Material.STONE_SWORD));
		p.getInventory().setItem(1, new ItemStack(Material.GOLDEN_APPLE, 16));
		
	}

}
