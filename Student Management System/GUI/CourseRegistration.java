package GUI;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileWriter;

public class CourseRegistration extends JFrame implements ActionListener {
    private JPanel panel;
    private String goBackID;
    private JLabel aiubSubTitle, aiubTitle;
    private JCheckBox course1, course2, course3, course4, course5;
    JButton confirmRegiButton, showRegiCoursesButton, goBackButton;

    public CourseRegistration(String goBackId) {
        this.goBackID = goBackId;
        this.setTitle("Course Registration");  // frame title
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

        course1 = new JCheckBox();
        course1.setText("DIFFERENTIAL CALCULUS & CO-ORDINATE GEOMETRY");
        course1.setBounds(50, 150, 400, 30);
        course1.setFocusable(false);
        panel.add(course1);

        course2 = new JCheckBox();
        course2.setText("PHYSICS 1");
        course2.setBounds(50, 180, 400, 30);
        course2.setFocusable(false);
        panel.add(course2);

        course3 = new JCheckBox();
        course3.setText("ENGLISH READING SKILLS & PUBLIC SPEAKING");
        course3.setBounds(50, 210, 400, 30);
        course3.setFocusable(false);
        panel.add(course3);

        course4 = new JCheckBox();
        course4.setText("INTRODUCTION TO PROGRAMMING");
        course4.setBounds(50, 240, 400, 30);
        course4.setFocusable(false);
        panel.add(course4);

        course5 = new JCheckBox();
        course5.setText("INTRODUCTION TO COMPUTER STUDIES");
        course5.setBounds(50, 270, 400, 30);
        course5.setFocusable(false);
        panel.add(course5);

        confirmRegiButton = new JButton("Confirm Registration");
        confirmRegiButton.setBounds(50,330,400,30);
        confirmRegiButton.setBackground(new Color(168, 30, 60));
        confirmRegiButton.setForeground(Color.WHITE);
        confirmRegiButton.setFocusable(false);
        confirmRegiButton.setBorder(BorderFactory.createEtchedBorder());
        confirmRegiButton.addActionListener(this);
        panel.add(confirmRegiButton);

        showRegiCoursesButton = new JButton("Show Registered Courses");
        showRegiCoursesButton.setBounds(50,380,400,30);
        showRegiCoursesButton.setBackground(new Color(168, 30, 60));
        showRegiCoursesButton.setForeground(Color.WHITE);
        showRegiCoursesButton.setFocusable(false);
        showRegiCoursesButton.setBorder(BorderFactory.createEtchedBorder());
        showRegiCoursesButton.addActionListener(this);
        panel.add(showRegiCoursesButton);

        goBackButton = new JButton("Go Back");
        goBackButton.setBounds(50,430,400,30);
        goBackButton.setBackground(new Color(168, 30, 60));
        goBackButton.setForeground(Color.WHITE);
        goBackButton.setFocusable(false);
        goBackButton.setBorder(BorderFactory.createEtchedBorder());
        goBackButton.addActionListener(this);
        panel.add(goBackButton);


        this.add(panel);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);  // makes frame visible
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String buttonText = e.getActionCommand();
        String selectedCourses = "";
        if(course1.isSelected()) {
            selectedCourses += course1.getText() +" &";
        }
        if(course2.isSelected()) {
            selectedCourses += course2.getText()+" &";
        }
        if(course3.isSelected()) {
            selectedCourses += course3.getText()+" &";
        }
        if(course4.isSelected()) {
            selectedCourses += course4.getText()+" &";
        }if(course5.isSelected()) {
            selectedCourses += course5.getText()+" &";
        }
        if(buttonText.equals(confirmRegiButton.getText())) {
            if(selectedCourses.equals("")) {
                JOptionPane.showMessageDialog(null, "No courses has been selected");
            }else {
                int temp = JOptionPane.showConfirmDialog(null, "Are you sure want to confirm?", "Confirm", JOptionPane.YES_NO_CANCEL_OPTION);
                if(temp == 0) {
                    try {
                        String textToWrite = "ID: & "+goBackID +" & Status : Confirmed & Registered Courses & "+selectedCourses+"\n";
                        BufferedWriter out = new BufferedWriter(new FileWriter("FilesIO/Registration.txt", true));
                        out.write(textToWrite);
                        out.close();
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                }
            }
            // JOptionPane.showMessageDialog(null, "Under Development!");
        } else if(buttonText.equals(showRegiCoursesButton.getText())) {
            if(selectedCourses.equals("")) {
                JOptionPane.showMessageDialog(null, "No courses has been selected");
            }else {
                String courses[] = selectedCourses.split("&");
                selectedCourses = "";
                for(String s : courses) selectedCourses += s + "\n";
                JOptionPane.showMessageDialog(null, selectedCourses, "Selected Courses", JOptionPane.OK_OPTION);
            }
        } else if (buttonText.equals(goBackButton.getText())) {
            new StudentPrivileges(goBackID);
        }
    }
}
