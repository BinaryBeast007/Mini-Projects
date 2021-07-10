package Classes;
import Interfaces.*;

public class ManagementSystem implements SystemFunctionalities {
    private AppUser appUser[];
    ManagementSystem() {
        appUser = new AppUser[100];
    }
    @Override
    public boolean addNewUser(AppUser aUser) {
        boolean flag = false;
        for(int i=0; i<appUser.length; i++) {
            if(appUser[i] == null) {
                appUser[i] = aUser;
                flag = true;
                break;
            }
        }
        return flag;
    }
    @Override
    public boolean removeUser(AppUser aUser) {
        boolean flag = false;
        for(int i=0; i<appUser.length; i++) {
            if(appUser[i] == aUser) {
                appUser[i] = null;
                flag = true;
                break;
            }
        }
        return flag;
    }
    @Override
    public AppUser searchUser(String ID) {
        AppUser aUser = null;
        for(int i=0; i<appUser.length; i++) {
            if(appUser[i] != null && appUser[i].getID() == ID) {
                aUser = appUser[i];
                break;
            }
        }
        return aUser;
    }
    @Override
    public void viewAllUserDetails() {
        for(int i=0; i<appUser.length; i++) {
            if(appUser[i] != null) {
                appUser[i].showProfile();
            }
        }
    }
}
