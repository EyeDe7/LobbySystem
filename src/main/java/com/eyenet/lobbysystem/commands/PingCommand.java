package com.eyenet.lobbysystem.commands;

import com.eyenet.lobbysystem.Main;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class PingCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] args) {

        Player sender = (Player) commandSender;

        if(args.length == 0) sender.sendMessage(Main.PREFIX+ "Your ping: " + sender.getPing());
        else {
            Player target = Bukkit.getPlayer(args[0]);

            if(target != null)
                sender.sendMessage(target.getDisplayName()+ "'s ping: " + target.getPing());
            else
                sender.sendMessage("The player " + args[0] + " doesn't exist!");
        }

        return true;
    }
}
