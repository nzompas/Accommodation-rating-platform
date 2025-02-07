package api;
import java.io.*;
import java.util.ArrayList;

/**
 * Κλάση που υλοποιεί τους απλούς χρήστες
 */
public class User {
    public static ArrayList<String> Namep=new ArrayList<>();
    public static ArrayList<String> Passwordp=new ArrayList<>();
    public static ArrayList<String> fnamep=new ArrayList<>();
    public  static ArrayList<String> lnamep=new ArrayList<>();
    /**
     * Κατασκευαστής που ξεκινάει τη διαδικασία αρχικοποίησης χρήστη μέσω αρχείου
     */
    public User()  throws IOException {
    }
    /**
     * Αρχικοποίηση των απλών χρηστών μέσω αρχείου
     * @param ftxt το αρχείο
     */
    public void files(String ftxt) throws IOException {
        InputStream userR;
        userR = getClass().getResourceAsStream(ftxt);
        BufferedReader reader;
        reader = new BufferedReader(new InputStreamReader(userR));
        String line;
        while(( line=reader.readLine()) != null){
            String[] k=line.split(" ",4);
            addData(k);
        }
        userR.close();
    }
    /**
     * Προσθήκη δεδομένων
     * @param k τα δεδομένα
     */
    public void addData(String[] k){
        Namep.add(k[0]);
        Passwordp.add(k[1]);
        fnamep.add(k[2]);
        lnamep.add(k[3]);
    }

    /**
     * Εξετάζει αν ο χρήστης είναι απλός χρήστης
     * @param username Το username που δόθηκε απο τον χρήστη
     * @param password Το password που δόθηκε απο τον χρήστη
     * @return true ο χρήστης είναι πάροχος false ο χρήστης δεν είναι πάροχος
     */
    public boolean ifnameisuser(String username, String password){
        int i=0;
        for(String x:Namep){
            if(x.equals(username)&&Passwordp.get(i).equals(password)) return true;
            i+=1;
        }
        return false;
    }



    /**
     * Προσθέτει έναν χρήστη στους εγγεγραμμένους χρήστες
     * @param user χρήστης που εγγράφτηκε
     */
    public void addUser(String[] user){
        addData(user);
    }

    /**
     * Προσθέτει τα στοιχεία ενός παρόχου στο αρχείο providers.txt
     * @param provider πάροχος που θα προστεθεί
     */
    public  void addfile(String[] provider) throws IOException {
        File myFile = new File("src/files/users.txt");
        FileWriter fw = new FileWriter(myFile,true);
        fw.write("\n"+provider[0]+" "+provider[1]+" "+provider[2]+" "+provider[3]);
        fw.close();
    }
    /**
     * Εξετάζει αν υπάρχει ένας χρήστης
     * @param username το username
     * @return true υπάρχει false δεν υπάρχει
     */
    public boolean ifnameexist(String username){
        int i;
        for(i=0;i<Namep.size();i+=1){
            if(Namep.get(i).equals(username)) return true;
        }
        return false;
    }

    /**
     * Προσδιορίζει τον χρήστη
     * @param nameP όνομα απλού χρήστη
     * @return αριθμός που προσδιορίζει τον χρήστη
     */
    public int findpr(String nameP){
        int i;
        for(i=0;i<Namep.size();i+=1){
            if(Namep.get(i).equals(nameP)) return i;
        }
        return i;
    }
}
