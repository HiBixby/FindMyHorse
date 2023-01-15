package io.github.hibxby.findmyhorse;

import io.github.hibxby.findmyhorse.commands.FindCommand;
import org.bukkit.plugin.java.JavaPlugin;

public final class FindMyHorse extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        getLogger().info("Loaded");
        getCommand("findmyhorse").setExecutor(new FindCommand());

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        getLogger().info("Disabled");
    }
}
