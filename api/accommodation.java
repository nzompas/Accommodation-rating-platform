package api;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;

/**
 * Κλάση που υλοποιεί τα καταλύματα
 */
public class accommodation implements openFiles {
    public static nameA name = new nameA();
    public static username provider = new username();
    public static typeA type = new typeA();
    public static addressA address = new addressA();
    public static areaA area = new areaA();
    public static postcodesA postcodes = new postcodesA();
    public static descriptionA description = new descriptionA();
    public static viewA view = new viewA();
    public static wcA wc = new wcA();
    public static clothWashA washing = new clothWashA();
    public static funA fun = new funA();
    public static heatingA heat = new heatingA();
    public static internetA internet = new internetA();
    public static kitchenA kitchen = new kitchenA();
    public static outSpaceA outsp = new outSpaceA();
    public static parkingA parking = new parkingA();
    public String nameP;
    public String nameA;

    public accommodation(int k) throws IOException {
        if (k == 0) {
            files("/files/accommodations.txt");
        }
    }

    /**
     * Καταγράφει τα καταλύματα
     */

    public void files(String ftxt) throws IOException {
        InputStream userR;
        userR = getClass().getResourceAsStream(ftxt);
        BufferedReader reader;
        reader = new BufferedReader(new InputStreamReader(userR));
        String line;
        ArrayList<String> accommodation = new ArrayList<>();
        int i;
        while ((line = reader.readLine()) != null) {
            if (!line.equals("-") && (!line.equals(""))) {
                accommodation.add(line);
                for (i = 0; i < 15; i += 1) {
                    accommodation.add(reader.readLine());
                }
                addAccommodations(accommodation, 0);
                accommodation.removeAll(accommodation);
            }
        }
        userR.close();
    }

    /**
     * Προσθήκη του καταλύματος
     *
     * @param Acc Λίστα με τα στοιχεία του καταλύματος
     * @param k   0 αντικείμενο του api 1 αντικείμενο του gui
     */

    public static void addAccommodations(ArrayList<String> Acc, int k) throws IOException {
        name.nameAadd(Acc.get(0));
        provider.addName(Acc.get(1));
        type.typeAadd(Acc.get(2));
        address.addressAadd(Acc.get(3));
        area.Aadd(Acc.get(4));
        postcodes.Aadd(Acc.get(5));
        description.Aadd(Acc.get(6));
        view.Aadd(Acc.get(7));
        wc.Aadd(Acc.get(8));
        washing.Aadd(Acc.get(9));
        fun.Aadd(Acc.get(10));
        heat.Aadd(Acc.get(11));
        internet.Aadd(Acc.get(12));
        kitchen.Aadd(Acc.get(13));
        outsp.Aadd(Acc.get(14));
        parking.Aadd(Acc.get(15));
        if (k == 1) {
            toFiles();
        }
    }

    /**
     * Εγγραφή του καταλύματος στο αρχείο accommodations.txt
     */
    public static void toFiles() throws IOException {
        int size = name.namesA.size() - 1;
        File myFile = new File("src/files/accommodations.txt");
        FileWriter fw = new FileWriter(myFile, true);
        fw.write("\n" + name.namesA.get(size));
        fw.write("\n" + provider.name.get(size));
        fw.write("\n" + type.typeA.get(size));
        fw.write("\n" + address.addressA.get(size));
        fw.write("\n" + area.areaA.get(size));
        fw.write("\n" + postcodes.postcodesA.get(size));
        fw.write("\n" + description.descriptionA.get(size));
        fw.write("\n" + view.viewA.get(size));
        fw.write("\n" + wc.wcA.get(size));
        fw.write("\n" + washing.clothwashA.get(size));
        fw.write("\n" + fun.funA.get(size));
        fw.write("\n" + heat.heatingA.get(size));
        fw.write("\n" + internet.internetA.get(size));
        fw.write("\n" + kitchen.kitchenA.get(size));
        fw.write("\n" + outsp.outspA.get(size));
        fw.write("\n" + parking.parkingA.get(size) + "\n" + "-");
        fw.close();
    }

    /**
     * Βρίσκει τα καταλύματα του παρόχου
     *
     * @param nam πάροχος
     * @return λίστα με τα καταλύματα του παρόχου
     */

    public int findPrAccom(String nam, String acc) {
        nameP = nam;
        int i = 0;
        for (String x : provider.name) {
            if (x.equals(nameP) && acc.equals(name.namesA.get(i))) {
                return i;
            }
            i += 1;
        }
        return -1;
    }

    /**
     * Διαγράφει ένα κατάλυμα
     * @param i δείχνει ποιο κατάλυμα πρέπει να διαγραφεί
     */
    public void deleteAccom(int i) throws IOException {
        name.namesA.remove(i);
        provider.name.remove(i);
        type.typeA.remove(i);
        address.addressA.remove(i);
        area.areaA.remove(i);
        postcodes.postcodesA.remove(i);
        description.descriptionA.remove(i);
        view.viewA.remove(i);
        wc.wcA.remove(i);
        washing.clothwashA.remove(i);
        fun.funA.remove(i);
        heat.heatingA.remove(i);
        internet.internetA.remove(i);
        kitchen.kitchenA.remove(i);
        outsp.outspA.remove(i);
        parking.parkingA.remove(i);
        deleteAccommodations();
    }

