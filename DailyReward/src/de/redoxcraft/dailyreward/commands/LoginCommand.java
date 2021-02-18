package de.redoxcraft.dailyreward.commands;

import java.time.LocalDate;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.EnchantmentStorageMeta;

import de.redoxcraft.dailyreward.main.Main;

public class LoginCommand implements CommandExecutor {
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		
		if(sender instanceof Player) {
			
			ItemStack SharpnessIV = new ItemStack(Material.ENCHANTED_BOOK);
			EnchantmentStorageMeta SharpnessIVMeta = (EnchantmentStorageMeta)SharpnessIV.getItemMeta();
			SharpnessIVMeta.addStoredEnchant(Enchantment.DAMAGE_ALL, 4, false);
			SharpnessIV.setItemMeta(SharpnessIVMeta);
			
			ItemStack Mending = new ItemStack(Material.ENCHANTED_BOOK);
			EnchantmentStorageMeta MendingMeta = (EnchantmentStorageMeta)Mending.getItemMeta();
			MendingMeta.addStoredEnchant(Enchantment.MENDING, 1, false);
			Mending.setItemMeta(MendingMeta);
			
			ItemStack ProtectionIV = new ItemStack(Material.ENCHANTED_BOOK);
			EnchantmentStorageMeta ProtectionIVMeta = (EnchantmentStorageMeta)ProtectionIV.getItemMeta();
			ProtectionIVMeta.addStoredEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 4, false);
			ProtectionIV.setItemMeta(ProtectionIVMeta);
			
			Player p = (Player) sender;
			LocalDate date = LocalDate.now();
			FileConfiguration config = Main.getPlugin().getConfig();
			
