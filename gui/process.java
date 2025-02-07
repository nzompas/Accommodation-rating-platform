package gui;

import api.accommodation;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;

public class process {
    public String NameP;
    public accommodation Accom = new accommodation(1);
    public JFrame frame = new JFrame("Πλατφόρμα αξιολόγησης καταλυμάτων");
    public JLabel label = new JLabel();
   public JButton aposindesi1=new JButton("Αποσύνδεση");
    public JButton ok = new JButton();
    public JButton ok1 = new JButton();
    public ArrayList<String> accom = new ArrayList<>();
    public JTextField addressa = new JTextField();
    public JTextField typea = new JTextField();
    public JTextField namea = new JTextField();
    public JTextField areaa = new JTextField();
    public JTextField postcodesa = new JTextField();
    public JTextField descriptiona = new JTextField();
    public JTextField viewa = new JTextField();
    public JTextField wca = new JTextField();
    public JTextField clothWasha = new JTextField();
    public JTextField funa = new JTextField();
    public JTextField heatinga = new JTextField();
    public JTextField interneta = new JTextField();
    public JTextField kitchena = new JTextField();
    public JTextField outSpacea = new JTextField();
    public JLabel lb = new JLabel();
    public JTextField parkinga = new JTextField();
    public ArrayList<String> providersAccom = new ArrayList<>();
    public
    accommodation accommod = new accommodation(1);

    public process(String nam,int k) throws IOException {
        NameP = nam;
        if(k==1){
        findAccom();
        }
    }

