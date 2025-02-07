package api;

import java.util.ArrayList;

/**
 * Τύποι καταλύματος
 */
public class typeA {
    public ArrayList<String> typeA = new ArrayList<>();
    public typeA(){};

    /**
     *Προσθέτει τύπο καταλύματος
     */
    public void typeAadd(String n){
        typeA.add(n);
    }
}
