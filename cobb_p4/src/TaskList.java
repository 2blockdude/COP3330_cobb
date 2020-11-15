import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Formatter;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskList
{
    private List<TaskItem> tasks;

    public TaskList()
    {
        tasks = new ArrayList<>();
    }

    public void addItem(String title, String description, String dueDate)
    {
        TaskItem l = new TaskItem(title, description, dueDate);
        tasks.add(l);
    }

    public void addItem(TaskItem data)
    {
        tasks.add(data);
    }

    public void removeItem(int item)
    {
        tasks.remove(item);
    }

    public void editItem(int item, String title, String description, String dueDate)
    {
            tasks.get(item).setTitle(title);
            tasks.get(item).setDescription(description);
            tasks.get(item).setDueDate(dueDate);
    }

    public void editItemTitle(int item, String title)
    {
        tasks.get(item).setTitle(title);
    }

    public void editItemDescription(int item, String description)
    {
        tasks.get(item).setDescription(description);
    }

    public void editItemDueDate(int item, String dueDate)
    {
        tasks.get(item).setDueDate(dueDate);
    }

    public void markCompleted(int item)
    {
        tasks.get(item).setCompleted(true);
    }

    public void markUncompleted(int item)
    {
        tasks.get(item).setCompleted(false);
    }

    public List<TaskItem> getList()
    {
        return List.copyOf(tasks);
    }

    public List<TaskItem> getListOfCompleted()
    {
        List<TaskItem> l = new ArrayList<>();

        for (TaskItem item : tasks)
            if (item.isCompleted())
                l.add(item);

        return List.copyOf(l);
    }

    public List<TaskItem> getListOfUncompleted()
    {
        List<TaskItem> l = new ArrayList<>();

        for (TaskItem item : tasks)
            if (!item.isCompleted())
                l.add(item);

        return List.copyOf(l);
    }

    public void writeToFile(String file)
    {
        try (Formatter output = new Formatter(file))
        {
            for (TaskItem item : tasks)
            {
                if (item.isCompleted())
                    output.format("*** %s%n", item);
                else
                    output.format("%s%n", item);
            }
        }
        catch (FileNotFoundException e)
        {
            System.out.println("file not found!");
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    public void importFromFile(String file)
    {
        TaskItem ti;
        List<String> data = new ArrayList<String>();

        try (Scanner fileReader = new Scanner(new File(file)))
        {
            while (fileReader.hasNextLine())
            {
                data.add(fileReader.nextLine());
            }
            for (String s : data)
            {
                // gets everything between the brackets
                Matcher m = Pattern.compile("\\[(.*?)\\]").matcher(s);
                m.find();

                // splits the title and description from the colon and only splits from the first colon
                String[] parts = s.split(":", 2);

                // for title I needed to remove the completed indicator and the data
                String title = parts[0].substring(parts[0].indexOf(']') + 2);
                String description = parts[1];
                String dueDate = m.group(1);

                try
                {
                    ti = new TaskItem(title, description, dueDate);
                    if (s.charAt(0) == '*')
                        ti.setCompleted(true);

                    tasks.add(ti);
                }
                catch (InvalidTitleException e)
                {
                    System.out.printf("Could not import list item - %s -. Cause: invalid title\n", s);
                }
                catch (InvalidDueDateException e)
                {
                    System.out.printf("Could not import list Item - %s -. Cause: invalid due date\n", s);
                }
            }
        }
        catch (FileNotFoundException e)
        {
            System.out.println("file not found!");
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
