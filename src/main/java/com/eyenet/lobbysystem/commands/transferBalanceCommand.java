package com.eyenet.lobbysystem.commands;

import com.eyenet.lobbysystem.sql.SQLInit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;

public class transferBalanceCommand implements Listener {

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] args) {

        Player sender = (Player) commandSender;

        if (args.length != 2) {
            sender.sendMessage("§7[§3Lobby§6System§7] §cBitte benutze /transferbalance <Spieler> <Betrag>");
            return false;
        }else{

        }

        return true;
    }


}
