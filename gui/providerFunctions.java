package gui;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

/**
 * Λειτουργίες παρόχων
 */
public class providerFunctions implements ActionListener {
    public JFrame frame=new JFrame("Πλατφόρμα αξιολόγησης καταλυμάτων");
    public JRadioButton prosthiki;
    public JRadioButton epexergasia;
    public JRadioButton diagrafi;
    public JRadioButton plirofories;
    public JLabel text;
public String name;//provider
    /**
     * Δημιουργία JFrame για τις λειτουργίες των παρόχων
     */
    public providerFunctions(String n){
        name=n;
        frame.setVisible(true);
        frame.setSize(500, 500);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        showFunctions();
        }

    /**
     * Εμφάνιση των λειτουργιών των παρόχων
     */
    public void showFunctions() {
        JButton aposindesi=new JButton("Αποσύνδεση");
        aposindesi.setSize(140,20);
        aposindesi.setBounds(160,1,130,30);
        frame.add(aposindesi);
        aposindesi.addActionListener(new ActionListener() {
                                         public void actionPerformed(ActionEvent e) {
                                             frame.dispose();
                                             try {
                                                 new Jframe();
                                             } catch (IOException ex) {
                                                 throw new RuntimeException(ex);
                                             }
                                         }
                                     }
        );
    text=new JLabel("Λειτουργίες:");
    text.setBounds(100,10,350,50);
    prosthiki = new JRadioButton("Προσθήκη καταχώρησης [Δ1]");
     epexergasia = new JRadioButton("Επεξεργασία καταχώρησης [Δ2]");
    diagrafi = new JRadioButton("Διαγραφή καταχώρησης [Δ3]");
     plirofories = new JRadioButton("Καρτέλα καταλυμάτων σας [Δ4]");
    prosthiki.setBounds(10, 50, 300, 30);
    epexergasia.setBounds(10, 80, 300, 30);
    diagrafi.setBounds(10, 110, 300, 30);
    plirofories.setBounds(10, 140, 300, 30);
    JButton b;
    ButtonGroup bg = new ButtonGroup();
    bg.add(prosthiki);
    bg.add(epexergasia);
    bg.add(diagrafi);
    bg.add(plirofories);
    b = new JButton("Επιλογή");
    b.setBounds(90, 180, 100, 30);
    b.addActionListener(this);
    frame.add(prosthiki);frame.add(epexergasia);frame.add(b);frame.add(diagrafi);frame.add(plirofories);frame.add(text);
    frame.setSize(300, 300);
    frame.setLayout(null);
    frame.setVisible(true);
}
        public void actionPerformed(ActionEvent e) {
        if(prosthiki.isSelected()){//Προσθήκη καταχώρησης
            frame.dispose();
            try {
                new addAccommodation(name);
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        }
        else if(epexergasia.isSelected()){//Επεξεργασία καταχώρησης
            frame.dispose();
            try {
                new process(name,1);
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        }
        else if(diagrafi.isSelected()){//Διαγραφή καταχώρησης
            frame.dispose();
            try {
                new delete(name,1);
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        }
        else if(plirofories.isSelected()){//Πληροφορίες καταλυμάτων σας
            frame.dispose();
            try {
                new dashboardP(name);
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        }
    }
}
