package prl;

import bll.StudentService;
import dao.User;
import dao.UserDao;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FormUpdate extends JFrame{
    private JPanel panel;
    private JTextField username;
    private JTextField password;
    private JTextField name;
    private JTextField card;
    private JTextField pnc;
    private JButton submit;
    private JTextArea resp;

    public FormUpdate() {

        super.setSize(350,400);
        this.panel=new JPanel();
        this.username=new JTextField(20);
        this.password=new JTextField(20);
        this.name=new JTextField(20);
        this.card=new JTextField(20);
        this.pnc=new JTextField(20);
        this.submit=new JButton("Submit Changes");
        this.resp=new JTextArea();
        panel.add(username);
        panel.add(password);
        panel.add(name);
        panel.add(card);
        panel.add(pnc);
        panel.add(submit);
        panel.add(resp);
        panel.setVisible(true);
        super.add(panel);



    }
    public void doActions(String user)
    {

        StudentService sv=new StudentService();
        username.setText(user);
        password.setText(sv.getUserObj(user).getPassword());
        name.setText(sv.getStudentObj(sv.getUserObj(user)).getName());
        card.setText(""+sv.getStudentObj(sv.getUserObj(user)).getCardNumber());
        pnc.setText(""+sv.getStudentObj(sv.getUserObj(user)).getPnc());

        submit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(submit.isEnabled())
                {
                    sv.updateProfile(username.getText(),password.getText(),name.getText(),
                                        card.getText(),pnc.getText());
                    resp.setText("Changes Saved");
                }

            }
        });
    }


}
