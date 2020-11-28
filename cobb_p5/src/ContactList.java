import java.io.File;
import java.io.FileNotFoundException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Formatter;
import java.util.List;
import java.util.Scanner;

public class ContactList
{
    private List<ContactItem> contacts;

    public ContactList()
    {
        contacts = new ArrayList<>();
    }

    public void addContact(String firstName, String lastName, String phone, String email)
    {
        contacts.add(new ContactItem(firstName, lastName, phone, email));
    }

    public void removeContact(int index)
    {
        contacts.remove(index);
    }

    public void editContact(int index, String firstName, String lastName, String phone, String email)
    {
        contacts.get(index).updateContact(firstName, lastName, phone, email);
    }

    public void editContactFirstName(int index, String firstName)
    {
        contacts.get(index).setFirstName(firstName);
    }

    public void editContactLastName(int index, String lastName)
    {
        contacts.get(index).setLastName(lastName);
    }

    public void editContactPhone(int index, String phone)
    {
        contacts.get(index).setPhone(phone);
    }

    public void editContactEmail(int index, String email)
    {
        contacts.get(index).setEmail(email);
    }

    public String getContact(int index)
    {
        return contacts.get(index).toString();
    }

    public String getContactFirstName(int index)
    {
        return contacts.get(index).getFirstName();
    }

    public String getContactLastName(int index)
    {
        return contacts.get(index).getLastName();
    }

    public String getContactPhone(int index)
    {
        return contacts.get(index).getPhone();
    }

    public String getContactEmail(int index)
    {
        return contacts.get(index).getEmail();
    }

    public List<ContactItem> getContactList()
    {
        return List.copyOf(contacts);
    }

    public int writeToFile(String file)
    {
        try (Formatter output = new Formatter(file))
        {
            for (ContactItem contact : contacts)
            {
                output.format("%s%n", contact.getFirstName());
                output.format("%s%n", contact.getLastName());
                output.format("%s%n", contact.getPhone());
                output.format("%s%n", contact.getEmail());
            }
            return 0;
        }
        catch (FileNotFoundException e)
        {
            System.out.println("file not found!");
            return 1;
        }
        catch (Exception e)
        {
            e.printStackTrace();
            return 1;
        }
    }

    public int importFromFile(String file)
    {
        List<String> data = new ArrayList<>();

        try (Scanner fileReader = new Scanner(new File(file)))
        {
            while (fileReader.hasNextLine())
            {
                String firstName = fileReader.nextLine();
                String lastName = fileReader.nextLine();
                String phone = fileReader.nextLine();
                String email = fileReader.nextLine();

                try
                {
                    contacts.add(new ContactItem(firstName, lastName, phone, email));
                }
                catch (IllegalArgumentException e)
                {
                    System.out.println("Could not import a contact item. Cause: invalid format");
                }
            }
            return 0;
        }
        catch (FileNotFoundException e)
        {
            System.out.println("file not found!");
            return 1;
        }
        catch (Exception e)
        {
            e.printStackTrace();
            return 1;
        }
    }
}
