package bot;

import bot.Engine.Chance;
import bot.Engine.Introduction;
import bot.Engine.PingUser;
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
        JDABuilder jdaBuilder = JDABuilder.createDefault(Discord.getToken());
        JDA jda = null;

        Introduction introCmd = new Introduction();
        PingUser pingCmd = new PingUser();
        Chance chanceCmds = new Chance();

        jdaBuilder.addEventListeners(introCmd);
        jdaBuilder.addEventListeners(pingCmd);
        jdaBuilder.addEventListeners(chanceCmds);

        try {
            jda = jdaBuilder.build();
        } catch (LoginException le) {
            le.printStackTrace();
        }
    }
}
