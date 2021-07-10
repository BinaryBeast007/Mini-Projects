package Classes;

import FilesIO.FileReadWrite;

public class LogIn {
    public String encryptPassword(String text, int key) {
        String cipher = ""; key%=26;
        for(int i=0; i<text.length(); i++) {
            if((text.charAt(i) >= 'a' && text.charAt(i) <= 'z') || (text.charAt(i) >= 'A' && text.charAt(i) <= 'Z')) {
                if(Character.isUpperCase(text.charAt(i))) {
                    cipher += Character.toString(((text.charAt(i) + key -65) % 26 + 65));
                }else {
                    cipher += Character.toString(((text.charAt(i) + key -97) % 26 + 97));
                }
            }else {
                cipher += text.charAt(i);
            }
        }
        return cipher;
    }
    public String decryptPassword(String text, int key) {
        String decipher = ""; key%=26;
        for(int i=0; i<text.length(); i++) {
            if((text.charAt(i) >= 'a' && text.charAt(i) <= 'z') || (text.charAt(i) >= 'A' && text.charAt(i) <= 'Z')) {
                if(Character.isUpperCase(text.charAt(i))) {
                    decipher += Character.toString((text.charAt(i) - key) < 65 ? (text.charAt(i) - key)+26 : (text.charAt(i) - key));
                }else {
                    decipher += Character.toString((text.charAt(i) - key) < 97 ? (text.charAt(i) - key)+26 : (text.charAt(i) - key));
                }
            }else {
                decipher += text.charAt(i);
            }
            
        }
        return decipher;
    }
    public boolean verifyPassword(String ID, String password) {
        boolean isVerified = false;
        FileReadWrite fReadWrite = new FileReadWrite();
        String details = fReadWrite.searchInFile(ID);
        if(details == null) return isVerified;
        String[] info = details.split(" ");
        String cipherPassword=""; int key=0;
        for(int i=0; i<info.length; i++) {
            if(info[i].equals("Password:")) {
                cipherPassword = info[i+1];
                break;
            }
        }
        for(int i=0; i<password.length(); i++) key += password.charAt(i);
        key%=26;
        cipherPassword = decryptPassword(cipherPassword, key);
        isVerified = cipherPassword.equals(password) ? true : false;
        return isVerified;
    } 
}
