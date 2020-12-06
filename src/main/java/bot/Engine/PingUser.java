package bot.Engine;

import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.entities.MessageChannel;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import java.util.regex.PatternSyntaxException;

/**
 * @author  Wil Aquino
 * Date:    December 5, 2020
 * Project: Sea+ Bot
 * Module:  PingUser.java
 * Purpose: Pings a user a certain amount of times.
 */
public class PingUser extends ListenerAdapter {

    /**
     * Pings a user a certain amount of times.
     * @param userID the user to ping.
     * @param k the amount of times to ping.
     * @param ch the output channel.
     */
    private void ping(String userID, int k, MessageChannel ch) {
        for (int i = 0; i < k; i++) {
            ch.sendMessage(userID).queue();
        }
    }

    /**
     * Checks if an ID is given by one of the Sea+ members.
     * @param userID the user's id.
     * @return True if the ID is from Sea+.
     *         False otherwise.
     *
     * Note: Clean up later.
     */
    private boolean isValidID(String userID) {
        if (userID.equals("<@!297413857645953025>")
            || userID.equals("<@!130196093039411200>")
            || userID.equals("<@!440059670170959874>")
            || userID.equals("<@!260923200697794562>")
            || userID.equals("<@!208788589188743168>")
            || userID.equals("<@!447491971188260885>")
            || userID.equals("<@!724851006634197012>")
            || userID.equals("<@!392856911562670085>")) {
            return true;
        }
        return false;
    }

    /**
     * Tests the ping functionality by taking in a ping.
     * @param e the ping to analyze. (Will only work in this case
     *          if the ping is given by "/ping").
     */
    @Override
    public void onMessageReceived(MessageReceivedEvent e) {
        String input = e.getMessage().getContentRaw();
        MessageChannel channel = e.getChannel();

        String[] args;
        String id;
        int pings;

        try {
            args = input.split(" ", 3);

            if (args[0].equals("--ping")) {
                id = args[1];
                pings = Integer.parseInt(args[2]);

                if (pings > 20) {
                    channel.sendMessage("If you ping them that much, had it "
                            + "not been for the laws of these lands, they would "
                            + "have slain you.").queue();
                } else if (isValidID(id)) {
                    ping(id, pings, channel);
                } else {
                    channel.sendMessage("You cannot ping that user!").queue();
                }
            }
        } catch (PatternSyntaxException pse) {
            channel.sendMessage("Invalid argument input.").queue();
        } catch (NumberFormatException
                | ArrayIndexOutOfBoundsException exc) {
            channel.sendMessage("Please specify a user to ping and how "
                    + "many times to ping them.").queue();
        }
    }
}
