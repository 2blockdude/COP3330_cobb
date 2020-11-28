public class ContactItem
{
    private String firstName;
    private String lastName;
    private String phone;
    private String email;

    public ContactItem(String firstName, String lastName, String phone, String email)
    {
        if (firstName.isEmpty() && lastName.isEmpty() && phone.isEmpty() && email.isEmpty())
        {
            throw new IllegalArgumentException("WARNING: at least one parameter must be filled out!");
        }
        else
        {
            if (isEmailValid(email) && isPhoneValid(phone))
            {
                this.firstName = firstName;
                this.lastName = lastName;
                this.phone = phone;
                this.email = email;
            }
            else if (!isPhoneValid(phone))
            {
                throw new IllegalArgumentException("WARNING: phone number must be in format NNN-NNN-NNNN");
            }
            else if (!isEmailValid(email))
            {
                throw new IllegalArgumentException("WARNING: email must be look like 'someone@domain.tld'");
            }
        }
    }

    public ContactItem()
    {
    }

    public void updateContact(String firstName, String lastName, String phone, String email)
    {
        if (firstName.isEmpty() && lastName.isEmpty() && phone.isEmpty() && email.isEmpty())
        {
            throw new IllegalArgumentException("WARNING: at least one parameter must be filled out!");
        }
        else
        {
            if (isEmailValid(email) && isPhoneValid(phone))
            {
                this.firstName = firstName;
                this.lastName = lastName;
                this.phone = phone;
                this.email = email;
            }
            else if (!isPhoneValid(phone))
            {
                throw new IllegalArgumentException("WARNING: phone number must be in format NNN-NNN-NNNN");
            }
            else if (!isEmailValid(email))
            {
                throw new IllegalArgumentException("WARNING: email must be look like 'someone@domain.tld'");
            }
        }
    }

    public String getFirstName()
    {
        return this.firstName;
    }

    public String getLastName()
    {
        return this.lastName;
    }

    public String getPhone()
    {
        return this.phone;
    }

    public String getEmail()
    {
        return this.email;
    }

    public void setFirstName(String firstName)
    {
        this.firstName = firstName;
    }

    public void setLastName(String lastName)
    {
        this.firstName = firstName;
    }

    public void setPhone(String phone)
    {
        if (isPhoneValid(phone))
        {
            this.phone = phone;
        }
        else
        {
            throw new IllegalArgumentException("WARNING: phone number must be in format NNN-NNN-NNNN");
        }
    }

    public void setEmail(String email)
    {
        if (isEmailValid(email))
        {
            this.email = email;
        }
        else
        {
            throw new IllegalArgumentException("WARNING: email must be look like 'someone@domain.tld'");
        }
    }

    private boolean isPhoneValid(String phone)
    {
        if (phone.isBlank())
            return true;

        return phone.matches("\\d{3}-\\d{3}-\\d{4}");
    }

    private boolean isEmailValid(String email)
    {
        if (email.isBlank())
            return true;
        // got regex from internet
        return email.matches("^[a-zA-Z0-9_+&*-]+(?:\\."+
                "[a-zA-Z0-9_+&*-]+)*@" +
                "(?:[a-zA-Z0-9-]+\\.)+[a-z" +
                "A-Z]{2,7}$");
    }

    @Override
    public String toString()
    {
        return "Name: " + this.firstName + " " + this.lastName + "%n" +
                "Phone: " + this.phone + "%n" +
                "Email: " + this.email;
    }
}