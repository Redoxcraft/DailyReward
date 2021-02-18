package de.redoxcraft.dailyreward.main;

import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import de.redoxcraft.dailyreward.commands.LoginCommand;
import de.redoxcraft.dailyreward.listener.LoginReminderListener;

public class Main extends JavaPlugin {

	private static Main plugin;
	
	public void onEnable() {
		plugin = this;
		
		System.out.println(this.getDescription().getName() + " " + this.getDescription().getVersion() + " geladen.");
	
		PluginManager PluginManager = Bukkit.getPluginManager();
		PluginManager.registerEvents(new LoginReminderListener(), this);
		
		getCommand("anmelden").setExecutor(new LoginCommand());
	
	}
	
	public static Main getPlugin( ) { 
		return plugin;
	}

}
