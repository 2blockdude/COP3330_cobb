import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import static org.junit.jupiter.api.Assertions.*;

class TaskListTest
{
    // test size
    @Test
    public void testAddTaskSizeIncrease()
    {
        TaskList l = new TaskList();

        assertEquals(0, l.getList().size());
        l.addTask("some title", "some description", "7777-77-77");
        assertEquals(1, l.getList().size());
    }
    @Test
    public void testRemoveTaskSizeDecreases()
    {
        TaskList l = new TaskList();

        assertEquals(0, l.getList().size());
        l.addTask("some title", "some description", "7777-77-77");
        l.addTask("some title2", "some description2", "7777-77-77");
        assertEquals(2, l.getList().size());
        l.removeTask(0);
        assertEquals(1, l.getList().size());
    }
    @Test
    public void testRemoveTaskWithInvalidIndex()
    {
        assertThrows(IndexOutOfBoundsException.class, new Executable() {
            @Override
            public void execute() throws Throwable {
                TaskList l = new TaskList();
                l.addTask("some title", "some description", "7777-77-77");
                l.removeTask(1);
            }
        });
    }

    // test mark completed
    @Test
    public void testItemMarkCompleted()
    {
        TaskList l = new TaskList();
        l.addTask("some title", "some description", "7777-77-77");
        l.markCompleted(0);

        assertEquals(true, l.getList().get(0).isCompleted());
    }
    @Test
    public void testMarkCompletedWithInvalidIndex()
    {
        assertThrows(IndexOutOfBoundsException.class, new Executable() {
            @Override
            public void execute() throws Throwable {
                TaskList l = new TaskList();
                l.addTask("some title", "some description", "7777-77-77");
                l.markCompleted(1);
            }
        });
    }

    // test mark uncompleted
    @Test
    public void testItemMarkUncompleted()
    {
        TaskList l = new TaskList();
        l.addTask("some title", "some description", "7777-77-77");
        l.markCompleted(0);
        l.markUncompleted(0);

        assertEquals(false, l.getList().get(0).isCompleted());
    }
    @Test
    public void testMarkUncompletedWithInvalidIndex()
    {
        assertThrows(IndexOutOfBoundsException.class, new Executable() {
            @Override
            public void execute() throws Throwable {
                TaskList l = new TaskList();
                l.addTask("some title", "some description", "7777-77-77");
                l.markUncompleted(1);
            }
        });
    }

    // getting task item values tests
    @Test
    public void testGetTaskItemTitle()
    {
        TaskList l = new TaskList();
        l.addTask("some title", "some description", "7777-77-77");
        assertEquals("some title", l.getTaskTitle(0));
    }
    @Test
    public void testGetTaskItemDescription()
    {
        TaskList l = new TaskList();
        l.addTask("some title", "some description", "7777-77-77");
        assertEquals("some description", l.getTaskDescription(0));
    }
    @Test
    public void testGetTaskItemDueDate()
    {
        TaskList l = new TaskList();
        l.addTask("some title", "some description", "7777-77-77");
        assertEquals("7777-77-77", l.getTaskDueDate(0));
    }
    @Test
    public void testGetTaskItemTitleWithInvalidIndex()
    {
        assertThrows(IndexOutOfBoundsException.class, new Executable() {
            @Override
            public void execute() throws Throwable {
                TaskList l = new TaskList();
                l.addTask("some title", "some description", "7777-77-77");
                assertEquals("some title", l.getTaskTitle(1));
            }
        });
    }
    @Test
    public void testGetTaskItemDescriptionWithInvalidIndex()
    {
        assertThrows(IndexOutOfBoundsException.class, new Executable() {
            @Override
            public void execute() throws Throwable {
                TaskList l = new TaskList();
                l.addTask("some title", "some description", "7777-77-77");
                assertEquals("some description", l.getTaskDescription(1));
            }
        });
    }
    @Test
    public void testGetTaskItemDueDateWithInvalidIndex()
    {
        assertThrows(IndexOutOfBoundsException.class, new Executable() {
            @Override
            public void execute() throws Throwable {
                TaskList l = new TaskList();
                l.addTask("some title", "some description", "7777-77-77");
                assertEquals("7777-77-77", l.getTaskDueDate(1));
            }
        });
    }

