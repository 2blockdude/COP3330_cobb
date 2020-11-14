import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import static org.junit.jupiter.api.Assertions.*;

class TaskListTest
{
    // test size
    @Test
    public void testArraySizeIncrease()
    {
        TaskList l = new TaskList();

        assertEquals(0, l.getList().size());
        l.addItem("some title", "some description", "7777-77-77");
        assertEquals(1, l.getList().size());
    }
    @Test
    public void testArraySizeDecreases()
    {
        TaskList l = new TaskList();

        assertEquals(0, l.getList().size());
        l.addItem("some title", "some description", "7777-77-77");
        l.addItem("some title2", "some description2", "7777-77-77");
        assertEquals(2, l.getList().size());
        l.removeItem(0);
        assertEquals(1, l.getList().size());
    }

    // test mark completed
    @Test
    public void testItemMarkCompleted()
    {
        TaskList l = new TaskList();
        l.addItem("some title", "some description", "7777-77-77");
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
                l.addItem("some title", "some description", "7777-77-77");
                l.markCompleted(1);
            }
        });
    }

    // test mark uncompleted
    @Test
    public void testItemMarkUncompleted()
    {
        TaskList l = new TaskList();
        l.addItem("some title", "some description", "7777-77-77");
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
                l.addItem("some title", "some description", "7777-77-77");
                l.markUncompleted(1);
            }
        });
    }
}