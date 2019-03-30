package me.HistoryMC_Arenas.Eventos;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;

import me.HistoryMC_Arenas.Menu.MenuPrincipal;


public class aoEnviarComando implements Listener {
	
	@EventHandler
	public void aoEnviarCmd(PlayerCommandPreprocessEvent e) {
		Player p = e.getPlayer();
		if(MenuPrincipal.arena_chain.contains(p.getName()) && MenuPrincipal.arena_p2.contains(p.getName()) && MenuPrincipal.arena_p4.contains(p.getName())) {
			if(e.getMessage().contains("/") && !e.getMessage().equals("spawn")) {
				p.sendMessage("§e[History§6MC§e] §eVocê não pode digitar comandos enquanto estiver na arena!");
				e.setCancelled(true);
			}
		}
	}

}
