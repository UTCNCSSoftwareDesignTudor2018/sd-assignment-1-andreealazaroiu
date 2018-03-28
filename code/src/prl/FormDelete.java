package prl;

import bll.EnrollmentService;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FormDelete extends JFrame{
    private JPanel panel;
    private JTextField courseName;
    private JTextArea theresponse;
    private JButton okButton;


    public FormDelete()
    {
        super.setSize(400,150);
        this.panel=new JPanel();
        this.courseName=new JTextField("Enter Course name",20);
        this.theresponse=new JTextArea();
        this.okButton=new JButton("Delete Enrollment");
        panel.add(courseName);
        panel.add(okButton);
        panel.add(theresponse);
        super.add(panel);


    }

    public void doAction(String studentName)
    {

        EnrollmentService es=new EnrollmentService();
        okButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String cours=courseName.getText();
                if(okButton.isEnabled())
                {
                    es.deleteEnrollment(cours,studentName);
                }
                theresponse.setText("The Enrollment has been deleted");
            }
        });
    }

}
