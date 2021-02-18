package de.redoxcraft.dailyreward.listener;

import java.time.LocalDate;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import de.redoxcraft.dailyreward.main.Main;

public class LoginReminderListener implements Listener {
	
	@EventHandler
	public static void onPlayerJoin(PlayerJoinEvent e) {
		Player p = e.getPlayer();
		LocalDate date = LocalDate.now();
		FileConfiguration config = Main.getPlugin().getConfig();
		
		if(e.getPlayer().hasPlayedBefore()) {
			if(config.get(p.getUniqueId() + ".dateyear") == null) {
				LoginReminderMessage(p);
				return;
			}else if(!(date.getYear() == (int) config.get(p.getUniqueId() + ".dateyear") && date.getDayOfYear() == (int) config.get(p.getUniqueId() + ".dateday"))) {
				LoginReminderMessage(p);
				return;
			}
		}return;
	}

	private static void LoginReminderMessage(Player p) {
		Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(Main.getPlugin(), new Runnable() {
			public void run() {
				p.sendMessage(ChatColor.WHITE + "Du hast dich heute noch nicht angemeldet. Tippe /anmelden !" + ChatColor.LIGHT_PURPLE + "" + ChatColor.ITALIC + " *Dein Kopf ist ein guter Notizblock*");	
			}
		}, 40);
	}

}
