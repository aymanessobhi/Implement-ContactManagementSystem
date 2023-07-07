import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ContactMangementSystem {
    private static List<Contact> contacts = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        ContactMangementSystem system = new ContactMangementSystem();
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

    }

    private void updateContact(){

    }

    private void deleteContact(){

    }

    private void displayContacts(){

    }

    private void displayContact(Contact contact){

    }

    private Contact findContactByName(String name){
        return null;
    }
}
