package me.HistoryMC_Arenas.APIs;

import java.io.File;
import java.io.IOException;

import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import me.HistoryMC_Arenas.HistoryMC_Arenas;

public class config_yml {
	
	public static File f;
	private static FileConfiguration config_yaml;
	
	 public static void criarArquivo() {
	    HistoryMC_Arenas.getInstance().saveDefaultConfig();
	    f = new File(HistoryMC_Arenas.getInstance().getDataFolder(), "config.yml");
	    if (!f.exists()) {
	      try {
	        f.createNewFile();
	      } catch (IOException var2) {
	        Bukkit.getConsoleSender().sendMessage("§cErro ao criar o arquivo config.yml");
	      }
	    }
	    config_yaml = YamlConfiguration.loadConfiguration(f);
	  }
	  
	  public static FileConfiguration getConfig() {
	    return config_yaml;
	  }
}
