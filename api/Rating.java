package api;
import java.io.*;
import java.util.ArrayList;

/**
 * Κλάση που υλοποιεί τις αξιολογήσεις των καταλυμάτων
 */
public class Rating implements openFiles {
    public static stars star = new stars();
    public static textRat text = new textRat();
    public static ratingAccom RA = new ratingAccom();
    public static ratingUsers RU = new ratingUsers();
    ArrayList<String> accommP = new ArrayList<>();

    /**
     * Κατασκευαστής που ξεκινάει τη διαδικασία αρχικοποίησης αξιολογήσεων μέσω αρχείου
     */
    public Rating(int k) throws IOException {
        if (k == 0) {
            files("/files/ratings.txt");
        }
    }

    /**
     * Καταγράφει τις αξιολογήσεις των καταλυμάτων
     *
     * @param ftxt αρχείο κειμένου
     */
    public void files(String ftxt) throws IOException {
        InputStream userR;
        userR = getClass().getResourceAsStream(ftxt);
        BufferedReader reader;
        reader = new BufferedReader(new InputStreamReader(userR));
        String line;
        String line1;
        String line2;
        String line3;
        while ((line = reader.readLine()) != null) {
            if (!(line.equals("-") || line.equals(""))) {
                line1 = reader.readLine();
                line2 = reader.readLine();
                line3 = reader.readLine();
                addrat(line, line1, line2, line3, 0);
            }
        }
        userR.close();
    }

    /**
     * Προσθέτει μία αξιολόγηση
     *
     * @param nameA όνομα καταλύματος
     * @param nameU όνομα χρήστη
     * @param bath  βαθμολογία
     * @param per   περιγραφή
     * @param k     0 τίποτα 1 προσθήκη στο αρχείο
     */
    public void addrat(String nameA, String nameU, String bath, String per, int k) throws IOException {
        RA.RAadd(nameA);
        RU.RUadd(nameU);
        star.starsadd(bath);
        text.textadd(per);
        if (k == 1) {
            addratToFiles(nameA, nameU, bath, per);
        }
    }

    /**
     * Προσθέτει μία αξιολόγηση στο αρχείο ratings.txt
     *
     * @param nameA όνομα καταλύματος
     * @param nameU όνομα χρήστη
     * @param bath  βαθμολογία
     * @param per   περιγραφή
     */
    public void addratToFiles(String nameA, String nameU, String bath, String per) throws IOException {
        File myFile = new File("src/files/ratings.txt");
        FileWriter fw = new FileWriter(myFile, true);
        fw.write("\n" + nameA);
        fw.write("\n" + nameU);
        fw.write("\n" + bath);
        fw.write("\n" + per + "\n" + "-");
        fw.close();
    }

    /**
     * Εξετάζει αν υπάρχει αξιολόγηση ενός χρήστη σε ένα κατάλυμα
     *
     * @param nameA όνομα καταλύματος
     * @param nameU όνομα χρήστη
     * @return -1 δεν υπάρχει αξιολόγηση του χρήστη στο κατάλυμα αλλιώς αριθμό που δείχνει το κατάλυμα που έχει αξιολογήσει
     */
    public int findRat(String nameU, String nameA) {
        int i = 0;
        for (String x : RU.Rusers) {
            if (x.equals(nameU) && nameA.equals(RA.Raccom.get(i))) {
                return i;
            }
            i += 1;
        }

        return -1;
    }

