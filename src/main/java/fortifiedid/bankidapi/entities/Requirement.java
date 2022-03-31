package fortifiedid.bankidapi.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import fortifiedid.bankidapi.util.JsonParser;
import fortifiedid.bankidapi.util.JsonParserException;

import java.util.ArrayList;
import java.util.List;

public class Requirement
{
    public String cardReader = null;
    public Boolean allowFingerprint = null;
    public Boolean autoStartTokenRequired = null;

    private List<String> issuerCn = new ArrayList<>();
    @JsonProperty("issuerCn")
    public List<String> getIssuerCn()
    {
        if(issuerCn.isEmpty())
            return null;
        else
            return issuerCn;
    }

    @JsonProperty("issuerCn")
    public void setIssuerCn(List<String>issuerCn)
    {
        this.issuerCn = issuerCn;
    }
    public void addIssuerCn(String issuerCn)
    {
        this.issuerCn.add(issuerCn);
    }

    private List<String> certificatePolicies = new ArrayList<>();
    @JsonProperty("certificatePolicies")
    public List<String> getCertificatePolicies()
    {
        if(certificatePolicies.isEmpty())
            return null;
        else
            return certificatePolicies;
    }

    @JsonProperty("certificatePolicies")
    public void setCertificatePolicies(List<String>certificatePolicies)
    {
        this.certificatePolicies = certificatePolicies;
    }

    public void addCertificatePolicy(String certificatePolcy)
    {
        this.certificatePolicies.add(certificatePolcy);
    }


    public static Requirement parseJson(byte[]jsonData) throws JsonParserException
    {
        return new JsonParser().parse(jsonData,Requirement.class);
    }

    public String toJson() throws JsonParserException
    {
        return new JsonParser().toJson(this);
    }
}
