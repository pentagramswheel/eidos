package bot.Engine;

import net.dv8tion.jda.api.entities.MessageChannel;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import java.util.Random;
import java.util.regex.PatternSyntaxException;

/**
 * @author  Wil Aquino
 * Date:    December 9, 2020
 * Project: Sea+ Bot
 * Module:  Chance.java
 * Purpose: Contains chance-related commands.
 */
public class Chance extends ListenerAdapter {

    /** The maximum amount of times you can toss a coin.. */
    private static final int MAX_TOSSES = 5;

    /**
     * Tosses a coin and outputs the result.
     * @param ch the channel to output the result to.
     */
    private void tossCoin(MessageChannel ch) {
        Random rGen = new Random();
        int pick = rGen.nextInt(2);

        if (pick == 0) {
            ch.sendMessage("Heads!").queue();
        } else {
            ch.sendMessage("Tails!").queue();
        }
    }

    /**
     * Rolls an n-sided die.
     * @param n the amount of sides of the die.
     * @param ch the channel to output the result to.
     */
    private void rollDie(int n, MessageChannel ch) {
        Random rGen = new Random();
        int roll = rGen.nextInt(n);
        ch.sendMessage(Integer.toString(roll)).queue();
    }

    /**
     * Runs the chance commands.
     * @param e the command to analyze.
     */
    @Override
    public void onMessageReceived(MessageReceivedEvent e) {
        String input = e.getMessage().getContentRaw();
        MessageChannel channel = e.getChannel();

        String[] args;

        try {
            args = input.split(" ", 3);

            if (args[0].equals("--coin") && args[1].equals("toss")) {
                int flips = Integer.parseInt(args[2]);

                if (flips > MAX_TOSSES) {
                    channel.sendMessage("You can only toss a coin "
                            + "best three out of five times.").queue();
                } else {
                    for (int i = 0; i < flips; i++) {
                        tossCoin(channel);
                    }
                }
            } else if (args[0].equals("--roll")) {
                int sides = Integer.parseInt(args[1]);
                if (args.length > 2) {
                    throw new PatternSyntaxException(null, null, 2);
                } else if (sides < 0) {
                    channel.sendMessage("Negative-sided die "
                            + "don't exist five-head.").queue();
                } else {
                    rollDie(sides, channel);
                }
            }
        } catch (PatternSyntaxException pse) {
            channel.sendMessage("Invalid argument input.").queue();
        } catch (NumberFormatException
                | ArrayIndexOutOfBoundsException exc) {
            channel.sendMessage("Invalid argument input. See `--help` "
                    + "for more info.").queue();
        }
    }
}
