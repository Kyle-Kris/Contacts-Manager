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

        System.out.println("Name          | Phone Number    |");
        System.out.println("---------------------------------");
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
        System.out.println("Please enter a name: ");
        String userName = phoneNumberScanner.nextLine();

        if (searchForContact(userName) != null) {
            System.out.println("There's already a contact named " + userName + ". Do you want to overwrite it? (Yes/No)");
            String yesOrNo = phoneNumberScanner.next();
            if (yesOrNo.equalsIgnoreCase("no")) {
                duplicateContact();
                return;
                // if you type no you exit the function, it tells it to STOP executing function
            } else {
                deleteContact(userName);
                duplicateContact();
                return;
            }

        }

        System.out.println("Please enter the phone number of the contact: ");
        String userPhoneNumber = phoneNumberScanner.nextLine();

        if (userPhoneNumber.length() == 7) {
            String firstThree = userPhoneNumber.substring(0, 3);
            String lastFour = userPhoneNumber.substring(3, 7);
            userPhoneNumber = firstThree + "-" + lastFour;
        } else if (userPhoneNumber.length() == 10) {
            String firstThree = userPhoneNumber.substring(0, 3);
            String secondThree = userPhoneNumber.substring(3, 6);
            String lastFour = userPhoneNumber.substring(6, 10);
            userPhoneNumber = "(" + firstThree + ")" + secondThree + "-" + lastFour;
        } else if (userPhoneNumber.length() == 11) {
            String first = userPhoneNumber.substring(0, 1);
            String firstThree = userPhoneNumber.substring(1, 4);
            String secondThree = userPhoneNumber.substring(4, 7);
            String lastFour = userPhoneNumber.substring(7, 11);
            userPhoneNumber = "+" + first + "(" + firstThree + ")" + secondThree + "-" + lastFour;
        }


//        String concatFormat = userName + " | " + userPhoneNumber;
        String concatFormat = String.format("%-13s | %-15s |", userName, userPhoneNumber);

        newAdditions.add(concatFormat);
        try {
            Files.write(pathToOurFile, newAdditions, StandardOpenOption.APPEND);
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }

    }
      //Default and overloading to take in a username
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
        //now we can search for a specified contact without case sensitivity
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
        // kristen moved lines 235-248 to this method as a way of capturing the value from userInput1 that the user inputs that they want to delete
          Scanner scanner1 = new Scanner(System.in);

          System.out.println("Please enter the name of the contact you would like to delete: ");

          String userInput1 = scanner1.nextLine();
          deleteContact(userInput1);
      }


    public void deleteContact(String userName) {
        // Creating Path to .txt file:
  // OKAY this method corresponds to #5 of the Project Once the user chooses to exit, re-write the contents of the contacts.txt file using the List of Contact objects
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
    public void duplicateContact(){
        Path pathToOurFile = Paths.get("src", "contacts.txt");
        Scanner phoneNumberScanner = new Scanner(System.in);


        List<String> newAdditions = new ArrayList<>();


        System.out.println("Please enter a name: ");
        String userName = phoneNumberScanner.nextLine();

        System.out.println("Please enter the phone number of the contact: ");
        String userPhoneNumber = phoneNumberScanner.nextLine();

        if (userPhoneNumber.length() == 7) {
            String firstThree = userPhoneNumber.substring(0, 3);
            String lastFour = userPhoneNumber.substring(3, 7);
            userPhoneNumber = firstThree + "-" + lastFour;
        } else if (userPhoneNumber.length() == 10) {
            String firstThree = userPhoneNumber.substring(0, 3);
            String secondThree = userPhoneNumber.substring(3, 6);
            String lastFour = userPhoneNumber.substring(6, 10);
            userPhoneNumber = "(" + firstThree + ")" + secondThree + "-" + lastFour;
        } else if (userPhoneNumber.length() == 11) {
            String first = userPhoneNumber.substring(0, 1);
            String firstThree = userPhoneNumber.substring(1, 4);
            String secondThree = userPhoneNumber.substring(4, 7);
            String lastFour = userPhoneNumber.substring(7, 11);
            userPhoneNumber = "+" + first + "(" + firstThree + ")" + secondThree + "-" + lastFour;
        }

        String concatFormat = String.format("%-13s | %-15s |", userName, userPhoneNumber);
        newAdditions.add(concatFormat);
        try {
            Files.write(pathToOurFile, newAdditions, StandardOpenOption.APPEND);
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }
}
