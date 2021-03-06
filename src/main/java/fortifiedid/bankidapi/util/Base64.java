//
// (C) Copyright IBM Corp. 1999 All rights reserved. US Government Users Restricted Rights Use,
// duplication or disclosure restricted by GSA ADP Schedule Contract with IBM Corp. The program is
// provided "as is" without any warranty express or implied, including the warranty of
// non-infringement and the implied warranties of merchantibility and fitness for a particular
// purpose. IBM will not be liable for any damages suffered by you as a result of using the Program.
// In no event will IBM be liable for any special, indirect or consequential damages or lost profits
// even if IBM has been advised of the possibility of their occurrence. IBM will not be liable for
// any third party claims against you.
//

package fortifiedid.bankidapi.util;

public class Base64
{
    private static final char[] S_BASE64CHAR  = {
            'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R',
            'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j',
            'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', '0', '1',
            '2', '3', '4', '5', '6', '7', '8', '9', '+', '/'
    };
    private static final char   S_BASE64PAD   = '=';
    private static final byte[] S_DECODETABLE = new byte[128];

    static
    {
        for (int i = 0; i < S_DECODETABLE.length; i++)
        {
            S_DECODETABLE[i] = Byte.MAX_VALUE; // 127
        }

        for (int i = 0; i < S_BASE64CHAR.length; i++) // 0 to 63
        {
            S_DECODETABLE[S_BASE64CHAR[i]] = (byte) i;
        }
    }

    /**
     * Decodes the specified Base64 string into a byte array.
     *
     * @param data The Base64 string to decode.
     * @param off The offset in data to read from.
     * @param len The number of bytes to read.
     * @return A decoded byte array.
     */
    /*
    private static byte[] decodeInternal(char[] data,
                                int off,
                                int len)
    {
        char[] ibuf = new char[4];
        int ibufcount = 0;
        byte[] obuf = new byte[(len / 4 * 3) + 3];
        int obufcount = 0;

        for (int i = off; i < (off + len); i++)
        {
            char ch = data[i];

            if ((ch == S_BASE64PAD)
                || ((ch < S_DECODETABLE.length) && (S_DECODETABLE[ch] != Byte.MAX_VALUE)))
            {
                ibuf[ibufcount++] = ch;

                if (ibufcount == ibuf.length)
                {
                    ibufcount = 0;
                    obufcount += decode0(ibuf, obuf, obufcount);
                }
            }
        }

        if (obufcount == obuf.length)
        {
            return obuf;
        }

        byte[] ret = new byte[obufcount];
        System.arraycopy(obuf, 0, ret, 0, obufcount);

        return ret;
    }
    */

    /**
     * Decodes the specified Base64 string into a byte array.
     *
     * @param data The Base64 string to decode.
     * @return A decoded byte array.
     */
    private static byte[] decodeInternal(String data)
    {
        char[] ibuf = new char[4];
        int ibufcount = 0;
        byte[] obuf = new byte[(data.length() / 4 * 3) + 3];
        int obufcount = 0;

        for (int i = 0; i < data.length(); i++)
        {
            char ch = data.charAt(i);

            if ((ch == S_BASE64PAD)
                    || ((ch < S_DECODETABLE.length) && (S_DECODETABLE[ch] != Byte.MAX_VALUE)))
            {
                ibuf[ibufcount++] = ch;

                if (ibufcount == ibuf.length)
                {
                    ibufcount = 0;
                    obufcount += decode0(ibuf, obuf, obufcount);
                }
            }
        }

        if (obufcount == obuf.length)
        {
            return obuf;
        }

        byte[] ret = new byte[obufcount];
        System.arraycopy(obuf, 0, ret, 0, obufcount);

        return ret;
    }


    /**
     * Encodes the specified byte array into a Base64 string.
     *
     * @param data The byte array to encode.
     * @return The Base64 string.
     */
    private static String encodeInternal(byte[] data)
    {
        return encodeInternal(data, 0, data.length);
    }


