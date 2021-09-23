import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

public class ContactApp {
    
    public static void main(String[] args) {

        // Creating Path to .txt file:

    Path pathToOurFile = Paths.get("src", "contacts.txt");

        try {
            if (Files.notExists(pathToOurFile)) {
                Files.createFile(pathToOurFile);
            }
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }

        // Setting Default Contacts:

        // Below code will create our HashMap and will add the Key Value pairs from the HashMap to the contacts.txt. After the enhanced-for loop, the names and phone numbers are printed:

    HashMap<String, String> contacts = new HashMap<>();
        contacts.put("Shelby ", "(605)475-6958");
        contacts.put("Joe", "(212)479-7990");
        contacts.put("Kyle", "(470)651-5050");
        contacts.put("Chris", "(212)479-7990");
        contacts.put("Sergio", "(880)651-5050");

        System.out.println("Name | Phone Number");
        System.out.println("-------------------");

        List<String> listOfContacts = new ArrayList<>();

        for (Map.Entry<String, String> contact : contacts.entrySet()) {
            String key = contact.getKey();
            Object value = contact.getValue();

            String concatFormat = key + " | " + value;

            listOfContacts.add(concatFormat);

            try {
                Files.write(pathToOurFile, listOfContacts);
            } catch (IOException ioe) {
                ioe.printStackTrace();
            }
        }

        // Instantiating Contact class:

    Contact contact = new Contact();

        // Using below method from Contact class. Will read and print .txt file:

    contact.readFileAndOutput(pathToOurFile);

    Scanner scanner = new Scanner(System.in);

    System.out.printf("%n%n1. View contacts.%n");
    System.out.println("2. Add a new contact.");
    System.out.println("3. Search a contact by name.");
    System.out.println("4. Delete an existing contact.");
    System.out.println("5. Exit.");
    System.out.println("Enter an option (1, 2, 3, 4 or 5):");

    }
}
