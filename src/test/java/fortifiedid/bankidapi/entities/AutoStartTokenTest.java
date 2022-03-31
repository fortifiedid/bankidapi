package fortifiedid.bankidapi.entities;

import fortifiedid.bankidapi.entities.AutoStartToken;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class AutoStartTokenTest
{
    @Test
    public void testConstructor() throws Exception
    {
        AutoStartToken autoStartToken = new AutoStartToken("token123");
        assertEquals("token123",autoStartToken.toString());
    }

    @Test
    public void testNull() throws Exception
    {
        AutoStartToken autoStartToken = new AutoStartToken(null);
        assertEquals(null,autoStartToken.toString());
    }
}
