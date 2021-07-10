package Classes;

public class Faculty extends AppUser {

    Faculty() {}
    public Faculty(String firstName, String lastName, String DOB, String contactNumber, String email, String ID, String homeAddress) {
        super(firstName, lastName, DOB, contactNumber, email, ID, homeAddress, homeAddress, homeAddress);
    }
}
