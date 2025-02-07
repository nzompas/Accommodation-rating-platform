package api;

import java.util.ArrayList;
import java.util.HashSet;

/**
 * Kλάση που υλοποιεί τα κείμενα αξιολόγησης
 */
public class textRat {
    public ArrayList<String> texts = new ArrayList<>();

    public textRat(){};
    /**
     * Προσθέτει κείμενο αξιολόγησης
     */

    public void textadd(String k){
        texts.add(k);
    }
}
