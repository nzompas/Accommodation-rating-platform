package gui;

import api.Rating;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class processRat {
   public  String nameA;
    public JTextField perigrafia=new JTextField();
    public JTextField bathmosa=new JTextField();
    public Rating rat=new Rating(1);
    public JButton ok1 = new JButton();
   String nameU;
    public JFrame frame = new JFrame("Πλατφόρμα αξιολόγησης καταλυμάτων");
    public JLabel label = new JLabel();
    public JButton ok = new JButton();
    public JTextField namea = new JTextField();
    public JLabel lb = new JLabel();
    public JLabel lb5 = new JLabel();
    public  processRat(String nam,int k) throws IOException {
        nameU=nam;
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
        if(k==1) {
            findAccom();
        }
    }
    public void findAccom() {
        frame.setVisible(true);
        frame.setSize(450, 400);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        label.setText("Εισάγεται το κατάλυμα του οποίου την αξιολόγηση θέλετε να επεξεργαστείτε:");
        label.setBounds(5, 20, 450, 30);
        namea.setBounds(50, 50, 300, 30);
        ok.setText("Επεξεργασία αξιολόγησης");
        ok.setBounds(120, 130, 220, 30);
        lb.setBounds(100, 180, 250, 30);
        frame.add(label);
        frame.add(namea);
        frame.add(ok);
        frame.add(lb);
        frame.setLayout(null);
        ok.addActionListener(new ActionListener() {
                                 public void actionPerformed(ActionEvent e) {
                                     nameA=namea.getText();
                                     int i = rat.findRat(nameU, namea.getText());
                                     if (i == -1) {
                                         lb.setText("Δεν υπάρχει αξιολόγηση σας στο κατάλυμα!");
                                     } else {
                                         frame.dispose();
                                         procesRat(i);
                                     }
                                 }
                             }
        );
    }
    public void procesRat(int i){
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
        ok1.setText("Αλλαγή αξιολόγησης");
        JLabel perigrafi=new JLabel("(*)Περιγραφή:");
        perigrafi.setBounds(10,60,350,100);
        perigrafia.setText(rat.text.texts.get(i));
        perigrafia.setBounds(100,95,100,30);
        JLabel bathmosA=new JLabel("(*)Βαθμολογία:");
        bathmosA.setBounds(10,120,350,100);
        bathmosa.setText(rat.star.star.get(i));
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
                                          rat.processRat(bathmos,perigraf,i);
                                          frame.dispose();
                                          userFunctions prF=new userFunctions(nameU);
                                      }
                                  }
                              }
        );
    }
}
