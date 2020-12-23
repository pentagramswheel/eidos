package bot.Engine.User;

import bot.Engine.Command;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.MessageChannel;
import net.dv8tion.jda.api.entities.TextChannel;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;

/**
 * @author  Wil Aquino
 * Date:    December 5, 2020
 * Project: Sea+ Bot
 * Module:  Birthday.java
 * Purpose: Announces birthdays within the announcements channel.
 */
public class Birthday {

    /**
     * Retrieves the current date and formats it such that it
     * looks like "[month]/[day]".
     * @return the current date.
     */
    private String getDate() {
        String[] currentDate =
                java.time.LocalDate.now().toString().split("-", 3);

        return currentDate[1] + "/" + currentDate[2];
    }

    /**
     * Announces that it's a user's birthday.
     * @param e the command to analyze.
     * @param name the user whose birthday it is.
     */
    private void announce(MessageReceivedEvent e, String name) {
        TextChannel textChannel = e.getGuild().getTextChannelsByName(
                "announcements",true).get(0);
        String message =
                String.format("It's %s's birthday today! Wish them a "
                        + "happy birthday!", name);

        textChannel.sendMessage(message).queue();
    }

    /**
     * Main method for testing.
     * @param args user input.
     */
    public static void main(String[] args) {
        Birthday bday = new Birthday();
        String testBirthday = bday.getDate();
    }
}
