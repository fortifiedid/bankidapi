package fortifiedid.bankidapi.util;

import fortifiedid.bankidapi.util.JsonParserException;
import fortifiedid.bankidapi.util.JsonParser;
import org.junit.Test;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertEquals;

public class JsonParserTest
{
    static class Shoe
    {
        public String name;
        public int size;
    }

    @Test
    public void testParseJson() throws Exception
    {
        String JSON = "{\"name\" : \"My shoe\", \"size\" : 43}";

        Shoe shoe1 = new JsonParser().parse(JSON.getBytes(),Shoe.class);
        assertEquals("My shoe", shoe1.name);
        assertEquals(43, shoe1.size);

        String json = new JsonParser().toJson(shoe1);

        assertTrue("Should contain name", json.contains("\"name\""));
        assertTrue("Should contain My shoe", json.contains("\"My shoe\""));
        assertTrue("Should contain size", json.contains("\"size\""));
        assertTrue("Should contain 43", json.contains("43"));

    }

    @Test (expected = JsonParserException.class)
    public void testInvalidJson() throws Exception
    {
        new JsonParser().parse("invalid".getBytes(),Shoe.class);
    }

    @Test (expected = JsonParserException.class)
    public void testToJsonNullObject() throws Exception
    {
        new JsonParser().toJson(null);
    }
}
