import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;

public class ContactApp {

     //we need a method that returns the path

    
    public static void main(String[] args) {
Path pathToOurFile = Paths.get("src", "contacts.txt");

        //1st string will be firstNameLastName
        // 2nd string will be the phoneNumber
       
 //  for (String userName : students.keySet()) {
        //            System.out.println(userName);
        //        }

        HashMap<String, String> contacts = new HashMap<>();
         contacts.put("Shelby ", "(605)475-6958");
         contacts.put("Joe", "(212)479-7990");
         contacts.put("Kyle", "(470)651-5050");
        contacts.put("Chris", "(212)479-7990");
        contacts.put("Sergio", "(880)651-5050");

        try {
            if (Files.notExists(pathToOurFile)) {
                Files.createFile(pathToOurFile);
            }
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }

        Contact contact = new Contact();

        System.out.println("Name | Phone Number");
        System.out.println("-------------------");

        contact.readFileAndOutput(pathToOurFile);
    }
}
