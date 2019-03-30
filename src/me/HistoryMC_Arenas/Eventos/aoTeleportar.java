package me.HistoryMC_Arenas.Eventos;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerTeleportEvent;

import me.HistoryMC_Arenas.Menu.MenuPrincipal;

public class aoTeleportar implements Listener {
	
	@EventHandler
	public void aoTeleportarEvent(PlayerTeleportEvent e) {
		Player p = e.getPlayer();
		if(MenuPrincipal.arena_chain.contains(p.getName())) {
			MenuPrincipal.arena_chain.remove(p.getName());
			p.getInventory().clear();
			p.sendMessage("§e[History§6MC§e] §eVocê teleportou-se, e com isso deixou a arena!");
		}
		
		if(MenuPrincipal.arena_p2.contains(p.getName())) {
			MenuPrincipal.arena_p2.remove(p.getName());
			p.sendMessage("§e[History§6MC§e] §eVocê teleportou-se, e com isso deixou a arena!");
		}
		
		if(MenuPrincipal.arena_p4.contains(p.getName())) {
			MenuPrincipal.arena_chain.remove(p.getName());
			p.sendMessage("§e[History§6MC§e] §eVocê teleportou-se, e com isso deixou a arena!");
		}
		
	}
	

}
