import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import static org.junit.jupiter.api.Assertions.*;

class ContactItemTest
{
    // test creation
    @Test
    public void testContactItemCreationFailsWithAllBlankValues()
    {
        assertThrows(IllegalArgumentException.class, new Executable() {
            @Override
            public void execute() throws Throwable {
                ContactItem i = new ContactItem("", "" , "", "");
            }
        });
    }

    @Test
    public void testContactItemCreationFailsWithInvalidPhone()
    {
        assertThrows(IllegalArgumentException.class, new Executable() {
            @Override
            public void execute() throws Throwable {
                ContactItem i = new ContactItem("", "" , "44n-444-8888", "");
            }
        });
    }

    @Test
    public void testContactItemCreationFailsWithInvalidEmail()
    {
        assertThrows(IllegalArgumentException.class, new Executable() {
            @Override
            public void execute() throws Throwable {
                ContactItem i = new ContactItem("", "" , "", "asdf;845-85.com");
            }
        });
    }

    @Test
    public void testContactItemCreationSucceedsWithAllFilledOut()
    {
        ContactItem i = new ContactItem("a", "a" , "444-444-4444", "someone@domain.tld");

        String s = "Name: a a%n" +
                "Phone: 444-444-4444%n" +
                "Email: someone@domain.tld";

        assertEquals(s, i.toString());
    }

    @Test
    public void testContactItemCreationSucceedsWithBlankFirstName()
    {
        ContactItem i = new ContactItem("", "a" , "444-444-4444", "someone@domain.tld");

        String s = "Name:  a%n" +
                "Phone: 444-444-4444%n" +
                "Email: someone@domain.tld";

        assertEquals(s, i.toString());
    }

    @Test
    public void testContactItemCreationSucceedsWithBlankLastName()
    {
        ContactItem i = new ContactItem("a", "" , "444-444-4444", "someone@domain.tld");

        String s = "Name: a %n" +
                "Phone: 444-444-4444%n" +
                "Email: someone@domain.tld";

        assertEquals(s, i.toString());
    }

    @Test
    public void testContactItemCreationSucceedsWithBlankPhone()
    {
        ContactItem i = new ContactItem("a", "a" , "", "someone@domain.tld");

        String s = "Name: a a%n" +
                "Phone: %n" +
                "Email: someone@domain.tld";

        assertEquals(s, i.toString());
    }

    @Test
    public void testContactItemCreationSucceedsWithBlankEmail()
    {
        ContactItem i = new ContactItem("a", "a" , "444-444-4444", "");

        String s = "Name: a a%n" +
                "Phone: 444-444-4444%n" +
                "Email: ";

        assertEquals(s, i.toString());
    }

    @Test
    public void testContactItemCreationSucceedsWithOnlyFirstName()
    {
        ContactItem i = new ContactItem("a", "" , "", "");

        String s = "Name: a %n" +
                "Phone: %n" +
                "Email: ";

        assertEquals(s, i.toString());
    }

    @Test
    public void testContactItemCreationSucceedsWithOnlyLastName()
    {
        ContactItem i = new ContactItem("", "a" , "", "");

        String s = "Name:  a%n" +
                "Phone: %n" +
                "Email: ";

        assertEquals(s, i.toString());
    }

    @Test
    public void testContactItemCreationSucceedsWithOnlyPhone()
    {
        ContactItem i = new ContactItem("", "" , "444-444-4444", "");

        String s = "Name:  %n" +
                "Phone: 444-444-4444%n" +
                "Email: ";

        assertEquals(s, i.toString());
    }

    @Test
    public void testContactItemCreationSucceedsWithOnlyEmail()
    {
        ContactItem i = new ContactItem("", "" , "", "someone@domain.tld");

        String s = "Name:  %n" +
                "Phone: %n" +
                "Email: someone@domain.tld";

        assertEquals(s, i.toString());
    }

    // test editing
    @Test
    public void testContactItemEditFailsWithAllBlankValues()
    {
        assertThrows(IllegalArgumentException.class, new Executable() {
            @Override
            public void execute() throws Throwable {
                ContactItem i = new ContactItem();
                i.updateContact("", "", "", "");
            }
        });
    }

    @Test
    public void testContactItemEditFailsWithInvalidPhone()
    {
        assertThrows(IllegalArgumentException.class, new Executable() {
            @Override
            public void execute() throws Throwable {
                ContactItem i = new ContactItem();
                i.updateContact("", "", "888-888-485S", "");
            }
        });
    }

    @Test
    public void testContactItemEditFailsWithInvalidEmail()
    {
        assertThrows(IllegalArgumentException.class, new Executable() {
            @Override
            public void execute() throws Throwable {
                ContactItem i = new ContactItem();
                i.updateContact("", "", "", "donkey@.com");
            }
        });
    }

    @Test
    public void testContactItemEditSucceedsWithBlankFirstName()
    {
        ContactItem i = new ContactItem("a", "a" , "444-444-4444", "someone@domain.tld");
        i.setFirstName("");

        assertEquals("", i.getFirstName());
    }

    @Test
    public void testContactItemEditSucceedsWithBlankLastName()
    {
        ContactItem i = new ContactItem("a", "a" , "444-444-4444", "someone@domain.tld");
        i.setLastName("");

        assertEquals("", i.getLastName());
    }

    @Test
    public void testContactItemEditSucceedsWithBlankPhone()
    {
        ContactItem i = new ContactItem("a", "a" , "444-444-4444", "someone@domain.tld");
        i.setPhone("");

        assertEquals("", i.getPhone());
    }

    @Test
    public void testContactItemEditSucceedsWithBlankEmail()
    {
        ContactItem i = new ContactItem("a", "a" , "444-444-4444", "someone@domain.tld");
        i.setEmail("");

        assertEquals("", i.getEmail());
    }

    @Test
    public void testContactItemEditSucceedsWithNonBlankFirstName()
    {
        ContactItem i = new ContactItem("a", "a" , "444-444-4444", "someone@domain.tld");
        i.setFirstName("b");

        assertEquals("b", i.getFirstName());
    }

    @Test
    public void testContactItemEditSucceedsWithNonBlankLastName()
    {
        ContactItem i = new ContactItem("a", "a" , "444-444-4444", "someone@domain.tld");
        i.setLastName("b");

        assertEquals("b", i.getLastName());
    }

    @Test
    public void testContactItemEditSucceedsWithNonBlankPhone()
    {
        ContactItem i = new ContactItem("a", "a" , "444-444-4444", "someone@domain.tld");
        i.setPhone("111-111-1111");

        assertEquals("111-111-1111", i.getPhone());
    }

    @Test
    public void testContactItemEditSucceedsWithNonBlankEmail()
    {
        ContactItem i = new ContactItem("a", "a" , "444-444-4444", "someone@domain.tld");
        i.setEmail("someoneelse@differentdomain.other");

        assertEquals("someoneelse@differentdomain.other", i.getEmail());
    }

    // toString
    @Test
    public void testContactItemToString()
    {
        ContactItem i = new ContactItem("a", "a" , "444-444-4444", "someone@domain.tld");

        String s = "Name: a a%n" +
                "Phone: 444-444-4444%n" +
                "Email: someone@domain.tld";

        assertEquals(s, i.toString());
    }
}