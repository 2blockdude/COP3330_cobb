public class TaskItem
{
    private String title;
    private String description;
    private String dueDate;
    private boolean completed;

    public TaskItem(String title, String description, String dueDate)
    {
        if (isTitleValid(title))
            setTitle(title);
        else
            throw new InvalidTitleException("title not valid; title must be more than 1 character long and cannot contain ':'");

        if (isDueDateValid(dueDate))
            setDueDate(dueDate);
        else
            throw new InvalidDueDateException("due date not valid; due date must be in format YYYY-MM-DD");

        setDescription(description);
    }

    public TaskItem()
    {
    }

    public void updateItem(String title, String description, String dueDate)
    {
        if (isTitleValid(title))
            setTitle(title);
        else
            throw new InvalidTitleException("title not valid; title must be more than 1 character long and cannot contain ':'");

        if (isDueDateValid(dueDate))
            setDueDate(dueDate);
        else
            throw new InvalidDueDateException("due date not valid; due date must be in format YYYY-MM-DD");

        setDescription(description);
    }

    public void setTitle(String title)
    {
        if (isTitleValid(title))
            this.title = title;
        else
            throw new InvalidTitleException("title not valid; title must be more than 1 character long and cannot contain ':'");
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
            throw new InvalidDueDateException("due date not valid; due date must be in format YYYY-MM-DD");
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

class InvalidTitleException extends IllegalArgumentException {
    public InvalidTitleException(String msg) {
        super(msg);
    }
}

class InvalidDueDateException extends IllegalArgumentException {
    public InvalidDueDateException(String msg) {
        super(msg);
    }
}