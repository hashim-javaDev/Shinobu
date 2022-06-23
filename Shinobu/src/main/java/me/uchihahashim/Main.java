package me.uchihahashim;

import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.OnlineStatus;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.interactions.commands.OptionType;
import net.dv8tion.jda.api.utils.cache.CacheFlag;

import javax.security.auth.login.LoginException;

public class Main {
    public static void main(String[] args) throws LoginException, InterruptedException {
        JDA bot = JDABuilder.createDefault("OTg5Mzk4OTkzODgyNzQyODE2.G2KnxL.EWLElYM4XwYF9bVwAie-zYZYnZ1nwdz2Py9r9o")
                .setActivity(Activity.watching("You"))
                .addEventListeners(new ReplyCommands())
                .addEventListeners(new SlashCommands())
                .enableCache(CacheFlag.VOICE_STATE)
                .build();
        bot.awaitReady();
        bot.getPresence().setStatus(OnlineStatus.IDLE);


        Guild guild = bot.getGuildById("989399635384737832");

        if (guild != null) {

             guild.upsertCommand("hello", "Moshi Moshi").queue();
             guild.upsertCommand("food","Your Favourite Food")
                     .addOption(OptionType.STRING,"name", "the name of your favourite food" , true)
                     .queue();
             guild.upsertCommand("sum","get the sum of 2 numbers")
                     .addOption(OptionType.INTEGER,"number1","Enter the first number",true)
                     .addOption(OptionType.INTEGER,"number2","Enter the second number",true)
                     .queue();
            guild.upsertCommand("difference","get the difference of 2 numbers")
                    .addOption(OptionType.INTEGER,"number1","Enter the first number",true)
                    .addOption(OptionType.INTEGER,"number2","Enter the second number",true)
                    .queue();
            guild.upsertCommand("product","get the product of 2 numbers")
                    .addOption(OptionType.INTEGER,"number1","Enter the first number",true)
                    .addOption(OptionType.INTEGER,"number2","Enter the second number",true)
                    .queue();
            guild.upsertCommand("quotient","get the quotient of 2 numbers")
                    .addOption(OptionType.INTEGER,"number1","Enter the first number",true)
                    .addOption(OptionType.INTEGER,"number2","Enter the second number",true)
                    .queue();

        }
    }
}