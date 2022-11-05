package com.eyenet.lobbysystem.listener;

import com.eyenet.lobbysystem.items.CreateItem;
import com.eyenet.lobbysystem.sql.SQLUtils;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import java.util.UUID;

public class OnJoinListener implements Listener {
        @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event){
            Player p = event.getPlayer();

        event.setJoinMessage("§7[§3Lobby§6System§7] §a" + p.getName() + " §7hat das Spiel betreten!");

        if (!SQLUtils.checkIfPlayerExists(p.getUniqueId())){
            SQLUtils.createPlayer(p.getUniqueId(), p.getName(), 100);
        }

        p.getInventory().clear();
        p.getInventory().setItem(4, CreateItem.createItem(Material.COMPASS, 1,0,  "§3Navigator"));
        p.getInventory().setItem(0, CreateItem.createItem(Material.ENDER_CHEST, 1,0,  "§3EnderChest"));
        p.getInventory().setItem(1, CreateItem.createItem(Material.CHEST, 1,0,  "§3Shop"));
        p.getInventory().setItem(7, CreateItem.createItem(Material.BARRIER, 1,0,  "§3Lobby verlassen"));

    }


}
