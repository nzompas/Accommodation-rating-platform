package gui;

import api.Rating;
import api.accommodation;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.IOException;

public class deleteRat {
    public String name;//onoma user
    public JFrame frame = new JFrame("Πλατφόρμα αξιολόγησης καταλυμάτων");

    public JLabel label = new JLabel();
    public JButton ok = new JButton();
    public JTextField namea = new JTextField();
    public JLabel lb = new JLabel();
    Rating rat = new Rating(1);
    public deleteRat(String n,int k) throws IOException {
        name=n;
        if(k==1) {
            deleteaccom();
        }
    }
    public void deleteaccom(){
        frame.setVisible(true);
        frame.setSize(450, 400);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);
        JButton aposindesi=new JButton("Αποσύνδεση");
        aposindesi.setBounds(5,300,130,30);
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
        label.setText("Εισάγεται το κατάλυμα του οποίου την αξιολόγηση θέλετε να διαγράψετε:");
        label.setBounds(5, 20, 430, 30);
        namea.setBounds(50, 50, 300, 30);
        ok.setText("Διαγραφή αξιολόγησης");
        ok.setBounds(120, 150, 200, 30);
        lb.setBounds(130, 180, 300, 30);
        frame.add(label);
        frame.add(namea);
        frame.add(ok);
        frame.add(lb);
        frame.setLayout(null);
        ok.addActionListener(new ActionListener() {
                                 public void actionPerformed(ActionEvent e) {
                                     int i = rat.findRat(name,namea.getText());
                                     if (i == -1) {
                                         lb.setText("Δεν υπάρχει αξιολόγηση σας στο κατάλυμα!");
                                     } else {
                                         frame.dispose();
                                         rat.deleterat(i);
                                         frame.dispose();
                                         userFunctions prF=new userFunctions(name);
                                     }
                                 }
                             }
        );
    }
}
