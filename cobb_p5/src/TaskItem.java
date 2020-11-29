public class TaskItem
{
    private String title;
    private String description;
    private String dueDate;
    private boolean completed;

    public TaskItem(String title, String description, String dueDate)
    {
        if (isTitleValid(title) && isDueDateValid(dueDate))
        {
            this.title = title;
            this.description = description;
            this.dueDate = dueDate;
        }
        else if (!isTitleValid(title))
        {
            throw new IllegalArgumentException("title not valid; title must be at least 1 character long");
        }
        else if (!isDueDateValid(dueDate))
        {
            throw new IllegalArgumentException("due date not valid; due date must be in format YYYY-MM-DD");
        }
    }

    public TaskItem()
    {
    }

    public void updateItem(String title, String description, String dueDate)
    {
        if (isTitleValid(title) && isDueDateValid(dueDate))
        {
            this.title = title;
            this.description = description;
            this.dueDate = dueDate;
        }
        else if (!isTitleValid(title))
        {
            throw new IllegalArgumentException("title not valid; title must be at least 1 character long");
        }
        else if (!isDueDateValid(dueDate))
        {
            throw new IllegalArgumentException("due date not valid; due date must be in format YYYY-MM-DD");
        }
    }

    public void setTitle(String title)
    {
        if (isTitleValid(title))
            this.title = title;
        else
            throw new IllegalArgumentException("title not valid; title must be at least 1 character long");
    }

    public void setDescription(String description)
    {
        this.description = description;
    }

    public void setDueDate(String dueDate)
    {
        if (isDueDateValid(dueDate))
            this.dueDate = dueDate;
        else
            throw new IllegalArgumentException("due date not valid; due date must be in format YYYY-MM-DD");
    }

    public String getTitle()
    {
        return title;
    }

    public String getDescription()
    {
        return description;
    }

    public String getDueDate()
    {
        return dueDate;
    }

    private boolean isTitleValid(String title)
    {
        return title.length() > 0;
    }

    private boolean isDueDateValid(String dueDate)
    {
        // \\d means integer. {4} means repeat previous n times.
        // \\d{4} means look for 4 characters and sees if they are an integer
        return dueDate.matches("\\d{4}-\\d{2}-\\d{2}");
    }

    public void setCompleted(boolean newState)
    {
        completed = newState;
    }

    public boolean isCompleted()
    {
        return completed;
    }

    @Override
    public String toString()
    {
        return "[" + this.dueDate + "]" + " " + this.title + ": " + this.description;
    }
}