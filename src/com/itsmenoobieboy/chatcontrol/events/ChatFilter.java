package com.itsmenoobieboy.chatcontrol.events;

import com.itsmenoobieboy.chatcontrol.ChatControl;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

import java.util.ArrayList;
import java.util.List;

public class ChatFilter implements Listener {

    @EventHandler
    public static void onPlayerChat(AsyncPlayerChatEvent event) {
        Player player = event.getPlayer();
        String message = event.getMessage();
        String[] words = message.split(" ");
        List<?> blacklistedWords = ChatControl.plugin.getConfig().getList("BlacklistedWords");

        boolean caseSensitive = ChatControl.plugin.getConfig().getBoolean("CaseSensitive");
        boolean replaceWord = ChatControl.plugin.getConfig().getBoolean("ReplaceWord");
        ArrayList formattedMessage = new ArrayList<String>();
        ArrayList formattedBlacklist = new ArrayList<String>();
        String sendMessage = new String();
        boolean hasBlacklistedWord = false;

        for (String wrd : words) {
            if (caseSensitive) {
                formattedMessage.add(wrd);
            }
            else {
                formattedMessage.add(wrd.toLowerCase());
            }
        }
        for (Object blacklistedWord : blacklistedWords) {
            if (caseSensitive) {
                formattedBlacklist.add(blacklistedWord);
            }
            else{
                formattedBlacklist.add(blacklistedWord.toString().toLowerCase());
            }
        }

        for (Object word : formattedMessage) {
            if (formattedBlacklist.contains(word.toString())) {
                hasBlacklistedWord = true;
                String beepedWord = new String();
                for (int j = 0; j < word.toString().length(); j++) {
                    beepedWord += "*";
                }
                sendMessage += beepedWord + " ";
            }
            else {
                sendMessage += word.toString() + " ";
            }
        }

        if (hasBlacklistedWord) {
            event.setCancelled(true);
            if (replaceWord) {
                player.chat(sendMessage);
            } else {
                player.sendMessage(ChatColor.RED + "Your message could not be delivered because it contains a blacklisted word.");
            }
        }
    }
}
