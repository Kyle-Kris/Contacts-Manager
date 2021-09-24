import java.util.Scanner;

public class ContactApp {

    public static void main(String[] args) {
        // Instantiating Contact object:

        Contact contact = new Contact();

        // Default contacts from Contact class/contacts.txt:

     //   contact.defaultContacts();

        // Main Menu:

        contact.mainMenu();





        /*
         public void addContact() {
        // Creating Path to .txt file:

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

       //public static void addContact(scanner sc) {
        sout("Enter a name: ");
         String name = sc.next();
         sout("enter a phone number: ");
         Sting phoneNumber = sc.next();
         boolean enterContactInfo
        if (contacts.get(name) != null) {
            System.out.println("There's already a contact named " + name + ". Do you want to overwrite it? (Yes/No)");
            String yesOrNo = sc.next();
            if (yesOrNo.equalsIgnoreCase("no")) {
                enterContactInfo = false;
            } else {
                listOptions();
            }
        // else if { (phoneNumber.length() == 10){
       String formatPhoneNumber = phoneNumber.substring(0,3)  + "-"+ phoneNumber.substring(3,6)+ "-"+;
       phoneNumber.substring(6)
        contacts.put(name, formatPhoneNumber);
        sout("Contact sucessfully added. Type option 1 to view.");
        listOptions();
         }        else {
         sout("this is not a valid phone number\nTry again slag");
         addContact(sc);
         
         */


        // " There's already a contact named Jane Doe. Do you want to overwrite it? (Yes/No)
    }
}



        

