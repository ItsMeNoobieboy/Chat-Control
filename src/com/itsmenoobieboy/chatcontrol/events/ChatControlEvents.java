package com.itsmenoobieboy.chatcontrol.events;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

import java.util.Arrays;

public class ChatControlEvents implements Listener {

    @EventHandler
    public static void onPlayerJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();
        String playerName = "§5" + player.getDisplayName();
        player.sendMessage(ChatColor.LIGHT_PURPLE + "Welcome to Trennett!");
        event.setJoinMessage("§9Welcome " + playerName + " §9to the server");
    }

    @EventHandler
    public static void onPlayerLeave(PlayerQuitEvent event) {
        Player player = event.getPlayer();
        String playerName = "§5" + player.getDisplayName();
        event.setQuitMessage(playerName + " §9left the server");
    }

    @EventHandler
    public static void onPlayerChat(AsyncPlayerChatEvent event) {
        Player player = event.getPlayer();
        String message = event.getMessage();
        String[] words = message.split(" ");
        if (Arrays.asList(words).contains("ez") || Arrays.asList(words).contains("L")) {
            event.setCancelled(true);
            player.chat("I love Rick Astley!");
        }
    }
}