    /**
     *Διαγράφει ένα κατάλυμα από το αρχείο accommodations.txt
     */
    public void deleteAccommodations() throws IOException {
        try {
            PrintWriter writer = new PrintWriter("src/files/accommodations.txt");
            writer.print("");
            writer.close();
            File myObj = new File("src/files/accommodations.txt");
            FileWriter fwr = new FileWriter(myObj, true);
            int i;
            for (i = 0; i < name.namesA.size(); i += 1) {
                fwr.write(name.namesA.get(i) + "\n");
                fwr.write(provider.name.get(i) + "\n");
                fwr.write(type.typeA.get(i) + "\n");
                fwr.write(address.addressA.get(i) + "\n");
                fwr.write(area.areaA.get(i) + "\n");
                fwr.write(postcodes.postcodesA.get(i) + "\n");
                fwr.write(description.descriptionA.get(i) + "\n");
                fwr.write(view.viewA.get(i) + "\n");
                fwr.write(wc.wcA.get(i) + "\n");
                fwr.write(washing.clothwashA.get(i) + "\n");
                fwr.write(fun.funA.get(i) + "\n");
                fwr.write(heat.heatingA.get(i) + "\n");
                fwr.write(internet.internetA.get(i) + "\n");
                fwr.write(kitchen.kitchenA.get(i) + "\n");
                fwr.write(outsp.outspA.get(i) + "\n");
                fwr.write(parking.parkingA.get(i) + "\n" + "-" + "\n");
            }
            fwr.close();
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    /**
     * Προσθέτει το επεξεργασμένο κατάλυμα
     * @param acom λίστα με τα στοιχεία του επεξεργασμένου καταλύματος
     * @param i δείχνει ποιο κατάλυμα πρέπει να αλλάξει
     */
    public void changeAccommodations(ArrayList<String> acom, int i) throws IOException {
        name.namesA.remove(i);
        name.namesA.add(i, acom.get(0));
        provider.name.remove(i);
        provider.name.add(i, acom.get(1));
        type.typeA.remove(i);
        type.typeA.add(i, acom.get(2));
        address.addressA.remove(i);
        address.addressA.add(i, acom.get(3));
        area.areaA.remove(i);
        area.areaA.add(i, acom.get(4));
        postcodes.postcodesA.remove(i);
        postcodes.postcodesA.add(i, acom.get(5));
        description.descriptionA.remove(i);
        description.descriptionA.add(i, acom.get(6));
        view.viewA.remove(i);
        view.viewA.add(i, acom.get(7));
        wc.wcA.remove(i);
        wc.wcA.add(i, acom.get(8));
        washing.clothwashA.remove(i);
        washing.clothwashA.add(i, acom.get(9));
        fun.funA.remove(i);
        fun.funA.add(i, acom.get(10));
        heat.heatingA.remove(i);
        heat.heatingA.add(i, acom.get(11));
        internet.internetA.remove(i);
        internet.internetA.add(i, acom.get(12));
        kitchen.kitchenA.remove(i);
        kitchen.kitchenA.add(i, acom.get(13));
        outsp.outspA.remove(i);
        outsp.outspA.add(i, acom.get(14));
        parking.parkingA.remove(i);
        parking.parkingA.add(i, acom.get(15));
        deleteAccommodations();
    }

    /**
     * Εξετάζει αν υπάρχει ένα κατάλυμα
     * @param nam όνομα καταλύματος που πρέπει να εξεταστεί
     * @return true υπάρχει το κατάλυμα false δεν υπάρχει το κατάλυμα
     */
    public boolean findAccom(String nam) {
        nameA = nam;
        for (String x : name.namesA) {
            if (x.equals(nameA)) {
                return true;
            }
        }
        return false;
    }

    /**
     * δημιουργεί μία λίστα με τα καταλύματα ενός παρόχου
     * @param nameP ο πάροχος
     * @return τη λίστα με τα καταλύματα ενός παρόχου
     */
    public ArrayList<String> Paccomm(String nameP) {
        ArrayList<String> accommP = new ArrayList<>();
        int i;
        for (i = 0; i < name.namesA.size(); i += 1) {
            if (provider.name.get(i).equals(nameP)) {
                accommP.add(name.namesA.get(i));
            }
        }
        return accommP;
    }

    /**
     * Προσδιορίζει ποιο είναι το κατάλυμα
     * @param accomm το κατάλυμα
     * @return έναν αριθμό που Προσδιορίζει ποιο είναι το κατάλυμα
     */
    public int findAcc(String accomm){
       int i;
       for(i=0;i<name.namesA.size();i+=1){
           if(name.namesA.get(i).equals(accomm)) {
               return i;
           }
       }
       return i;
    }
}

