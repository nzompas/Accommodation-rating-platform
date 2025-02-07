package api;

import java.util.ArrayList;

/**
 * Χώρος στάθμευσης
 */
public class parkingA {
    public ArrayList<String> parkingA = new ArrayList<>();
    public parkingA(){};

    /**
     *Προσθέτει τον χώρο στάθμευσης του καταλύματος
     */
    public void Aadd(String n){
        parkingA.add(n);
    }
}
