package gui;

import api.*;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class  dashboardP implements ActionListener {
    public JLabel epiloges=new JLabel();
    public accommodation Accom = new accommodation(1);
    public JLabel nRat=new JLabel();
    public JLabel label = new JLabel();
    public Rating rat=new Rating(1);
    public Provider pr=new Provider();
    public accommodation accomm=new accommodation(1);
    public String nameP;
    public JLabel flname=new JLabel();
    public JLabel tR=new JLabel();
    public JLabel aR=new JLabel();
    public JLabel ac=new JLabel();
    public JLabel addressa = new JLabel();
    public JLabel typea = new JLabel();
    public JLabel namea = new JLabel();
    public JLabel areaa = new JLabel();
    public JLabel postcodesa = new JLabel();
    public JLabel descriptiona = new JLabel();
    public JLabel viewa = new JLabel();
    public JLabel wca = new JLabel();
    public JLabel clothWasha = new JLabel();
    public JLabel funa = new JLabel();
    public JLabel heatinga = new JLabel();
    public JLabel interneta = new JLabel();
    public JLabel kitchena = new JLabel();
    public JLabel outSpacea = new JLabel();
    public JLabel lb = new JLabel();
    public JLabel parkinga = new JLabel();
    public JRadioButton epexergasia;
    public JRadioButton diagrafi;
    public String nameAA;
    JFrame frame1=new JFrame("Πλατφόρμα αξιολόγησης καταλυμάτων");
    accommodation accommod = new accommodation(1);
    public dashboardP(String n) throws IOException {
        nameP=n;
        showdash();
    }
    public void showdash(){
        JFrame frame=new JFrame("Πλατφόρμα αξιολόγησης καταλυμάτων");
        frame.setVisible(true);
        frame.setSize(800, 600);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);
        JButton aposindesi=new JButton("Αποσύνδεση");
        aposindesi.setBounds(5,500,130,30);
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
        int i=pr.findpr(nameP);
        String fln=(pr.fnamep.get(i)+" "+pr.lnamep.get(i)+",");
        flname.setText(fln);
        flname.setBounds(10,30,300,30);
        ArrayList accommP=new ArrayList();
        accommP=accomm.Paccomm(nameP);
        String tr="Ο συνολικός αριθμός των αξιολογήσεων που έχουν δεχθεί τα καταλύματά σας είναι "+ (int)rat.totalr(accommP,0);
        tR.setText(tr);
        tR.setBounds(10,60,600,30);
        String ar="Ο μέσος όρος όλων των αξιολογήσεων των καταλυμάτων σας είναι "+rat.totalr(accommP,1);
        aR.setText(ar);
        aR.setBounds(10,90,600,30);
        ac.setText("Τα καταλύματα σας είναι τα εξής:");
        ac.setBounds(10,120,600,30);
        JLabel ac1=new JLabel("Επιλέξτε ένα για να εμφανιστούν τα χαρακτηριστικά του.");
        ac1.setBounds(10,135,600,30);
        final JLabel label = new JLabel();
        label.setHorizontalAlignment(JLabel.CENTER);
        label.setSize(400,100);
        JButton b=new JButton("Επιλογή");
        b.setBounds(160,175,100,20);
        final JComboBox cb=new JComboBox(accommP.toArray());
        cb.setBounds(10, 175,90,20);
        frame.add(flname);frame.add(tR);frame.add(aR);
        frame.add(cb); frame.add(label); frame.add(b);frame.add(ac);frame.add(ac1);
            b.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    frame.dispose();
                    nameAA=String.valueOf(cb.getItemAt(cb.getSelectedIndex()));
                    int i = accommod.findPrAccom(nameP,String.valueOf(cb.getItemAt(cb.getSelectedIndex())) );
                    showAccomm(String.valueOf(cb.getItemAt(cb.getSelectedIndex())),i);
                }
            });
    }
    public void showAccomm(String accomm,int i){
        label.setText("Στοιχεία καταλύματος:");
        frame1.setVisible(true);
        frame1.setSize(800, 800);
        frame1.setLocationRelativeTo(null);
        frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame1.setLayout(null);
        JButton aposindesi=new JButton("Αποσύνδεση");
        aposindesi.setBounds(5,600,130,30);
        frame1.add(aposindesi);
        aposindesi.addActionListener(new ActionListener() {
                                         public void actionPerformed(ActionEvent e) {
                                             frame1.dispose();
                                             try {
                                                 new Jframe();
                                             } catch (IOException ex) {
                                                 throw new RuntimeException(ex);
                                             }
                                         }
                                     }
        );
        label.setBounds(310,-20,350,100);
        JLabel nameA=new JLabel("Όνομα:");
        nameA.setBounds(10,20,350,100);
        namea.setBounds(60,55,700,30);
        namea.setText(Accom.name.namesA.get(i));
        JLabel typeA=new JLabel("Τύπος:");
        typeA.setBounds(10,40,350,100);
        typea.setBounds(60,75,700,30);
        typea.setText(Accom.type.typeA.get(i));
        JLabel addressA=new JLabel("Διεύθυνση:");
        addressA.setBounds(10,60,350,100);
        addressa.setBounds(90,95,700,30);
        addressa.setText(Accom.address.addressA.get(i));
        JLabel areaA=new JLabel("Πόλη:");
        areaA.setBounds(10,80,350,100);
        areaa.setBounds(60,115,700,30);
        areaa.setText(Accom.area.areaA.get(i));
        JLabel postcodesA=new JLabel("Ταχυδρομικός Κώδικας:");
        postcodesA.setBounds(10,100,350,100);
        postcodesa.setBounds(160,135,700,30);
        postcodesa.setText(Accom.postcodes.postcodesA.get(i));
        JLabel descriptionA=new JLabel("Περιγραφή:");
        descriptionA.setBounds(10,120,350,100);
        descriptiona.setBounds(90,155,900,30);
        descriptiona.setText(Accom.description.descriptionA.get(i));
        JLabel viewA=new JLabel("Θέα:");
        viewA.setBounds(10,140,350,100);
        viewa.setBounds(50,175,700,30);
        if(Accom.view.viewA.get(i).equals("Null")){
            viewa.setText("-");
        }
        else{
            viewa.setText(Accom.view.viewA.get(i));
        }
        JLabel wcA=new JLabel("Μπάνιο:");
        wcA.setBounds(10,160,350,100);
        wca.setBounds(70,195,700,30);
        if(Accom.wc.wcA.get(i).equals("Null")){
            wca.setText("-");
        }
        else{
            wca.setText(Accom.wc.wcA.get(i));
        }
        JLabel clothWashA=new JLabel("Πλύσιμο ρούχων:");
        clothWashA.setBounds(10,180,350,100);
        clothWasha.setBounds(120,215,700,30);
        if(Accom.washing.clothwashA.get(i).equals("Null")){
            clothWasha.setText("-");
        }
        else{
            clothWasha.setText(Accom.washing.clothwashA.get(i));
        }
        JLabel funA=new JLabel("Ψυχαγωγία:");
        funA.setBounds(10,200,350,100);
        funa.setBounds(90,235,700,30);
        if(Accom.fun.funA.get(i).equals("Null")){
            funa.setText("-");
        }
        else{
            funa.setText(Accom.fun.funA.get(i));
        }
        JLabel heatingA=new JLabel("Θέρμανση και κλιματισμός:");
        heatingA.setBounds(10,220,350,100);
        heatinga.setBounds(170,255,700,30);
        if(Accom.heat.heatingA.get(i).equals("Null")){
            heatinga.setText("-");
        }
        else{
            heatinga.setText(Accom.heat.heatingA.get(i));
        }
        JLabel internetA=new JLabel("Διαδίκτυο:");
        internetA.setBounds(10,240,350,100);
        interneta.setBounds(80,275,700,30);
        if(Accom.internet.internetA.get(i).equals("Null")){
            interneta.setText("-");
        }
        else{
            interneta.setText(Accom.internet.internetA.get(i));
        }
        JLabel kitchenA=new JLabel("Κουζίνα και τραπεζαρία:");
        kitchenA.setBounds(10,260,350,100);
        kitchena.setBounds(160,295,700,30);
        if(Accom.kitchen.kitchenA.get(i).equals("Null")){
            kitchena.setText("-");
        }
        else{
            kitchena.setText(Accom.kitchen.kitchenA.get(i));
        }
        JLabel outSpaceA=new JLabel("Εξωτερικός χώρος:");
        outSpaceA.setBounds(10,280,350,100);
        outSpacea.setBounds(135,315,700,30);
        if(Accom.outsp.outspA.get(i).equals("Null")){
            outSpacea.setText("-");
        }
        else{
            outSpacea.setText(Accom.outsp.outspA.get(i));
        }
        JLabel parkingA=new JLabel("Χώρος στάθμευσης:");
        parkingA.setBounds(10,300,350,100);
        parkinga.setBounds(135,335,700,30);
        if(Accom.parking.parkingA.get(i).equals("Null")){
            parkinga.setText("-");
        }
        else{
            parkinga.setText(Accom.parking.parkingA.get(i));
        }
        ArrayList<String> acom=new ArrayList<>();
        acom.add(Accom.name.namesA.get(i));
        nRat.setText("Ο αριθμός των αξιολογήσεων που έχει δεχθεί είναι "+ (int)rat.totalr(acom,0));
        nRat.setBounds(10,355,700,30);
        lb.setText("Ο μέσος όρος των αξιολογήσεων του είναι "+rat.totalr(acom,1));
        lb.setBounds(10,375,700,30);
        epiloges.setText("Επιλογές:");
        epiloges.setBounds(10,395,700,30);
        epexergasia = new JRadioButton("Επεξεργασία καταχώρησης");
        epexergasia.setBounds(10,425,700,30);
        diagrafi = new JRadioButton("Διαγραφή καταχώρησης");
        diagrafi.setBounds(10,450,700,30);
        JButton b;
        ButtonGroup bg = new ButtonGroup();
        bg.add(epexergasia);
        bg.add(diagrafi);
        b = new JButton("Επιλογή");
        b.setBounds(90, 480, 100, 30);
        b.addActionListener(this);
        frame1.add(label);frame1.add(nameA);frame1.add(typeA);frame1.add(nRat);frame1.add(epiloges);
        frame1.add(addressA);frame1.add(areaA);frame1.add(postcodesA);frame1.add(descriptionA);
        frame1.add(viewA);frame1.add(wcA);frame1.add(clothWashA);frame1.add(funA);frame1.add(heatingA);
        frame1.add(internetA);frame1.add(kitchenA);frame1.add(outSpaceA);frame1.add(parkingA);frame1.add(lb);
        frame1.add(namea);frame1.add(typea);frame1.add(addressa);frame1.add(areaa);frame1.add(postcodesa);
        frame1.add(descriptiona);frame1.add(viewa);frame1.add(wca);frame1.add(clothWasha);frame1.add(funa);
        frame1.add(heatinga);frame1.add(interneta);frame1.add(kitchena);frame1.add(outSpacea);frame1.add(parkinga);
        frame1.add(epexergasia);frame1.add(diagrafi);frame1.add(b);
        frame1.setLayout(null);
    }
    public void actionPerformed(ActionEvent e) {
        int i = accommod.findPrAccom(nameP, nameAA);
        if(epexergasia.isSelected()){//Επεξεργασία καταχώρησης
            frame1.dispose();
            try {
                process proc=new process(nameP,0);
                proc.proces(i);
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        }
        else if(diagrafi.isSelected()){//Διαγραφή καταχώρησης
            frame1.dispose();
            try {
               delete del= new delete(nameP,0);
                del.Accom.deleteAccom(i);
                providerFunctions prF=new providerFunctions(nameP);
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        }
    }
}
