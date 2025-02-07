package gui;

import api.Provider;
import api.User;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Είσοδος χρήστη
 */
public class logIn  {
    public JButton b = new JButton("Σύνδεση");
public String username;
   public String password;
    public ArrayList<String> firstn=new ArrayList<>();
    public logIn(){}

    /**
     *  Αναγνώριση σύνδεσης από τα credentials
     * @param frame πλατφόρμα
     */
    public void datalog(JFrame frame) throws IOException {
        final JLabel label = new JLabel();
        label.setBounds(70,190, 200,60);
        final JPasswordField value = new JPasswordField();
        value.setBounds(120,105,100,30);
        JLabel l1=new JLabel("Όνομα χρήστη:");
        JLabel l3=new JLabel("Σύνδεση");
        l3.setBounds(120,10,100,30);
        l1.setBounds(20,50, 100,30);
        JLabel l2=new JLabel("Κωδικός:");
        l2.setBounds(20,105, 100,30);
        b.setBounds(105,160, 100,30);
        final JTextField text = new JTextField();
        text.setBounds(120,50, 100,30);
        frame.add(value); frame.add(l1); frame.add(l2); frame.add(b); frame.add(text);frame.add(l3);frame.add(label);
        frame.setSize(300,300);
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
                if (nameIsuser.ifnameisuser(text.getText(), String.valueOf(value.getPassword()))){//Ο χρήστης είναι απλός χρήστης
                    frame.dispose();
                    System.out.println("aplos");
                    new userFunctions(text.getText());
                }
                else{//O χρήστης δεν είναι απλός χρήστης
                    Provider nameIsprovider=null;
                    try {
                         nameIsprovider=new Provider();
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                    if(nameIsprovider.ifnameisprovider(text.getText(), String.valueOf(value.getPassword()))){//Ο χρήστης είναι πάροχος
                        frame.dispose();
                        System.out.println("paroxos");
                    providerFunctions prF=new providerFunctions(text.getText());
                }
                    else{//Ο χρήστης δεν υπάρχει
                       label.setText("Ο χρήστης δεν υπάρχει!");
                }
                }
                  username = text.getText();
                  password= new String(value.getPassword());
            }
        });
    }
    }



