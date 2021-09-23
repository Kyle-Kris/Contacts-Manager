import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.*;

public class ContactApp {
    
    public static void main(String[] args) {
        Path pathToOurFile = Paths.get("src", "contacts.txt");

        // Instantiating Contact object:

        Contact contact = new Contact();

        // Using method from Contact class:

        contact.defaultContacts();

        // Main Menu:

        Scanner scanner = new Scanner(System.in);

        System.out.printf("%n%n1. View contacts.%n");
        System.out.println("2. Add a new contact.");
        System.out.println("3. Search a contact by name.");
        System.out.println("4. Delete an existing contact.");
        System.out.println("5. Exit.");
        System.out.println("Enter an option (1, 2, 3, 4 or 5):");

        // Conditionals required for User Input:

        int userInput = scanner.nextInt();

        if (userInput == 1) {
            contact.readFileAndOutput(pathToOurFile);
        } else if (userInput == 2) {
            contact.addContact();
        } else if (userInput == 3) {

        } else if (userInput == 4) {

        } else if (userInput == 5) {

        } else {
            System.out.println("I'm sorry, that is not a valid input.");
        }
    }
}
