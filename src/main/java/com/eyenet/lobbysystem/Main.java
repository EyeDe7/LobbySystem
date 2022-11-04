package com.eyenet.lobbysystem;

import org.bukkit.plugin.java.JavaPlugin;

public final class Main extends JavaPlugin {

    public static final String PREFIX = "§7[§3Lobby§6System§7]";

    @Override
    public void onEnable() {
        // Plugin startup logic
        System.out.println("Enabled " +  PREFIX);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
