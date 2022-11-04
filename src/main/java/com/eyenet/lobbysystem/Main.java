package com.eyenet.lobbysystem;

import com.eyenet.lobbysystem.commands.CheckDB;
import com.eyenet.lobbysystem.commands.PingCommand;
import com.eyenet.lobbysystem.commands.RandomTPCommand;
import com.eyenet.lobbysystem.sql.SQLInit;
import org.bukkit.plugin.java.JavaPlugin;

public final class Main extends JavaPlugin {

    public static final String PREFIX = "§7[§3Lobby§6System§7]";

    @Override
    public void onEnable() {
        // Plugin startup logic
        System.out.println("Enabled " + PREFIX);

        getCommand("ping").setExecutor(new PingCommand());
        getCommand("wild").setExecutor(new RandomTPCommand());
        getCommand("checkdb").setExecutor(new CheckDB());
        SQLInit.initDB();
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
