package fortifiedid.bankidapi.entities;

import fortifiedid.bankidapi.entities.Status;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class StatusTest
{
    @Test
    public void testToString() throws Exception
    {
        assertEquals("pending", Status.PENDING.toString());
        assertEquals("failed",Status.FAILED.toString());
        assertEquals("complete",Status.COMPLETE.toString());
        assertEquals("unknown",Status.UNKNOWN.toString());
    }

    @Test
    public void testParse() throws Exception
    {
        assertEquals(Status.PENDING,Status.parse("pending"));
        assertEquals(Status.FAILED,Status.parse("failed"));
        assertEquals(Status.COMPLETE,Status.parse("complete"));

        assertEquals(Status.UNKNOWN,Status.parse("unknown"));
        assertEquals(Status.UNKNOWN,Status.parse(null));
        assertEquals(Status.UNKNOWN,Status.parse(""));
        assertEquals(Status.UNKNOWN,Status.parse("apa"));
    }

    @Test
    public void testValueOf() throws Exception
    {
        assertEquals(Status.PENDING,Status.valueOf("PENDING"));
    }
}
