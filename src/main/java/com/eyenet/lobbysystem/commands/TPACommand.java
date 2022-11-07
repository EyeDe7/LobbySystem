package com.eyenet.lobbysystem.commands;

import com.eyenet.lobbysystem.sql.SQLUtils;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class TPACommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        Player sender = (Player) commandSender;

        if(sender == null){
            Bukkit.getConsoleSender().sendMessage("§7[§3Lobby§6System§7] §cDu kannst diesen Befehl nicht als Konsole ausführen!");
            return false;
        }

        if(strings.length == 0){
            sender.sendMessage("§7[§3Lobby§6System§7] §cBitte benutze /tpa <Spieler>");
            return false;
        }

        Player target = Bukkit.getPlayer(strings[0]);

        if(target == null) {
            sender.sendMessage("§7[§3Lobby§6System§7] §cDer Spieler existiert nicht!");
            return false;
        }

        target.sendMessage("§7[§3Lobby§6System§7] §a" + sender.getName() + "§a möchte sich zu dir teleportieren! §7(§a/tpaccept§7)");
        SQLUtils.addTPARequest(target.getUniqueId(), sender.getUniqueId());
        sender.sendMessage("§7[§3Lobby§6System§7] §aDu hast §e" + target.getName() + "§a eine Teleportationsanfrage gesendet!");

        return true;
    }
}
