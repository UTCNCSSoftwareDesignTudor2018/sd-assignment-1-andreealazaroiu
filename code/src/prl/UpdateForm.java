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
    private JTextField gri;

    public UpdateForm()
    {
        super.setSize(300,200);
        this.panel=new JPanel();
        this.course=new JTextField("Enter Course name",20);
        this.examDate=new JTextField("Enter Date",10);
        this.addDate=new JButton("Ok");
        this.mes=new JTextArea();
        this.gri=new JTextField("Enter Grade",10);
        panel.add(course);
        panel.add(examDate);
        panel.add(gri);
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
                int grade= Integer.parseInt(gri.getText());
                if(addDate.isEnabled())
                {
                    ao.addExamdate(studentName,c,ec,grade);
                }
                mes.setText("The exam date has been added and also the grade has been added");
            }
        });
    }


    public void doActions2(String studentName)
    {

        AdminService ao=new AdminService();

        addDate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String c=course.getText();
                String ec=examDate.getText();
                if(addDate.isEnabled())
                {
                    ao.addGrade(studentName,c,ec);
                }
                mes.setText("The grade has been added");
            }
        });



    }
}
