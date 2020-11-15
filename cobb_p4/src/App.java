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
                    markItemCompleted();
                    break;
                case 6:
                    markItemUncompleted();
                    break;
                case 7:
                    saveCurrentList();
                    break;
                case 8:
                    break menu;
            }
        }
    }

    private void importList()
    {
        list = new TaskList();
        if (list.importFromFile(getUserInput("Enter the filename to load: ")) == 0)
        {
            System.out.println("task list has been loaded");
            listMenuLoop();
        }
        else
            System.out.println("task list failed to load...");
    }

    private void createNewList()
    {
        list = new TaskList();
        System.out.println();
        System.out.println("New list created!");
    }

    private void saveCurrentList()
    {
        if (list.getList().size() > 0)
        {
            String fileName = getUserInput("Name of file: ");
            if (list.writeToFile(fileName) == 0)
                System.out.println("List Saved!");
            else
                System.out.println("List failed to save...");
        }
        else
        {
            System.out.println("Nothing to save...");
        }
    }

    private void markItemUncompleted()
    {
        int sizeOfCompleted = list.getListOfCompleted().size();

        if (sizeOfCompleted > 0)
        {
            printListOfCompleted();

            int fakeCount = 0;
            int[] realPosition = new int[sizeOfCompleted];

            for (int i = 0; i < list.getList().size(); i++)
            {
                if (list.getList().get(i).isCompleted())
                {
                    realPosition[fakeCount] = i;
                    fakeCount++;
                }
            }

            int selected = getOption("Which task would you like to mark as uncomplete: ", sizeOfCompleted);
            int index = realPosition[selected - 1];
            list.markUncompleted(index);
        }
        else
        {
            System.out.println("No tasks to mark as uncomplete...");
        }
    }

    private void markItemCompleted()
    {
        int sizeOfUncompleted = list.getListOfUncompleted().size();

        if (sizeOfUncompleted > 0)
        {
            printListOfUncompleted();

            int fakeCount = 0;
            int[] realPosition = new int[sizeOfUncompleted];

            for (int i = 0; i < list.getList().size(); i++)
            {
                if (!list.getList().get(i).isCompleted())
                {
                    realPosition[fakeCount] = i;
                    fakeCount++;
                }
            }

            int selected = getOption("Which task would you like to mark as complete: ", sizeOfUncompleted);
            int index = realPosition[selected - 1];
            list.markCompleted(index);
        }
        else
        {
            System.out.println("No tasks to mark as complete...");
        }
    }

    private void removeItemFromList()
    {
        if (list.getList().size() > 0)
        {
            printList();
            System.out.println();
            int index = getOption("Which task would you like to remove: ", list.getList().size());

            list.removeTask(index - 1);
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

                list.editTask(index - 1, title, description, dueDate);
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

            list.addTask(title, description, dueDate);
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
                System.out.printf("%d) *** " + list.getList().get(i) + "\n", i + 1);
            else
                System.out.printf("%d) " + list.getList().get(i) + "\n", i + 1);
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
            System.out.printf("%d) " + list.getListOfCompleted().get(i) + "\n", i + 1);
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
            System.out.printf("%d) " + list.getListOfUncompleted().get(i) + "\n", i + 1);
        }
        System.out.println();
    }

    public static void main(String[] args)
    {
        new App();
    }
}
