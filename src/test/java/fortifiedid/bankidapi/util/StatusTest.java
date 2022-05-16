/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fortifiedid.bankidapi.util;

import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Ignore;

/**
 *
 * @author Anders Andrén
 */
public class StatusTest {

    String staticData = "{\n"
            + " \"orderRef\":\"131daac9-16c6-4618-beb0-365768f37288\",\n"
            + " \"status\":\"pending\",\n"
            + " \"hintCode\":\"userSign\"\n"
            + "}";

    public StatusTest() {
    }

    /**
     * Test of values method, of class Status.
     */
    @Test
    public void testValues() {

        assertTrue(HintCode.parseJson(HintCode.outstandingTransaction.toJson().getBytes()).equals(HintCode.outstandingTransaction));
        assertTrue(HintCode.parseJson(HintCode.noClient.toJson().getBytes()).equals(HintCode.noClient));

        HintCode s = HintCode.parseJson(staticData.getBytes());
        
        assertTrue(s.equals(HintCode.userSign));
    }

    /**
     * Test of valueOf method, of class Status.
     */
    @Test
    @Ignore
    public void testValueOf() {
        System.out.println("valueOf");
        String string = "";
        HintCode expResult = null;
        HintCode result = HintCode.valueOf(string);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of toJson method, of class Status.
     */
    @Test
    @Ignore
    public void testToJson() {
        System.out.println("toJson");
        HintCode instance = null;
        String expResult = "";
        String result = instance.toJson();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of parseJson method, of class Status.
     */
    @Test
    @Ignore
    public void testParseJson() {
        System.out.println("parseJson");
        byte[] jsonData = null;
        HintCode expResult = null;
        HintCode result = HintCode.parseJson(jsonData);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

}
