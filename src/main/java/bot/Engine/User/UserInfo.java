package bot.Engine.User;

import bot.Engine.Command;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.MessageChannel;

/**
 * @author  Wil Aquino
 * Date:    December 18, 2020
 * Project: Sea+ Bot
 * Module:  UserInfo.java
 * Purpose: Stores and accesses user info into/from a database.
 * Usage:   --profile set [name] [birthday] [pronouns].
 *          --profile [user]
 */
public class UserInfo implements Command {

    /**
     * Runs one of the profile commands.
     * @param inChannel the channel the command was sent in.
     * @param outChannel the channel to output to, if it exists.
     * @param user the user to attach to the command output, if they exist.
     * @param args the arguments of the command, if they exist.
     */
    @Override
    public void runCmd(MessageChannel inChannel, MessageChannel outChannel,
                       Member user, String[] args) {
        if 
    }
}
