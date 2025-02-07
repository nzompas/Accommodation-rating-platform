package gui;

import api.accommodation;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.IOException;

public class delete {
    public accommodation Accom = new accommodation(1);
    public String name;
    public JFrame frame = new JFrame("Πλατφόρμα αξιολόγησης καταλυμάτων");
    public JLabel label = new JLabel();
    public JButton ok = new JButton();
    public JTextField namea = new JTextField();
    public JLabel lb = new JLabel();
    accommodation accommod = new accommodation(1);
    public delete(String n,int k) throws IOException {
        name=n;
        if(k==1) {
            deleteaccom();
        }
    }
  public void deleteaccom(){
      frame.setVisible(true);
      frame.setSize(400, 400);
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
      label.setText("Εισάγεται το κατάλυμα που θέλετε να διαγράψετε:");
      label.setBounds(50, 20, 300, 30);
      namea.setBounds(50, 50, 300, 30);
      ok.setText("Διαγραφή");
      ok.setBounds(120, 150, 140, 30);
      lb.setBounds(130, 180, 200, 30);
      frame.add(label);
      frame.add(namea);
      frame.add(ok);
      frame.add(lb);
      frame.setLayout(null);
      ok.addActionListener(new ActionListener() {
                               public void actionPerformed(ActionEvent e) {
                                   int i = accommod.findPrAccom(name, namea.getText());
                                   if (i == -1) {
                                       lb.setText("Μη έγκυρο κατάλυμα!");
                                   } else {
                                       frame.dispose();
                                       try {
                                           Accom.deleteAccom(i);
                                           frame.dispose();
                                           providerFunctions prF=new providerFunctions(name);
                                       } catch (FileNotFoundException ex) {
                                           throw new RuntimeException(ex);
                                       } catch (IOException ex) {
                                           throw new RuntimeException(ex);
                                       }
                                   }
                               }
                           }
      );
  }
}
