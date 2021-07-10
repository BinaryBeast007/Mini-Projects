package GUI;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import FilesIO.FileReadWrite;

public class RemoveUser extends JFrame implements ActionListener {
    private JPanel panel;
    private JLabel aiubTitle, aiubSubTitle, removeID;
    private JTextField removeIDTF;
    private JButton remove, goBack;
    String goBackID;
    public RemoveUser(String goBackID) {
        this.goBackID = goBackID;
        this.setTitle("Remove User");  // frame title
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

        removeID = new JLabel("Enter ID to remove");
        removeID.setBounds(80, 200, 150, 30);
        removeID.setBackground(new Color(50, 107, 168));
        removeID.setForeground(Color.white);
        removeID.setFont(new Font("Arial", Font.BOLD, 15));
        removeID.setOpaque(true);
        panel.add(removeID);

        removeIDTF = new JTextField();
        removeIDTF.setBounds(250,200,180,30);
        panel.add(removeIDTF);

        remove = new JButton("Remove");
        remove.setBounds(80,250,350,30);
        remove.setBackground(new Color(168, 30, 60));
        remove.setForeground(Color.WHITE);
        remove.setFocusable(false);
        remove.setBorder(BorderFactory.createEtchedBorder());
        remove.addActionListener(this);
        panel.add(remove);

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
        if(buttonText.equals(remove.getText())) {
            int temp = JOptionPane.showConfirmDialog(null, "Are you sure want to remove [ "+removeIDTF.getText()+" ] this person?", "Confirm", JOptionPane.YES_NO_CANCEL_OPTION);
            if(temp == 0) {
                FileReadWrite fileReadWrite = new FileReadWrite();
                if(removeIDTF.getText().equals(goBackID)) {
                    JOptionPane.showMessageDialog(null, "You can not remove yourself!");
                } else if(fileReadWrite.removeFromFile(removeIDTF.getText())) {
                    
                    JOptionPane.showMessageDialog(null, removeIDTF.getText()+" removed successfully");
                }else {
                    JOptionPane.showMessageDialog(null, removeIDTF.getText()+" not found");
                }
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
