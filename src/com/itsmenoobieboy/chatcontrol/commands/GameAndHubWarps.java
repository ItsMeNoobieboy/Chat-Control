package com.itsmenoobieboy.chatcontrol.commands;

import com.itsmenoobieboy.chatcontrol.ChatControl;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;

public class GameAndHubWarps implements CommandExecutor {
    private Plugin plugin = ChatControl.getPlugin(ChatControl.class);

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (!(sender instanceof Player)) {
        }

        Player player = (Player) sender;

        // /chatcontrol
        if (cmd.getName().equalsIgnoreCase("chatcontrol")){
            if (args.length > 0) {
                switch (args[0]) {
                    case "add":
                        if (args.length > 1) {
                            ChatControl.plugin.getConfig().set("BlacklistedWords", args[1]);
                            ChatControl.plugin.saveConfig();
                            return true;
                        }
                        break;
                    case "list":

                }
            }
            player.sendMessage("§a§l================================\n" +
                    "§r§e§lTrennett ChatControl\n" +
                    "§rA custom plugin for Chat Moderation\n" +
                    "Developed by ItsMeNoobieboy\n\n" +
                    "Do /cc help for a list of commands\n" +
                    "§a§l================================");
        }

        // /hub
        if (cmd.getName().equalsIgnoreCase("hub")){
            player.sendMessage(ChatColor.GRAY + "\n\nSending you to the hub...\n\n");
            Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(), "mvtp " + player.getDisplayName() + " Hub");
        }

        return true;
    }
}
