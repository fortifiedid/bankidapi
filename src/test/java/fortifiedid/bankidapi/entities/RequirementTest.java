package fortifiedid.bankidapi.entities;

import fortifiedid.bankidapi.entities.Requirement;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertNotNull;
import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertFalse;

public class RequirementTest
{
    @Test
    public void testIncludedMembersInJson()
    {
        Requirement requirement = new Requirement();

        String json = requirement.toJson();
        assertFalse("Should not contain certificatePolicies", json.contains("certificatePolicies"));
        assertFalse("Should not contain issuerCn", json.contains("issuerCn"));
        assertFalse("Should not contain cardReader", json.contains("cardReader"));
        assertFalse("Should not contain allowFingerprint", json.contains("allowFingerprint"));
        assertFalse("Should not contain autoStartTokenRequired", json.contains("autoStartTokenRequired"));

        requirement.addCertificatePolicy("policy1");
        requirement.addIssuerCn("Nordea");
        requirement.cardReader = "card1";
        requirement.allowFingerprint = Boolean.TRUE;
        requirement.autoStartTokenRequired = Boolean.TRUE;

        json = requirement.toJson();
        assertTrue("Should contain certificatePolicies", json.contains("certificatePolicies"));
        assertTrue("Should contain issuerCn", json.contains("issuerCn"));
        assertTrue("Should contain cardReader", json.contains("cardReader"));
        assertTrue("Should contain allowFingerprint", json.contains("allowFingerprint"));
        assertTrue("Should contain autoStartTokenRequired", json.contains("autoStartTokenRequired"));
    }

    @Test
    public void testDefaultValues()
    {
        Requirement requirement = new Requirement();

        assertEquals(null, requirement.getCertificatePolicies());
        assertEquals(null, requirement.getIssuerCn());
        assertEquals(null, requirement.cardReader);
        assertEquals(null, requirement.allowFingerprint);
        assertEquals(null, requirement.autoStartTokenRequired);
    }

    @Test
    public void testValues()
    {
        Requirement requirement = new Requirement();
        requirement.allowFingerprint = Boolean.TRUE;
        requirement.autoStartTokenRequired = Boolean.FALSE;
        requirement.cardReader = "card1";

        assertEquals(null, requirement.getCertificatePolicies());
        assertEquals(null, requirement.getIssuerCn());
        assertEquals("card1", requirement.cardReader);
        assertEquals(Boolean.TRUE, requirement.allowFingerprint);
        assertEquals(Boolean.FALSE, requirement.autoStartTokenRequired);
    }

    @Test
    public void testJson()
    {
        String JSON =
                "{"+
                "\"allowFingerprint\" : true," +
                "\"autoStartTokenRequired\" : false," +
                "\"cardReader\" : \"card1\"," +
                "\"issuerCn\" : [\"Nordea\"]," +
                "\"certificatePolicies\" : [\"policy123\",\"policy456\"]" +
                "}";

        Requirement requirement = Requirement.parseJson(JSON.getBytes());
        assertEquals(Boolean.TRUE, requirement.allowFingerprint);
        assertEquals(Boolean.FALSE, requirement.autoStartTokenRequired);
        assertEquals("card1", requirement.cardReader);
        assertNotNull(requirement.getIssuerCn());
        assertEquals(1, requirement.getIssuerCn().size());
        assertEquals("Nordea", requirement.getIssuerCn().get(0));
        assertNotNull(requirement.getCertificatePolicies());
        assertEquals(2, requirement.getCertificatePolicies().size());
        assertEquals("policy123", requirement.getCertificatePolicies().get(0));
        assertEquals("policy456", requirement.getCertificatePolicies().get(1));

        String json = requirement.toJson();
        requirement = Requirement.parseJson(json.getBytes());
        assertEquals(Boolean.TRUE, requirement.allowFingerprint);
        assertEquals(Boolean.FALSE, requirement.autoStartTokenRequired);
        assertEquals("card1", requirement.cardReader);
        assertNotNull(requirement.getIssuerCn());
        assertEquals(1, requirement.getIssuerCn().size());
        assertEquals("Nordea", requirement.getIssuerCn().get(0));
        assertNotNull(requirement.getCertificatePolicies());
        assertEquals(2, requirement.getCertificatePolicies().size());
        assertEquals("policy123", requirement.getCertificatePolicies().get(0));
        assertEquals("policy456", requirement.getCertificatePolicies().get(1));
    }
}