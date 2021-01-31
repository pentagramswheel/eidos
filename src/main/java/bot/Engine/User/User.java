package bot.Engine.User;

/**
 * @author  Wil Aquino
 * Date:    December 18, 2020
 * Project: Eidos Bot
 * Module:  User.java
 * Purpose: Storage class for user data.
 */
public class User {

    /** Field for the user's Discord mention. */
    private String mentionID;

    /** Field for the user's effective name. */
    private String name;

    /** Field for the user's birthday. */
    private String birthday;

    /** Field for the user's preferred pronouns. */
    private String pronouns;

    /**
     * Retrieves the user's name as a Discord mention.
     * @return their Discord mention.
     */
    public String getMentionID() {
        return mentionID;
    }

    /**
     * Retrieves the user's effective name.
     * @return their name.
     */
    public String getName() {
        return name;
    }

    /**
     * Retrieves the user's birthday.
     * @return their birthday.
     */
    public String getBirthday() {
        return birthday;
    }

    /**
     * Retrieves the user's preferred pronouns.
     * @return their pronouns.
     */
    public String getPronouns() {
        return pronouns;
    }

    /**
     * Sets the user's Discord mention.
     * @param mentionID their Discord mention ID.
     */
    public void setMentionID(String mentionID) {
        this.mentionID = mentionID;
    }

    /**
     * Sets the user's effective name.
     * @param name their name.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Sets the user's birthday.
     * @param birthday the date of their birthday.
     */
    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    /**
     * Sets the user's preferred pronouns.
     * @param pronouns their pronouns.
     */
    public void setPronouns(String pronouns) {
        this.pronouns = pronouns;
    }
}
