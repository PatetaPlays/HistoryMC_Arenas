package me.HistoryMC_Arenas;

import org.bukkit.Bukkit;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import me.HistoryMC_Arenas.APIs.config_yml;
import me.HistoryMC_Arenas.Comandos.Comando;
import me.HistoryMC_Arenas.Eventos.aoEnviarComando;
import me.HistoryMC_Arenas.Eventos.aoMorrer;
import me.HistoryMC_Arenas.Eventos.aoQuitar;
import me.HistoryMC_Arenas.Eventos.aoTeleportar;
import me.HistoryMC_Arenas.Menu.MenuPrincipal;

public class HistoryMC_Arenas extends JavaPlugin {
	
	private static HistoryMC_Arenas plugin;
	ConsoleCommandSender cs = Bukkit.getConsoleSender();
	
	public void onEnable() {
		cs.sendMessage("§e[HistoryArenas] Plugin Ativado com Sucesso!");
		cs.sendMessage("§e[HistoryArenas] Criadores: §4PatetinhaaS2 §ee §4N0CRYB4BY");
		plugin = this;
		this.registrarComandos();
		this.registrarEventos();
		config_yml.criarArquivo();
	}
	
	public void onDisable() {
		cs.sendMessage("§e[History§6MC§e] Plugin Desativado com Sucesso!");
	}
	
	public void registrarEventos() {
		PluginManager pm = Bukkit.getPluginManager();
		pm.registerEvents(new MenuPrincipal(), this);
		pm.registerEvents(new aoEnviarComando(), this);
		pm.registerEvents(new aoMorrer(), this);
		pm.registerEvents(new aoQuitar(), this);
		pm.registerEvents(new aoTeleportar(), this);
	}
	
	public void registrarComandos() {
		getCommand("arenas").setExecutor(new Comando());
	}
	
	public static HistoryMC_Arenas getInstance() {
		return plugin;
	}
	

}
