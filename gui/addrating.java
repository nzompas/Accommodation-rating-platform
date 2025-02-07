package gui;

import api.Rating;
import api.accommodation;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;

public class addrating {
    String nameU;
    String nameA;
    Rating rat=new Rating(1);
    accommodation accommod = new accommodation(1);
    public JLabel lb5=new JLabel();
    public JFrame frame=new JFrame("Πλατφόρμα αξιολόγησης καταλυμάτων");
    public JLabel label=new JLabel("Εισάγεται την αξιολόγηση του καταλύματος:");
    public JButton ok = new JButton("Εισαγωγή");
    public JButton ok1 = new JButton("Εισαγωγή αξιολόγησης");
    public JTextField namea = new JTextField();
    public JLabel lb = new JLabel();
    public JTextField perigrafia=new JTextField();
    public JTextField bathmosa=new JTextField();
    public addrating(String n) throws IOException {
        nameU=n;
        frame.setVisible(true);
        frame.setSize(800, 800);
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
        findAccom();
    }
    public void findAccom() {

        frame.setVisible(true);
        frame.setSize(400, 400);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        label.setText("Εισάγεται το κατάλυμα που θέλετε να αξιολογήσετε:");
        label.setBounds(50, 20, 300, 30);
        namea.setBounds(50, 50, 300, 30);
        ok.setText("Αξιολόγηση");
        ok.setBounds(110, 150, 140, 30);
        lb.setBounds(115, 180, 200, 30);
        frame.add(label);
        frame.add(namea);
        frame.add(ok);
        frame.add(lb);
        frame.setLayout(null);
        ok.addActionListener(new ActionListener() {
                                 public void actionPerformed(ActionEvent e) {
                                     nameA=namea.getText();
                                     boolean exist = accommod.findAccom(nameA);
                                     if (exist == false) {
                                         lb.setText("Το κατάλυμα δεν υπάρχει!");
                                     } else {
                                         frame.dispose();
                                        Addrating();
                                     }
                                 }
                             }
        );
    }
    public void Addrating(){
        label.setText("Στοιχεία αξιολόγησης:");
        frame.remove(lb);
        frame.setVisible(true);
        frame.remove(namea);
        frame.setSize(500, 500);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        lb5.setBounds(115, 180, 200, 30);
        label.setBounds(200,-20,350,100);
        ok1.setBounds(150,210,180,40);
        JLabel perigrafi=new JLabel("(*)Περιγραφή:");
        perigrafi.setBounds(10,60,350,100);
        perigrafia.setBounds(100,95,100,30);
        JLabel bathmosA=new JLabel("(*)Βαθμολογία:");
        bathmosA.setBounds(10,120,350,100);
        bathmosa.setBounds(100,155,100,30);
        frame.add(ok1);frame.add(label);frame.add(perigrafi);frame.add(perigrafia);
        frame.add(bathmosA);frame.add(bathmosa);
        frame.remove(ok);frame.add(lb5);
        frame.setLayout(null);
        ok1.addActionListener(new ActionListener() {
                                 public void actionPerformed(ActionEvent e) {
                                     String perigraf=perigrafia.getText();
                                     String bathmos=bathmosa.getText();
                                     if(perigraf.equals("")||bathmos.equals("")) {
                                         lb5.setText("Δεν συμπληρώθηκαν τα απαιτούμενα πεδία(*)!");
                                     }
                                     else if(perigraf.length()>500){
                                         lb5.setText("Το κείμενο της αξιολόγησης είναι μεγάλο!");
                                     }
                                     else if(!(bathmos.equals("1")||bathmos.equals("2")||bathmos.equals("3")||bathmos.equals("4")||bathmos.equals("5"))){
                                         lb5.setText("Μη έγκυρη βαθμολογία!");
                                     }
                                     else{
                                         try {
                                             rat.addrat(nameA,nameU,bathmos,perigraf,1);
                                         } catch (IOException ex) {
                                             throw new RuntimeException(ex);
                                         }
                                         frame.dispose();
                                         userFunctions prF=new userFunctions(nameU);
                                     }
                                 }
                             }
        );
    }
}
