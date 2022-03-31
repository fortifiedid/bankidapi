package fortifiedid.bankidapi.entities;

public class Device
{
    private final String ipAddress;

    public Device(String ipAddress)
    {
        this.ipAddress = ipAddress;
    }

    @Override
    public String toString()
    {
        return ipAddress;
    }
}
