import java.util.InputMismatchException;
import java.util.Scanner;

public class ContactApp
{
    private static final Scanner input = new Scanner(System.in);
    private ContactList contactList;

    public ContactApp()
    {
        mainMenuLoop();
    }

    private void mainMenuLoop()
    {
        menu:
        while (true)
        {
            printMainMenu();
            switch (getOption("> ", 3))
            {
                case 1:
                    createNewList();
                    listMenuLoop();
                    break;
                case 2:
                    importList();
                    break;
                case 3:
                    break menu;
            }
        }
    }

    private void listMenuLoop()
    {
        menu:
        while (true)
        {
            printListMenu();
            switch (getOption("> ", 6))
            {
                case 1:
                    printList();
                    break;
                case 2:
                    addContactToList();
                    break;
                case 3:
                    editContactFromList();
                    break;
                case 4:
                    removeContactFromList();
                    break;
                case 5:
                    saveCurrentList();
                    break;
                case 6:
                    break menu;
            }
        }
    }

    private void importList()
    {
        contactList = new ContactList();
        if (contactList.importFromFile(getUserInput("Enter the filename to load: ")) == 0)
        {
            System.out.println("task list has been loaded");
            listMenuLoop();
        }
        else
            System.out.println("task list failed to load...");
    }

    private void createNewList()
    {
        contactList = new ContactList();
        System.out.println();
        System.out.println("New list created!");
    }

    private void saveCurrentList()
    {
        if (contactList.getList().size() > 0)
        {
            String fileName = getUserInput("Name of file: ");
            if (contactList.writeToFile(fileName) == 0)
                System.out.println("List Saved!");
            else
                System.out.println("List failed to save...");
        }
        else
        {
            System.out.println("Nothing to save...");
        }
    }

    private void removeContactFromList()
    {
        if (contactList.getList().size() > 0)
        {
            printList();
            System.out.println();
            int index = getOption("Which task would you like to remove: ", contactList.getList().size());

            contactList.removeContact(index - 1);
        }
        else
        {
            System.out.println("No contacts to remove...");
        }
    }

    private void editContactFromList()
    {
        if (contactList.getList().size() > 0)
        {
            try
            {
                printList();
                System.out.println();
                int index = getOption("Which task could you like to edit: ", contactList.getList().size());

                String firstName = getUserInput("New First Name: ");
                String lastName = getUserInput("New Last Name: ");
                String phone = getUserInput("New Phone Number (XXX-XXX-XXXX): ");
                String email = getUserInput("New Email Address (x@y.z): ");

                contactList.editContact(index - 1, firstName, lastName, phone, email);
            }
            catch (IllegalArgumentException e)
            {
                System.out.println(e.getMessage());
            }
        }
        else
        {
            System.out.println("No contacts to edit...");
        }
    }

    private void addContactToList()
    {
        try
        {
            String firstName = getUserInput("First Name: ");
            String lastName = getUserInput("Last Name: ");
            String phone = getUserInput("Phone Number (XXX-XXX-XXXX): ");
            String email = getUserInput("Email Address (x@y.z): ");

            contactList.addContact(firstName, lastName, phone, email);
        }
        catch (IllegalArgumentException e)
        {
            System.out.println(e.getMessage());
        }
    }

    private String getUserInput(String prompt)
    {
        System.out.print(prompt);
        return input.nextLine();
    }

    private int getOption(String prompt, int numOfOptions)
    {
        int intInput;

        while (true)
        {
            System.out.print(prompt);

            try
            {
                intInput = input.nextInt();

                if (intInput > numOfOptions || intInput < 1)
                {
                    System.out.printf("Input must be between 1 and %d\n", numOfOptions);
                }
                else
                {
                    break;
                }
            }
            catch (InputMismatchException e)
            {
                System.out.println("Input invalid! Must be integer value!");
            }
            finally
            {
                input.nextLine();
            }
        }
        return intInput;
    }

    private void printMainMenu()
    {
        System.out.println();
        System.out.println("Main Menu");
        System.out.println("---------");
        System.out.println();
        System.out.println("1) create a new list");
        System.out.println("2) load an existing list");
        System.out.println("3) quit");
        System.out.println();
    }

    private void printListMenu()
    {
        System.out.println();
        System.out.println("List Menu");
        System.out.println("---------");
        System.out.println();
        System.out.println("1) view the list");
        System.out.println("2) add an item");
        System.out.println("3) edit an item");
        System.out.println("4) remove an item");
        System.out.println("5) save the current list");
        System.out.println("6) quit to the main menu");
        System.out.println();
    }

    private void printList()
    {
        System.out.println();
        System.out.println("Current Contacts");
        System.out.println("-------------");
        System.out.println();
        for (int i = 0; i < contactList.getList().size(); i++)
        {
            System.out.printf("%d)\n" + contactList.getList().get(i) + "\n", i + 1);
        }
        System.out.println();
    }

    public static void main(String[] args)
    {
        new ContactApp();
    }
}
