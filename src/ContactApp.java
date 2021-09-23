import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class ContactApp {
    public static void main(String[] args) {
        Path pathToOurFile = Paths.get("src", "contacts.txt");



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
