package api;

import java.util.ArrayList;

/**
 * Όνομα του χρήστη
 */
public class firstName {
    public  ArrayList<String> firstname = new ArrayList<>();

    public void firstName() {
    }

    /**
     * Προσθέτει ένα όνομα
     *
     * @param nam όνομα
     */

    public void addName(String nam) {
        firstname.add(nam);
    }

    public String getfName(int i) {
        return firstname.get(i);
    }
}