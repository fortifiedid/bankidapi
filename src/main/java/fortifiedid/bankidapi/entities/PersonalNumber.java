package fortifiedid.bankidapi.entities;

public class PersonalNumber
{
    private final String personalNumber;

    public PersonalNumber(String personalNumber)
    {
        this.personalNumber = personalNumber;
    }

    @Override
    public String toString()
    {
        return personalNumber;
    }
}
