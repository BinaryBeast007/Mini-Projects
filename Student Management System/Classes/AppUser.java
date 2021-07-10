package Classes;
import FilesIO.*;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.*;

public class AppUser {
    protected String firstName, lastName, DOB, contactNumber, email, homeAddress, ID, password, designation;

    public AppUser() {
        this.firstName = "NONE";
        this.lastName = "NONE";
        this.DOB = "NONE";
        this.contactNumber = "NONE";
        this.email = "NONE";
        this.homeAddress = "NONE";
        this.ID = "NONE";
        this.designation = "NONE";
    }
    public AppUser(String firstName, String lastName, String designation, String DOB, String contactNumber, String email, String ID, String homeAddress, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.DOB = DOB;
        this.contactNumber = contactNumber;
        this.email = email;
        this.ID = ID;
        this.homeAddress = homeAddress;
        this.designation = designation;
        setPassword(password);
        this.writeProfileDetails();
    }
    // set methods
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public void setDOB(String dOB) {
        DOB = dOB;
    }
    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public void setID(String iD) {
        ID = iD;
    }
    public void setHomeAddress(String homeAddress) {
        this.homeAddress = homeAddress;
    }
    public void setDesignation(String designation) {
        this.designation = designation;
    }
    // get methods
    public String getFirstName() {
        return firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public String getDOB() {
        return DOB;
    }
    public String getContactNumber() {
        return contactNumber;
    }
    public String getEmail() {
        return email;
    }
    public String getID() {
        return ID;
    }
    public String getPassword() {
        return password;
    }
    public String getDesignation() {
        return designation;
    }
    public String getHomeAddress() {
        return homeAddress;
    }
    // write profile details in file
    void writeProfileDetails() {
        String profileDetails = "ID: "+generateID(designation)+" Password: "+password+" Designation: "+designation+" First-Name: "+firstName+" Last-Name: "+lastName+" Date-of-Birth: "+DOB+" Contact-Number: "+contactNumber+" Email: "+email+" Home-Address: "+homeAddress+" Join-TimeStamp: "+new SimpleDateFormat("HH:mm:ss_dd/MM/yyyy").format(new Date())+"\n";
        FileReadWrite fileReadWrite = new FileReadWrite();
        fileReadWrite.writeInFile(profileDetails);  // storing in file
    }
    // generate ID
    public String generateID(String designation) {
        String[] generatedID = new String[3]; // holds 3 parts of ID >> XXXX-XXXX-X
        String newID;   // this will be the generated ID
        if(designation.equals("Admin")) {
            // Admin ID : XXXX-XXXX-X looks like 1111-XXXX-1
            generatedID[0] = "1111"; generatedID[1] = "1001"; generatedID[2] = "1";
        }else if(designation.equals("Faculty")) {
            // Faculty ID : XXXX-XXXX-X
            generatedID[0] = "2222"; generatedID[1] = "2001"; generatedID[2] = "2";
        }else if(designation.equals("Student")) {
            // Student ID : XXXX-XXXX-X
            generatedID[0] = "3333"; generatedID[1] = "3001"; generatedID[2] = "3";
        }
        ArrayList<Integer> allID = new ArrayList<Integer>();
        try {
            BufferedReader in = new BufferedReader(new FileReader("FilesIO/ProfileDetails.txt"));
            String textFromFile; //int idx = 0;
            while ((textFromFile = in.readLine()) != null) {
                String[] wordsFromFile = textFromFile.split(" ");
                for(String text: wordsFromFile) {
                    if(text.contains(generatedID[0])) {
                        String[] splitID = text.split("-");
                        allID.add(Integer.parseInt(splitID[1]));
                        break;
                    }
                }
            }
            in.close();
            Collections.sort(allID); int temp = Integer.parseInt(generatedID[1]);
            for(int i=0; i<allID.size(); i++) {
                if(temp == allID.get(i)) { temp++; continue; }
            }
            generatedID[1] = String.valueOf(temp);
        }
        catch (IOException e) {
            e.printStackTrace();
        }catch(Exception e) {
            e.printStackTrace();
        }
        newID = generatedID[0]+"-"+generatedID[1]+"-"+generatedID[2];
        this.ID = newID;
        return newID;
    }
    // set password
    public void setPassword(String userPassword) {
        // Scanner input = new Scanner(System.in);
        // while(true) {
        //     System.out.println("Set Password : ");
        //     String userPassword = input.next();
        //     System.out.println("Confirm Password : ");
        // if(userPassword.equals(confirmPassword) && userPassword.length()>=8) {
        //     // input.close();
            
        //     return true;
        // }   
        //     // else {
        //     //     System.out.println("Opps! Password didn't match or password length is less than 8 characters");
        //     // }
        // // }
        // return false;
        int key = 0;
        for(int i=0; i<userPassword.length(); i++) key += userPassword.charAt(i);
        key%=26;
        this.password = new LogIn().encryptPassword(userPassword, key);
        // System.out.println(password);
    }
    // show user profile
    void showProfile() {
        System.out.println("First Name : " + firstName);
        System.out.println("Last Name : " + lastName);
        System.out.println("Date of Birth : " + DOB);
        System.out.println("Contact Number : " + contactNumber);
        System.out.println("Email : " + email);
        System.out.println("Home Address : " + homeAddress);
    }
}
