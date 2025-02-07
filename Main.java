import java.io.IOException;
import api.Provider;
import api.User;
import api.Rating;
import api.accommodation;
import gui.Jframe;

/**
 * Πλατφόρμα αξιολόγησης καταλυμάτων
 */
public class Main {
    public static void main(String[] args) throws IOException {
        User user= new User();
        user.files("/files/users.txt");
        Provider provider=new Provider();
        provider.files("/files/providers.txt");
        Rating rating=new Rating(0);
       accommodation accom=new accommodation(0);
        Jframe frame=new Jframe();
    }
}