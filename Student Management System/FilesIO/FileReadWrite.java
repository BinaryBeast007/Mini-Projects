package FilesIO;
import java.io.*;

public class FileReadWrite {
    private File file;
    private BufferedWriter out;
    private BufferedReader in;
    private String fileName = "FilesIO/ProfileDetails.txt";

    public FileReadWrite() {
        try{
            file = new File(fileName);
            if (!file.exists()) {
                file.createNewFile();
            }
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
    public String getFileName() {
        return fileName;
    }

    public void writeInFile(String textToWrite) {
        try {
            out = new BufferedWriter(new FileWriter(file, true));
            out.write(textToWrite);
            out.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void readFromFile() {
        String textFromFile;
        try {
            in = new BufferedReader(new FileReader(fileName));
            while ((textFromFile = in.readLine()) != null) {
                System.out.println(textFromFile);
            }
            in.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public String searchInFile(String textToSearch) {
        String text="";
        try {
            in = new BufferedReader(new FileReader(file));
            String textFromFile;
            while ((textFromFile = in.readLine()) != null) {
                String[] wordsFromFile = textFromFile.split(" ");
                for(String txt: wordsFromFile) {
                    if(txt.equals(textToSearch)) {
                        return textFromFile;
                    }
                }
                // if(textFromFile.contains(text)) {
                //     return textFromFile;
                // }
            }
            in.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return text;
    }
    public boolean removeFromFile(String textToRemove) {
        boolean isRemoved = false;
        try {
            in = new BufferedReader(new FileReader(file));
            File tempFile = new File("_temp_.txt");
            if (!tempFile.exists()) {
                tempFile.createNewFile();
            }
            out = new BufferedWriter(new FileWriter(tempFile));
            String textFromFile;
            while ((textFromFile = in.readLine()) != null) {
                boolean found = false;
                String[] wordsFromFile = textFromFile.split(" ");
                for(String text: wordsFromFile) {
                    if(text.equals(textToRemove)) {
                        found = true;
                        isRemoved = true;
                        break;
                    }
                }
                if(!found){
                    out.write(textFromFile + "\n");
                }
            }
            file.delete();
            tempFile.renameTo(file);
            out.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return isRemoved;
    }
}
