package bot;

import bot.Engine.Chance;
import bot.Engine.Introduction;
import bot.Engine.PingUser;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.MessageChannel;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import java.util.List;

/**
 * @author  Wil Aquino
 * Date:    December 5, 2020
 * Project: Sea+ Bot
 * Module:  Events.java
 * Purpose: Builds the bot by adding commands and analyzing user input.
 * Usages:  See getHelpString() within Introduction class for more
 *          information.
 */
public class Events extends ListenerAdapter {

    /** Field for storing the current state of the bot. */
    public static JDABuilder bot;

    /**
     * Checks if a command has the correct amount of arguments.
     * @param ch the channel to send an error message in.
     * @param args the list of arguments to check.
     * @param n the number of arguments to have.
     */
    private void checkArgs(MessageChannel ch, String[] args, int n) {
        if (args.length > n) {
            ch.sendMessage("Invalid argument input. "
                    + "See `--help` for more info.").queue();
        }
    }

    /**
     * Runs the "--help", "--introduce", or "--thankyou" command.
     * @param user the user who sent the command.
     * @param ch the channel the command was ran in.
     * @param args the arguments of the command.
     */
    private void runIntroCmd(Member user, MessageChannel ch, String[] args) {
        Introduction intro = new Introduction();
        intro.runCmd(ch, null, user, args);
    }

    /**
     * Runs the "--ping" command.
     * @param users the mentioned users.
     * @param ch the channel the command was ran in.
     * @param args the arguments of the command.
     */
    private void runPingCmd(List<Member> users, MessageChannel ch,
                            String[] args) {
        if (users.size() != 1) {
            ch.sendMessage("You can only ping one valid user!").queue();
        } else {
            PingUser ping = new PingUser();
            ping.runCmd(ch, null, users.get(0), args);
        }
    }

    /**
     * Runs the "--coin" or "--roll" command.
     * @param ch the channel the command was ran in.
     * @param args the arguments of the command.
     */
    private void runChanceCmd(MessageChannel ch, String[] args) {
        Chance chance = new Chance();
        chance.runCmd(ch, null, null, args);
    }

    /**
     * Runs one of the bot's commands.
     * @param e the command to analyze.
     */
    @Override
    public void onMessageReceived(MessageReceivedEvent e) {
        String input = e.getMessage().getContentRaw();
        MessageChannel channel = e.getChannel();
        String[] args = input.split(" ", 3);

        switch (args[0]) {
            case "--help":
                checkArgs(channel, args, 1);
                runIntroCmd(null, channel, args);
                break;
            case "--ping":
                checkArgs(channel, args, 3);
                List<Member> ids = e.getMessage().getMentionedMembers();
                runPingCmd(ids, channel, args);
                break;
            case "--coin":
                checkArgs(channel, args, 3);
            case "--roll":
                checkArgs(channel, args, 2);
                runChanceCmd(channel, args);
                break;
            case "--introduce":
            case "--thankyou":
                checkArgs(channel, args, 1);
                runIntroCmd(e.getMember(), channel, args);
                break;
        }
    }
}
