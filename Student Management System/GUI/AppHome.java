package GUI;
import Classes.LogIn;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class AppHome extends JFrame implements ActionListener {
    private JLabel aiubTitle, aiubSubTitle, userID, userPassword;
    private JTextField userIDTF;
    private JPasswordField passwordField;
    private JButton loginButton, createAccount;
    private JPanel panel;
    private JRadioButton admin, faculty, student;
    private ButtonGroup buttonGroup;

    public AppHome() {
        this.setTitle("HOME");  // frame title


        this.setSize(500, 650);  // sets x-dimension & y-dimention
        ImageIcon image = new ImageIcon("aiub-logo.png"); // creates an ImageIcon
        this.setIconImage(image.getImage()); // change the icon
        this.setResizable(false);
        this.getContentPane().setBackground(new Color(50, 121, 234)); // change background color
        this.setLocationRelativeTo(null); // make frame in center of screen

        panel = new JPanel();
        panel.setLayout(null);
        panel.setBackground(new Color(50, 107, 168));
    //    aiubLogo = new JLabel();
    //    ImageIcon logo = new ImageIcon("logo.png");
    //    aiubLogo.setVisible(true);
    //    aiubLogo.setIcon(new ImageIcon("aiub-logo.png"));
    //    aiubLogo.setBounds(190, 5, 100, 100);
    //    aiubLogo.setBackground(Color.RED);
    //    aiubLogo.setOpaque(true);
    //    aiubLogo.setVisible(true);
    //    panel.add(aiubLogo);

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

        userID = new JLabel("User ID");
        userID.setBounds(120,255,60,30);
        panel.add(userID);

        userIDTF = new JTextField();
        userIDTF.setBounds(220,255,200,30);
        panel.add(userIDTF);

        userPassword = new JLabel("Password");
        userPassword.setBounds(120,290,100,30);
        panel.add(userPassword);

        passwordField = new JPasswordField();
        passwordField.setBounds(220,290,200,30);
        panel.add(passwordField);

        loginButton = new JButton("LogIn");
        loginButton.setBounds(120,335,300,30);
        loginButton.setBackground(new Color(168, 30, 60));
        loginButton.setForeground(Color.WHITE);
        loginButton.setFocusable(false);
        loginButton.setBorder(BorderFactory.createEtchedBorder());
//        loginButton.addActionListener(this);
        loginButton.addActionListener(this);
        panel.add(loginButton);

        admin = new JRadioButton("Admin");
        admin.setBounds(120,200,100,30);
        admin.setSelected(true);
        panel.add(admin);

        faculty = new JRadioButton("Faculty");
        faculty.setBounds(220,200,100,30);
        panel.add(faculty);

        student = new JRadioButton("Student");
        student.setBounds(320,200,100,30);
        panel.add(student);

        buttonGroup = new ButtonGroup();
        buttonGroup.add(admin);
        buttonGroup.add(faculty);
        buttonGroup.add(student);

        createAccount = new JButton("Create Account");
        createAccount.setBounds(120,375,300,30);
        createAccount.setBackground(new Color(168, 30, 60));
        createAccount.setForeground(Color.WHITE);
        createAccount.setFocusable(false);
        createAccount.setBorder(BorderFactory.createEtchedBorder());
//        loginButton.addActionListener(this);
        createAccount.addActionListener(this);
        panel.add(createAccount);

        this.add(panel);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  // exits out of app on close
        this.setVisible(true);  // makes frame visible
//        this.pack();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String buttonText = e.getActionCommand();
        if(buttonText.equals(createAccount.getText())) {
            this.dispose();
            new ProfileRegistration("NONE");
        }
        // if() 
        if((buttonText.equals(loginButton.getText()) && (userIDTF.getText().isEmpty() || passwordField.getText().isEmpty()))) {
           JOptionPane.showMessageDialog(null, "Please fill all the fields");
        }else {
            if(new LogIn().verifyPassword(userIDTF.getText(), passwordField.getText())) {
                if(userIDTF.getText().contains("1111") && admin.isSelected()) {
                    new AdminPrivileges(userIDTF.getText());
                }else if(userIDTF.getText().contains("2222") && faculty.isSelected()) {
                    new FacultyPrivileges(userIDTF.getText());
                }else if(userIDTF.getText().contains("3333") && student.isSelected()) {
                    new StudentPrivileges(userIDTF.getText());
                }else {
                    JOptionPane.showMessageDialog(null, "Wrong Credentials");
                }
            }else {
                JOptionPane.showMessageDialog(null, "Wrong Credentials");
            }
        }

    //    System.out.println(text);
    //    System.out.println(createAccount.getText());
//        System.out.println(loginButton.getText());
//        panel.setBackground(Color.BLACK);
       
        // new ProfileRegistration("Admin");
    }
}
