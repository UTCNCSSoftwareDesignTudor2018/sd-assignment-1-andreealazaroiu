package prl;

import bll.AdminService;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DelStudForm extends JFrame{
    private JTextField nameStudent;
    private JButton deleteStudent;
    private JTextArea message;
    private JPanel panel;
    //private JTextField curs;

    public DelStudForm()
    {
        super.setSize(350,200);
        this.nameStudent=new JTextField("Enter Student Name",20);
        this.deleteStudent=new JButton("Delete Student");
        this.message=new JTextArea();
        //this.curs=new JTextField("Enter Course Name",20);
        this.panel=new JPanel();
        panel.add(nameStudent);
        //panel.add(curs);
        panel.add(deleteStudent);
        panel.add(message);
        panel.setVisible(true);
        super.add(panel);

    }


    public void doActions()
    {
        AdminService as=new AdminService();
        deleteStudent.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String s=nameStudent.getText();
                if(deleteStudent.isEnabled())
                {
                    as.deleteStudent(s);
                    message.setText("The Student has been deleted");
                }
            }
        });
    }
}
