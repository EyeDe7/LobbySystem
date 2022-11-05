package com.eyenet.lobbysystem.commands;

import com.eyenet.lobbysystem.sql.SQLUtils;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.UUID;

public class TransferBalanceCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] args) {

        Player sender = (Player) commandSender;

        if (args.length != 2) {
            sender.sendMessage("§7[§3Lobby§6System§7] §cBitte benutze /transferbalance <Spieler> <Betrag>");
            return false;
        }else{
            Player target = Bukkit.getPlayer(args[0]);
            if (target != null){
             UUID targetUUID = target.getUniqueId();
             if (targetUUID == sender.getUniqueId()) {
                 sender.sendMessage("§7[§3Lobby§6System§7] §cDu kannst dir nicht selbst Geld überweisen!");
                 return false;
             }
             SQLUtils.transferBalance(sender.getUniqueId(), targetUUID, Integer.parseInt(args[1]));
             sender.sendMessage("§7[§3Lobby§6System§7] §aDu hast §e" + args[1] + "§a an §e" + target.getName() + "§a überwiesen!");
            }else{
                sender.sendMessage("§7[§3Lobby§6System§7] §cDer Spieler existiert nicht!");
            }


        }

        return true;
    }


}
