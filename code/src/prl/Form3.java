package prl;

import bll.StudentService;
import dao.Student;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;

public class Form3 extends JFrame{

    //private JFrame frame;
    private JTextField usernameField;
    private JTextField passwField;
    private JTextField nameField;
    private JTextField cardField;
    private JTextField pncField;
    private JPanel panel1;
    private JButton signin;
    private JTextArea resp;

    public Form3(){


       super.setSize(500,200);

        this.panel1=new JPanel();
        this.usernameField=new JTextField("Username",20);
        this.passwField=new JTextField("Password",20);
        this.nameField=new JTextField("Name",20);
        this.cardField=new JTextField("Card",5);
        this.pncField=new JTextField("PNC",6);
        this.resp=new JTextArea();

        this.signin=new JButton("Sign In");

        panel1.add(usernameField);
        panel1.add(passwField);
        panel1.add(nameField);
        panel1.add(cardField);
        panel1.add(pncField);
        panel1.add(signin);
        panel1.add(resp);

        panel1.setVisible(true);
        super.add(panel1);
        //this.frame.setVisible(true);



    }


    public void actionButtons()
    {
        signin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                StudentService so=new StudentService();

                if(signin.isEnabled())
                {
                    int id=so.getIdForNew()+1;
                    so.createProfile(new Student(id,id,usernameField.getText(),passwField.getText(),
                            nameField.getText(),Integer.parseInt(cardField.getText()),Integer.parseInt(pncField.getText())));

                }
                resp.setText("The account has been created");

            }
        });


    }
}
