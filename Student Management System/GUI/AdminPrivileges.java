package GUI;

import java.awt.*;
import javax.swing.*;

import FilesIO.FileReadWrite;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;

public class AdminPrivileges extends JFrame implements ActionListener {
    private JLabel aiubTitle, aiubSubTitle;
    // private JTextField firstNameTF, lastNameTF, DOBTF, emailTF, homeAddressTF, contactNumberTF;
    // private JPasswordField passwordF, confirmPassF;
    private JButton viewProfile, addUser, removeUser, searchUser, viewAllUser;
    private JPanel panel;
    String designation, ID;

    public AdminPrivileges(String ID) {
        this.ID = ID;
        this.setTitle("Admin Privileges");  // frame title
        this.setResizable(false);
        this.setSize(500, 650);  // sets x-dimension & y-dimention
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

        addUser = new JButton("Add User");
        addUser.setBounds(80,200,350,30);
        addUser.setBackground(new Color(168, 30, 60));
        addUser.setForeground(Color.WHITE);
        addUser.setFocusable(false);
        addUser.setBorder(BorderFactory.createEtchedBorder());
        addUser.addActionListener(this);
        panel.add(addUser);

        removeUser = new JButton("Remove User");
        removeUser.setBounds(80,250,350,30);
        removeUser.setBackground(new Color(168, 30, 60));
        removeUser.setForeground(Color.WHITE);
        removeUser.setFocusable(false);
        removeUser.setBorder(BorderFactory.createEtchedBorder());
        removeUser.addActionListener(this);
        panel.add(removeUser);

        searchUser = new JButton("Search User");
        searchUser.setBounds(80,300,350,30);
        searchUser.setBackground(new Color(168, 30, 60));
        searchUser.setForeground(Color.WHITE);
        searchUser.setFocusable(false);
        searchUser.setBorder(BorderFactory.createEtchedBorder());
        searchUser.addActionListener(this);
        panel.add(searchUser);

        viewAllUser = new JButton("View All User");
        viewAllUser.setBounds(80,350,350,30);
        viewAllUser.setBackground(new Color(168, 30, 60));
        viewAllUser.setForeground(Color.WHITE);
        viewAllUser.setFocusable(false);
        viewAllUser.setBorder(BorderFactory.createEtchedBorder());
        viewAllUser.addActionListener(this);
        panel.add(viewAllUser);


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
        if(buttonText.equals(addUser.getText())) {
            this.dispose();
            new ProfileRegistration(ID);
        }else if(buttonText.equals(removeUser.getText())) {
            this.dispose();
            new RemoveUser(ID);
        }else if(buttonText.equals(searchUser.getText())) {
            this.dispose();
            new SearchUser(ID);
        }else if(buttonText.equals(viewAllUser.getText())) {
            String textFromFile, showDetails = "";
            try {  
                BufferedReader in = new BufferedReader(new FileReader("FilesIO/ProfileDetails.txt"));
                while ((textFromFile = in.readLine()) != null) {
                    String details[] = textFromFile.split(" ");
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
                    showDetails+="\n";
                }
                in.close();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
            JOptionPane.showMessageDialog(null, showDetails);
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
            // this.dispose();
            // new ProfileRegistration();
        }
    }
}