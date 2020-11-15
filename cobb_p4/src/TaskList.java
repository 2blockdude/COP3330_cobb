import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Formatter;
import java.util.List;

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

    }
}
