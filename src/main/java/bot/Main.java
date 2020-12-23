package bot;

import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;

import javax.security.auth.login.LoginException;

/**
 * @author  Wil Aquino
 * Date:    December 5, 2020
 * Project: Sea+ Bot
 * Module:  Main.java
 * Purpose: The entry point of the bot's backend.
 */
public class Main {
    public static void main(String[] args) {
        Events.bot = JDABuilder.createDefault(Discord.getToken());
        JDA jda = null;

        Events.bot.addEventListeners(new Events());

        try {
            jda = Events.bot.build();
        } catch (LoginException le) {
            le.printStackTrace();
        }
    }
}
