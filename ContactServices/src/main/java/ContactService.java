import java.util.ArrayList;
import java.util.Scanner;

public class ContactService {
    Scanner scanner = new Scanner(System.in); //Scanner class to accept user input
    ArrayList<Contact> contacts = new ArrayList<>(); //List of contacts

    // Displays the list of contacts
    public void displayContactList() {
        for (Contact contact : contacts) {
            System.out.println(contact + "\n");
        }
    }

    //Adds a new contact to the contact list
    public void addContact() {
        Contact newContact = new Contact();

        System.out.print("Enter unique ID. The ID will not be changeable (10 character max): ");
        String uniqueID = scanner.nextLine().strip();

        if (uniqueID.length() > 10) {
            System.out.println("INVALID ENTRY...TRY AGAIN");
            System.out.println();
            addContact();
        }

        System.out.println();

        System.out.print("Enter first name (10 character max): ");
        String firstName = scanner.nextLine().strip();

        if (firstName.length() > 10) {
            System.out.println("INVALID ENTRY...TRY AGAIN");
            System.out.println();
            addContact();
        }

        System.out.println();

        System.out.print("Enter last name (10 character max): ");
        String lastName = scanner.nextLine().strip();

        if (lastName.length() > 10) {
            System.out.println("INVALID ENTRY...TRY AGAIN");
            System.out.println();
            addContact();
        }

        System.out.println();

        System.out.print("Enter address (30 character max): ");
        String address = scanner.nextLine().strip();

        if (address.length() > 30) {
            System.out.println("INVALID ENTRY...TRY AGAIN");
            System.out.println();
            addContact();
        }

        System.out.println();

        System.out.print("Enter phone number (Do not enter special characters): ");
        String phoneNum = scanner.nextLine().strip();

        if (phoneNum.length() != 10) {
            System.out.println("INVALID ENTRY...TRY AGAIN");
            System.out.println();
            addContact();
        }

        System.out.println();

        newContact.setUniqueID(uniqueID);
        newContact.setFirstName(firstName);
        newContact.setLastName(lastName);
        newContact.setAddress(address);
        newContact.setPhoneNum(phoneNum);

        this.contacts.add(newContact);

        displayContactList();
        userChoice();
    }

    //Removes a contact from the list
    public void removeContact() {
        System.out.print("Enter the ID of the contact you wish to delete: ");
        String uniqueID = scanner.nextLine().strip();

        System.out.println();

        for (int i = 0; i < contacts.size(); i++) {
            if (contacts.get(i).getUniqueID().equals(uniqueID)) {
                contacts.remove(i);
            }
        }
        displayContactList();
        userChoice();
    }

    //Asks the user if they want to add or remove a contact from the list
    public void userChoice() {

        System.out.print("To add a contact enter ADD\n" +
                "To remove a contact enter REMOVE\n" +
                "To close the program enter EXIT\n" +
                "Your selection: ");
        String userInput = scanner.nextLine().strip();
        System.out.println();

        if (userInput.equalsIgnoreCase("add")) {
            addContact();
        } else if (userInput.equalsIgnoreCase("remove")) {
            removeContact();
        } else if (userInput.equalsIgnoreCase("exit")) {
            System.exit(0);
        } else {
            System.out.println("INVALID INPUT...TRY AGAIN");
            userChoice();
        }
    }
}
