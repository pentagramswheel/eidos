package bot.Engine;

import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.MessageChannel;

import java.util.Random;

/**
 * @author  Wil Aquino
 * Date:    December 9, 2020
 * Project: Eidos Bot
 * Module:  Chance.java
 * Purpose: Contains chance-related commands.
 * Usage:   --coin toss [amount]
 *          --roll [amount]
 */
public class Chance implements Command {

    /** The maximum amount of times you can toss a coin.. */
    private static final int MAX_TOSSES = 5;

    /**
     * Runs the coin toss command.
     * @param inChannel the channel the command was sent in.
     * @param flips the amount of coin tosses.
     */
    private void runCoinToss(MessageChannel inChannel, int flips) {
        if (flips > MAX_TOSSES) {
            inChannel.sendMessage("You can only toss a coin "
                    + "best three out of five times.").queue();
        } else if (flips == 0) {
            inChannel.sendMessage("Why even bother tossing?").queue();
        } else {
            tossCoin(inChannel, flips);
        }
    }

    /**
     * Tosses a coin a certain amount of times and outputs the result.
     * @param ch the channel to output the result to.
     * @param k the amount of times to toss the coin.
     */
    private void tossCoin(MessageChannel ch, int k) {
        for (int i = 0; i < k; i++) {
            Random rGen = new Random();
            int pick = rGen.nextInt(2);

            if (pick == 0) {
                ch.sendMessage("Heads!").queue();
            } else {
                ch.sendMessage("Tails!").queue();
            }
        }
    }

    /**
     * Runs the die roll command.
     * @param inChannel the channel the command was sent in.
     * @param sides the amount of sides the die can roll.
     */
    private void runDieRoll(MessageChannel inChannel, int sides) {
        if (sides < 0) {
            inChannel.sendMessage("Negative-sided die "
                    + "don't exist five-head.").queue();
        } else if (sides == 0) {
            inChannel.sendMessage("Why even bother rolling?").queue();
        } else {
            rollDie(inChannel, sides);
        }
    }

    /**
     * Rolls an n-sided die.
     * @param ch the channel to output the result to.
     * @param n the amount of sides of the die.
     */
    private void rollDie(MessageChannel ch, int n) {
        Random rGen = new Random();
        int roll = rGen.nextInt(n) + 1;
        ch.sendMessage(Integer.toString(roll)).queue();
    }

    /**
     * Runs one of the chance commands.
     * @param inChannel the channel the command was sent in.
     * @param outChannel the channel to output to, if it exists.
     * @param user the user to attach to the command output, if they exist.
     * @param args the arguments of the command, if they exist.
     */
    @Override
    public void runCmd(MessageChannel inChannel, MessageChannel outChannel,
                       Member user, String[] args) {
        try {
            if (args[0].equals("--coin") && args[1].equals("toss")) {
                if (args.length == 2) {
                    runCoinToss(inChannel, 1);
                } else {
                    int flips = Integer.parseInt(args[2]);
                    runCoinToss(inChannel, flips);
                }
            } else if (args[0].equals("--roll")) {
                int sides = Integer.parseInt(args[1]);
                runDieRoll(inChannel, sides);
            }
        } catch (NumberFormatException
                | ArrayIndexOutOfBoundsException exc) {
            inChannel.sendMessage("Invalid argument input. See `--help` "
                    + "for more info.").queue();
        }
    }
}
