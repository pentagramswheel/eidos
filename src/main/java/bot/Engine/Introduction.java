package bot.Engine;

import net.dv8tion.jda.api.entities.MessageChannel;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

/**
 * @author  Wil Aquino
 * Date:    December 5, 2020
 * Project: Sea+ Bot
 * Module:  Introduction.java
 * Purpose: A module for introducing the bot and helping users.
 */
public class Introduction extends ListenerAdapter {

    /**
     * Retrieves the bot's introduction.
     * @param e the command to analyze.
     * @return the introduction string.
     */
    private String getIntro(MessageReceivedEvent e) {
        return String.format("Greetings %s. I am *Sea+ Bot*, the official bot "
                + "of the Splatoon competitive team's (Sea+) Discord server! "
                + "If you would like a list of all of things I can do, run "
                + " the `--help` command for more information. Thank you!",
                e.getMember().getEffectiveName());
    }

    /**
     * Retrieves the full list of commands.
     * @return the help string.
     */
    private String getHelpString() {
        return "`--help` - Displays the list of commands.\n"
                + "`--ping [user] [amount]` - Pings a user a certain amount of times.\n"
                + "`--coin toss [amount]` - Tosses a coin a certain amount of times.\n"
                + "`--roll [amount]` - Rolls an amount-sided die, up to 2147483647 sides.\n"
                + "`--introduce` - Runs bot introduction.\n";
    }

    /**
     * Runs the introduction command.
     * @param e the command to analyze.
     */
    @Override
    public void onMessageReceived(MessageReceivedEvent e) {
        String input = e.getMessage().getContentRaw();
        MessageChannel channel = e.getChannel();

        if (input.equals("--introduce")) {
            channel.sendMessage(getIntro(e)).queue();
        } else if (input.equals("--help")) {
            channel.sendMessage(getHelpString()).queue();
        }
    }
}
