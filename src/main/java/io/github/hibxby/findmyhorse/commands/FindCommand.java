package io.github.hibxby.findmyhorse.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Horse;
import org.bukkit.entity.Player;

public class FindCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (!(sender instanceof Player)) {
            sender.sendMessage(ChatColor.DARK_RED + "This command must be executed by a player.");
            return true;
        }
        if (!sender.hasPermission("findmyhorse.find")) {
            sender.sendMessage(ChatColor.DARK_RED + "You do not have a permission to run this command!");
            return true;
        }
        int numberOfHorse = 0;
        for (World world : Bukkit.getWorlds()) {
            for (Horse horse : world.getEntitiesByClass(Horse.class)) {
                if (horse.getOwner() == sender) {
                    Location horseLocation = horse.getLocation();
                    String nameOfHorse = horse.getName();
                    String nameOfHorseWorld = horseLocation.getWorld().getName();
                    int blockX = horseLocation.getBlockX();
                    int blockY = horseLocation.getBlockY();
                    int blockZ = horseLocation.getBlockZ();
                    numberOfHorse++;
                    sender.sendMessage(String.format("%d. %s ( %s ) : [ X: %d, Y : %d, Z: %d ]", numberOfHorse, nameOfHorse, nameOfHorseWorld, blockX, blockY, blockZ));
                }
            }
        }
        if (numberOfHorse == 0) {
            sender.sendMessage(ChatColor.DARK_RED + "You don't have your own horse!");
        }
        return true;
    }
}
