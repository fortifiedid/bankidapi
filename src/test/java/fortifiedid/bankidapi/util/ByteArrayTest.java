package fortifiedid.bankidapi.util;

import fortifiedid.bankidapi.util.ByteArray;
import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class ByteArrayTest
{
    @Test
    public void testConstructorForCoverage() throws Exception
    {
       new ByteArray();
    }

    @Test
    public void testFromUTF8String() throws Exception
    {
        assertArrayEquals("apa".getBytes("UTF8"),ByteArray.fromUTF8String("apa"));
    }

    @Test (expected = RuntimeException.class)
    public void testFromUTF8StringNull() throws Exception
    {
        ByteArray.fromUTF8String(null);
    }
}
