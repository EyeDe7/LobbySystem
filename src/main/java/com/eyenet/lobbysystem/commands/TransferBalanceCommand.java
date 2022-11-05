package com.eyenet.lobbysystem.commands;

import com.eyenet.lobbysystem.sql.SQLUtils;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;

import java.util.UUID;

import static com.eyenet.lobbysystem.sql.SQLUtils.getUUIDbyName;

public class TransferBalanceCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] args) {

        Player sender = (Player) commandSender;

        if (args.length != 2) {
            sender.sendMessage("§7[§3Lobby§6System§7] §cBitte benutze /transferbalance <Spieler> <Betrag>");
            return false;
        }else{
            UUID receiverUUID = getUUIDbyName(args[0]);
            SQLUtils.transferBalance(sender.getUniqueId(), receiverUUID, Integer.parseInt(args[1]));
        }

        return true;
    }


}