			if(config.get(p.getUniqueId() + ".alldays") != null) { //config already exist
				
				int streak = (int) config.get(p.getUniqueId() + ".streak");
				int alldays = (int) config.get(p.getUniqueId() + ".alldays");
				
				if(date.minusDays(1).getYear() == (int) config.get(p.getUniqueId() + ".dateyear") && date.minusDays(1).getDayOfYear() == (int) config.get(p.getUniqueId() + ".dateday")) { //yesterday /anmelden
					if(p.getInventory().firstEmpty() == -1) {
						p.sendMessage("Dein Inventar ist voll!" + ChatColor.LIGHT_PURPLE + "" + ChatColor.ITALIC + " *Du schaust in deine überfüllten Taschen*");
						return true;
					}else {
						String item = "";
						if(streak <= 6) { //Day 1 To 7 (loot for 7th day, if streak = 6)
							switch(streak) {
							case 1: p.getInventory().addItem(new ItemStack(Material.BONE, 16)); item = "16 Knochen"; break; 
							case 2: p.getInventory().addItem(new ItemStack(Material.IRON_INGOT, 8)); item = "8 Eisenbarren"; break; 
							case 3: p.getInventory().addItem(new ItemStack(Material.LAPIS_LAZULI, 16)); item = "16 Lapislazuli"; break;
							case 4: p.getInventory().addItem(new ItemStack(Material.EMERALD)); item = "einen Smaragd"; break;
							case 5: p.getInventory().addItem(new ItemStack(Material.GOLD_INGOT, 8)); item = "8 Goldbarren"; break;
							case 6: p.getInventory().addItem(new ItemStack(Material.EXPERIENCE_BOTTLE, 4)); item = "4 Erfahrungsfläschchen"; break; 
							default: p.sendMessage(ChatColor.RED + "DailyLogin Error NEGATIVE STREAK. Bitte melde den Fehler einem Administrator!"); return false;
							}
						
						}else if(streak >= 7 && streak <= 29) { //Day 8 to 30
							int randomRarity = (int) (Math.random()*(14));
							switch(randomRarity) {
							case 0: p.getInventory().addItem(new ItemStack(Material.DIAMOND, 2)); item = "2 Diamanten"; break;
							case 1: p.getInventory().addItem(new ItemStack(Material.BONE, 32)); item = "32 Knochen"; break;
							case 2: p.getInventory().addItem(new ItemStack(Material.IRON_INGOT, 16)); item = "16 Eisenbarren"; break;
							case 3: p.getInventory().addItem(new ItemStack(Material.LAPIS_LAZULI, 32)); item = "32 Lapislazuli"; break;
							case 4: p.getInventory().addItem(new ItemStack(Material.EMERALD, 2)); item = "2 Smaragde"; break;
							case 5: p.getInventory().addItem(new ItemStack(Material.GOLD_INGOT, 16)); item = "16 Goldbarren"; break;
							case 6: p.getInventory().addItem(new ItemStack(Material.EXPERIENCE_BOTTLE, 8)); item = "8 Erfahrungsfläschchen"; break;
							case 7: p.getInventory().addItem(new ItemStack(Material.GOLDEN_APPLE)); item = "einen goldenen Apfel"; break;
							case 8: p.getInventory().addItem(new ItemStack(Material.BLAZE_ROD)); item = "eine Lohenrute"; break;
							case 9: p.getInventory().addItem(new ItemStack(Material.ENDER_PEARL, 4)); item = "4 Enderperlen"; break;
							case 10: p.getInventory().addItem(new ItemStack(Material.REDSTONE, 32)); item = "32 Redstone"; break;
							case 11: p.getInventory().addItem(new ItemStack(Material.OBSIDIAN, 8)); item = "8 Obsidian"; break;
							case 12: p.getInventory().addItem(new ItemStack(Material.NAUTILUS_SHELL)); item = "eine Nautilusschale"; break;
							case 13: p.getInventory().addItem(new ItemStack(Material.ANCIENT_DEBRIS)); item = "antiken Schrott"; break;
							default: p.sendMessage(ChatColor.RED + "DailyLogin Error NEGATIVE STREAK. Bitte melde den Fehler einem Administrator!"); return false;
							}
							
						}else if(streak >= 30) { //Day 30+
							int randomRarity = (int) (Math.random()*(21));
							switch(randomRarity) {
							case 0: p.getInventory().addItem(new ItemStack(Material.DIAMOND, 4)); item = "4 Diamanten"; break;
							case 1: p.getInventory().addItem(new ItemStack(Material.BONE, 64)); item = "64 Knochen"; break;
							case 2: p.getInventory().addItem(new ItemStack(Material.IRON_INGOT, 32)); item = "32 Eisenbarren"; break;
							case 3: p.getInventory().addItem(new ItemStack(Material.LAPIS_LAZULI, 64)); item = "64 Lapislazuli"; break;
							case 4: p.getInventory().addItem(new ItemStack(Material.EMERALD, 4)); item = "4 Smaragde"; break;
							case 5: p.getInventory().addItem(new ItemStack(Material.GOLD_INGOT, 32)); item = "32 Goldbarren"; break;
							case 6: p.getInventory().addItem(new ItemStack(Material.EXPERIENCE_BOTTLE, 16)); item = "16 Erfahrungsfläschchen"; break;
							case 7: p.getInventory().addItem(new ItemStack(Material.GOLDEN_APPLE, 2)); item = "2 goldene Äpfel"; break;
							case 8: p.getInventory().addItem(new ItemStack(Material.BLAZE_ROD, 2)); item = "2 Lohenruten"; break;
							case 9: p.getInventory().addItem(new ItemStack(Material.ENDER_PEARL, 8)); item = "8 Enderperlen"; break;
							case 10: p.getInventory().addItem(new ItemStack(Material.REDSTONE, 64)); item = "64 Redstone"; break;
							case 11: p.getInventory().addItem(new ItemStack(Material.OBSIDIAN, 16)); item = "16 Obsidian"; break;
							case 12: p.getInventory().addItem(new ItemStack(Material.NAUTILUS_SHELL, 2)); item = "2 Nautilusschalen"; break;
							case 13: p.getInventory().addItem(new ItemStack(Material.ANCIENT_DEBRIS, 2)); item = "2 antiken Schrott"; break;
							case 14: p.getInventory().addItem(new ItemStack(Material.SHULKER_SHELL)); item = "eine Shulkerschale"; break;
							case 15: p.getInventory().addItem(new ItemStack(Material.NETHERITE_INGOT)); item = "ein Netherritebarren"; break;
							case 16: p.getInventory().addItem(new ItemStack(Material.TOTEM_OF_UNDYING)); item = "ein Totem der Unsterblichkeit"; break;
							case 17: p.getInventory().addItem(new ItemStack(Material.HEART_OF_THE_SEA)); item = "ein Herz des Meeres"; break;
							case 18: p.getInventory().addItem(ProtectionIV); item = "ein Schutz 4 Buch"; break;
							case 19: p.getInventory().addItem(SharpnessIV); item = "ein Schärfe 4 Buch"; break;
							case 20: p.getInventory().addItem(Mending); item = "ein Reparatur Buch"; break;
							default: p.sendMessage(ChatColor.RED + "DailyLogin Error NEGATIVE STREAK. Bitte melde den Fehler einem Administrator!"); return false;
							}
							
						}else { //Error
							p.sendMessage(ChatColor.RED + "DailyLogin Error NO STREAK. Bitte melde den Fehler einem Administrator!");
							return false;
						}
						
						p.sendMessage("Tag " + (streak + 1) + ": Du hast dich erfolgreich angemeldet und " + item + " erhalten."  + ChatColor.LIGHT_PURPLE + "" + ChatColor.ITALIC + " *Du freust dich*");
						config.set(p.getUniqueId() + ".alldays", (alldays + 1));
						config.set(p.getUniqueId() + ".streak", (streak + 1));
						config.set(p.getUniqueId() + ".dateyear", date.getYear());
						config.set(p.getUniqueId() + ".dateday", date.getDayOfYear());
						
						Main.getPlugin().saveConfig();
						return true;
						
					}	
						
				}else if(date.getYear() == (int) config.get(p.getUniqueId() + ".dateyear") && date.getDayOfYear() == (int) config.get(p.getUniqueId() + ".dateday")) { //today already /anmelden
					
					p.sendMessage("Du hast dich heute bereits angemeldet!");
					p.sendMessage(ChatColor.LIGHT_PURPLE + "" + ChatColor.ITALIC + "*Noch einmal schlafen...*");
					return true;
				
				}else { //longer in the past then yesterday, streak restart
					
					if(p.getInventory().firstEmpty() == -1) {
						p.sendMessage("Dein Inventar ist voll!" + ChatColor.LIGHT_PURPLE + "" + ChatColor.ITALIC + " *Du schaust in deine überfüllten Taschen*");
						return true;
					}else {
						p.getInventory().addItem(new ItemStack(Material.DIAMOND));
						p.sendMessage("Leider wurde deine Anmeldeserie unterbrochen. Aber 30 Tage gehen schneller um als du denkst ;)" + ChatColor.LIGHT_PURPLE + "" + ChatColor.ITALIC + " *Du bist motiviert deine Anmeldeserie wieder aufzubauen*");
						p.sendMessage("Tag 1: Du hast dich erfolgreich angemeldet und einen Diamanten erhalten!" + ChatColor.LIGHT_PURPLE + "" + ChatColor.ITALIC + " *Du freust dich*");
						config.set(p.getUniqueId() + ".oldstreak", streak);
						config.set(p.getUniqueId() + ".alldays", (alldays + 1));
						config.set(p.getUniqueId() + ".streak", 1);
						config.set(p.getUniqueId() + ".dateyear", date.getYear());
						config.set(p.getUniqueId() + ".dateday", date.getDayOfYear());
						Main.getPlugin().saveConfig();
					
						return true;
					}
				}
				
			}else { //no config yet
				
				if(p.getInventory().firstEmpty() == -1) {
					p.sendMessage("Dein Inventar ist voll!" + ChatColor.LIGHT_PURPLE + "" + ChatColor.ITALIC + " *Du schaust in deine überfüllten Taschen*");
					return true;
				}else {
					p.getInventory().addItem(new ItemStack(Material.DIAMOND));
					p.sendMessage("Tag 1: Du hast dich erfolgreich angemeldet und einen Diamanten erhalten!" + ChatColor.LIGHT_PURPLE + "" + ChatColor.ITALIC + " *Du freust dich*");
					p.sendMessage("Melde dich jeden Tag mit /anmelden an, um Belohnungen zu erhalten. Je öfter du dich hintereinander anmeldest, desto besser die Belohnungen. Nach 30 Tagen hast du die besten Belohnungen freigeschaltet, aber Achtung, solltest du dich an einem Tag nicht anmelden, beginnen die Belohnungen von vorne!" + ChatColor.LIGHT_PURPLE + "" + ChatColor.ITALIC + " *Du bist motiviert eine Anmeldeserie aufzubauen*");
					config.set(p.getUniqueId() + ".firstyear",  date.getYear());
					config.set(p.getUniqueId() + ".firstday", date.getDayOfYear());
					config.set(p.getUniqueId() + ".alldays", 1);
					config.set(p.getUniqueId() + ".oldstreak", 0);
					config.set(p.getUniqueId() + ".streak", 1);
					config.set(p.getUniqueId() + ".dateyear", date.getYear());
					config.set(p.getUniqueId() + ".dateday", date.getDayOfYear());
					Main.getPlugin().saveConfig();
				
					return true;
				}
				
			}
			
		}
		return false;
		
	}	
	
	
}
