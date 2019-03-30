package me.HistoryMC_Arenas.Comandos;

import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.HistoryMC_Arenas.APIs.Locations;
import me.HistoryMC_Arenas.Menu.MenuPrincipal;

public class Comando implements CommandExecutor {
	// viadagem U.u
	String prefix = "§e[History§6MC§e] ";
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if(!(sender instanceof Player)) {
			sender.sendMessage("§e[History§6MC§e] Este comando não pode ser utilizado pelo console.");
			return true;
		}
		Player p = (Player)sender;
		if(args.length == 0) {
			if(cmd.getName().equalsIgnoreCase("arenas")) {
				MenuPrincipal.openMenu(p);
				p.sendMessage("§e[History§6MC§e] Você abriu o menu de arenas!");
				p.playSound(p.getLocation(), Sound.LEVEL_UP, 1.0F, 1.0F);
				return true;
			}
		}
		
		if(args[0].equalsIgnoreCase("sair")) {
			
			if(MenuPrincipal.arena_chain.contains(p.getName())) {
				p.chat("/spawn");
				p.sendMessage(prefix + "§eVocê deixou à arena!");
				p.getInventory().clear();
				MenuPrincipal.arena_chain.remove(p.getName());
				return true;
				
			}else if(!MenuPrincipal.arena_chain.contains(p.getName())) {
				p.sendMessage(prefix + "§eComo sair de algo que você nem entrou ?");
				return true;
			}
			
			if(MenuPrincipal.arena_p2.contains(p.getName())) {
				p.chat("/spawn");
				p.sendMessage(prefix + "§eVocê deixou à arena!");
				MenuPrincipal.arena_p2.remove(p.getName());
				return true;
				
			}else if(!MenuPrincipal.arena_p2.contains(p.getName())) {
				p.sendMessage(prefix + "§eComo sair de algo que você nem entrou ?");
				return true;
			}

			if(MenuPrincipal.arena_p4.contains(p.getName())) {
				p.chat("/spawn");
				p.sendMessage(prefix + "§eVocê deixou à arena!");
				MenuPrincipal.arena_p4.remove(p.getName());
				return true;
				
	
			}else if(!MenuPrincipal.arena_p4.contains(p.getName())) {
				p.sendMessage(prefix + "§eComo sair de algo que você nem entrou ?");
				return true;
			}
			
		}
		
		if(args[0].equalsIgnoreCase("ajuda")) {
			if(p.hasPermission("HistoryMC.Admin")) {
				p.sendMessage("§e[History§6MC§e] Comandos:");
				p.sendMessage("§e[History§6MC§e] /arenas setar <chain, p2, p4 > §8- §7Use para setar as arenas.");
			}else {
				p.sendMessage("§e[History§6MC§e] Você não tem permissão para isso!");
			}
		}
		
		if(args[0].equalsIgnoreCase("setar")) {
			
			if(args[1].equalsIgnoreCase("chain")) {
				if(p.hasPermission("HistoryMC.Admin")) {
					Locations.setArenaChain(p);
					p.sendMessage(prefix + "§eVocê setou a arena Chain!");
				}else {
					p.sendMessage(prefix + "§eVocê não tem permissão para isso!");
					return true;
				}
			}
			
			if(args[1].equalsIgnoreCase("p2")) {
				if(p.hasPermission("HistoryMC.Admin")) {
					Locations.setArenaP2(p);
					p.sendMessage(prefix + "§eVocê setou a arena P2!");
				}else {
					p.sendMessage(prefix + "§eVocê não tem permissão para isso!");
					return true;
				}
			}
			
			if(args[1].equalsIgnoreCase("p4")) {
				if(p.hasPermission("HistoryMC.Admin")) {
					Locations.setArenaP4(p);
					p.sendMessage(prefix + "§eVocê setou a arena P4!");
				}else {
					p.sendMessage(prefix + "§eVocê não tem permissão para isso!");
					return true;
				}
			}
		
		
	}
		return false;
  }
}
