package fortifiedid.bankidapi.entities;

public class Cert
{
    public final long notBefore;
    public final long notAfter;

    public Cert(long notBefore,long notAfter)
    {
        this.notBefore = notBefore;
        this.notAfter = notAfter;
    }

    public Cert(String notBefore,String notAfter)
    {
        this.notBefore = parseString(notBefore);
        this.notAfter = parseString(notAfter);
    }

    private long parseString(String value)
    {
        try
        {
            return Long.parseLong(value);
        }
        catch(Exception e)
        {
            return 0;
        }
    }
}
