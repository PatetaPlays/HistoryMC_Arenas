package me.HistoryMC_Arenas.Eventos;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

import me.HistoryMC_Arenas.Menu.MenuPrincipal;

public class aoQuitar implements Listener {
	
	@EventHandler
	public void aoSairEvent(PlayerQuitEvent e) {
		Player p = e.getPlayer();
		
		if(MenuPrincipal.arena_chain.contains(p.getName())) {
			MenuPrincipal.arena_chain.remove(p.getName());
			p.getInventory().clear();
			p.getInventory().getHelmet().setType(Material.AIR);
			p.getInventory().getChestplate().setType(Material.AIR);
			p.getInventory().getLeggings().setType(Material.AIR);
			p.getInventory().getBoots().setType(Material.AIR);
		}
		
		if(MenuPrincipal.arena_p2.contains(p.getName())) {
			MenuPrincipal.arena_p2.remove(p.getName());
		}
		
		if(MenuPrincipal.arena_p4.contains(p.getName())) {
			MenuPrincipal.arena_p4.remove(p.getName());
		}
	}
}
