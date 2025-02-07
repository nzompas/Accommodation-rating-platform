package api;

import java.util.ArrayList;

/**
 * Πλύσιμο ρούχων
 */
public class clothWashA {
    public ArrayList<String> clothwashA = new ArrayList<>();
    public clothWashA(){};

    /**
     *Προσθέτει τις παροχές για το πλύσιμο των ρούχων
     */
    public void Aadd(String n){
        clothwashA.add(n);
    }
}
