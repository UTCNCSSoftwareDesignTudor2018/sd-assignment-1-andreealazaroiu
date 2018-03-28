package prl;

import bll.AdminService;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UpdateForm extends JFrame{
    private JPanel panel;
    private JTextField course;
    private JTextField examDate;
    private JButton addDate;
    private JTextArea mes;

    public UpdateForm()
    {
        super.setSize(300,200);
        this.panel=new JPanel();
        this.course=new JTextField("Enter Course name",20);
        this.examDate=new JTextField(20);
        this.addDate=new JButton("Ok");
        this.mes=new JTextArea();
        panel.add(course);
        panel.add(examDate);
        panel.add(addDate);
        panel.add(mes);
        panel.setVisible(true);
        super.add(panel);


    }

    public void doActions(String studentName)
    {
        AdminService ao=new AdminService();

        addDate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String c=course.getText();
                String ec=examDate.getText();
                if(addDate.isEnabled())
                {
                    ao.addExamdate(studentName,c,ec);
                }
                mes.setText("The exam date has been added");
            }
        });
    }
}
