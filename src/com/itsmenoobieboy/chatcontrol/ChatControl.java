package com.itsmenoobieboy.chatcontrol;

import com.itsmenoobieboy.chatcontrol.commands.GameAndHubWarps;
import com.itsmenoobieboy.chatcontrol.events.ChatFilter;
import com.itsmenoobieboy.chatcontrol.events.SystemMsgs;
import org.bukkit.ChatColor;
import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.io.IOException;

public class ChatControl extends JavaPlugin {

    public static ChatControl plugin;

    @Override
    public void onEnable() {
        GameAndHubWarps gameAndHubWarpCmds = new GameAndHubWarps();
        getServer().getPluginManager().registerEvents(new SystemMsgs(), this);
        getServer().getPluginManager().registerEvents(new ChatFilter(), this);
        getCommand("chatcontrol").setExecutor(gameAndHubWarpCmds);
        getCommand("hub").setExecutor(gameAndHubWarpCmds);
        createFiles();
        plugin = this;
        getServer().getConsoleSender().sendMessage(ChatColor.GREEN + "ChatControl is enabled.");
    }

    @Override
    public void onDisable() {
        getServer().getConsoleSender().sendMessage(ChatColor.RED + "ChatControl is disabled.");
    }

    private File configf;
    private FileConfiguration config;

    private void createFiles(){
        configf = new File(getDataFolder(), "config.yml");

        if(!configf.exists()) {
            configf.getParentFile().mkdirs();
            saveResource("config.yml", false);
        }

        config = new YamlConfiguration();

        try {
            config.load(configf);
        } catch (IOException | InvalidConfigurationException e) {
            e.printStackTrace();
        }
    }


}
