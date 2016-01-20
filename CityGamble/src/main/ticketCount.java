package main;

import org.bukkit.entity.Player;

import net.md_5.bungee.api.ChatColor;
import net.milkbowl.vault.economy.EconomyResponse;

public class ticketCount {

	public Main ticketCount(String color, Player player) {

		if (color == "red") {

			// Let's parse the red ticket count into an int
			int redcount = Integer.parseInt(ticketRed);

			// We're going to add one to that count, because we just bought
			// a ticket
			redcount++;

			// We're going to transfer it back into a string
			ticketRed = Integer.toString(redcount);

			// recompile the amount of tickets this player has
			String recompile = ticketRed + "-" + ticketBlack + "-" + ticketGreen;

			// we're puting to put him back into the hashmap
			Main.playerTickets.put(player.getName(), recompile);

		}

		return null;

	}

	public void Charge(Player player) {

		// let's charge the player for a red ticket. $20,000 Cost.
		EconomyResponse r = Main.econ.bankWithdraw(player.getName(), 20000);
		if (r.transactionSuccess()) {
			player.sendMessage(ChatColor.DARK_GRAY + "[" + ChatColor.RED + ChatColor.BOLD + "Gamble"
					+ ChatColor.DARK_GRAY + "]" + ChatColor.AQUA + "You've purchased a " + ChatColor.RED + "Red"
					+ ChatColor.AQUA + " gamble ticket, cost of $20,00 GOOD LUCK!");
		} else {
			player.sendMessage("" + ChatColor.DARK_RED + ChatColor.BOLD
					+ "ERROR OCCURED while purching a RED Ticket, please contact staff with a screenshot of this message!");
		}

	}

	public String ticketValue(String color, Player player) {
		// TODO: We need to move this to it's own class.
		String ticketRed = Main.playerTickets.get(player.getName()).split("-")[0];
		String ticketBlack = Main.playerTickets.get(player.getName()).split("-")[1];
		String ticketGreen = Main.playerTickets.get(player.getName()).split("-")[2];
		if (color == "red") {

		} else if (color == "black") {

		} else if (color == "green") {

		}
	}

}}
