package com.eyenet.lobbysystem.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.UUID;

public class BalanceCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {

        Player sender = (Player) commandSender;
        UUID uuid = sender.getUniqueId();

        // get balance from player using SQLUtils

        //int balance = SQLUtils.getBalance(uuid);
        //sender.sendMessage("Your balance: " + balance);

        return true;
    }
}
