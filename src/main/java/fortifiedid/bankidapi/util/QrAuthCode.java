/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fortifiedid.bankidapi.util;

import java.nio.ByteBuffer;
import javax.crypto.spec.SecretKeySpec;
import org.bouncycastle.crypto.digests.SHA256Digest;
import org.bouncycastle.crypto.macs.HMac;
import org.bouncycastle.crypto.params.KeyParameter;
import org.bouncycastle.util.encoders.Hex;

/**
 *
 * @author andersandren
 */
public class QrAuthCode {

    public static String generate(String key, String data) {

        try {
            HMac hMac = new HMac(new SHA256Digest());

            hMac.init(new KeyParameter(key.getBytes()));

            byte[] hmacIn = data.getBytes();
            hMac.update(hmacIn, 0, hmacIn.length);
            byte[] hmacOut = new byte[hMac.getMacSize()];

            hMac.doFinal(hmacOut, 0);

            return Hex.toHexString(hmacOut);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

}
