package main;

import java.awt.Color;

import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import me.libraryaddict.inventory.InventoryApi;
import me.libraryaddict.inventory.ItemBuilder;
import me.libraryaddict.inventory.PageInventory;


public class gamble implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		
		if (cmd.getName().equalsIgnoreCase("gamble")) { 
			Player player = (Player) sender;
			PageInventory inv = new PageInventory(player);
			
			ItemStack[] items = new ItemStack[4];
			
			  items[i] = new ItemBuilder(Material.SKULL_ITEM).setTitle("Player: " + players.get(i).getName()).build();
			  items[1] = new ItemBuilder(Material.WOOL).setTitle("Risky").setColor(org.bukkit.Color.RED).addLore("20% chance of winning").setColor(oorg.bukkit.Color.RED).build();
			
			inv.setPages(items);
			inv.setTitle("CityGamble");
			inv.openInventory();
			
			
			
			return true;
		} 
	        
		return false; 
	}

}
