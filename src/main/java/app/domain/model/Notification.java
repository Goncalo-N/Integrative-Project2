package app.domain.model;
import java.util.UUID;

public class Notification {
    private final String Email;
    private static final String TEXT = "Your registration has been successful. \n" +
            "Use this password: " + generatePassword();

    public Notification (String Email){
        this.Email = Email;
    }
    public String getEmail() {
        return Email;
    }

    public static String generatePassword() {
        return UUID.randomUUID().toString();
    }


}
