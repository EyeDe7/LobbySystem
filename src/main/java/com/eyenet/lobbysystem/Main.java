package com.eyenet.lobbysystem;

import com.eyenet.lobbysystem.commands.*;
import com.eyenet.lobbysystem.listener.OnJoinListener;
import com.eyenet.lobbysystem.listener.BalanceListener;
import com.eyenet.lobbysystem.listener.OnPlace;
import com.eyenet.lobbysystem.sql.CreateTables;
import com.eyenet.lobbysystem.sql.SQLInit;
import org.bukkit.plugin.java.JavaPlugin;

public final class Main extends JavaPlugin {

    public static final String PREFIX = "§7[§3Lobby§6System§7]";

    @Override
    public void onEnable() {
        // Plugin startup logic
        System.out.println("Enabled " + PREFIX);

        SQLInit.initDB();
        if (SQLInit.hasConn()){
            CreateTables.createTables();
        }

        getCommand("ping").setExecutor(new PingCommand());
        getCommand("wild").setExecutor(new RandomTPCommand());
        getCommand("checkdb").setExecutor(new CheckDB());
        getCommand("balance").setExecutor(new BalanceCommand());
        getCommand("transfer").setExecutor(new TransferBalanceCommand());
        getCommand("report").setExecutor(new ReportUserCommand());

        getServer().getPluginManager().registerEvents(new OnJoinListener(), this);
        getServer().getPluginManager().registerEvents(new BalanceListener(), this);
        getServer().getPluginManager().registerEvents(new OnPlace(), this);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
