package com.matthew.villagerTraderPlugin;

import org.bukkit.Bukkit;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

public final class VillagerTraderPlugin extends JavaPlugin{

    @Override
    public void onEnable() {
        // Plugin startup logic
        System.out.println("VillagerTraderPlugin enabled");
        getCommand("spawntrader").setExecutor(new SpawnTrader());
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
