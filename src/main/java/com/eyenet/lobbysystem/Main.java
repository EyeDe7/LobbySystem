package com.eyenet.lobbysystem;

import com.eyenet.lobbysystem.commands.CheckDB;
import com.eyenet.lobbysystem.commands.PingCommand;
import com.eyenet.lobbysystem.sql.SQLInit;
import org.bukkit.plugin.java.JavaPlugin;

public final class Main extends JavaPlugin {

    public static final String PREFIX = "§7[§3Lobby§6System§7]";

    @Override
    public void onEnable() {
        // Plugin startup logic
        System.out.println("Enabled " + PREFIX);
        System.out.println("Initializing Database...");
        SQLInit.initDB();

        getCommand("ping").setExecutor(new PingCommand());
        getCommand("checkdb").setExecutor(new CheckDB());
    }

    @Override
    public void onDisable() {
        System.out.println("Disabling LobbySystem...");
    }
}
