package prl;

import bll.UserService;
import dao.Student;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;

public class Form1 extends JFrame {
    //private JFrame frame;
    private JPanel panel1;
    private JPanel panel2;
    private JTextField username;
    private JPasswordField password;
    private JButton login;
    private JButton signin;
    private JPanel panel3;
    private JTextArea pleaseSignin;

    public Form1() {



        super.setSize(500, 200);
        this.panel1 = new JPanel();
        this.panel2 = new JPanel();
        this.panel3 = new JPanel();
        this.username = new JTextField(20);
        this.password = new JPasswordField(20);
        this.login = new JButton("Login");
        this.signin = new JButton("Sign In");
        this.pleaseSignin = new JTextArea();
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
        super.add(panel1);
        super.setVisible(true);

    }
    public void actions()
    {

        login.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                UserService us=new UserService();
                String u=username.getText();
                String pa=password.getText();
                if(login.isEnabled() && us.verifyLogin(u,pa) && us.isAdmin(u,pa))
                {FormAdmin f= new FormAdmin();
                    f.setVisible(true);
                    f.doActions();}

                if(login.isEnabled() && us.verifyLogin(u,pa) && !us.isAdmin(u,pa))
                {   Form2 f2=new Form2();
                    f2.setVisible(true);
                    f2.doActions(u);
                }





            }
        });
        signin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Form3 f=new Form3();
                if(signin.isEnabled())
                { f.setVisible(true);
                    f.actionButtons();

                }
                f.getDefaultCloseOperation();



            }
        });
    }
    }

