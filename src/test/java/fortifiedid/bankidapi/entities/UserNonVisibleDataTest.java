package fortifiedid.bankidapi.entities;

import fortifiedid.bankidapi.entities.UserNonVisibleData;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class UserNonVisibleDataTest
{
    @Test
    public void testConstructor() throws Exception
    {
        UserNonVisibleData data = new UserNonVisibleData("testdata123".getBytes());
        assertEquals("dGVzdGRhdGExMjM=",data.toBase64());
    }

    @Test (expected = NullPointerException.class)
    public void testNull() throws Exception
    {
        new UserNonVisibleData(null);
    }
}
