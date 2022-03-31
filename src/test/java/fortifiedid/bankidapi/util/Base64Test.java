package fortifiedid.bankidapi.util;

import org.junit.Test;

import static junit.framework.TestCase.fail;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

public class Base64Test
{
    @Test
    public void testConstructor()
    {
        new Base64();
    }

    @Test
    public void testBase64()
    {
        base64TestCase("","");
        base64TestCase("f","Zg==");
        base64TestCase("fo","Zm8=");
        base64TestCase("foo","Zm9v");
        base64TestCase("foob","Zm9vYg==");
        base64TestCase("fooba","Zm9vYmE=");
        base64TestCase("foobar", "Zm9vYmFy");
    }

    private void base64TestCase(String data,String expected)
    {
        byte[]dataBytes = data.getBytes();

        // Encode
        String encoded = Base64.encode(dataBytes);
        assertEquals(expected, encoded);

        // Decode
        byte[]decodedStringBytes = Base64.decode(expected);
        assertArrayEquals(dataBytes, decodedStringBytes);
    }

    @Test
    public void testBase64Url()
    {
        base64UrlTestCase("", "");
        base64UrlTestCase("1", "MQ");
        base64UrlTestCase("ladies and gentlemen, we are floating in space", "bGFkaWVzIGFuZCBnZW50bGVtZW4sIHdlIGFyZSBmbG9hdGluZyBpbiBzcGFjZQ");
    }

    private void base64UrlTestCase(String data,String expected)
    {
        byte[]dataBytes = data.getBytes();

        // Encode
        String encoded = Base64.encodeUrl(dataBytes);
        assertEquals(expected, encoded);

        // Decode
        byte[]decodedStringBytes = Base64.decodeUrl(expected);
        assertArrayEquals(dataBytes, decodedStringBytes);
    }

    @Test
    public void testDecodeAllCharacters()
    {
        Base64.decode("abcdefghijklmnopqrstuvxyzABCDEFGHIJKLMNOPQRSTUVXYZ0123456789+/A===");
    }


    @Test (expected = Base64Exception.class)
    public void testEncodeNull()
    {
        Base64.encode(null);
    }

    @Test (expected = Base64Exception.class)
    public void testDecodeNull()
    {
        Base64.decode(null);
    }

    @Test (expected = Base64Exception.class)
    public void testEncodeUrlNull()
    {
        Base64.encodeUrl(null);
    }

    @Test (expected = Base64Exception.class)
    public void testDecodeUrlNull()
    {
        Base64.decodeUrl(null);
    }

    @Test
    public void testDecodeInvalidCharacters()
    {
        String[]testStrings = new String[]
                {
                        "Zm9v Yg==", // Spaces
                        "[", // Larger than Z
                        "{" , // Larger than z
                };

        for(String string : testStrings)
        {
            try
            {
                Base64.decode(string);

                fail("Should throw Base64Exception for string "+string);
            }
            catch(Base64Exception e)
            {
                // Expected
            }
            catch(Exception e)
            {
                fail("Should throw Base64Exception for string "+string+", did throw "+e);
            }
        }
    }
}
