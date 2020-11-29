import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import static org.junit.jupiter.api.Assertions.*;

class ContactListTest
{
    // test size
    @Test
    public void testContactListAddItemIncreasesSize()
    {
        ContactList l = new ContactList();
        l.addContact("a", "a", "777-777-7777", "someone@domain.tld");
        assertEquals(1, l.getList().size());
    }

    @Test
    public void testContactListRemoveItemDecreasesSize()
    {
        ContactList l = new ContactList();
        l.addContact("a", "a", "777-777-7777", "someone@domain.tld");
        l.removeContact(0);
        assertEquals(0, l.getList().size());
    }

    @Test
    public void testNewContactListIsEmpty()
    {
        ContactList l = new ContactList();
        l.addContact("a", "a", "777-777-7777", "someone@domain.tld");
        l = new ContactList();

        assertEquals(0, l.getList().size());
    }

    // test invalid edits
    @Test
    public void testContactListEditFailsWithAllBlankValues()
    {
        assertThrows(IllegalArgumentException.class, new Executable() {
            @Override
            public void execute() throws Throwable {
                ContactList l = new ContactList();
                l.addContact("a", "a", "777-777-7777", "someone@domain.tld");
                l.editContact(0, "", "", "", "");
            }
        });
    }

    @Test
    public void testContactListEditFailsWithInvalidPhone()
    {
        assertThrows(IllegalArgumentException.class, new Executable() {
            @Override
            public void execute() throws Throwable {
                ContactList l = new ContactList();
                l.addContact("a", "a", "777-777-7777", "someone@domain.tld");
                l.editContact(0, "", "", "5558-444-7777", "");
            }
        });
    }

    @Test
    public void testContactListEditFailsWithInvalidEmail()
    {
        assertThrows(IllegalArgumentException.class, new Executable() {
            @Override
            public void execute() throws Throwable {
                ContactList l = new ContactList();
                l.addContact("a", "a", "777-777-7777", "someone@domain.tld");
                l.editContact(0, "", "", "", "@some.com");
            }
        });
    }

    @Test
    public void testContactListEditFailsWithInvalidIndex()
    {
        assertThrows(IndexOutOfBoundsException.class, new Executable() {
            @Override
            public void execute() throws Throwable {
                ContactList l = new ContactList();
                l.addContact("a", "a", "777-777-7777", "someone@domain.tld");
                l.editContact(1, "", "", "", "@some.com");
            }
        });
    }

    @Test
    public void testContactListRemoveFailsWithInvalidIndex()
    {
        assertThrows(IndexOutOfBoundsException.class, new Executable() {
            @Override
            public void execute() throws Throwable {
                ContactList l = new ContactList();
                l.addContact("a", "a", "777-777-7777", "someone@domain.tld");
                l.removeContact(1);
            }
        });
    }

    // test edit
    @Test
    public void testContactListEditSucceedsWithNonBlankValues()
    {
        ContactList l = new ContactList();
        l.addContact("a", "a", "777-777-7777", "someone@domain.tld");
        l.editContact(0, "b", "b", "111-111-1111", "other@donkey.com");

        String s = "Name: b b%n" +
                "Phone: 111-111-1111%n" +
                "Email: other@donkey.com";

        assertEquals(s, l.getContact(0));
    }

    @Test
    public void testContactListEditSucceedsWithBlankFirstName()
    {
        ContactList l = new ContactList();
        l.addContact("a", "a", "777-777-7777", "someone@domain.tld");
        l.editContact(0, "", "b", "111-111-1111", "other@donkey.com");

        String s = "Name:  b%n" +
                "Phone: 111-111-1111%n" +
                "Email: other@donkey.com";

        assertEquals(s, l.getContact(0));
    }

    @Test
    public void testContactListEditSucceedsWithBlankLastName()
    {
        ContactList l = new ContactList();
        l.addContact("a", "a", "777-777-7777", "someone@domain.tld");
        l.editContact(0, "b", "", "111-111-1111", "other@donkey.com");

        String s = "Name: b %n" +
                "Phone: 111-111-1111%n" +
                "Email: other@donkey.com";

        assertEquals(s, l.getContact(0));
    }

    @Test
    public void testContactListEditSucceedsWithBlankPhone()
    {
        ContactList l = new ContactList();
        l.addContact("a", "a", "777-777-7777", "someone@domain.tld");
        l.editContact(0, "b", "b", "", "other@donkey.com");

        String s = "Name: b b%n" +
                "Phone: %n" +
                "Email: other@donkey.com";

        assertEquals(s, l.getContact(0));
    }

    @Test
    public void testContactListEditSucceedsWithBlankEmail()
    {
        ContactList l = new ContactList();
        l.addContact("a", "a", "777-777-7777", "someone@domain.tld");
        l.editContact(0, "b", "b", "111-111-1111", "");

        String s = "Name: b b%n" +
                "Phone: 111-111-1111%n" +
                "Email: ";

        assertEquals(s, l.getContact(0));
    }

    @Test
    public void testContactListEditSucceedsWithOnlyFirstName()
    {
        ContactList l = new ContactList();
        l.addContact("a", "a", "777-777-7777", "someone@domain.tld");
        l.editContact(0, "b", "", "", "");

        String s = "Name: b %n" +
                "Phone: %n" +
                "Email: ";

        assertEquals(s, l.getContact(0));
    }

    @Test
    public void testContactListEditSucceedsWithOnlyLastName()
    {
        ContactList l = new ContactList();
        l.addContact("a", "a", "777-777-7777", "someone@domain.tld");
        l.editContact(0, "", "b", "", "");

        String s = "Name:  b%n" +
                "Phone: %n" +
                "Email: ";

        assertEquals(s, l.getContact(0));
    }

    @Test
    public void testContactListEditSucceedsWithOnlyPhone()
    {
        ContactList l = new ContactList();
        l.addContact("a", "a", "777-777-7777", "someone@domain.tld");
        l.editContact(0, "", "", "111-111-1111", "");

        String s = "Name:  %n" +
                "Phone: 111-111-1111%n" +
                "Email: ";

        assertEquals(s, l.getContact(0));
    }

    @Test
    public void testContactListEditSucceedsWithOnlyEmail()
    {
        ContactList l = new ContactList();
        l.addContact("a", "a", "777-777-7777", "someone@domain.tld");
        l.editContact(0, "", "", "", "other@donkey.com");

        String s = "Name:  %n" +
                "Phone: %n" +
                "Email: other@donkey.com";

        assertEquals(s, l.getContact(0));
    }

    // load and import
    @Test
    public void testContactListSaveList()
    {
        ContactList l = new ContactList();
        l.addContact("a", "a", "777-777-7777", "someone@domain.tld");
        l.addContact("b", "b", "747-777-7777", "someone@domain.tld");
        l.addContact("c", "c", "777-777-7797", "someone@domain.tld");

        l.writeToFile("Ctest.txt");
    }

    @Test
    public void testContactListImportList()
    {
        ContactList l = new ContactList();

        l.importFromFile("Ctest.txt");

        assertEquals(3, l.getList().size());
    }
}