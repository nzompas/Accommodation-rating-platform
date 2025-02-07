package api;

import java.util.ArrayList;

/**
 * Κλάση που υλοποιεί τους χρήστες που έχουν αξιολογήσει
 */
public class ratingUsers {
    public ArrayList<String> Rusers = new ArrayList<>();
    public ratingUsers() {};
    /**
     * Προσθέτει χρήστη που έχει αξιολογήσει
     */
    public void RUadd(String k){
        Rusers.add(k);
    }
}
