package GUI;

import javax.swing.*;

import Classes.AppUser;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ProfileRegistration extends JFrame implements ActionListener {
    private JLabel frameTitle, firstName, lastName, DOB, email, homeAddress, contactNumber, password, confirmPass;
    private JTextField firstNameTF, lastNameTF, DOBTF, emailTF, homeAddressTF, contactNumberTF;
    private JPasswordField passwordF, confirmPassF;
    private JButton submitButton, goBackButton;
    private JPanel panel;
    private JRadioButton admin, faculty, student;
    private ButtonGroup buttonGroup;
    String designation, goBackID;
    ProfileRegistration(String goBackID) {
        this.goBackID = goBackID;
        this.setTitle("Profile Registration");  // frame title
        this.setSize(500, 650);  // sets x-dimension & y-dimention
        this.setResizable(false);
        ImageIcon image = new ImageIcon("aiub-logo.png"); // creates an ImageIcon
        this.setIconImage(image.getImage()); // change the icon
        this.getContentPane().setBackground(new Color(50, 121, 234)); // change background color
        this.setLocationRelativeTo(null); // make frame in center of screen

        panel = new JPanel();
        panel.setLayout(null);
        panel.setBackground(new Color(50, 107, 168));

        frameTitle = new JLabel("Profile Registration", SwingConstants.CENTER);
        frameTitle.setBounds(55, 20, 400, 50);
        frameTitle.setBackground(new Color(50, 107, 168));
        frameTitle.setForeground(Color.white);
        frameTitle.setFont(new Font("Arial", Font.BOLD, 15));
        frameTitle.setOpaque(true);
        panel.add(frameTitle);

        String splitGoBack[] = goBackID.split("-");
        if(goBackID.equals("NONE")) {
            faculty = new JRadioButton("Faculty");
            faculty.setBounds(115,80,117,30);
            panel.add(faculty);
            student = new JRadioButton("Student");
            student.setBounds(232,80,117,30);
            panel.add(student);
            buttonGroup = new ButtonGroup();
            buttonGroup.add(faculty);
            buttonGroup.add(student);
        }else if(splitGoBack[0].equals("1111")) {
            admin = new JRadioButton("Admin");
            admin.setBounds(50,80,117,30);
            admin.setSelected(true);
            panel.add(admin);
            faculty = new JRadioButton("Faculty");
            faculty.setBounds(167,80,117,30);
            panel.add(faculty);
            student = new JRadioButton("Student");
            student.setBounds(284,80,117,30);
            panel.add(student);
            buttonGroup = new ButtonGroup();
            buttonGroup.add(admin);
            buttonGroup.add(faculty);
            buttonGroup.add(student);
        } else if(splitGoBack[0].equals("2222")) {
            student = new JRadioButton("Student");
            student.setBounds(284,80,117,30);
            panel.add(student);
            buttonGroup = new ButtonGroup();
            buttonGroup.add(student);
        }
        
        firstName = new JLabel("First Name");
        firstName.setBounds(50,120,100,30);
        firstName.setForeground(Color.white);
        panel.add(firstName);

        firstNameTF = new JTextField();
        firstNameTF.setBounds(200,120,200,30);
        panel.add(firstNameTF);

        lastName = new JLabel("Last Name");
        lastName.setBounds(50,170,100,30);
        lastName.setForeground(Color.white);
        panel.add(lastName);

        lastNameTF = new JTextField();
        lastNameTF.setBounds(200,170,200,30);
        panel.add(lastNameTF);
//-----------------------------
        DOB = new JLabel("Date of Birth");
        DOB.setBounds(50,220,100,30);
        DOB.setForeground(Color.white);
        panel.add(DOB);

        DOBTF = new JTextField();
        DOBTF.setBounds(200,220,200,30);
        panel.add(DOBTF);

        contactNumber = new JLabel("Contact Number");
        contactNumber.setBounds(50,270,150,30);
        contactNumber.setForeground(Color.white);
        panel.add(contactNumber);

        contactNumberTF = new JTextField();
        contactNumberTF.setBounds(200,270,200,30);
        panel.add(contactNumberTF);

        email = new JLabel("Email");
        email.setBounds(50,320,100,30);
        email.setForeground(Color.white);
        panel.add(email);

        emailTF = new JTextField();
        emailTF.setBounds(200,320,200,30);
        panel.add(emailTF);

        homeAddress = new JLabel("Home Address");
        homeAddress.setBounds(50,370,150,30);
        homeAddress.setForeground(Color.white);
        panel.add(homeAddress);

        homeAddressTF = new JTextField();
        homeAddressTF.setBounds(200,370,200,30);
        panel.add(homeAddressTF);

        password = new JLabel("Password");
        password.setBounds(50,420,150,30);
        password.setForeground(Color.white);
        panel.add(password);

        passwordF = new JPasswordField();
        passwordF.setBounds(200,420,200,30);
        panel.add(passwordF);

        confirmPass = new JLabel("Confirm Password");
        confirmPass.setBounds(50,470,150,30);
        confirmPass.setForeground(Color.white);
        panel.add(confirmPass);

        confirmPassF = new JPasswordField();
        confirmPassF.setBounds(200,470,200,30);
        panel.add(confirmPassF);

        submitButton = new JButton("Submit");
        submitButton.setBounds(50,520,350,30);
        submitButton.setBackground(new Color(168, 30, 60));
        submitButton.setForeground(Color.WHITE);
        submitButton.setFocusable(false);
        submitButton.setBorder(BorderFactory.createEtchedBorder());
        submitButton.addActionListener(this);
        panel.add(submitButton);

        goBackButton = new JButton("Go Back");
        goBackButton.setBounds(50,570,350,30);
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
        if(buttonText.equals(goBackButton.getText())) {
            String splitGoBack[] = goBackID.split("-");
            if(goBackID.equals("NONE")){
                this.dispose();
                new AppHome();
            }else if(splitGoBack[0].equals("1111")) {
                this.dispose();
                new AdminPrivileges(goBackID);
            }else if(splitGoBack[0].equals("2222")) {
                this.dispose();
                new FacultyPrivileges(goBackID);
            }else if(splitGoBack[0].equals("3333")) {
                this.dispose();
                // new AdminPrivileges(goBackID);
            }
        } else if(firstNameTF.getText().isEmpty()||lastNameTF.getText().isEmpty()||DOBTF.getText().isEmpty()||contactNumberTF.getText().isEmpty()||emailTF.getText().isEmpty()||homeAddressTF.getText().isEmpty()||passwordF.getText().isEmpty()||confirmPassF.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Please fill all the fields");
        } else if(passwordF.getText().equals(confirmPassF.getText()) && passwordF.getText().length() >= 8) { // password length must be >= 8
            // System.out.println("Matched");
            if(admin.isSelected()) {
                designation = "Admin";
            }else if(faculty.isSelected()) {
                designation = "Faculty";
            }else {
                designation = "Student";
            }
            // System.out.println("DOB-------" + DO);
            // AppUser(String firstName, String lastName, String designation, String DOB, String contactNumber, String email, String ID, String homeAddress)
            int temp = JOptionPane.showConfirmDialog(null, "Are you sure want to submit?", "Confirm", JOptionPane.YES_NO_CANCEL_OPTION);
            if(temp == 0) {
                AppUser tempUser = new AppUser(firstNameTF.getText(), lastNameTF.getText(), designation, DOBTF.getText(), contactNumberTF.getText(), emailTF.getText(), "NONE", homeAddressTF.getText(), passwordF.getText());
                JOptionPane.showMessageDialog(null, "Account created successfully\nUser ID : "+tempUser.getID());
                tempUser = null;
                this.dispose();
                new AppHome();
            }
        } else {
            JOptionPane.showMessageDialog(null, "Opps! Password didn't match or \npassword length is less than 8 characters");
        }
    }
}
