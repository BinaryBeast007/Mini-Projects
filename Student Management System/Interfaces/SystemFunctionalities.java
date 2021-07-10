package Interfaces;

import Classes.AppUser;

public interface SystemFunctionalities {
    public boolean addNewUser(AppUser aUser);
    public boolean removeUser(AppUser aUser);
    public AppUser searchUser(String ID);
    public void viewAllUserDetails();
}
