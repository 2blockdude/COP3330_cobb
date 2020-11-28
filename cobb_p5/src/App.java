import java.util.InputMismatchException;
import java.util.Scanner;

public class App
{
    private static final Scanner input = new Scanner(System.in);

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
                    new TaskApp();
                    break;
                case 2:
                    new ContactApp();
                    break;
                case 3:
                    break menu;
            }
        }
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
        System.out.println("Select an Application");
        System.out.println("---------");
        System.out.println();
        System.out.println("1) task list");
        System.out.println("2) contact list");
        System.out.println("3) quit");
        System.out.println();
    }

    public static void main(String[] args)
    {
        new App();
    }
}
