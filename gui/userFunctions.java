package gui;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class userFunctions implements ActionListener {
    public JFrame frame=new JFrame("Πλατφόρμα αξιολόγησης καταλυμάτων");
    public JRadioButton anazitisi;
    public JRadioButton eisagwgh;
    public JRadioButton epejergasia;
    public JRadioButton diagrafi;
    public JRadioButton plirofories;
    public JLabel text;
    public String name;//onoma user
    public userFunctions(String n){
        name=n;
        frame.setVisible(true);
        frame.setSize(500, 500);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        showFunctions();
    }

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
        anazitisi = new JRadioButton("Αναζήτηση καταλυμάτων [Ε1]");
        eisagwgh= new JRadioButton("Εισαγωγή αξιολόγησης [Ε2]");
        epejergasia = new JRadioButton("Επεξεργασία αξιολόγησης [Ε3]");
        diagrafi = new JRadioButton("Διαγραφή αξιολόγησης [Ε4]");
        plirofories = new JRadioButton("Καρτέλα αξιολογήσεων σας [Ε5]");
        anazitisi.setBounds(10, 50, 300, 30);
        eisagwgh.setBounds(10,80,300,30);
        epejergasia.setBounds(10, 110, 300, 30);
        diagrafi.setBounds(10, 140, 300, 30);
        plirofories.setBounds(10, 170, 300, 30);
        JButton b;
        ButtonGroup bg = new ButtonGroup();
        bg.add(anazitisi);
        bg.add(eisagwgh);
        bg.add(epejergasia);
        bg.add(diagrafi);
        bg.add(plirofories);
        b = new JButton("Επιλογή");
        b.setBounds(90, 210, 100, 30);
        b.addActionListener(this);
        frame.add(anazitisi);frame.add(eisagwgh);frame.add(epejergasia);frame.add(b);frame.add(diagrafi);frame.add(plirofories);frame.add(text);
        frame.setSize(300, 300);
        frame.setLayout(null);
        frame.setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if(anazitisi.isSelected()){//Αναζήτηση καταλυμάτων
            frame.dispose();
            new userFunctions(name);
        }
        else if (eisagwgh.isSelected()){//Εισαγωγή αξιολόγησης
            frame.dispose();
            try {
                new addrating(name);
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        }
        else if(epejergasia.isSelected()){//Επεξεργασία αξιολόγησης
            frame.dispose();
            try {
                new processRat(name,1);
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        }
        else if(diagrafi.isSelected()){//Διαγραφή αξιολόγησης
            frame.dispose();
            try {
                new deleteRat(name,1);
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        }
        else if(plirofories.isSelected()){//Πληροφορίες αξιολογήσεων
            frame.dispose();
            try {
                new dashboardU(name);
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        }
    }
}
