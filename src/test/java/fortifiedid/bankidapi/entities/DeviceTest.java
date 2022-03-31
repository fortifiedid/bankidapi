package fortifiedid.bankidapi.entities;

import fortifiedid.bankidapi.entities.Device;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class DeviceTest
{
    @Test
    public void testConstructor() throws Exception
    {
        Device device = new Device("ip123");
        assertEquals("ip123",device.toString());
    }

    @Test
    public void testNull() throws Exception
    {
        Device device = new Device(null);
        assertEquals(null,device.toString());
    }
}
