package prl;

import bll.EnrollmentService;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FormEnroll extends JFrame {
    private JPanel panel;
    private JTextField chooseCourse;
    private JButton okEnroll;
    private JTextArea seeCourses;
    private JTextArea responeEnroll;

    public FormEnroll() {

        super.setSize(400,500);
        this.panel=new JPanel();
        this.chooseCourse=new JTextField("Enter Course Name ",20);
        this.okEnroll=new JButton("Enroll");
        this.seeCourses=new JTextArea(20,25);
        this.responeEnroll=new JTextArea();
        panel.add(seeCourses);
        panel.add(chooseCourse);
        panel.add(okEnroll);
        panel.add(responeEnroll);
        panel.setVisible(true);
        super.add(panel);



    }

    public void doActions(String studentName)
    {
        EnrollmentService eo=new EnrollmentService();

        seeCourses.append("Available Courses are:\n");
        seeCourses.setText(eo.getCourses(studentName));
        okEnroll.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                seeCourses.revalidate();
                String cc=chooseCourse.getText();
                if(okEnroll.isEnabled())
                {
                    eo.createEnrollment(cc,studentName);


                }

                responeEnroll.setText("You have enrolled");
                seeCourses.revalidate();
            }
        });
    }

}
