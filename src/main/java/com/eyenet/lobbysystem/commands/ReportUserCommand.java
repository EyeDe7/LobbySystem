package com.eyenet.lobbysystem.commands;

import com.eyenet.lobbysystem.sql.SQLUtils;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.UUID;

public class ReportUserCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] args) {

        Player sender = (Player) commandSender;

        if (args.length < 2) {
            sender.sendMessage("§7[§3Lobby§6System§7] §cBitte benutze /report <Spieler> <Grund>");
            return false;
        } else {
            Player target = Bukkit.getPlayer(args[0]);
            if (target != null) {
                UUID targetUUID = target.getUniqueId();
                if (targetUUID == sender.getUniqueId()) {
                    sender.sendMessage("§7[§3Lobby§6System§7] §cDu kannst dich nicht selbst melden!");
                    return false;
                }
                if (SQLUtils.checkIfPlayerExists(targetUUID)) {
                    StringBuilder reason = new StringBuilder();
                    for (int i = 1; i < args.length; i++) {
                        reason.append(args[i]).append(" ");
                    }
                    SQLUtils.reportPlayer(targetUUID, sender.getUniqueId(), reason.toString());
                    sender.sendMessage("§7[§3Lobby§6System§7] §aDu hast den Spieler §e" + target.getName() + " §aerfolgreich gemeldet!");
                    return true;
                } else {
                    sender.sendMessage("§7[§3Lobby§6System§7] §cDer Spieler existiert nicht!");
                }
                return false;
            }

        }
        return false;
    }
}
