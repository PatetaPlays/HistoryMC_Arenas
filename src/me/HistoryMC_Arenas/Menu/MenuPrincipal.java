package me.HistoryMC_Arenas.Menu;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import me.HistoryMC_Arenas.APIs.ItemBuilder;
import me.HistoryMC_Arenas.APIs.Locations;
import me.HistoryMC_Arenas.APIs.config_yml;
import me.HistoryMC_Arenas.Utils.ArmaduraP2;
import me.HistoryMC_Arenas.Utils.ArmaduraP4;
import me.HistoryMC_Arenas.Utils.InventarioVazio;
import me.HistoryMC_Arenas.Utils.SetItensChain;

public class MenuPrincipal implements Listener {

	String prefix = "§e[History§6MC§e] ";
	public static ArrayList<String> arena_chain = new ArrayList<String>();
	public static ArrayList<String> arena_p2 = new ArrayList<String>();
	public static ArrayList<String> arena_p4 = new ArrayList<String>();

	public static void openMenu(Player p) {
		Inventory inv = Bukkit.createInventory(null, 3 * 9, "§8Arenas");

		inv.setItem(0,
				new ItemBuilder(Material.CHAINMAIL_CHESTPLATE).durability(3).name("§eArena Chain")
						.lore("§7Nesta arena é permitido somente o uso de armadura de Chain, seu inventário",
								"§7deverá estar vazio, e os itens serão setados em você ao entrar.",
								"§aJogadores na Arena: §7" + arena_chain.size())

						.build());

		inv.setItem(1,
				new ItemBuilder(Material.NETHER_BRICK).durability(3).name("§eArena P2")
						.lore("§7Nesta arena é permitido somente o uso de armadura",
								"§7de diamante Protection 2 Umbreaking 2 ou inferior.",
								"§aJogadores na Arena: §7" + arena_p2.size())

						.build());

		inv.setItem(2,
				new ItemBuilder(Material.PACKED_ICE).durability(3).name("§eArena P4")
						.lore("§7Nesta arena é permitido somente o uso de armadura",
								"§7de diamante Protection 4 Umbreaking 4 ou inferior.",
								"§aJogadores na Arena: §7" + arena_p4.size())

						.build());

		p.openInventory(inv);
	}

