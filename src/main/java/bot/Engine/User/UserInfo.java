package bot.Engine.User;

import bot.Engine.Command;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.OnlineStatus;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.MessageChannel;

import java.awt.*;

/**
 * @author  Wil Aquino
 * Date:    December 18, 2020
 * Project: Eidos Bot
 * Module:  UserInfo.java
 * Purpose: Stores and accesses user info into/from a database.
 * Usage:   --profile set [name] [birthday] [pronouns].
 *          --profile [user]
 */
public class UserInfo implements Command {

    /**
     * Creates and outputs an embed using with a user's info.
     * @param avi the Discord avatar of the user.
     * @param tag the user's Discord tag.
     * @param name the name of the user.
     * @param birthday the birthday of the user.
     * @param pronouns the user's pronouns.
     */
    private void embedProfile(MessageChannel channel, String avi,
                              String tag, String name, OnlineStatus status,
                              String birthday, String pronouns) {
        EmbedBuilder eb = new EmbedBuilder();
        eb.setColor(Color.CYAN);

        eb.setThumbnail(avi);
        eb.addField("User", name, true);
        eb.addField("Tag", tag, true);
        eb.addField("Status", status.toString(), true);
        eb.addField("Birthday", birthday, true);
        eb.addField("Pronouns", pronouns, true);

        channel.sendMessage(eb.build()).queue();
    }

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
        String avatar = user.getUser().getAvatarUrl();
        String tag = user.getUser().getAsTag();
        String name = user.getEffectiveName();

        embedProfile(inChannel, avatar, tag, name, user.getOnlineStatus(), "10/17", "he/him/his");
    }
}
