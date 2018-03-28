package prl;

import bll.AdminService;
import bll.StudentService;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Form2 extends JFrame{

    private JButton update;
    private JButton view;
    private JButton viewProfile;
    private JButton enroll;
    private JTextArea viewArea;
    private JButton deleteProfile;
    //private JButton updateProfile;
    private JPanel panel;


    public Form2() {
        super.setSize(800,200);
        panel=new JPanel();
        update =new JButton("Update Personal Information");
        view=new JButton("View Personal Information");
        viewProfile =new JButton("View Enrollments");
        enroll=new JButton("Enroll");
        this.viewArea=new JTextArea();
        this.deleteProfile=new JButton("Delete Enrollment");
        //this.updateProfile=new JButton("Update Enrollment");
        panel.add(update);
        panel.add(view);
        panel.add(viewProfile);
        panel.add(enroll);
        panel.add(deleteProfile);
        //panel.add(updateProfile);
        panel.add(viewArea);
        panel.setVisible(true);
        super.add(panel);



    }


    public void doActions(String studentname)
    {
        StudentService sv=new StudentService();


        view.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(view.isEnabled())
                {
                    viewArea.setText(sv.viewProfile(studentname));
                }

            }
        });

        viewProfile.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if(viewProfile.isEnabled())
                {
                    viewArea.setText(sv.generateEnrollments(studentname));
                }
            }
        });
        deleteProfile.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if(deleteProfile.isEnabled())
                {
                    FormDelete f=new FormDelete();
                    f.setVisible(true);
                    f.doAction(studentname);
                }

            }
        });
        update.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(update.isEnabled())
                {
                    FormUpdate fu=new FormUpdate();
                    fu.setVisible(true);
                    fu.doActions(studentname);
                }


            }
        });

        enroll.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if(enroll.isEnabled())
                {
                    FormEnroll ff=new FormEnroll();
                    ff.setVisible(true);
                    ff.doActions(studentname);
                }
            }
        });

    }
}
