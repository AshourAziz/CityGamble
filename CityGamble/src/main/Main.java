package main;

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

import org.bukkit.plugin.Plugin;

public class Main extends JavaPlugin implements Listener {

	public void onEnable() {

		getServer().getPluginManager().registerEvents(this, this);
		this.getCommand("basic").setExecutor(new gamble(this));
		System.out.println("CityGamble has been enabled");
	}

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
