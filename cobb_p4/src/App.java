import java.util.InputMismatchException;
import java.util.Scanner;

public class App
{
    private static final Scanner input = new Scanner(System.in);
    private TaskList list;

    public App()
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
                    list = new TaskList();
                    System.out.println();
                    System.out.println("New list created!");
                    listMenuLoop();
                    break;
                case 2:
                    list = new TaskList();
                    list.importFromFile("somefile.txt");
                    System.out.println();
                    System.out.println("List imported successfully");
                    listMenuLoop();
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
            switch (getOption("> ", 8))
            {
                case 1:
                    printList();
                    break;
                case 2:
                    addItemToList();
                    break;
                case 3:
                    editItemFromList();
                    break;
                case 4:
                    removeItemFromList();
                    break;
                case 5:
                    break;
                case 6:
                    break;
                case 7:
                    break;
                case 8:
                    break menu;
            }
        }
    }

    private void removeItemFromList()
    {
        if (list.getList().size() > 0)
        {
            printList();
            System.out.println();
            int index = getOption("Which task could you like to remove: ", list.getList().size());

            list.removeItem(index - 1);
        }
        else
        {
            System.out.println("No tasks to remove...");
        }
    }

    private void editItemFromList()
    {
        if (list.getList().size() > 0)
        {
            try
            {
                printList();
                System.out.println();
                int index = getOption("Which task could you like to edit: ", list.getList().size());

                String title = getUserInput("New task title: ");
                String description = getUserInput("New task description: ");
                String dueDate = getUserInput("New task due date: ");

                list.editItem(index - 1, title, description, dueDate);
            }
            catch (InvalidTitleException e)
            {
                System.out.println("WARNING: title cannot be empty or contain a colon; edit not saved");
            }
            catch (InvalidDueDateException e)
            {
                System.out.println("WARNING: due date must be formatted 'YYYY-MM-DD'; edit not saved");
            }
        }
        else
        {
            System.out.println("No tasks to edit...");
        }
    }

    private void addItemToList()
    {
        try
        {
            String title = getUserInput("Task title: ");
            String description = getUserInput("Task description: ");
            String dueDate = getUserInput("Task due date: ");

            list.addItem(title, description, dueDate);
        }
        catch (InvalidTitleException e)
        {
            System.out.println("WARNING: title cannot be empty or contain a colon; task not created");
        }
        catch (InvalidDueDateException e)
        {
            System.out.println("WARNING: due date must be formatted 'YYYY-MM-DD'; task not created");
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
            if (list.getList().get(i).isCompleted())
                System.out.printf("%d) *** " + list.getList().get(i), i + 1);
            else
                System.out.printf("%d) " + list.getList().get(i), i + 1);
        }
        System.out.println();
    }

//    private void printListOfCompleted()
//    {
//        System.out.println();
//        System.out.println("Completed Tasks");
//        System.out.println("-------------");
//        System.out.println();
//        for (int i = 0; i < list.getListOfCompleted().size(); i++)
//        {
//            System.out.printf("%d) " + list.getListOfCompleted().get(i), i + 1);
//        }
//        System.out.println();
//    }
//
//    private void printListOfUncompleted()
//    {
//        System.out.println();
//        System.out.println("Uncompleted Tasks");
//        System.out.println("-------------");
//        System.out.println();
//        for (int i = 0; i < list.getListOfUncompleted().size(); i++)
//        {
//            System.out.printf("%d) " + list.getListOfUncompleted().get(i), i + 1);
//        }
//        System.out.println();
//    }

    public static void main(String[] args)
    {
        new App();
    }
}
