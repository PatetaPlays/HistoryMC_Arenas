package me.HistoryMC_Arenas.APIs;

import java.io.IOException;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Player;

public class Locations {

	public static Location getArenaChain() {

		Location teleporte = new Location(Bukkit.getWorld(config_yml.getConfig().getString("Arenas.Chain.World")),
				config_yml.getConfig().getDouble("Arenas.Chain.X"), config_yml.getConfig().getDouble("Arenas.Chain.Y"),
				config_yml.getConfig().getDouble("Arenas.Chain.Z"));
		teleporte.setYaw(config_yml.getConfig().getInt("Arenas.Chain.Yaw"));
		teleporte.setPitch(config_yml.getConfig().getInt("Arenas.Chain.Pitch"));
		return teleporte;

	}

	public static void setArenaChain(Player p) {
		try {
			config_yml.getConfig().set("Arenas.Chain.World", p.getWorld().getName());
			config_yml.getConfig().set("Arenas.Chain.X", p.getLocation().getX());
			config_yml.getConfig().set("Arenas.Chain.Y", p.getLocation().getY());
			config_yml.getConfig().set("Arenas.Chain.Z", p.getLocation().getZ());
			config_yml.getConfig().set("Arenas.Chain.Yaw", p.getLocation().getYaw());
			config_yml.getConfig().set("Arenas.Chain.Pitch", p.getLocation().getPitch());
			config_yml.getConfig().save(config_yml.f);
		} catch (IOException e) {
			Bukkit.getConsoleSender().sendMessage("§e[History§6MC§e] ERRO AO SALVAR A CONFIG.YML!");
			Bukkit.getConsoleSender().sendMessage("§e[History§6MC§e] ERRO AO SALVAR A CONFIG.YML!");
			Bukkit.getConsoleSender().sendMessage("§e[History§6MC§e] ERRO AO SALVAR A CONFIG.YML!");
		}

	}

	public static Location getArenaP2() {

		Location teleporte2 = new Location(Bukkit.getWorld(config_yml.getConfig().getString("Arenas.P2.World")),
				config_yml.getConfig().getDouble("Arenas.P2.X"), config_yml.getConfig().getDouble("Arenas.P2.Y"),
				config_yml.getConfig().getDouble("Arenas.P2.Z"));
		teleporte2.setYaw(config_yml.getConfig().getInt("Arenas.P2.Yaw"));
		teleporte2.setPitch(config_yml.getConfig().getInt("Arenas.P2.Pitch"));
		return teleporte2;
	}

	public static void setArenaP2(Player p) {
		try {
			config_yml.getConfig().set("Arenas.P2.World", p.getWorld().getName());
			config_yml.getConfig().set("Arenas.P2.X", p.getLocation().getX());
			config_yml.getConfig().set("Arenas.P2.Y", p.getLocation().getY());
			config_yml.getConfig().set("Arenas.P2.Z", p.getLocation().getZ());
			config_yml.getConfig().set("Arenas.P2.Yaw", p.getLocation().getYaw());
			config_yml.getConfig().set("Arenas.P2.Pitch", p.getLocation().getPitch());
			config_yml.getConfig().save(config_yml.f);
		} catch (IOException e) {
			Bukkit.getConsoleSender().sendMessage("§e[History§6MC§e] ERRO AO SALVAR A CONFIG.YML!");
			Bukkit.getConsoleSender().sendMessage("§e[History§6MC§e] ERRO AO SALVAR A CONFIG.YML!");
			Bukkit.getConsoleSender().sendMessage("§e[History§6MC§e] ERRO AO SALVAR A CONFIG.YML!");
		}
	}

	public static Location getArenaP4() {
		Location teleporte3 = new Location(Bukkit.getWorld(config_yml.getConfig().getString("Arenas.P4.World")),
				config_yml.getConfig().getDouble("Arenas.P4.X"), config_yml.getConfig().getDouble("Arenas.P4.Y"),
				config_yml.getConfig().getDouble("Arenas.P4.Z"));
		teleporte3.setYaw(config_yml.getConfig().getInt("Arenas.P4.Yaw"));
		teleporte3.setPitch(config_yml.getConfig().getInt("Arenas.P4.Pitch"));
		return teleporte3;
	}

	public static void setArenaP4(Player p) {
		try {
			config_yml.getConfig().set("Arenas.P4.World", p.getWorld().getName());
			config_yml.getConfig().set("Arenas.P4.X", p.getLocation().getX());
			config_yml.getConfig().set("Arenas.P4.Y", p.getLocation().getY());
			config_yml.getConfig().set("Arenas.P4.Z", p.getLocation().getZ());
			config_yml.getConfig().set("Arenas.P4.Yaw", p.getLocation().getYaw());
			config_yml.getConfig().set("Arenas.P4.Pitch", p.getLocation().getPitch());
			config_yml.getConfig().save(config_yml.f);
		} catch (IOException e) {
			Bukkit.getConsoleSender().sendMessage("§e[History§6MC§e] ERRO AO SALVAR A CONFIG.YML!");
			Bukkit.getConsoleSender().sendMessage("§e[History§6MC§e] ERRO AO SALVAR A CONFIG.YML!");
			Bukkit.getConsoleSender().sendMessage("§e[History§6MC§e] ERRO AO SALVAR A CONFIG.YML!");
		}
	}

}