    /**
     * Encodes the specified byte array into a Base64 string.
     *
     * @param data The byte array to encode.
     * @param off The offset in data to read from.
     * @param len The number of bytes to read.
     * @return The Base64 string.
     */
    private static String encodeInternal(byte[] data,
                                         int off,
                                         int len)
    {
        if (len <= 0)
        {
            return "";
        }

        char[] out = new char[(len / 3 * 4) + 4];
        int rindex = off;
        int windex = 0;

        //
        // RoEge fixed bug:
        // Rest is set to len - off. Should be set to len!!
        // Old code:
        //
        // int rest = len-off;
        //
        int rest = len;

        while (rest >= 3)
        {
            int i = ((data[rindex] & 0xff) << 16) + ((data[rindex + 1] & 0xff) << 8)
                    + (data[rindex + 2] & 0xff);
            out[windex++] = S_BASE64CHAR[i >> 18];
            out[windex++] = S_BASE64CHAR[(i >> 12) & 0x3f];
            out[windex++] = S_BASE64CHAR[(i >> 6) & 0x3f];
            out[windex++] = S_BASE64CHAR[i & 0x3f];
            rindex += 3;
            rest -= 3;
        }

        if (rest == 1)
        {
            int i = data[rindex] & 0xff;
            out[windex++] = S_BASE64CHAR[i >> 2];
            out[windex++] = S_BASE64CHAR[(i << 4) & 0x3f];
            out[windex++] = S_BASE64PAD;
            out[windex++] = S_BASE64PAD;
        }
        else if (rest == 2)
        {
            int i = ((data[rindex] & 0xff) << 8) + (data[rindex + 1] & 0xff);
            out[windex++] = S_BASE64CHAR[i >> 10];
            out[windex++] = S_BASE64CHAR[(i >> 4) & 0x3f];
            out[windex++] = S_BASE64CHAR[(i << 2) & 0x3f];
            out[windex++] = S_BASE64PAD;
        }

        return new String(out, 0, windex);
    }


    /**
     * Utility method.
     *
     * @param ibuf Input buffer.
     * @param obuf Output buffer.
     * @param wp Apa
     *
     * @return Number of decoded bytes.
     *
     * @throws RuntimeException If an internal error occurred.
     */
    private static int decode0(char[] ibuf,
                               byte[] obuf,
                               int wp)
    {
        int outlen = 3;

        if (ibuf[3] == S_BASE64PAD)
        {
            outlen = 2;
        }

        if (ibuf[2] == S_BASE64PAD)
        {
            outlen = 1;
        }

        int b0 = S_DECODETABLE[ibuf[0]];
        int b1 = S_DECODETABLE[ibuf[1]];
        int b2 = S_DECODETABLE[ibuf[2]];
        int b3 = S_DECODETABLE[ibuf[3]];

        switch (outlen)
        {
            case 1 :
                obuf[wp] = (byte) (((b0 << 2) & 0xfc) | ((b1 >> 4) & 0x3));

                return 1;

            case 2 :
                obuf[wp++] = (byte) (((b0 << 2) & 0xfc) | ((b1 >> 4) & 0x3));
                obuf[wp] = (byte) (((b1 << 4) & 0xf0) | ((b2 >> 2) & 0xf));

                return 2;

            case 3 :
                obuf[wp++] = (byte) (((b0 << 2) & 0xfc) | ((b1 >> 4) & 0x3));
                obuf[wp++] = (byte) (((b1 << 4) & 0xf0) | ((b2 >> 2) & 0xf));
                obuf[wp] = (byte) (((b2 << 6) & 0xc0) | (b3 & 0x3f));

                return 3;

            default :
                throw new RuntimeException("Internal Errror");
        }
    }


    // Those methods are visible outside the class

    public static String encode(byte[]bytes)
    {
        if(bytes == null)
            throw new Base64Exception("Could not encode null");

        return encodeInternal(bytes);
    }

    public static byte[] decode(String base64)
    {
        if(base64 == null)
            throw new Base64Exception("Could not decode null");

        checkValidCharacters(base64);

        return decodeInternal(base64);
    }

    public static String encodeUrl(byte[]data)
    {
        String base64 = encode(data);
        base64 = base64.replace("/","_");
        base64 = base64.replace("+","-");
        base64 = base64.replace("=","");
        return base64;
    }

    public static byte[] decodeUrl(String base64)
    {
        if(base64 == null)
            throw new Base64Exception("Could not decode null");

        base64 = addPaddingIfMissing(base64);

        base64 = base64.replace("_","/");
        base64 = base64.replace("-","+");
        return decode(base64);
    }

    private static String addPaddingIfMissing(String base64)
    {
        int mod = base64.length()%4;

        if(mod > 0)
        {
            for(int i=0;i<(4-mod);i++)
            {
                base64 = base64 + "=";
            }
        }

        return base64;
    }

    private static void checkValidCharacters(String base64)
    {
        for(char ch : base64.toCharArray())
        {
            if(!isValidCharacter(ch))
                throw new Base64Exception("String "+base64+" contains invalid characters");
        }
    }

    private static boolean isValidCharacter(char ch)
    {
        if(ch >= 'a' && ch <= 'z') return true;
        if(ch >= 'A' && ch <= 'Z') return true;
        if(ch >= '0' && ch <= '9') return true;
        if(ch == '+') return true;
        if(ch == '/') return true;
        if(ch == '=') return true;

        return false;
    }
}
