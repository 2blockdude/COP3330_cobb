import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Formatter;
import java.util.List;
import java.util.Scanner;

public class TaskList
{
    private List<TaskItem> tasks;

    public TaskList()
    {
        tasks = new ArrayList<>();
    }

    public void addTask(String title, String description, String dueDate)
    {
        TaskItem l = new TaskItem(title, description, dueDate);
        tasks.add(l);
    }

    public void addTask(TaskItem data)
    {
        tasks.add(data);
    }

    public void removeTask(int item)
    {
        tasks.remove(item);
    }

    public void editTask(int item, String title, String description, String dueDate)
    {
        tasks.get(item).updateItem(title, description, dueDate);
    }

    public void editTaskTitle(int item, String title)
    {
        tasks.get(item).setTitle(title);
    }

    public void editTaskDescription(int item, String description)
    {
        tasks.get(item).setDescription(description);
    }

    public void editTaskDueDate(int item, String dueDate)
    {
        tasks.get(item).setDueDate(dueDate);
    }

    public String getTask(int item)
    {
        return tasks.get(item).toString();
    }

    public String getTaskTitle(int item)
    {
        return tasks.get(item).getTitle();
    }

    public String getTaskDescription(int item)
    {
        return tasks.get(item).getDescription();
    }

    public String getTaskDueDate(int item)
    {
        return tasks.get(item).getDueDate();
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

    public int writeToFile(String file)
    {
        try (Formatter output = new Formatter(file))
        {
            for (TaskItem item : tasks)
            {
                output.format("%s%n", item.getTitle());
                output.format("%s%n", item.getDescription());
                output.format("%s%n", item.getDueDate());

                if (item.isCompleted())
                    output.format("true%n");
                else
                    output.format("false%n");
            }
            return 0;
        }
        catch (FileNotFoundException e)
        {
            System.out.println("file not found!");
            return 1;
        }
        catch (Exception e)
        {
            e.printStackTrace();
            return 1;
        }
    }

    public int importFromFile(String file)
    {
        TaskItem ti;
        List<String> data = new ArrayList<>();

        try (Scanner fileReader = new Scanner(new File(file)))
        {
            while (fileReader.hasNextLine())
            {

                String title = fileReader.nextLine();
                String description = fileReader.nextLine();
                String dueDate = fileReader.nextLine();
                String completed = fileReader.nextLine();

                try
                {
                    ti = new TaskItem(title, description, dueDate);
                    if (completed.equals("true"))
                        ti.setCompleted(true);

                    tasks.add(ti);
                }
                catch (InvalidTitleException e)
                {
                    System.out.printf("Could not import list item - %s -. Cause: invalid title\n", '[' + dueDate + "] " + title + ": " + description);
                }
                catch (InvalidDueDateException e)
                {
                    System.out.printf("Could not import list Item - %s -. Cause: invalid due date\n", "[" + dueDate + "] " + title + ": " + description);
                }
            }
            return 0;
        }
        catch (FileNotFoundException e)
        {
            System.out.println("file not found!");
            return 1;
        }
        catch (Exception e)
        {
            e.printStackTrace();
            return 1;
        }
    }
}
