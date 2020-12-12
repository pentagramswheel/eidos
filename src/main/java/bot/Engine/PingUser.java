package bot.Engine;

import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.entities.MessageChannel;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import java.util.ArrayList;
import java.util.regex.PatternSyntaxException;

/**
 * @author  Wil Aquino
 * Date:    December 5, 2020
 * Project: Sea+ Bot
 * Module:  PingUser.java
 * Purpose: Pings a user a certain amount of times.
 */
public class PingUser extends ListenerAdapter {

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
     * @param e the command to analyze.
     */
    @Override
    public void onMessageReceived(MessageReceivedEvent e) {
        String input = e.getMessage().getContentRaw();
        MessageChannel channel = e.getChannel();

        String[] args;
        int pings;

        try {
            args = input.split(" ", 3);

            if (args[0].equals("--ping")) {
                ArrayList<Member> ids = (ArrayList<Member>)
                        e.getMessage().getMentionedMembers();
                pings = Integer.parseInt(args[2]);

                if (pings > MAX_PINGS) {
                    channel.sendMessage("If you ping them that much, had it "
                            + "not been for the laws of these lands, they "
                            + "would have slain you.").queue();
                } else if (pings < 0) {
                    channel.sendMessage("Why would you ping someone a "
                            + "negative amount of times...").queue();
                } else if (ids.size() == 1) {
                    ping(ids.get(0), pings, channel);
                } else {
                    channel.sendMessage("You can only ping one valid "
                            + "user!").queue();
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
