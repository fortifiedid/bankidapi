package fortifiedid.bankidapi.entities;

public class OcspResponse
{
    private final String ocspResponse;

    public OcspResponse(String ocspResponse)
    {
        this.ocspResponse = ocspResponse;
    }

    @Override
    public String toString()
    {
        return ocspResponse;
    }
}
