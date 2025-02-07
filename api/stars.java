package api;

import java.util.ArrayList;
import java.util.HashSet;

/**
 * Κλάση που υλοποιεί της βαθμολογίες των καταλυμάτων
 */
public class stars {
    public ArrayList<String> star = new ArrayList<>();

    public stars(){};
    /**
     * Προσθέτει βαθμό αξιολόγησης
     */
    public void starsadd(String k){
        star.add(k);
    }
}
