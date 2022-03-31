package fortifiedid.bankidapi.entities;

import fortifiedid.bankidapi.entities.HintCode;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class HintCodeTest
{
    @Test
    public void testToString() throws Exception
    {
        assertEquals("noClient", HintCode.NO_CLIENT.toString());
        assertEquals("outstandingTransaction",HintCode.OUTSTANDING_TRANSACTION.toString());
        assertEquals("started",HintCode.STARTED.toString());
        assertEquals("userSign",HintCode.USER_SIGN.toString());
        assertEquals("unknown",HintCode.UNKNOWN.toString());


        assertEquals("expiredTransaction",HintCode.EXPIRED_TRANSACTION.toString());
        assertEquals("certificateErr",HintCode.CERTIFICATE_ERR.toString());
        assertEquals("userCancel",HintCode.USER_CANCEL.toString());
        assertEquals("cancelled",HintCode.CANCELLED.toString());
        assertEquals("startFailed",HintCode.START_FAILED.toString());
    }

    @Test
    public void testParse() throws Exception
    {
        assertEquals(HintCode.NO_CLIENT,HintCode.parse("noClient"));
        assertEquals(HintCode.OUTSTANDING_TRANSACTION,HintCode.parse("outstandingTransaction"));
        assertEquals(HintCode.STARTED,HintCode.parse("started"));
        assertEquals(HintCode.USER_SIGN,HintCode.parse("userSign"));

        assertEquals(HintCode.EXPIRED_TRANSACTION,HintCode.parse("expiredTransaction"));
        assertEquals(HintCode.CERTIFICATE_ERR,HintCode.parse("certificateErr"));
        assertEquals(HintCode.USER_CANCEL,HintCode.parse("userCancel"));
        assertEquals(HintCode.CANCELLED,HintCode.parse("cancelled"));
        assertEquals(HintCode.START_FAILED,HintCode.parse("startFailed"));

        assertEquals(HintCode.UNKNOWN,HintCode.parse("unknown"));
        assertEquals(HintCode.UNKNOWN,HintCode.parse(null));
        assertEquals(HintCode.UNKNOWN,HintCode.parse(""));
        assertEquals(HintCode.UNKNOWN,HintCode.parse("apa"));
    }

    @Test
    public void testValueOf() throws Exception
    {
        assertEquals(HintCode.NO_CLIENT,HintCode.valueOf("NO_CLIENT"));
    }
}
