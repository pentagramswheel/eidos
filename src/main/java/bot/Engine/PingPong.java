package bot.Engine;

import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

/**
 * @author  Wil Aquino
 * Date:    December 5, 2020
 * Project: Sea+ Bot
 * Module:  PingPong.java
 * Purpose: A class for testing ping functions of the bot.
 *          (This class was just for initial testing)
 */
public class PingPong extends ListenerAdapter {

    /**
     * Tests the ping functionality by taking in a ping.
     * @param e the ping to analyze. (Will only work in this case
     *          if the ping is given by "/ping").
     */
    @Override
    public void onMessageReceived(MessageReceivedEvent e) {
        if (e.getMessage().getContentRaw().equals("--ping")) {
            e.getChannel().sendMessage("pong!").queue();
        }
    }
}