    /**
     * Διαγράφει ένα κατάλυμα
     *
     * @param k δείχνει ποιο κατάλυμα πρέπει να διαγραφεί
     */
    public void deleterat(int k) {
        RA.Raccom.remove(k);
        RU.Rusers.remove(k);
        star.star.remove(k);
        text.texts.remove(k);
        try {
            PrintWriter writer = new PrintWriter("src/files/ratings.txt");
            writer.print("");
            writer.close();
            File myObj = new File("src/files/ratings.txt");
            FileWriter fwr = new FileWriter(myObj, true);
            int i;
            for (i = 0; i < RA.Raccom.size(); i += 1) {
                fwr.write(RA.Raccom.get(i) + "\n");
                fwr.write(RU.Rusers.get(i) + "\n");
                fwr.write(star.star.get(i) + "\n");
                fwr.write(text.texts.get(i) + "\n" + "-" + "\n");
            }
            fwr.close();
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    /**
     * Προσθέτει την επεξεργασμένη αξιολόγηση
     *
     * @param bath επεξεργασμένη βαθμολογία
     * @param per  επεξεργασμένη περιγραφή
     * @param i    δείχνει ποια αξιολόγηση πρέπει να επεξεργαστεί
     */
    public void processRat(String bath, String per, int i) {
        star.star.remove(i);
        star.star.add(i, bath);
        text.texts.remove(i);
        text.texts.add(i, per);
        try {
            PrintWriter writer = new PrintWriter("src/files/ratings.txt");
            writer.print("");
            writer.close();
            File myObj = new File("src/files/ratings.txt");
            FileWriter fwr = new FileWriter(myObj, true);
            int k;
            for (k = 0; k < star.star.size(); k += 1) {
                fwr.write(RA.Raccom.get(k) + "\n");
                fwr.write(RU.Rusers.get(k) + "\n");
                fwr.write(star.star.get(k) + "\n");
                fwr.write(text.texts.get(k) + "\n" + "-" + "\n");
            }
            fwr.close();
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    /**
     * Υπολογίζει τις αξιολογήσεις ενός καταλύματος
     * @param accommP το κατάλυμα
     * @param k 0 επιστρέφει τον αριθμό αξιολογήσεων αλλιώς υπολογίζει τον μέσο όρο
     * @return k=0 αριθμός αξιολογήσεων, k!=0 μέσο όρο αξιολογήσεων
     */
    public double totalr(ArrayList<String> accommP, int k) {
        int t = 0;
        for (String x : accommP) {
            for (String y : RA.Raccom) {
                if (x.equals(y)) t += 1;
            }
        }
        if (k == 0) {
            return t;
        } else {
            int r = 0;
            for (String x : accommP) {
                int i;
                for (i = 0; i < RA.Raccom.size(); i += 1) {
                    if (x.equals(RA.Raccom.get(i))) {
                        r += Integer.parseInt(star.star.get(i));
                    }
                }
            }
            System.out.println(r / 10.0);
            return r / (t * 1.0);
        }
    }

    /**
     * Υπολογίζει τον μέσο όρο αξιολογήσεων που έχει κάνει ένας χρήστη
     * @param nameU όνομα χρήστη
     * @return μέσος όρος αξιολογήσεων που έχει κάνει ένας χρήστη
     */
    public double Uaccomm(String nameU) {
        int k = 0;
        int i;
        for (i = 0; i < RU.Rusers.size(); i += 1) {
            if (RU.Rusers.get(i).equals(nameU)) {
                accommP.add(RA.Raccom.get(i));
                k += Integer.parseInt(star.star.get(i));
            }
        }
        return k / (accommP.size() * 1.0);
    }

    /**
     * Επιστρέφει μία λίστα με τα καταλύματα που έχει αξιολογήσει ένας χρήστης
     * @param nameU όνομα χρήστη
     * @return λίστα με τα καταλύματα που έχει αξιολογήσει ένας χρήστης
     */
    public ArrayList<String> Arat(String nameU) {
        return accommP;
    }

    /**
     * Βρίσκει τη βαθμολογία που έχι δώσει ένας χρήστης σε κάποιο κατάλυμα
     * @param accom το κατάλυμα
     * @param user ο χρήστης
     * @return τη βαθμολογία που έχι δώσει ένας χρήστης σε κάποιο κατάλυμα
     */
    public int ratAccom(String accom,String user){
        int i;
        for(i=0;i<RA.Raccom.size();i+=1){
            if(RA.Raccom.get(i).equals(accom)&&RU.Rusers.get(i).equals(user)){
                return Integer.parseInt(star.star.get(i));
            }
        }
        return i;
    }
}

