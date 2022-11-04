package com.eyenet.lobbysystem.listeners;

import org.bukkit.Material;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;

public class BalanceListener implements Listener {

    public void onBlockBreak(BlockBreakEvent event) {
        if(event.getBlock().getBlockData().getMaterial().equals(Material.OAK_LOG)) {
            event.getPlayer().sendMessage("You broke an oak log!");
        }
    }

}
