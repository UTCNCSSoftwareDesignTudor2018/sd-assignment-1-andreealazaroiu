package prl;

import bll.UserService;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Form1 extends JFrame {
    private JFrame frame;
    private JPanel panel1;
    private JPanel panel2;
    private JTextField username;
    private JPasswordField password;
    private JButton login;
    private JButton signin;
    private JPanel panel3;
    private JTextArea pleaseSignin;

    public Form1() {


        this.frame=new JFrame();
        this.frame.setSize(500,200);
        this.panel1=new JPanel();
        this.panel2=new JPanel();
        this.panel3=new JPanel();
        this.username=new JTextField(20);
        this.password=new JPasswordField(20);
        this.login=new JButton("Login");
        this.signin=new JButton("Sign In");
        this.pleaseSignin=new JTextArea();
        panel2.add(username);
        panel2.add(password);
        panel3.add(login);
        panel3.add(signin);
        panel3.add(pleaseSignin);
        panel1.add(panel2);
        panel1.add(panel3);
        panel2.setVisible(true);
        panel3.setVisible(true);
        panel1.setVisible(true);
        frame.add(panel1);
        frame.setVisible(true);


        login.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                UserService us=new UserService();


                String u=username.getText();
                String pa=password.getText();
                if(login.isEnabled()&& us.verifyLogin(u,pa))
                    new Form2();
                else
                    pleaseSignin.append("You don't have an account.Please Sign in");



            }
        });
        signin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(signin.isEnabled())
                    new Form3();
            }
        });
    }
}
