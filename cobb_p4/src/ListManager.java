import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Formatter;
import java.util.List;

public class ListManager
{
    private List<ListItem> tasks;

    public ListManager()
    {
        tasks = new ArrayList<>();
    }

    public void addItem(ListItem item)
    {
        tasks.add(item);
    }

    public void removeItem(int item)
    {
        tasks.remove(item);
    }

    public void editItem(int item, ListItem newItem)
    {
            newItem.setCompleted(tasks.get(item).isCompleted());
            tasks.set(item, newItem);
    }

    public void markCompleted(int item)
    {
        tasks.get(item).setCompleted(true);
    }

    public void markUncompleted(int item)
    {
        tasks.get(item).setCompleted(false);
    }

    public List<String> getList()
    {
        List<String> list = new ArrayList<>();

        for (ListItem item : tasks)
        {
            if (item.isCompleted())
                list.add("*** " + item.toString());
            else
                list.add(item.toString());
        }

        return list;
    }

    public List<String> getListOfCompleted()
    {
        List<String> list = new ArrayList<>();

        for (ListItem item : tasks)
        {
            if (item.isCompleted())
                list.add(item.toString());
        }

        return list;
    }

    public List<String> getListOfUncompleted()
    {
        List<String> list = new ArrayList<>();

        for (ListItem item : tasks)
        {
            if (!item.isCompleted())
                list.add(item.toString());
        }

        return list;
    }

    public void writeToFile(String file)
    {
        try (Formatter output = new Formatter(file))
        {
            for (ListItem item : tasks)
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
