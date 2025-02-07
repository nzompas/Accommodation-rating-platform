package api;

import java.util.ArrayList;

/**
 * Κλάση που υλοποιεί τα usernames για τους απλούς χρήστες
 */
public class username {
    public   ArrayList<String> name = new ArrayList<>();
    public  firstName fn=new firstName();
    public  lastName ln=new lastName();
    public void userName() {};

    /**
     * Προσθέτει ένα username
     * @param nam username
     */

    public void addName(String nam) {
       name.add(nam);
    }
    public String getflName(String flname){
        int i;
        for(i=0;i<name.size();i+=1){
            if(name.get(i).equals(flname)){
                return fn.getfName(i)+ln.getlName(i);
            }
        }
        return null;
    }
}
