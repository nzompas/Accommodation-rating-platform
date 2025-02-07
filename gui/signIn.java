package gui;

import api.Provider;
import api.User;
import api.firstName;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

/**
 * Εγγραφή χρήστη
 */
public class signIn {
    public String[] sign=new String[4];
    public JButton b = new JButton("Εγγραφή");
    public firstName firstn=new firstName();
    public signIn(){}

    public void datasign(JFrame frame) {
        final JLabel name = new JLabel("Όνομα:");
        name.setBounds(20,50,100,30);
        final JTextField namef = new JTextField();
        namef.setBounds(70, 55, 100, 20);

        final JLabel lastname = new JLabel("Επίθετο:");
        lastname.setBounds(20,90,100,30);
        final JTextField lastnamef = new JTextField();
        lastnamef.setBounds(75, 95, 100, 20);

        final JLabel type = new JLabel("Τύπος χρήστη:");
        type.setBounds(20,210,100,30);
        final JTextField typef = new JTextField();
        typef.setBounds(110, 215, 100, 20);

        final JLabel label = new JLabel();
        label.setBounds(110, 300, 350, 60);
        final JLabel label1=new JLabel("(Χρήστης/Πάροχος)");
        label1.setBounds(20,230,200,30);

        JLabel pass = new JLabel("Password:");
        pass.setBounds(20, 170, 100, 30);
        final JPasswordField passf = new JPasswordField();
        passf.setBounds(85, 175, 100, 20);

        JLabel usern = new JLabel("Username:");
        usern.setBounds(20, 130, 100, 30);
        final JTextField usernf = new JTextField();
        usernf.setBounds(85, 135, 100, 20);

        JLabel l3 = new JLabel("Εγγραφή");
        l3.setBounds(150, 20, 100, 30);

        b.setBounds(150, 280, 100, 30);
        frame.add(b);frame.add(l3);frame.add(label);
        frame.add(name);frame.add(namef);
        frame.add(lastname);frame.add(lastnamef);
        frame.add(type);frame.add(typef);
        frame.add(pass);frame.add(passf);
        frame.add(usern);frame.add(usernf);frame.add(label1);
        frame.setSize(400, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);
        frame.setVisible(true);
        b.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                User nameIsuser= null;
                try {
                    nameIsuser = new User();
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
                Provider nameIsprovider=null;
                try {
                    nameIsprovider=new Provider();
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
                if (usernf.getText().equals("")||String.valueOf(passf.getPassword()).equals("")||namef.getText().equals("")||lastnamef.getText().equals("")||typef.getText().equals("")){
                    label.setText("Δεν συμπληρώθηκαν τα απαιτούμενα πεδία");
                }
              else  if (nameIsuser.ifnameexist(usernf.getText())||nameIsprovider.ifnameexist(usernf.getText())){//Ο χρήστης υπάρχει
                    label.setText("Ο χρήστης υπάρχει ήδη!");
                }

               else if(typef.getText().equals("Χρήστης")){
                    sign[0]=usernf.getText();
                    sign[1]=(String.valueOf(passf.getPassword()));
                    sign[2]=(namef.getText());
                    sign[3]=(lastnamef.getText());
                    nameIsuser.addUser(sign);
                    try {
                        nameIsuser.addfile(sign);
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                    frame.dispose();
                    new userFunctions(usernf.getText());
                }
                else if(typef.getText().equals("Πάροχος")){
                    sign[0]=(usernf.getText());
                    sign[1]=(String.valueOf(passf.getPassword()));
                    sign[2]=(namef.getText());
                    sign[3]=(lastnamef.getText());
                    nameIsprovider.addProvider(sign);
                    frame.dispose();
                    try {
                        nameIsprovider.addfile(sign);
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                    providerFunctions prF=new providerFunctions(usernf.getText());
                }
                else{
                    label.setText("Μη έγκυρος τύπος χρήστη!");
                }
                }

        });
    }
}
