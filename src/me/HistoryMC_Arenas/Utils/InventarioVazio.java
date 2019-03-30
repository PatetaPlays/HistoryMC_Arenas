package me.HistoryMC_Arenas.Utils;

import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class InventarioVazio {
	
	  public static boolean invVazio(Player p) {
		    boolean isEmpty = true;
		    ItemStack[] arrayOfItemStack;
		    int j = (arrayOfItemStack = p.getInventory().getContents()).length;
		    for (int i = 0; i < j; i++) {
		      ItemStack item = arrayOfItemStack[i];
		      if (item != null) {
		        isEmpty = false;
		        break;
		      }
		    }
		    if (isEmpty) {
		      if ((p.getInventory().getHelmet() == null) && (p.getInventory().getChestplate() == null) &&
		        (p.getInventory().getLeggings() == null) && (p.getInventory().getBoots() == null)) {
		        return true;
		      }
		      return false;
		    }
		    return false;
		  }

}
