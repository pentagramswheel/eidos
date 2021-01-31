package bot;

import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.requests.GatewayIntent;

import javax.security.auth.login.LoginException;

/**
 * @author  Wil Aquino
 * Date:    December 5, 2020
 * Project: Eidos Bot
 * Module:  Main.java
 * Purpose: The entry point of the bot's backend.
 */
public class Main {
    public static void main(String[] args) {
        Events.bot = JDABuilder.createDefault(Discord.getToken())
                .enableIntents(GatewayIntent.GUILD_PRESENCES);
        JDA jda = null;

        Events.bot.addEventListeners(new Events());

        try {
            jda = Events.bot.build();

            String funMessage = "i like ya cut g";
            jda.getPresence().setActivity(Activity.playing(
                    "--help | " + funMessage));
        } catch (LoginException le) {
            le.printStackTrace();
        }
    }
}
