package com.eyenet.lobbysystem.listener;

import com.eyenet.lobbysystem.sql.SQLUtils;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import java.util.UUID;

public class OnJoinListener implements Listener {

        @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event){
        event.setJoinMessage("§7[§3Lobby§6System§7] §a" + event.getPlayer().getName() + " §7hat das Spiel betreten!");

        String name = event.getPlayer().getName();
        UUID UUID = event.getPlayer().getUniqueId();

        if (!SQLUtils.checkIfPlayerExists(UUID)){
            SQLUtils.createPlayer(UUID, name, 100);
        }

    }


}
