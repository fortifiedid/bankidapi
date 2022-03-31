package fortifiedid.bankidapi.entities;

import fortifiedid.bankidapi.entities.Cert;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CertTest
{
    @Test
    public void testConstructorString()
    {
        Cert cert = new Cert("111111","222222");
        assertEquals(111111,cert.notBefore);
        assertEquals(222222,cert.notAfter);
    }

    @Test
    public void testConstructorLong()
    {
        Cert cert = new Cert(-111111,222222);
        assertEquals(-111111,cert.notBefore);
        assertEquals(222222,cert.notAfter);
    }

    @Test
    public void testConstructorInvalid1()
    {
        Cert cert = new Cert("111111iinv","222222inv");
        assertEquals(0,cert.notBefore);
        assertEquals(0,cert.notAfter);
    }
}
