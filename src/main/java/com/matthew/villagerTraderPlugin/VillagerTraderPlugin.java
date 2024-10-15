package com.matthew.villagerTraderPlugin;

import org.bukkit.Bukkit;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;
import revxrsal.commands.Lamp;
import revxrsal.commands.bukkit.BukkitLamp;
import revxrsal.commands.bukkit.actor.BukkitCommandActor;

public final class VillagerTraderPlugin extends JavaPlugin{

    @Override
    public void onEnable() {
        // Plugin startup logic
        System.out.println("VillagerTraderPlugin enabled with LAMP");

        Lamp<BukkitCommandActor> lamp = BukkitLamp.builder(this).build();
        lamp.register(new SpawnTrader());
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
