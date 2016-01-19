package main;

import java.util.ArrayList;
import java.util.HashMap;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;

import net.milkbowl.vault.economy.Economy;

import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.RegisteredServiceProvider;

public class Main extends JavaPlugin implements Listener {
	String info = "";
	public static Economy econ = null;

	public void onEnable() {
		
		//Vaule
		if (!setupEconomy()) {
			System.out.println(
					String.format("[%s] - Disabled due to no Vault dependency found!", getDescription().getName()));
			getServer().getPluginManager().disablePlugin(this);
			return;
		}

		//end vault
		getCommand("gamble").setExecutor(new gamble(this));
		;
		System.out.println("CityGamble has been enabled");

	}
	
	//start setup economy

	private boolean setupEconomy() {
		if (getServer().getPluginManager().getPlugin("Vault") == null) {
			return false;
		}
		RegisteredServiceProvider<Economy> rsp = getServer().getServicesManager().getRegistration(Economy.class);
		if (rsp == null) {
			return false;
		}
		econ = rsp.getProvider();
		return econ != null;
	}
	
	//end eceonomy

	public String CalculateWinner() {
		String winner = "";

		int probability = (int) (Math.random() * (100)) + 1;

		if (probability > 0 && probability < 11) {
			winner = "red";

		} else if (probability > 11 && probability < 31) {
			winner = "black";
		} else if (probability > 31 && probability < 61) {
			winner = "green";

		} else if (probability > 61 && probability < 101) {
			winner = "blue";
		}

		return winner;
	}

}
