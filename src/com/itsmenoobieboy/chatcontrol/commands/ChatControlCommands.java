package com.itsmenoobieboy.chatcontrol.commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class ChatControlCommands implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (!(sender instanceof Player)) {
        }

        Player player = (Player) sender;

        // /chatcontrol
        if (cmd.getName().equalsIgnoreCase("chatcontrol")){
            player.sendMessage("§a================================\n" +
                    "§r§lTrennett ChatControl\n" +
                    "§rA custom plugin for Chat Moderation.\n" +
                    "Developed by ItsMeNoobieboy\n" +
                    "§a================================");
        }

        return true;
    }
}
