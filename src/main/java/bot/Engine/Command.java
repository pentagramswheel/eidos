package bot.Engine;

import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.MessageChannel;

/**
 * @author  Wil Aquino
 * Date:    December 18, 2020
 * Project: Eidos Bot
 * Module:  Command.java
 * Purpose: Template for command classes.
 */
public interface Command {

    /**
     * Runs the command.
     * @param inChannel the channel the command was sent in.
     * @param outChannel the channel to output to, if it exists.
     * @param user the user to attach to the command output, if they exist.
     * @param args the arguments of the command, if they exist.
     */
    void runCmd(MessageChannel inChannel, MessageChannel outChannel,
             Member user, String[] args);
}
