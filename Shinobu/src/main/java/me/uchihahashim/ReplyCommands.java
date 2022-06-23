package me.uchihahashim;

import net.dv8tion.jda.api.Permission;
import net.dv8tion.jda.api.entities.Channel;
import net.dv8tion.jda.api.entities.User;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;


public class ReplyCommands extends ListenerAdapter {
    public String prefix = "!";

    @Override
    public void onMessageReceived(MessageReceivedEvent event) {
        User author = event.getAuthor();
        String user = event.getMember().getUser().getName();

        String[] args = event.getMessage().getContentRaw().split(" ");


        if (author.isBot())
            return;

        if (args[0].equalsIgnoreCase("Bye"))
            event.getMessage().reply("Sayonara " + user).queue();

        else if (args[0].equalsIgnoreCase("Hello")) {
            event.getMessage().reply("Moshi Moshi").queue();
        } else if (args[0].equalsIgnoreCase(prefix + "meow")) {
            event.getMessage().reply("Bow Bow").queue();
        } else if (args[0].equalsIgnoreCase(prefix + "invite")) {
            event.getMessage().reply("Hey " + event.getAuthor().getName() + " Wanna Invite me?").queue();
            event.getChannel().sendMessage("Here you go: " + event.getJDA().getInviteUrl(Permission.ADMINISTRATOR) ).queue();

        } else if (args[0].equalsIgnoreCase("COD")) {
            event.getMessage().reply("You guys play COD? cool").queue();
        }
    }
}

