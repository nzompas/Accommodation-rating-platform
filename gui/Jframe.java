package gui;

import javax.swing.*;
import java.io.IOException;

/**
 * Κλάση για την υλοποίηση
 */
public class Jframe {
   public JFrame frame= new JFrame("Πλατφόρμα αξιολόγησης καταλυμάτων");
    public logSingin logsign=new logSingin();
   public logIn log=new logIn();
   public signIn sign=new signIn();

    /**
     * Κατασκευαστής, δημιουργείται το αντικείμενο του JFrame
     */
    public Jframe() throws IOException {
        makeFrame();
    }

    /**
     * Εμφάνιση της πλατφόρμας
     */
    private void makeFrame() throws IOException {
        frame.setVisible(true);
        frame.setSize(500, 500);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       int n= logsign.logsign(frame);//δεδομένο εγγραφής ή εισόδου
            if (n == 0) {//Log in
                log.datalog(frame);
            } else if (n==1) {//Sing in
                sign.datasign(frame);
            }
    }
}