    // task item value change tests
    @Test
    public void testTaskChangeValues()
    {
        TaskList l = new TaskList();
        l.addTask("some title", "some description", "7777-77-77");
        assertEquals("[7777-77-77] some title: some description", l.getTask(0));
        l.editTask(0, "new title", "new description", "0000-00-00");
        assertEquals("[0000-00-00] new title: new description", l.getTask(0));
    }
    @Test
    public void testTaskChangeTileValue()
    {
        TaskList l = new TaskList();
        l.addTask("some title", "some description", "7777-77-77");
        assertEquals("some title", l.getTaskTitle(0));
        l.editTaskTitle(0, "new title");
        assertEquals("new title", l.getTaskTitle(0));
    }
    @Test
    public void testTaskChangeDescriptionValue()
    {
        TaskList l = new TaskList();
        l.addTask("some title", "some description", "7777-77-77");
        assertEquals("some description", l.getTaskDescription(0));
        l.editTaskDescription(0, "new description");
        assertEquals("new description", l.getTaskDescription(0));
    }
    @Test
    public void testTaskChangeDueDateValue()
    {
        TaskList l = new TaskList();
        l.addTask("some title", "some description", "7777-77-77");
        assertEquals("7777-77-77", l.getTaskDueDate(0));
        l.editTaskDueDate(0, "0000-00-00");
        assertEquals("0000-00-00", l.getTaskDueDate(0));
    }
    @Test
    public void testTaskChangeTitleWithInvalidIndex()
    {
        assertThrows(IndexOutOfBoundsException.class, new Executable() {
            @Override
            public void execute() throws Throwable {
                TaskList l = new TaskList();
                l.addTask("some title", "some description", "7777-77-77");
                l.editTaskTitle(1, "new title");
            }
        });
    }
    @Test
    public void testTaskChangeDescriptionWithInvalidIndex()
    {
        assertThrows(IndexOutOfBoundsException.class, new Executable() {
            @Override
            public void execute() throws Throwable {
                TaskList l = new TaskList();
                l.addTask("some title", "some description", "7777-77-77");
                l.editTaskDescription(1, "new description");
            }
        });
    }
    @Test
    public void testTaskChangeDueDateWithInvalidIndex()
    {
        assertThrows(IndexOutOfBoundsException.class, new Executable() {
            @Override
            public void execute() throws Throwable {
                TaskList l = new TaskList();
                l.addTask("some title", "some description", "7777-77-77");
                l.editTaskDueDate(1, "0000-00-00");
            }
        });
    }

    // new task list is empty tests
    @Test
    public void testNewTaskListIsEmpty()
    {
        TaskList l = new TaskList();
        l.addTask("some title", "some description", "7777-77-77");
        assertEquals(1, l.getList().size());

        l = new TaskList();
        assertEquals(0, l.getList().size());
    }

    // test write list to file
    @Test
    public void testWriteTaskListToFile()
    {
        TaskList l = new TaskList();
        assertEquals(0, l.getList().size());
        l.addTask("some title", "some description", "7777-77-77");
        l.addTask("some title", "some description", "7777-77-77");
        l.addTask("some title", "some description", "7777-77-77");
        // write to file returns 0 if the import was successful
        assertEquals(0, l.writeToFile("test.txt"));
        assertEquals(3, l.getList().size());
    }

    // import task list from file
    @Test
    public void testImportingTaskListFromFile()
    {
        TaskList l = new TaskList();
        assertEquals(0, l.getList().size());
        // importfromfile returns 0 if the import was successful
        assertEquals(0, l.importFromFile("test.txt"));
        assertEquals(3, l.getList().size());
    }
}