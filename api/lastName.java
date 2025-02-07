package api;

import java.util.ArrayList;

/**
 * Επίθετο
 */
public class lastName {
    public  ArrayList<String> lastname = new ArrayList<>();
    public void lastName() {};

    /**
     * Προσθέτει ένα επίθετο
     * @param nam επίθετο
     */

    public void addName(String nam) {
        lastname.add(nam);
    }
    public String getlName(int i) {
        return lastname.get(i);
    }
}
