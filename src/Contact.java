import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.*;


public class Contact {
    public void readFileAndOutput(Path pathToFile) {
        List<String> linesInTheFile = new ArrayList<>();
        try {
            linesInTheFile = Files.readAllLines(pathToFile);
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
        for (String line : linesInTheFile) {
            System.out.println(line);
        }
    }

    public void defaultContacts() {
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
    }

        // Below code will add a contact to the contacts.txt file:

    public void addContact() {
        Path pathToOurFile = Paths.get("src", "contacts.txt");

        Scanner nameScanner = new Scanner(System.in);
        Scanner phoneNumberScanner = new Scanner(System.in);

        List<String> newAdditions = new ArrayList<>();

        // Below will add a contact to the .txt file. Will move this to a method for better use:

        System.out.println("Please enter the name of the contact: ");
        String userName = nameScanner.next();

        System.out.println("Please enter the phone number of the contact (Ex: (123)456-7890) : ");
        String userPhoneNumber = phoneNumberScanner.next();

        String concatFormat = userName + " | " + userPhoneNumber;

        newAdditions.add(concatFormat);
        try {
            Files.write(pathToOurFile, newAdditions, StandardOpenOption.APPEND);
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }

        public void displayCurrentContacts() {
        Path pathToOurFile = Paths.get("src", "contacts.txt");

        List<String> currentList = new ArrayList<>();

        try {
            currentList = Files.readAllLines(pathToOurFile);
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }

        System.out.println("Name | Phone Number");
        System.out.println("-------------------");
        for (String person : currentList) {
            System.out.println(person);
        }
    }
}
