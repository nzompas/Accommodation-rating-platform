package gui;

import api.accommodation;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Προσθήκη καταχώρησης
 */
public class addAccommodation  {
    public String name;
    public accommodation Accom=new accommodation(1);
public JFrame frame=new JFrame("Πλατφόρμα αξιολόγησης καταλυμάτων");
public JLabel label=new JLabel("Εισάγεται τα στοιχεία του καταλύματος:");
    public JButton ok = new JButton("Προσθήκη");
    public ArrayList<String> accom=new ArrayList<>();
    public JTextField addressa=new JTextField();
    public JTextField typea=new JTextField();
    public JTextField namea=new JTextField();
    public JTextField areaa=new JTextField();
    public JTextField postcodesa=new JTextField();
    public JTextField descriptiona=new JTextField();
    public JTextField viewa=new JTextField();
    public JTextField wca=new JTextField();
   public  JTextField clothWasha=new JTextField();
   public  JTextField funa=new JTextField();
    public JTextField heatinga=new JTextField();
    public JTextField interneta=new JTextField();
    public JTextField kitchena=new JTextField();
   public  JTextField outSpacea=new JTextField();

   public JTextField parkinga=new JTextField();
    /**
     * Δημιουργία JFrame για την προσθήκη καταχώρησης
     */
    public addAccommodation(String n) throws IOException {
        final JLabel lb=new JLabel();
        name=n;
        frame.setVisible(true);
        frame.setSize(800, 800);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        label.setBounds(250,-20,350,100);
        frame.setLayout(null);
        JButton aposindesi=new JButton("Αποσύνδεση");
        aposindesi.setBounds(5,700,130,30);
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
        ok.setBounds(350,700,120,40);
        JLabel nameA=new JLabel("(*)Όνομα:");
        nameA.setBounds(10,20,350,100);
        namea.setBounds(70,55,100,30);
        JLabel typeA=new JLabel("(*)Τύπος:");
        typeA.setBounds(10,60,350,100);
        typea.setBounds(70,95,100,30);
        JLabel addressA=new JLabel("(*)Διεύθυνση:");
        addressA.setBounds(10,100,350,100);
        addressa.setBounds(100,135,100,30);
        JLabel areaA=new JLabel("(*)Πόλη:");
        areaA.setBounds(10,140,350,100);
        areaa.setBounds(70,175,100,30);
        JLabel postcodesA=new JLabel("(*)Ταχυδρομικός Κώδικας:");
        postcodesA.setBounds(10,180,350,100);
        postcodesa.setBounds(170,215,100,30);
        JLabel descriptionA=new JLabel("(*)Περιγραφή:");
        descriptionA.setBounds(10,220,350,100);
        descriptiona.setBounds(100,255,100,30);
        JLabel viewA=new JLabel("Θέα:");
        viewA.setBounds(10,260,350,100);
        viewa.setBounds(60,295,100,30);
        JLabel wcA=new JLabel("Μπάνιο:");
        wcA.setBounds(10,300,350,100);
        wca.setBounds(70,335,100,30);
        JLabel clothWashA=new JLabel("Πλύσιμο ρούχων:");
        clothWashA.setBounds(10,340,350,100);
        clothWasha.setBounds(120,375,100,30);
        JLabel funA=new JLabel("Ψυχαγωγία:");
        funA.setBounds(10,380,350,100);
        funa.setBounds(90,415,100,30);
        JLabel heatingA=new JLabel("Θέρμανση και κλιματισμός:");
        heatingA.setBounds(10,420,350,100);
        heatinga.setBounds(170,455,100,30);
        JLabel internetA=new JLabel("Διαδίκτυο:");
        internetA.setBounds(10,460,350,100);
        interneta.setBounds(80,495,100,30);
        JLabel kitchenA=new JLabel("Κουζίνα και τραπεζαρία:");
        kitchenA.setBounds(10,500,350,100);
        kitchena.setBounds(160,535,100,30);
        JLabel outSpaceA=new JLabel("Εξωτερικός χώρος:");
        outSpaceA.setBounds(10,540,350,100);
        outSpacea.setBounds(140,575,100,30);
        JLabel parkingA=new JLabel("Χώρος στάθμευσης:");
        parkingA.setBounds(10,580,350,100);
        parkinga.setBounds(140,615,100,30);
        lb.setBounds(50,620,350,100);
        frame.add(label);frame.add(ok);frame.add(nameA);frame.add(typeA);
        frame.add(addressA);frame.add(areaA);frame.add(postcodesA);frame.add(descriptionA);
        frame.add(viewA);frame.add(wcA);frame.add(clothWashA);frame.add(funA);frame.add(heatingA);
        frame.add(internetA);frame.add(kitchenA);frame.add(outSpaceA);frame.add(parkingA);frame.add(lb);
        frame.add(namea);frame.add(typea);frame.add(addressa);frame.add(areaa);frame.add(postcodesa);
        frame.add(descriptiona);frame.add(viewa);frame.add(wca);frame.add(clothWasha);frame.add(funa);
        frame.add(heatinga);frame.add(interneta);frame.add(kitchena);frame.add(outSpacea);frame.add(parkinga);
        frame.setLayout(null);
        ok.addActionListener(new ActionListener() {
                                 public void actionPerformed(ActionEvent e) {
                    if(namea.getText().equals("")||typea.getText().equals("")||addressa.getText().equals("")||areaa.getText().equals("")||postcodesa.getText().equals("")||descriptiona.getText().equals("")) {
                        lb.setText("Δεν συμπληρώθηκαν τα απαιτούμενα πεδία(*)!");
                    }
                        else{        accom.add(namea.getText());
                                     accom.add(name);
                                     accom.add(typea.getText());
                                     accom.add(addressa.getText());
                                     accom.add(areaa.getText());
                                     accom.add(postcodesa.getText());
                                     accom.add(descriptiona.getText());
                                     if(viewa.getText().equals("")){
                                        accom.add("Null");
                                     }
                                     else accom.add(viewa.getText());
                                     if(wca.getText().equals("")){
                                         accom.add("Null");
                                     }
                                     else accom.add(wca.getText());
                                     if(clothWasha.getText().equals("")){
                                         accom.add("Null");
                                     }
                                     else accom.add(clothWasha.getText());
                                     if(heatinga.getText().equals("")){
                                         accom.add("Null");
                                     }
                                     else accom.add(heatinga.getText());
                                     if(interneta.getText().equals("")){
                                         accom.add("Null");
                                     }
                                     else accom.add(interneta.getText());
                                     if(funa.getText().equals("")){
                                         accom.add("Null");
                                     }
                                    else  accom.add(funa.getText());
                                     if(kitchena.getText().equals("")){
                                         accom.add("Null");
                                     }
                                     else accom.add(kitchena.getText());
                                     if(outSpacea.getText().equals("")){
                                         accom.add("Null");
                                     }
                                    else  accom.add(outSpacea.getText());
                                     if(parkinga.getText().equals("")){
                                         accom.add("Null");
                                     }
                                     else accom.add(parkinga.getText());
                                     System.out.println(accom);
                        try {
                            accommodation.addAccommodations(accom,1);
                            frame.dispose();
                            providerFunctions prF=new providerFunctions(name);
                        } catch (IOException ex) {
                            throw new RuntimeException(ex);
                        }
                    }
                                 }
                             }
        );
    }
}
