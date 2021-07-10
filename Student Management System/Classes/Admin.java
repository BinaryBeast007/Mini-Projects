package Classes;

public class Admin extends AppUser {
    protected String ID;
    ManagementSystem mSystem = new ManagementSystem();
    Admin() {}
    public Admin(String firstName, String lastName, String DOB, String contactNumber, String email, String ID, String homeAddress) {
        super(firstName, lastName, DOB, contactNumber, email, ID, homeAddress, homeAddress, homeAddress);
    }


    String generateAdminID() {
        return "";
    }
}
