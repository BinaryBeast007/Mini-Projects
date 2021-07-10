package Classes;

import Interfaces.StudentFunctionalities;

public class Student extends AppUser implements StudentFunctionalities {
    Student() {}
    public Student(String firstName, String lastName, String DOB, String contactNumber, String email, String ID, String homeAddress) {
        super(firstName, lastName, DOB, contactNumber, email, ID, homeAddress, homeAddress, homeAddress);
    }
    
    @Override
    public boolean addNewCourse() {
        boolean flag = false;
        return flag;
    }
    @Override
    public boolean removeCourse() {
        boolean flag = false;
        return flag;
    } 
}