	@EventHandler
	public void onInteractMenu(InventoryClickEvent e) {
		Player p = (Player) e.getWhoClicked();
		if (e.getInventory().getName().equalsIgnoreCase("§8Arenas")) {
			if ((e.getCurrentItem() == null) || (e.getCurrentItem().getType() == Material.AIR)) {
				e.setCancelled(true);
				return;
			}
			e.setCancelled(true);
			ItemStack item = e.getCurrentItem();

			if ((item.getType() == Material.CHAINMAIL_CHESTPLATE) && (item.hasItemMeta())
					&& (item.getItemMeta().hasDisplayName())
					&& (item.getItemMeta().getDisplayName().equalsIgnoreCase("§eArena Chain"))) {

				if (config_yml.getConfig().contains("Arenas.Chain")) {
					if (InventarioVazio.invVazio(p) == true) {
						p.teleport(Locations.getArenaChain());
						SetItensChain.SetarItensChain(p);
						arena_chain.add(p.getName());
						p.sendMessage(prefix + "§eVocê teleportou-se até a arena Chain!");
					} else if (InventarioVazio.invVazio(p) == false) {
						p.sendMessage(prefix + "§eVocê deve estar com seu inventário vazio para entrar nesta arena!");
					}
				} else if (!config_yml.getConfig().contains("Arenas.Chain")) {
					p.sendMessage(prefix + "§eEsta arena ainda não foi setada!");
					p.sendMessage(prefix + "§eProcure um administrador para que possa seta-lá!");
				}
			}

			if ((item.getType() == Material.NETHER_BRICK) && (item.hasItemMeta())
					&& (item.getItemMeta().hasDisplayName())
					&& (item.getItemMeta().getDisplayName().equalsIgnoreCase("§eArena P2"))) {
				int min = 0;
				int max = 2;
				ItemStack cap = p.getInventory().getHelmet();
				ItemStack pei = p.getInventory().getChestplate();
				ItemStack cal = p.getInventory().getLeggings();
				ItemStack bot = p.getInventory().getBoots();
				if (config_yml.getConfig().contains("Arenas.P2")) {
					if (p.isOp()) {
						p.teleport(Locations.getArenaP2());
					}
					if (cap != null && pei != null && cal != null && bot != null
							&& cap.getType() == Material.DIAMOND_HELMET && pei.getType() == Material.DIAMOND_CHESTPLATE
							&& cal.getType() == Material.DIAMOND_LEGGINGS && bot.getType() == Material.DIAMOND_BOOTS
							&& cap.getItemMeta().getEnchantLevel(Enchantment.PROTECTION_ENVIRONMENTAL) >= min
							&& cap.getItemMeta().getEnchantLevel(Enchantment.PROTECTION_ENVIRONMENTAL) <= max
							&& pei.getItemMeta().getEnchantLevel(Enchantment.PROTECTION_ENVIRONMENTAL) >= min
							&& pei.getItemMeta().getEnchantLevel(Enchantment.PROTECTION_ENVIRONMENTAL) <= max
							&& cal.getItemMeta().getEnchantLevel(Enchantment.PROTECTION_ENVIRONMENTAL) >= min
							&& cal.getItemMeta().getEnchantLevel(Enchantment.PROTECTION_ENVIRONMENTAL) <= max
							&& bot.getItemMeta().getEnchantLevel(Enchantment.PROTECTION_ENVIRONMENTAL) >= min
							&& bot.getItemMeta().getEnchantLevel(Enchantment.PROTECTION_ENVIRONMENTAL) <= max
							&& !ArmaduraP2.seArmaduraForP2(p, new ItemStack(Material.DIAMOND_HELMET),
									Enchantment.PROTECTION_ENVIRONMENTAL, max, max)
							&& !ArmaduraP2.seArmaduraForP2(p, new ItemStack(Material.DIAMOND_CHESTPLATE),
									Enchantment.PROTECTION_ENVIRONMENTAL, max, max)
							&& !ArmaduraP2.seArmaduraForP2(p, new ItemStack(Material.DIAMOND_LEGGINGS),
									Enchantment.PROTECTION_ENVIRONMENTAL, max, max)
							&& !ArmaduraP2.seArmaduraForP2(p, new ItemStack(Material.DIAMOND_BOOTS),
									Enchantment.PROTECTION_ENVIRONMENTAL, max, max)) {
						p.teleport(Locations.getArenaP2());
						arena_p2.add(p.getName());
						p.sendMessage(prefix + "§eVocê entrou na arena P2!");
					} else {
						p.sendMessage(prefix
								+ "§eVocê está usando um item que não é permitido nesta arena, ou em seu inventário contém algum item inválido!");
						return;
					}
				} else if (!config_yml.getConfig().contains("Arenas.P2")) {
					p.sendMessage(prefix + "§eEsta arena ainda não foi setada!");
					p.sendMessage(prefix + "§eProcure um administrador para que possa seta-lá!");
				}

			}

			if ((item.getType() == Material.PACKED_ICE) && (item.hasItemMeta()) && (item.getItemMeta().hasDisplayName())
					&& (item.getItemMeta().getDisplayName().equalsIgnoreCase("§eArena P4"))) {
				int min = 3;
				int max = 4;
				ItemStack cap = p.getInventory().getHelmet();
				ItemStack pei = p.getInventory().getChestplate();
				ItemStack cal = p.getInventory().getLeggings();
				ItemStack bot = p.getInventory().getBoots();
				if (config_yml.getConfig().contains("Arenas.P4")) {
					if (p.isOp()) {
						p.teleport(Locations.getArenaP2());
					}
					if (cap != null && pei != null && cal != null && bot != null
							&& cap.getItemMeta().getEnchantLevel(Enchantment.PROTECTION_ENVIRONMENTAL) >= min
							&& cap.getItemMeta().getEnchantLevel(Enchantment.PROTECTION_ENVIRONMENTAL) <= max
							&& pei.getItemMeta().getEnchantLevel(Enchantment.PROTECTION_ENVIRONMENTAL) >= min
							&& pei.getItemMeta().getEnchantLevel(Enchantment.PROTECTION_ENVIRONMENTAL) <= max
							&& cal.getItemMeta().getEnchantLevel(Enchantment.PROTECTION_ENVIRONMENTAL) >= min
							&& cal.getItemMeta().getEnchantLevel(Enchantment.PROTECTION_ENVIRONMENTAL) <= max
							&& bot.getItemMeta().getEnchantLevel(Enchantment.PROTECTION_ENVIRONMENTAL) >= min
							&& bot.getItemMeta().getEnchantLevel(Enchantment.PROTECTION_ENVIRONMENTAL) <= max
							&& cap.getItemMeta().getEnchantLevel(Enchantment.PROTECTION_ENVIRONMENTAL) <= max
							&& pei.getItemMeta().getEnchantLevel(Enchantment.PROTECTION_ENVIRONMENTAL) <= max
							&& cal.getItemMeta().getEnchantLevel(Enchantment.PROTECTION_ENVIRONMENTAL) <= max
							&& bot.getItemMeta().getEnchantLevel(Enchantment.PROTECTION_ENVIRONMENTAL) <= max
							&& !ArmaduraP4.seArmaduraForP4(p, new ItemStack(Material.DIAMOND_HELMET),
									Enchantment.PROTECTION_ENVIRONMENTAL, max, max)
							&& !ArmaduraP4.seArmaduraForP4(p, new ItemStack(Material.DIAMOND_CHESTPLATE),
									Enchantment.PROTECTION_ENVIRONMENTAL, max, max)
							&& !ArmaduraP4.seArmaduraForP4(p, new ItemStack(Material.DIAMOND_LEGGINGS),
									Enchantment.PROTECTION_ENVIRONMENTAL, max, max)
							&& !ArmaduraP4.seArmaduraForP4(p, new ItemStack(Material.DIAMOND_BOOTS),
									Enchantment.PROTECTION_ENVIRONMENTAL, max, max)) {
						p.teleport(Locations.getArenaP4());
						arena_p4.add(p.getName());
						p.sendMessage(prefix + "§eVocê entrou na arena P4!");
					}

				} else if (!config_yml.getConfig().contains("Arenas.P4")) {
					p.sendMessage(prefix + "§eEsta arena ainda não foi setada!");
					p.sendMessage(prefix + "§eProcure um administrador para que possa seta-lá!");
				}
			}

		}
	}
}
