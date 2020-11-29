import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import static org.junit.jupiter.api.Assertions.*;

class TaskItemTest
{
    // test invalid due date
    @Test
    public void testInvalidDueDate1()
    {
        assertThrows(IllegalArgumentException.class, new Executable() {
            @Override
            public void execute() throws Throwable {
                TaskItem i = new TaskItem();
                i.setDueDate("777m-77-77");
            }
        });
    }
    @Test
    public void testInvalidDueDate2()
    {
        assertThrows(IllegalArgumentException.class, new Executable() {
            @Override
            public void execute() throws Throwable {
                TaskItem i = new TaskItem();
                i.setDueDate("777-77-77");
            }
        });
    }
    @Test
    public void testInvalidDueDate3()
    {
        assertThrows(IllegalArgumentException.class, new Executable() {
            @Override
            public void execute() throws Throwable {
                TaskItem i = new TaskItem();
                i.setDueDate("77777777");
            }
        });
    }
    @Test
    public void testInvalidDueDate4()
    {
        assertThrows(IllegalArgumentException.class, new Executable() {
            @Override
            public void execute() throws Throwable {
                TaskItem i = new TaskItem();
                i.setDueDate("7777-7m-77");
            }
        });
    }
    @Test
    public void testInvalidDueDate5()
    {
        assertThrows(IllegalArgumentException.class, new Executable() {
            @Override
            public void execute() throws Throwable {
                TaskItem i = new TaskItem();
                i.setDueDate("7777-77-7m");
            }
        });
    }
    @Test
    public void testInvalidDueDate6()
    {
        assertThrows(IllegalArgumentException.class, new Executable() {
            @Override
            public void execute() throws Throwable {
                TaskItem i = new TaskItem("some title", "some description", "777m-77-77");
            }
        });
    }

    // test invalid title
    @Test
    public void testInvalidTitle1()
    {
        assertThrows(IllegalArgumentException.class, new Executable() {
            @Override
            public void execute() throws Throwable {
                TaskItem i = new TaskItem();
                i.setTitle("");
            }
        });
    }
    @Test
    public void testInvalidTitle2()
    {
        assertThrows(IllegalArgumentException.class, new Executable() {
            @Override
            public void execute() throws Throwable {
                TaskItem i = new TaskItem("", "some description", "7777-77-77");
            }
        });
    }

    // test valid due date
    @Test
    public void testValidDueDate1()
    {
        TaskItem i = new TaskItem();
        i.setDueDate("7777-77-77");
    }
    @Test
    public void testValidDueDate2()
    {
        TaskItem i = new TaskItem("some title", "some description", "7777-77-77");
    }

    // test valid title
    @Test
    public void testValidTitle1()
    {
        TaskItem i = new TaskItem();
        i.setTitle("some title");
    }
    @Test
    public void testValidTitle2()
    {
        TaskItem i = new TaskItem("some title", "some description", "7777-77-77");
    }
}