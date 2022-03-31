package fortifiedid.bankidapi.collect;

import fortifiedid.bankidapi.collect.CollectResult;
import fortifiedid.bankidapi.entities.Device;
import fortifiedid.bankidapi.entities.Signature;
import fortifiedid.bankidapi.entities.HintCode;
import fortifiedid.bankidapi.entities.OrderRef;
import fortifiedid.bankidapi.entities.Cert;
import fortifiedid.bankidapi.entities.CompletionData;
import fortifiedid.bankidapi.entities.Status;
import fortifiedid.bankidapi.entities.OcspResponse;
import fortifiedid.bankidapi.entities.PersonalNumber;
import fortifiedid.bankidapi.entities.User;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CollectResultTest
{
    @Test
    public void testConstructor() throws Exception
    {
        User user = new User(new PersonalNumber("1011120001"),"name123","givenname1","surname1");
        Device device = new Device("device1");
        Cert cert = new Cert("12345","45678");
        Signature signature = new Signature("signdata1");
        OcspResponse ocspResponse = new OcspResponse("ocspdata1");

        CompletionData completionData = new CompletionData(user,device,cert,signature,ocspResponse);
        CollectResult result = new CollectResult(new OrderRef("order123"), Status.PENDING, HintCode.OUTSTANDING_TRANSACTION,completionData,"{}");

        assertEquals("order123",result.orderRef.toString());
        assertEquals(HintCode.OUTSTANDING_TRANSACTION,result.hintCode);
        assertEquals(Status.PENDING,result.status);

        assertEquals("1011120001",result.completionData.user.personalNumber.toString());
	
	
	assertEquals(result.rawresponse,"{}");
	
	
	
    }
}
