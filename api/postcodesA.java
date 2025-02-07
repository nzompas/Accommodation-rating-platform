package api;

import java.util.ArrayList;

/**
 * Ταχυδρομικοί κώδικες καταλυμάτων
 */
public class postcodesA {
    public ArrayList<String> postcodesA = new ArrayList<>();
    public postcodesA(){};

    /**
     *Προσθέτει τ.κ. καταλύματος
     */
    public void Aadd(String n){
        postcodesA.add(n);
    }
}
