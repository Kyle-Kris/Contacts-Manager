import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.*;


public class Contact<searchForContact> {
    //Path to contacts.txt 
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
        contacts.put("Shelby", "(605)475-6958");
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

    public void mainMenu() {
        // Creating Path to .txt file:

        Path pathToOurFile = Paths.get("src", "contacts.txt");

        // Main Menu:

        String userContinue = "";

        do {

            Scanner scanner = new Scanner(System.in);
//
            System.out.printf("%n%n1. View contacts.%n");
            System.out.println("2. Add a new contact.");
            System.out.println("3. Search a contact by name.");
            System.out.println("4. Delete an existing contact.");
            System.out.println("5. Exit.");
            System.out.println("Enter an option (1, 2, 3, 4 or 5):");

            // Conditionals required for User Input:

            int userInput = scanner.nextInt();

            if (userInput == 1) {
                displayCurrentContacts();
            } else if (userInput == 2) {
                addContact();
            } else if (userInput == 3) {
                searchForContact();
            } else if (userInput == 4) {
                deleteContact();
            } else if (userInput == 5) {
                break;
            } else {
                System.out.println("I'm sorry, that is not a valid input.");
            }

            System.out.println("Would you like to continue using the Contacts App? (yes/no)");
            userContinue = scanner.next();


        } while (userContinue.equalsIgnoreCase("yes"));
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

    // Below code will add a contact to the contacts.txt file:

    public void addContact() {
        // Creating Path to .txt file:

        Path pathToOurFile = Paths.get("src", "contacts.txt");

        Scanner phoneNumberScanner = new Scanner(System.in);

        List<String> newAdditions = new ArrayList<>();

        // Below will add a contact to the .txt file. Will move this to a method for better use:
        System.out.println("please enter a name: ");
        String userName = phoneNumberScanner.next();

        if (searchForContact(userName) != null) {
            System.out.println("There's already a contact named " + userName + ". Do you want to overwrite it? (Yes/No)");
            String yesOrNo = phoneNumberScanner.next();
            if (yesOrNo.equalsIgnoreCase("no")) {
                return;
                // if you type no you exit the function, it tells it to STOP executing function
            } else {
                deleteContact(userName);
            }

        }

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
      //Default and overloading to take in a Un
    public String searchForContact() {
        Scanner scanner1 = new Scanner(System.in);

        System.out.println("Please enter a name: ");

        String userInput1 = scanner1.nextLine();
          return searchForContact(userInput1);
    }



    public String searchForContact(String userName) {
        // Creating Path to .txt file:

        Path pathToOurFile = Paths.get("src", "contacts.txt");



        List<String> currentList = new ArrayList<>();

        try {
            currentList = Files.readAllLines(pathToOurFile);
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }

        Iterator<String> listIterator = currentList.iterator();
        //now we can search lowercase
        while (listIterator.hasNext()) {
            String item = listIterator.next();
            if (item.toLowerCase().contains(userName.toLowerCase())) {
                System.out.println(item);
                return userName;
            }
        }
        return null;
    }
    // searches for input if input is typed in

      public void deleteContact(){
          Scanner scanner1 = new Scanner(System.in);

          System.out.println("Please enter the name of the contact you would like to delete: ");

          String userInput1 = scanner1.nextLine();
          deleteContact(userInput1);
      }


    public void deleteContact(String userName) {
        // Creating Path to .txt file:

        Path pathToOurFile = Paths.get("src", "contacts.txt");
         // moved to other delete contact function
//        Scanner scanner1 = new Scanner(System.in);
//
//        System.out.println("Please enter the name of the contact you would like to delete: ");
//
//        String userInput1 = scanner1.nextLine();

        List<String> currentList = new ArrayList<>();

        try {
            currentList = Files.readAllLines(pathToOurFile);
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }

        Iterator<String> listIterator = currentList.iterator();

        while (listIterator.hasNext()) {
            String item = listIterator.next();
            if (item.contains(userName)) {
                listIterator.remove();
            }
        }

        try {
            Files.write(pathToOurFile, currentList);
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }



    }
}
