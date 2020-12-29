package com.itsmenoobieboy.chatcontrol;

import com.itsmenoobieboy.chatcontrol.commands.ChatControlCommands;
import com.itsmenoobieboy.chatcontrol.events.ChatControlEvents;
import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;

public class ChatControl extends JavaPlugin {

    @Override
    public void onEnable() {
        ChatControlCommands commands = new ChatControlCommands();
        getServer().getPluginManager().registerEvents(new ChatControlEvents(), this);
        getCommand("chatcontrol").setExecutor(commands);
        getServer().getConsoleSender().sendMessage(ChatColor.GREEN + "ChatControl is enabled.");
    }

    @Override
    public void onDisable() {
        getServer().getConsoleSender().sendMessage(ChatColor.RED + "ChatControl is disabled.");
    }

}
