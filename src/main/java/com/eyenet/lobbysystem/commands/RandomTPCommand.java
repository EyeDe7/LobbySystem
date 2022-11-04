package com.eyenet.lobbysystem.commands;

import com.eyenet.lobbysystem.Main;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class RandomTPCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {

        Player sender = (Player) commandSender;

        World world = sender.getWorld();
        double x,y,z;
        x = Math.random()*(29_000_000 + 29_000_000) - 29_000_000;
        z = Math.random()*(29_000_000 + 29_000_000) - 29_000_000;
        y = world.getHighestBlockYAt(new Location(world, x, 0, z));
        Block yBlock = world.getBlockAt(new Location(world, x, y-1, z));
        Location location = new Location(world, x, y+1, z);

        sender.teleport(location);

        return true;
    }
}
