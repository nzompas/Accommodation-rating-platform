package api;

import java.util.ArrayList;

/**
 * Κουζίνα και τραπεζαρία
 */
public class kitchenA {
    public ArrayList<String> kitchenA = new ArrayList<>();
    public kitchenA(){};

    /**
     *Προσθέτει την κουζίνα και τα σκεύη του καταλύματος
     */
    public void Aadd(String n){
        kitchenA.add(n);
    }
}
