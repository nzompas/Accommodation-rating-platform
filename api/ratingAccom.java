package api;

import java.util.ArrayList;

/**
 * Κλάση που υλοποιεί τα καταλύματα που έχουν αξιολογηθεί
 */
public class ratingAccom {
    public ArrayList<String> Raccom = new ArrayList<>();
    public ratingAccom(){};
    /**
     * Προσθέτει κατάλυμα που έχει αξιολογηθεί
     */
    public void RAadd(String k){
        Raccom.add(k);
    }

}
