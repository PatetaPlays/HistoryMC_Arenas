package me.HistoryMC_Arenas.Eventos;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;

import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;

import me.HistoryMC_Arenas.APIs.config_yml;


import me.HistoryMC_Arenas.Menu.MenuPrincipal;

public class aoMorrer implements Listener {
	
	@EventHandler
	public void onDeathEvent(PlayerDeathEvent e) {
		Player p = e.getEntity();
		
		if(MenuPrincipal.arena_chain.contains(p.getName())) {
			p.getInventory().clear();
			p.sendMessage(config_yml.getConfig().getString("Morreu_e_Matou.Morreu").replace("&", "§").replace("@matador", p.getKiller().getName()));
			p.getKiller().sendMessage(config_yml.getConfig().getString("Morreu_e_Matou.Matou").replace("&", "§").replace("@morreu", p.getName()));
			MenuPrincipal.arena_chain.remove(p.getName());
		}
		
		if(MenuPrincipal.arena_p2.contains(p.getName())) {
			p.sendMessage(config_yml.getConfig().getString("Morreu_e_Matou.Morreu").replace("&", "§").replace("@matador", p.getKiller().getName()));
			p.getKiller().sendMessage(config_yml.getConfig().getString("Morreu_e_Matou.Matou").replace("&", "§").replace("@morreu", p.getName()));
			MenuPrincipal.arena_p2.remove(p.getName());
		}
		// no arquivo de config eu deixei um exemplo lá...
		
		if(MenuPrincipal.arena_p4.contains(p.getName())) {
			p.sendMessage(config_yml.getConfig().getString("Morreu_e_Matou.Morreu").replace("&", "§").replace("@matador", p.getKiller().getName()));
			p.getKiller().sendMessage(config_yml.getConfig().getString("Morreu_e_Matou.Matou").replace("&", "§").replace("@morreu", p.getName()));
			MenuPrincipal.arena_p4.remove(p.getName());
		}
	}

}
