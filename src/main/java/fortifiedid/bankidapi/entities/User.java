package fortifiedid.bankidapi.entities;

public class User
{
    public final PersonalNumber personalNumber;
    public final String name;
    public final String givenName;
    public final String surname;

    public User(PersonalNumber personalNumber, String name, String givenName, String surname)
    {
        this.personalNumber = personalNumber;
        this.name = name;
        this.givenName = givenName;
        this.surname = surname;
    }
}
