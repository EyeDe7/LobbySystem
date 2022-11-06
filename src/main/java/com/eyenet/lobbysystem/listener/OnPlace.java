package com.eyenet.lobbysystem.listener;

import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;

public class OnPlace implements Listener {

    @EventHandler
    public static void onPlace(BlockPlaceEvent event){
        Player p = event.getPlayer();

    }

}
