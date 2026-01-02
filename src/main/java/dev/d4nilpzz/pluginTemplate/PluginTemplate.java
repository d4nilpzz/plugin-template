package dev.d4nilpzz.pluginTemplate;

import org.bukkit.plugin.java.JavaPlugin;
import revxrsal.commands.Lamp;
import revxrsal.commands.bukkit.BukkitLamp;
import revxrsal.commands.bukkit.actor.BukkitCommandActor;

public final class PluginTemplate extends JavaPlugin {

    @Override
    public void onEnable() {
        Lamp<BukkitCommandActor> lamp = BukkitLamp.builder(this).build();
        lamp.register(
                new LaunchCommand()
                // All the command goes here
        );
    }

    @Override
    public void onDisable() {

    }
}
