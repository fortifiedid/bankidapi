package fortifiedid.bankidapi.entities;

public class CompletionData
{
    public final User user;
    public final Device device;
    public final Cert cert;
    public final Signature signature;
    public final OcspResponse ocspResponse;

    public CompletionData(User user, Device device, Cert cert, Signature signature, OcspResponse ocspSignature)
    {
        this.user = user;
        this.device = device;
        this.cert = cert;
        this.signature = signature;
        this.ocspResponse = ocspSignature;
    }
}
