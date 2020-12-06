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
        JDABuilder jdaBuilder = JDABuilder.createDefault(
                "Nzg1MDI1NDQyNDczNDQzMzM4.X8x16g.9qK7QopSxCU-2m4GP01UGC3GUPE");
        JDA jda;
        try {
            jda = jdaBuilder.build();
        } catch (LoginException le) {
            le.printStackTrace();
        }
    }
}
