import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ListManagerTest
{
    @Test
    public void testWriteToFile()
    {
        ListManager l = new ListManager();
        ListItem li = new ListItem("Some title", "Some description", "2020-85-45");
        l.addItem(li);
        l.addItem(li);
        l.markCompleted(0);
        l.writeToFile("output.txt");
    }
}