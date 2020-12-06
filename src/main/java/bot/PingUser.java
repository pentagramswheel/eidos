package bot;

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
     * Tests the ping functionality by taking in a ping.
     * @param e the ping to analyze. (Will only work in this case
     *          if the ping is given by "/ping").
     */
    @Override
    public void onMessageReceived(MessageReceivedEvent e) {
        String input = e.getMessage().getContentRaw();
        MessageChannel channel = e.getChannel();
        String[] args = null;

        try {
            args = input.split(" ", 3);
        } catch (PatternSyntaxException pse) {
            channel.sendMessage("Invalid argument input.").queue();
            pse.printStackTrace();
            System.exit(0);
        }

        if (args[0].equals("--ping")) {
            if (args.length != 3) {
                channel.sendMessage("Please specify a user to ping and how "
                        + "many times to ping them.").queue();
                System.exit(0);
            }
            int pings = Integer.parseInt(args[2]);

            ping(args[1], pings, channel);

//            switch (args[1]) {
//                case "Aloe":
//                    ping("@aloeverai#0778", pings, channel);
//                    break;
//                case "Bren":
//                    ping("@blondefox25#4828", pings, channel);
//                    break;
//                case "PTW":
//                    ping("@PentagramsWheel#0168", pings, channel);
//                    break;
//                default:
//                    channel.sendMessage("You cannot ping that user!").queue();
//            }
        }
    }
}
