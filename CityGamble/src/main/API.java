package main;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.*;


import java.util.HashMap;

public class API {

    protected static int broadcastCounter = 0;

    public static HashMap<String, String> getTicketHash() {
        return Main.playerTickets;
    }

    public static int ticketsSold() {

        //We should create an array list, and just keep adding one and return the size of the array list.
        int sold = getTicketHash().size();
        return sold;
    }

    public static Inventory myInventory() {

        // Create our inventory-
        Inventory myInventory = Bukkit.createInventory(null, 18, "Colors!");

        return myInventory;
    }

    public static void setBroadcastCount(int count) {
        broadcastCounter += count;

    }

    public static int getBroadcastCount() {
        return broadcastCounter;

    }

    public static void broadcast() {
        Main.getInstance().getServer().broadcastMessage(
                ChatColor.translateAlternateColorCodes('&', "&b&l/gamble is drawing VERY SOON! Buy your tickets now!"));

    }

    public static String draw() {

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

    public static void winnerPayOut(String winningColor) {
        for(Player player : Bukkit.getServer().getOnlinePlayers()) {
            String ticketRed = getTicketHash().get(player.getDisplayName().toString()).split("-")[0];
            String ticketBlack = main.Main.playerTickets.get(player.getDisplayName().toString()).split("-")[1];
            String ticketGreen = main.Main.playerTickets.get(player.getDisplayName().toString()).split("-")[2];

            Main.econ.bankDeposit(player.getName().toString(), );


        }

    }

    }

}


