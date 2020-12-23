package bot.Engine;

import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.MessageChannel;

/**
 * @author  Wil Aquino
 * Date:    December 5, 2020
 * Project: Sea+ Bot
 * Module:  Introduction.java
 * Purpose: A module for introducing the bot and helping users.
 * Usage:   --help
 *          --introduce
 *          --thankyou
 */
public class Introduction implements Command {

    /**
     * Retrieves the bot's introduction.
     * @param user the user who sent the command.
     * @return the introduction string.
     */
    private String getIntro(Member user) {
        return String.format("Greetings %s. I am `Sea+ Bot`, the official bot "
                + "of the Splatoon competitive team's (Sea+) Discord server! "
                + "If you would like a list of all of things I can do, run "
                + " the `--help` command for more information. Thank you!",
                user.getEffectiveName());
    }

    /**
     * Retrieves the full list of commands.
     * @return the help string.
     */
    private String getHelpString() {
        return "`--help` - Displays the list of commands.\n"
                + "`--ping [user] [amount]` - Pings a user a certain amount of times.\n"
                + "`--coin toss [amount]` - Tosses a coin a certain amount of times.\n"
                + "`--roll [amount]` - Rolls an amount-sided die, up to `2147483647` sides.\n"
                + "`--introduce` - Runs bot introduction.\n"
                + "`--thankyou` - Thank the bot.";
    }

    /**
     * Retrieves the thank you string.
     * @param user the user who sent the command.
     * @return the thank you string.
     */
    private String getWelcome(Member user) {
        return "You are very welcome master " + user.getEffectiveName() + ".";
    }

    /**
     * Runs one of the introduction commands.
     * @param inChannel the channel the command was sent in.
     * @param outChannel the channel to output to, if it exists.
     * @param user the user to attach to the command output, if they exist.
     * @param args the arguments of the command, if they exist.
     */
    @Override
    public void runCmd(MessageChannel inChannel, MessageChannel outChannel,
                    Member user, String[] args) {
        switch (args[0]) {
            case "--introduce":
                inChannel.sendMessage(getIntro(user)).queue();
                break;
            case "--help":
                inChannel.sendMessage(getHelpString()).queue();
                break;
            case "--thankyou":
                inChannel.sendMessage(getWelcome(user)).queue();
                break;
        }
    }
}
