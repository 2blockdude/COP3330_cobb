public class ListItem
{
    private String title;
    private String description;
    private String dueDate;
    private boolean completed;

    private void setTitle(String newTitle)
    {
        this.title = newTitle;
    }

    private String getTitle()
    {
        return this.title;
    }

    private void setDescription(String newDescription)
    {
        this.description = newDescription;
    }

    private String getDescription()
    {
        return this.description;
    }

    private void setDueDate(String newDueDate)
    {
        this.dueDate = newDueDate;
    }

    private String getDueDate()
    {
        return this.dueDate;
    }

    private void setCompleted()
    {
        completed = !completed;
    }

    private boolean isCompleted()
    {
        return completed;
    }

    @Override
    public String toString()
    {
        return "[" + this.dueDate + "]" + " " + this.title + ": " + this.description;
    }
}
