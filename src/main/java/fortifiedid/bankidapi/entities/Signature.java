package fortifiedid.bankidapi.entities;

public class Signature
{
    private final String signature;

    public Signature(String signature)
    {
        this.signature = signature;
    }

    @Override
    public String toString()
    {
        return signature;
    }
}
