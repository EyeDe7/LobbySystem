package com.eyenet.lobbysystem.commands;

import com.eyenet.lobbysystem.sql.SQLUtils;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class TPAcceptCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {

        Player sender = (Player) commandSender;

        if(sender == null){
            Bukkit.getConsoleSender().sendMessage("§7[§3Lobby§6System§7] §cDu kannst diesen Befehl nicht als Konsole ausführen!");
            return false;
        }

        if(strings.length == 0){
            sender.sendMessage("§7[§3Lobby§6System§7] §cBitte benutze /tpaccept <Spieler>");
            return false;
        }

        Player target = Bukkit.getPlayer(strings[0]);

        if(SQLUtils.hasPlayerTPARequest(target.getUniqueId(), sender.getUniqueId())){
            target.teleport(sender);
            target.sendMessage("§7[§3Lobby§6System§7] §aDu wurdest zu §e" + sender.getName() + "§a teleportiert!");
            sender.sendMessage("§7[§3Lobby§6System§7] §aDu hast §e" + target.getName() + "§a zu dir teleportiert!");
            SQLUtils.removeTPARequest(target.getUniqueId(), sender.getUniqueId());
        }

        return true;
    }
}
