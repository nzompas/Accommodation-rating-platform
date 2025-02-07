package gui;

import javax.swing.*;

/**
 * Δίνει τη δυνατότητα εγγραφής ή εισόδου
 */
public class logSingin {
public int ans;
    public logSingin(){;}

    /**
     * Εμφάνιση για την εγγραφή ή την είσοδο
     * @param frame πλατφόρμα
     * @return 0 είσοδος 1 εγγραφή
     */
    public int logsign(JFrame frame)  {
        Object[] options = {"Σύνδεση", "Εγγραφή"};
        final JTextField text = new JTextField();
        text.setBounds(100,20, 100,30);

        int n = JOptionPane.showOptionDialog(frame,
                "θα θέλατε να συνδεθείτε ή να εγγραφείτε;",
                "Log in/Sign in",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null,
                options,
                options[0]);
        return n;
    }
}
