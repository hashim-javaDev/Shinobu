package me.uchihahashim;

import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.interactions.commands.OptionMapping;
import org.jetbrains.annotations.NotNull;



public class SlashCommands extends ListenerAdapter {

    @Override
    public void onSlashCommandInteraction(@NotNull SlashCommandInteractionEvent event) {
        if (event.getName().equalsIgnoreCase("hello")) {
            event.deferReply().queue();
            event.getHook().sendMessage("Moshi Moshi").queue();
        } else if (event.getName().equalsIgnoreCase("food")) {

            OptionMapping option = event.getOption("name");

            if (option == null) {
                event.reply("For some reason, Food name was not provided").queue();

                return;
            }

            String favFood = option.getAsString();

            event.deferReply().queue();
            event.getHook().sendMessage("Your favourite food is " + favFood).queue();

        } else if (event.getName().equalsIgnoreCase("add")) {

            OptionMapping num1 = event.getOption("number1");
            OptionMapping num2 = event.getOption("number2");

            if (num1 == null || num2 == null) {
                event.reply("For some reason, numbers were not provided!").queue();
            }

            int sum = num1.getAsInt() + num2.getAsInt();

            event.deferReply().queue();
            event.getHook().sendMessage("The sum is " + sum).setEphemeral(true).queue();
        }

            else if (event.getName().equalsIgnoreCase("difference")) {
            OptionMapping num1 = event.getOption("number1");
            OptionMapping num2 = event.getOption("number2");

            if (num1 == null || num2 == null) {
                event.reply("For some reason, numbers were not provided!").queue();
            }

                int result = num1.getAsInt() - num2.getAsInt();

                event.deferReply().queue();
                event.getHook().sendMessage("The difference is " + result).setEphemeral(true).queue();
        }
        else if (event.getName().equalsIgnoreCase("product")) {
            OptionMapping num1 = event.getOption("number1");
            OptionMapping num2 = event.getOption("number2");

            if (num1 == null || num2 == null) {
                event.reply("For some reason, numbers were not provided!").queue();
            }

            int result = num1.getAsInt() * num2.getAsInt();

            event.deferReply().queue();
            event.getHook().sendMessage("The product is " + result).setEphemeral(true).queue();
        }
        else if (event.getName().equalsIgnoreCase("quotient")) {
            OptionMapping num1 = event.getOption("number1");
            OptionMapping num2 = event.getOption("number2");

            if (num1 == null || num2 == null) {
                event.reply("For some reason, numbers were not provided!").queue();
            }

            int result = num1.getAsInt() / num2.getAsInt();

            event.deferReply().queue();
            event.getHook().sendMessage("The quotient is " + result).setEphemeral(true).queue();
        }
    }
}

