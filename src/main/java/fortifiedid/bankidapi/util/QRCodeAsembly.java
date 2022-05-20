/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fortifiedid.bankidapi.util;

/**
 *
 * @author andersandren
 */
public class QRCodeAsembly {

    private static final String QR_PATTERN = "bankid.%s.%d.%s";

    public static String generate(String startToken, int counter, String authCode) {

        return String.format(QR_PATTERN, startToken, counter, authCode);
    }
}
