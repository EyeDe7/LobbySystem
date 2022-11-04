package com.eyenet.lobbysystem.commands;

import com.eyenet.lobbysystem.sql.SQLUtils;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.UUID;

public class BalanceCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] args) {

        Player sender = (Player) commandSender;

        if(args.length == 0) {
            sender.sendMessage("Your balance: " + SQLUtils.getBalance(sender.getUniqueId()));
        } else {
            UUID target = Bukkit.getPlayer(args[0]).getUniqueId();
            if(target != null) {
                sender.sendMessage(args[0] + "'s balance: " + SQLUtils.getBalance(target));
            } else {
                sender.sendMessage("The player " + args[0] + " doesn't exist!");
            }
        }


        return true;
    }
}
