import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ContactManagementSystem {
    private static List<Contact> contacts = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        ContactManagementSystem system = new ContactManagementSystem();
        system.run();
    }
    private void run(){
        int choice = 0;
        do {
            displayMenu();
            choice = getUserChoice();
            switch (choice){
                case 1:
                    addContact();
                    break;
                case 2:
                    searchContact();
                    break;
                case 3:
                    updateContact();
                    break;
                case 4:
                    deleteContact();
                    break;
                case 5:
                    displayContacts();
                    break;
                case 6:
                    System.out.println("Exiting the program... Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice! Please try again.");
                    break;
            }

        }while (choice !=6);
    }
    private void displayMenu(){
        System.out.println("===== Contact Management System =====");
        System.out.println("1. Add a contact");
        System.out.println("2. Search for a contact");
        System.out.println("3. Update a contact");
        System.out.println("4. Delete a contact");
        System.out.println("5. Display all contacts");
        System.out.println("6. Exit");
        System.out.println("Enter your choice");
    }

    private int getUserChoice(){
        int choice = scanner.nextInt();
        scanner.nextLine();
        return choice;
    }

    private void addContact(){
        System.out.println("Enter contact name: ");
        String name = scanner.nextLine();
        System.out.println("Enter contact phone number: ");
        String phoneNumber = scanner.nextLine();
        System.out.println("Enter contact email");
        String email = scanner.nextLine();
        Contact contact = new Contact(name,phoneNumber,email);
        contacts.add(contact);
        System.out.println("Contact added succussfully");
        System.out.println();
    }

    private void searchContact(){
        System.out.println("Enter contact name to search: ");
        String name = scanner.nextLine();
        boolean found = false;
        for (Contact contact : contacts){
            if(contact.getName().equalsIgnoreCase(name)){
                displayContact(contact);
                found = true;
                break;
            }
        }
        if (!found){
            System.out.println("Contact not found");
        }
        System.out.println();
    }

    private void updateContact(){
        System.out.println("Enter contact name to update: ");
        String name = scanner.nextLine();

        Contact contact = findContactByName(name);
        if(contact !=null){
            System.out.print("Enter new phone number: ");
            String phoneNumber = scanner.nextLine();
            System.out.println("Enter new email");
            String email = scanner.nextLine();

            contact.setPhoneNumber(phoneNumber);
            contact.setEmail(email);
            System.out.println("Contact updated successfully!");
        }else{
            System.out.println("Contact not found");
        }
        System.out.println();
    }

    private void deleteContact(){
        System.out.println("Enter contact name to delete: ");
        String name = scanner.nextLine();
        Contact contact = findContactByName(name);
        if(contact!=null){
            contacts.remove(contact);
            System.out.println("Contact deleted successfully!");
        }else {
            System.out.println("Contact not found!");
        }
        System.out.println();
    }

    private void displayContacts(){
        if(contacts.isEmpty()){
            System.out.println("No Contacts found!");
        }else {
            System.out.println("===== All Contacts =====");
            for (Contact contact:contacts){
                displayContact(contact);
            }
        }
        System.out.println();
    }

    private void displayContact(Contact contact){
        System.out.println("Name : "+contact.getName());
        System.out.println("Phone Number: "+ contact.getPhoneNumber());
        System.out.println("Email: "+contact.getEmail());
        System.out.println("--------------------------");
    }

    private Contact findContactByName(String name){
        for (Contact contact:contacts){
            if(contact.getName().equalsIgnoreCase(name)){
                return contact;
            }
        }
        return null;
    }
}
