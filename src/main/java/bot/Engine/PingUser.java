package bot.Engine;

import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.MessageChannel;

/**
 * @author  Wil Aquino
 * Date:    December 5, 2020
 * Project: Eidos Bot
 * Module:  PingUser.java
 * Purpose: Pings a user a certain amount of times.
 * Usage:   --ping [user] [amount]
 */
public class PingUser implements Command {

    /** The maximum amount of times you can ping someone. */
    private static final int MAX_PINGS = 20;

    /**
     * Pings a user a certain amount of times.
     * @param user the user to ping.
     * @param k the amount of times to ping.
     * @param ch the output channel.
     */
    private void ping(Member user, int k, MessageChannel ch) {
        for (int i = 0; i < k; i++) {
            ch.sendMessage(user.getAsMention()).queue();
        }
    }

    /**
     * Runs the ping command.
     * @param inChannel the channel the command was sent in.
     * @param outChannel the channel to output to, if it exists.
     * @param user the user to attach to the command output, if they exist.
     * @param args the arguments of the command, if they exist.
     */
    @Override
    public void runCmd(MessageChannel inChannel, MessageChannel outChannel,
                       Member user, String[] args) {
        try {
            int pings = Integer.parseInt(args[2]);

            if (pings > MAX_PINGS) {
                inChannel.sendMessage("If you ping them that much, had it "
                        + "not been for the laws of these lands, they "
                        + "would have slain you.").queue();
            } else if (pings < 0) {
                inChannel.sendMessage("Why would you ping someone a "
                        + "negative amount of times...").queue();
            } else {
                ping(user, pings, inChannel);
            }
        } catch (NumberFormatException exc) {
            inChannel.sendMessage("Invalid argument input. See `--help` "
                    + "for more info.").queue();
        }
    }
}