    public void findAccom() {
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
        label.setText("Εισάγεται το κατάλυμα που θέλετε να επεξεργαστείτε:");
        label.setBounds(50, 20, 300, 30);
        namea.setBounds(50, 50, 300, 30);
        ok.setText("Επεξεργασία");
        ok.setBounds(120, 130, 150, 30);
        lb.setBounds(130, 180, 200, 30);
        frame.add(label);
        frame.add(namea);
        frame.add(ok);
        frame.add(lb);
        frame.setLayout(null);
        ok.addActionListener(new ActionListener() {
                                 public void actionPerformed(ActionEvent e) {
                                     int i = accommod.findPrAccom(NameP, namea.getText());
                                     if (i == -1) {
                                         lb.setText("Μη έγκυρο κατάλυμα!");
                                     } else {
                                         frame.dispose();
                                         frame.remove(aposindesi);
                                         proces(i);
                                     }
                                 }
                             }
        );
    }
    public void proces(int i){
        frame.setLayout(null);
        aposindesi1.setBounds(5,700,130,30);
        frame.add(aposindesi1);
        aposindesi1.addActionListener(new ActionListener() {
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
        label.setText("Στοιχεία καταλύματος:");
        frame.setVisible(true);
        frame.setSize(800, 800);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        label.setBounds(310,-20,350,100);
        ok1.setBounds(350,700,200,40);
        ok1.setText("Επεξεργασία καταχώρησης");
        JLabel nameA=new JLabel("(*)Όνομα:");
        nameA.setBounds(10,20,350,100);
        namea.setBounds(70,55,100,30);
        namea.setText(Accom.name.namesA.get(i));
        JLabel typeA=new JLabel("(*)Τύπος:");
        typeA.setBounds(10,60,350,100);
        typea.setBounds(70,95,100,30);
        typea.setText(Accom.type.typeA.get(i));
        JLabel addressA=new JLabel("(*)Διεύθυνση:");
        addressA.setBounds(10,100,350,100);
        addressa.setBounds(100,135,100,30);
        addressa.setText(Accom.address.addressA.get(i));
        JLabel areaA=new JLabel("(*)Πόλη:");
        areaA.setBounds(10,140,350,100);
        areaa.setBounds(70,175,100,30);
        areaa.setText(Accom.area.areaA.get(i));
        JLabel postcodesA=new JLabel("(*)Ταχυδρομικός Κώδικας:");
        postcodesA.setBounds(10,180,350,100);
        postcodesa.setBounds(170,215,100,30);
        postcodesa.setText(Accom.postcodes.postcodesA.get(i));
        JLabel descriptionA=new JLabel("(*)Περιγραφή:");
        descriptionA.setBounds(10,220,350,100);
        descriptiona.setBounds(100,255,100,30);
        descriptiona.setText(Accom.description.descriptionA.get(i));
        JLabel viewA=new JLabel("Θέα:");
        viewA.setBounds(10,260,350,100);
        viewa.setBounds(60,295,100,30);
        if(Accom.view.viewA.get(i).equals("Null")){
            viewa.setText("");
        }
        else{
            viewa.setText(Accom.view.viewA.get(i));
        }
        JLabel wcA=new JLabel("Μπάνιο:");
        wcA.setBounds(10,300,350,100);
        wca.setBounds(70,335,100,30);
        if(Accom.wc.wcA.get(i).equals("Null")){
            wca.setText("");
        }
        else{
            wca.setText(Accom.wc.wcA.get(i));
        }
        JLabel clothWashA=new JLabel("Πλύσιμο ρούχων:");
        clothWashA.setBounds(10,340,350,100);
        clothWasha.setBounds(120,375,100,30);
        if(Accom.washing.clothwashA.get(i).equals("Null")){
            clothWasha.setText("");
        }
        else{
            clothWasha.setText(Accom.washing.clothwashA.get(i));
        }
        JLabel funA=new JLabel("Ψυχαγωγία:");
        funA.setBounds(10,380,350,100);
        funa.setBounds(90,415,100,30);
        if(Accom.fun.funA.get(i).equals("Null")){
            funa.setText("");
        }
        else{
            funa.setText(Accom.fun.funA.get(i));
        }
        JLabel heatingA=new JLabel("Θέρμανση και κλιματισμός:");
        heatingA.setBounds(10,420,350,100);
        heatinga.setBounds(170,455,100,30);
        if(Accom.heat.heatingA.get(i).equals("Null")){
            heatinga.setText("");
        }
        else{
            heatinga.setText(Accom.heat.heatingA.get(i));
        }
        JLabel internetA=new JLabel("Διαδίκτυο:");
        internetA.setBounds(10,460,350,100);
        interneta.setBounds(80,495,100,30);
        if(Accom.internet.internetA.get(i).equals("Null")){
            interneta.setText("");
        }
        else{
            interneta.setText(Accom.internet.internetA.get(i));
        }
        JLabel kitchenA=new JLabel("Κουζίνα και τραπεζαρία:");
        kitchenA.setBounds(10,500,350,100);
        kitchena.setBounds(160,535,100,30);
        if(Accom.kitchen.kitchenA.get(i).equals("Null")){
            kitchena.setText("");
        }
        else{
            kitchena.setText(Accom.kitchen.kitchenA.get(i));
        }
        JLabel outSpaceA=new JLabel("Εξωτερικός χώρος:");
        outSpaceA.setBounds(10,540,350,100);
        outSpacea.setBounds(140,575,100,30);
        if(Accom.outsp.outspA.get(i).equals("Null")){
            outSpacea.setText("");
        }
        else{
            outSpacea.setText(Accom.outsp.outspA.get(i));
        }
        JLabel parkingA=new JLabel("Χώρος στάθμευσης:");
        parkingA.setBounds(10,580,350,100);
        parkinga.setBounds(140,615,100,30);
        if(Accom.parking.parkingA.get(i).equals("Null")){
            parkinga.setText("");
        }
        else{
            parkinga.setText(Accom.parking.parkingA.get(i));
        }
        lb.setBounds(350,750,350,100);
        frame.add(label);frame.add(ok1);frame.add(nameA);frame.add(typeA);
        frame.add(addressA);frame.add(areaA);frame.add(postcodesA);frame.add(descriptionA);
        frame.add(viewA);frame.add(wcA);frame.add(clothWashA);frame.add(funA);frame.add(heatingA);
        frame.add(internetA);frame.add(kitchenA);frame.add(outSpaceA);frame.add(parkingA);frame.add(lb);
        frame.add(namea);frame.add(typea);frame.add(addressa);frame.add(areaa);frame.add(postcodesa);
        frame.add(descriptiona);frame.add(viewa);frame.add(wca);frame.add(clothWasha);frame.add(funa);
        frame.add(heatinga);frame.add(interneta);frame.add(kitchena);frame.add(outSpacea);frame.add(parkinga);
        frame.remove(ok);
        frame.setLayout(null);
        ok1.addActionListener(new ActionListener() {
                                 public void actionPerformed(ActionEvent e) {
                                     if(namea.getText().equals("")||typea.getText().equals("")||addressa.getText().equals("")||areaa.getText().equals("")||postcodesa.getText().equals("")||descriptiona.getText().equals("")) {
                                         lb.setText("Δεν συμπληρώθηκαν τα απαιτούμενα πεδία(*)!");
                                     }
                                     else{
                                         accom.add(namea.getText());
                                         accom.add(NameP);
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
                                         if(funa.getText().equals("")){
                                             accom.add("Null");
                                         }
                                         else  accom.add(funa.getText());
                                         if(heatinga.getText().equals("")){
                                             accom.add("Null");
                                         }
                                         else accom.add(heatinga.getText());
                                         if(interneta.getText().equals("")){
                                             accom.add("Null");
                                         }
                                         else accom.add(interneta.getText());
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
                                         try {
                                             frame.dispose();
                                             Accom.changeAccommodations(accom,i);
                                             providerFunctions prF=new providerFunctions(NameP);
                                         } catch (IOException ex) {
                                             throw new RuntimeException(ex);
                                         }
                                     }
                                 }
                             }
                             );
    }
}

