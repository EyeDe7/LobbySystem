package com.eyenet.lobbysystem.listener;

import com.eyenet.lobbysystem.sql.SQLUtils;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;

public class BalanceListener implements Listener {

    @EventHandler
    public void onBlockBreak(BlockBreakEvent event) {
        if(event.getBlock().getBlockData().getMaterial().equals(Material.OAK_LOG)) {
            // increase balance
            SQLUtils.addBalance(event.getPlayer().getUniqueId(), 10);
        }
    }

}
