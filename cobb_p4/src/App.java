import java.util.InputMismatchException;
import java.util.Scanner;

public class App
{
    private static final Scanner input = new Scanner(System.in);
    private ListManager list = new ListManager();

    public App()
    {
        mainMenuLoop();
    }

    private void mainMenuLoop()
    {
        loop:
        while (true)
        {
            printMainMenu();
            switch (getOption(3))
            {
                case 1:
                    System.out.println("new task list has been created");
                    listMenuLoop();
                    break;
                case 2:
                    break;
                case 3:
                    break loop;
            }
        }
    }

    private void listMenuLoop()
    {
        while (true)
        {
            printListMenu();
            switch (getOption(8))
            {
                case 1:
                    printList();
                    break;
                case 2:
                    addItemToList();
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 5:
                    break;
                case 6:
                    break;
                case 7:
                    break;
                case 8:
                    break;
            }
        }
    }

    private void addItemToList()
    {
        ListItem l = getUserInputListItem();

        if (l != null)
        {
            list.addItem(l);
            System.out.println("task added to list");
        }
    }

    private void editItemFromList()
    {
        ListItem l = getUserInputListItem();

        if (l != null)
        {
        }
    }

    // asks for user input and returns an integer value from one to max num specified.
    private int getOption(int numberOfOptions)
    {
        int optionSelect;
        while (true)
        {
            System.out.print("> ");
            try
            {
                optionSelect = input.nextInt();
                if (optionSelect > numberOfOptions || optionSelect < 1)
                {
                    System.out.printf("Invalid Option! Pick options between 1 and %d!\n", numberOfOptions);
                }
                else
                {
                    input.nextLine();
                    return optionSelect;
                }
            }
            catch (InputMismatchException e)
            {
                System.out.println("Invalid Option! Option must be integer value!");
                input.nextLine();
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }
        }
    }

    private ListItem getUserInputListItem()
    {
        ListItem item;

        try
        {
            System.out.println();
            String title = getUserInputListTitle();
            String description = getUserInputListDescription();
            String dueDate = getUserInputListDueDate();

            item = new ListItem(title, description, dueDate);
            return item;
        }
        catch (InvalidTitleException e)
        {
            System.out.println();
            System.out.println("Invalid title! Title must be 1 character or longer and cannot contain a colon.");
            System.out.println("Task not created...");
            System.out.println();
        }
        catch (InvalidDueDateException e)
        {
            System.out.println();
            System.out.println("Invalid due date! Due date must be formatted as 'YYYY-MM-DD'.");
            System.out.println("Task not created...");
            System.out.println();
        }

        return null;
    }

    private String getUserInputListTitle()
    {
        System.out.print("Task title: ");
        return input.nextLine();
    }

    private String getUserInputListDescription()
    {
        System.out.print("Task description: ");
        return input.nextLine();
    }

    private String getUserInputListDueDate()
    {
        System.out.print("Task due date (YYYY-MM-DD): ");
        return input.nextLine();
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
        System.out.println("5) mark an item as completed");
        System.out.println("6) unmark an item as completed");
        System.out.println("7) save the current list");
        System.out.println("8) quit to the main menu");
        System.out.println();
    }

    private void printList()
    {
        System.out.println();
        System.out.println("Current Tasks");
        System.out.println("-------------");
        System.out.println();
        for (int i = 0; i < list.getList().size(); i++)
        {
            System.out.printf("%d) " + list.getList().get(i), i + 1);
        }
        System.out.println();
    }

    private void printListOfCompleted()
    {
        System.out.println();
        System.out.println("Completed Tasks");
        System.out.println("-------------");
        System.out.println();
        for (int i = 0; i < list.getListOfCompleted().size(); i++)
        {
            System.out.printf("%d) " + list.getListOfCompleted().get(i), i + 1);
        }
        System.out.println();
    }

    private void printListOfUncompleted()
    {
        System.out.println();
        System.out.println("Uncompleted Tasks");
        System.out.println("-------------");
        System.out.println();
        for (int i = 0; i < list.getListOfUncompleted().size(); i++)
        {
            System.out.printf("%d) " + list.getListOfUncompleted().get(i), i + 1);
        }
        System.out.println();
    }

    public static void main(String[] args)
    {
        new App();
    }
}
