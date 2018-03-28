package prl;

import bll.AdminService;
import bll.StudentService;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static java.awt.Transparency.TRANSLUCENT;

public class FormAdmin extends JFrame {
    private JPanel panel;
    private JButton view;
    private JButton update;
    private JButton delete;
    private JButton insert;
    private JButton generateReport;
    private JTextArea response;
    private JTextArea studentInfo;
    private JTextField enterStudentName;



    public FormAdmin()
    {

        super.setSize(1000,700);
        this.panel=new JPanel();
        this.view=new JButton("View Student Information");
        this.delete=new JButton("Delete Student Information");
        this.insert=new JButton("Add Exam Date or Grade to Student");
        this.generateReport=new JButton("Generate Student Report");
        this.response=new JTextArea(20,80);
        this.studentInfo=new JTextArea();
        this.enterStudentName=new JTextField("Enter Student Name" ,40);

        panel.add(view);
       // panel.add(update);
        panel.add(delete);
        panel.add(insert);
        panel.add(generateReport);
        panel.add(enterStudentName);
        panel.add(response);
        panel.add(studentInfo);
        panel.setVisible(true);
        JScrollPane scroll=new JScrollPane(panel);
        scroll.setVisible(true);
        super.add(panel);



    }

    public void doActions() {


        AdminService ao=new AdminService();
        this.revalidate();
        this.response.setText(ao.generateAllStudents());
        this.response.append(ao.generateAllCourses());
        this.response.append(ao.generateExamDates());

        view.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(view.isEnabled()) {
                    studentInfo.setText("");
                    studentInfo.append(ao.viewStudent(enterStudentName.getText()));
                }
            }
        });

        generateReport.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(generateReport.isEnabled())
                {
                    studentInfo.setText("");
                    studentInfo.setText(ao.generateReport(enterStudentName.getText()));
                }
            }
        });

        insert.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //We grade a course exam with this function
                if(insert.isEnabled())
                {
                    UpdateForm uf=new UpdateForm();
                    uf.setVisible(true);
                    uf.doActions(enterStudentName.getText());
                }


            }
        });

        delete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(delete.isEnabled())
                {
                    DelStudForm fa=new DelStudForm();
                    fa.setVisible(true);
                    fa.doActions();
                }
                response.setText(ao.generateAllStudents());
                response.append(ao.generateAllCourses());
                response.append(ao.generateExamDates());
            } });

        update.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if(update.isEnabled())
                {
                    UpdateForm fu=new UpdateForm();
                    fu.setVisible(true);
                    fu.doActions2(enterStudentName.getText());
                }

            }
        });
    }



}
