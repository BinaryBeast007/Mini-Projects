package GUI;

import java.awt.*;
import javax.swing.*;
import FilesIO.FileReadWrite;
import java.awt.event.*;
import java.io.*;

public class StudentPrivileges extends JFrame implements ActionListener {
    private JLabel aiubTitle, aiubSubTitle;
    // private JTextField firstNameTF, lastNameTF, DOBTF, emailTF, homeAddressTF, contactNumberTF;
    // private JPasswordField passwordF, confirmPassF;
    private JButton viewProfile, notify, goToReg, gradeRep, viewCurr;
    private JPanel panel;
    String designation, ID;

    public StudentPrivileges(String ID) {
        this.ID = ID;
        this.setTitle("Student Privileges");  // frame title
        this.setSize(500, 650);  // sets x-dimension & y-dimention
        this.setResizable(false);
        ImageIcon image = new ImageIcon("aiub-logo.png"); // creates an ImageIcon
        this.setIconImage(image.getImage()); // change the icon
        this.getContentPane().setBackground(new Color(50, 121, 234)); // change background color
        this.setLocationRelativeTo(null); // make frame in center of screen

        panel = new JPanel();
        panel.setLayout(null);
        panel.setBackground(new Color(50, 107, 168));

        aiubTitle = new JLabel("American International University-Bangladesh (AIUB)", SwingConstants.CENTER);
        aiubTitle.setBounds(55, 20, 400, 50);
        aiubTitle.setBackground(new Color(50, 107, 168));
        aiubTitle.setForeground(Color.white);
        aiubTitle.setFont(new Font("Arial", Font.BOLD, 15));
        aiubTitle.setOpaque(true);
        panel.add(aiubTitle);

        aiubSubTitle = new JLabel("-where leaders are created", SwingConstants.CENTER);
        aiubSubTitle.setBounds(100, 60, 300, 30);
        aiubSubTitle.setBackground(new Color(50, 107, 168));
        aiubSubTitle.setForeground(Color.white);
        aiubSubTitle.setFont(new Font("Arial", Font.PLAIN, 15));
        aiubSubTitle.setOpaque(true);
        panel.add(aiubSubTitle);

        notify = new JButton("Notifications");
        notify.setBounds(80,200,350,30);
        notify.setBackground(new Color(168, 30, 60));
        notify.setForeground(Color.WHITE);
        notify.setFocusable(false);
        notify.setBorder(BorderFactory.createEtchedBorder());
        notify.addActionListener(this);
        panel.add(notify);

        goToReg = new JButton("Go to Registration");
        goToReg.setBounds(80,250,350,30);
        goToReg.setBackground(new Color(168, 30, 60));
        goToReg.setForeground(Color.WHITE);
        goToReg.setFocusable(false);
        goToReg.setBorder(BorderFactory.createEtchedBorder());
        goToReg.addActionListener(this);
        panel.add(goToReg);

        gradeRep = new JButton("Grade Reports");
        gradeRep.setBounds(80,300,350,30);
        gradeRep.setBackground(new Color(168, 30, 60));
        gradeRep.setForeground(Color.WHITE);
        gradeRep.setFocusable(false);
        gradeRep.setBorder(BorderFactory.createEtchedBorder());
        gradeRep.addActionListener(this);
        panel.add(gradeRep);

        viewCurr = new JButton("View Curriculum");
        viewCurr.setBounds(80,350,350,30);
        viewCurr.setBackground(new Color(168, 30, 60));
        viewCurr.setForeground(Color.WHITE);
        viewCurr.setFocusable(false);
        viewCurr.setBorder(BorderFactory.createEtchedBorder());
        viewCurr.addActionListener(this);
        panel.add(viewCurr);


        viewProfile = new JButton("View Profile");
        viewProfile.setBounds(80,400,350,30);
        viewProfile.setBackground(new Color(168, 30, 60));
        viewProfile.setForeground(Color.WHITE);
        viewProfile.setFocusable(false);
        viewProfile.setBorder(BorderFactory.createEtchedBorder());
        viewProfile.addActionListener(this);
        panel.add(viewProfile);

        this.add(panel);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);  // makes frame visible
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        String buttonText = e.getActionCommand();
        if(buttonText.equals(notify.getText())) {
            String nt = "";
            try {
                String textFromFile="";
                BufferedReader in = new BufferedReader(new FileReader("FilesIO/Notifications.txt"));
                while ((textFromFile = in.readLine()) != null) {
                    nt += textFromFile + "\n";
                }
                in.close();
            } catch (Exception exx) {
                exx.printStackTrace();
            }
            if(nt.equals(""))
                JOptionPane.showMessageDialog(null, "No notifications to show");
            else
                JOptionPane.showMessageDialog(null, nt);
            // this.dispose();
            // new ProfileRegistration();
            // JOptionPane.showMessageDialog(null, "Under Development!");
        }else if(buttonText.equals(goToReg.getText())) {
            this.dispose();
            new CourseRegistration(ID);
        }else if(buttonText.equals(gradeRep.getText())) {
            // this.dispose();
            // new ProfileRegistration();
            JOptionPane.showMessageDialog(null, "Under Development!");
        }else if(buttonText.equals(viewCurr.getText())) {
            String curriculam = "";
            String textFromFile;
            try {
                BufferedReader in = new BufferedReader(new FileReader("FilesIO/Curriculam.txt"));
                while ((textFromFile = in.readLine()) != null) {
                    curriculam += textFromFile + "\n";
                }
                in.close();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
            JOptionPane.showMessageDialog(null, curriculam);
            // this.dispose();
            // new ProfileRegistration();
        }else if(buttonText.equals(viewProfile.getText())) {
            FileReadWrite fileReadWrite = new FileReadWrite();
            String fromFile = fileReadWrite.searchInFile(ID);
            if(fromFile.equals("")){
                JOptionPane.showMessageDialog(null, "Sorry!\nSomething went wrong!");
            }else {
                String details[] = fromFile.split(" "); String showDetails="Profile\n\n";
                for(int i=0; i<details.length; i++) {
                    if(details[i].contains("Password")) {
                        i++; continue;
                    } 
                    if(i%2==0) {
                        showDetails += details[i] +" ";
                    }else {
                        showDetails += details[i] +"\n";
                    }
                }
                JOptionPane.showMessageDialog(null, showDetails);
            }
        }
    }
}