package com.eyenet.lobbysystem.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import com.eyenet.lobbysystem.sql.SQLInit;
import org.bukkit.entity.Player;

public class CheckDB implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] args) {

        Player sender = (Player) commandSender;

        sender.sendMessage("Database Connection: " + SQLInit.hasConn());

        return true;
    }


}
