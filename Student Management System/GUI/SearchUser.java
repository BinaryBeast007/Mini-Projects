package GUI;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import FilesIO.FileReadWrite;

public class SearchUser extends JFrame implements ActionListener {
    private JPanel panel;
    private JLabel aiubTitle, aiubSubTitle, searchID;
    private JTextField searchIDTF;
    private JButton search, goBack;
    String goBackID;
    public SearchUser(String goBackID) {
        this.goBackID = goBackID;
        this.setTitle("Search User");  // frame title
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

        searchID = new JLabel("Enter ID to search");
        searchID.setBounds(80, 200, 150, 30);
        searchID.setBackground(new Color(50, 107, 168));
        searchID.setForeground(Color.white);
        searchID.setFont(new Font("Arial", Font.BOLD, 15));
        searchID.setOpaque(true);
        panel.add(searchID);

        searchIDTF = new JTextField();
        searchIDTF.setBounds(250,200,180,30);
        panel.add(searchIDTF);

        search = new JButton("Search");
        search.setBounds(80,250,350,30);
        search.setBackground(new Color(168, 30, 60));
        search.setForeground(Color.WHITE);
        search.setFocusable(false);
        search.setBorder(BorderFactory.createEtchedBorder());
        search.addActionListener(this);
        panel.add(search);

        goBack = new JButton("Go Back");
        goBack.setBounds(80,300,350,30);
        goBack.setBackground(new Color(168, 30, 60));
        goBack.setForeground(Color.WHITE);
        goBack.setFocusable(false);
        goBack.setBorder(BorderFactory.createEtchedBorder());
        goBack.addActionListener(this);
        panel.add(goBack);


        this.add(panel);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);  // makes frame visible
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        String buttonText = e.getActionCommand();
        if(buttonText.equals(search.getText())) {
            if(searchIDTF.getText().contains("1111")||searchIDTF.getText().contains("2222")||searchIDTF.getText().contains("3333")){
                FileReadWrite fileReadWrite = new FileReadWrite();
                String fromFile = fileReadWrite.searchInFile(searchIDTF.getText());
                if(fromFile.equals("")){
                    JOptionPane.showMessageDialog(null, searchIDTF.getText()+" not found\nEnter a valid ID");
                }else {
                    String details[] = fromFile.split(" "); String showDetails="ID FOUND!\n\n";
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
            }else {
                JOptionPane.showMessageDialog(null, searchIDTF.getText()+" not found\nEnter a valid ID");
            }
            // this.dispose();
            // new ProfileRegistration();
        }else if(buttonText.equals(goBack.getText())) {
            this.dispose();
            String splitID[] = goBackID.split("-");
            if(splitID[0].equals("1111"))
                new AdminPrivileges(goBackID);
            else if(splitID[0].equals("2222"))
                new FacultyPrivileges(goBackID);
            // else if(splitID[0].equals("3333"))
                // new StudentPrivileges();
        }
    }
}
