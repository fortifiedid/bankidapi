package fortifiedid.bankidapi.entities;

import fortifiedid.bankidapi.entities.PersonalNumber;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PersonalNumberTest
{
    @Test
    public void testConstructor() throws Exception
    {
        PersonalNumber personalNumber = new PersonalNumber("123456");
        assertEquals("123456",personalNumber.toString());
    }
}
