/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package fortifiedid.bankidapi.util;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author andersandren
 */
public class QrAuthCodeTest {
    
    public QrAuthCodeTest() {
    }

    @Test
    public void testSomeMethod() {
        
        assertEquals(QrAuthCode.generate("d28db9a7-4cde-429e-a983-359be676944c", "0")
                ,"dc69358e712458a66a7525beef148ae8526b1c71610eff2c16cdffb4cdac9bf8");
        assertEquals(QrAuthCode.generate("d28db9a7-4cde-429e-a983-359be676944c", "1")
                ,"949d559bf23403952a94d103e67743126381eda00f0b3cbddbf7c96b1adcbce2");
          assertEquals(QrAuthCode.generate("d28db9a7-4cde-429e-a983-359be676944c", "2")
                ,"a9e5ec59cb4eee4ef4117150abc58fad7a85439a6a96ccbecc3668b41795b3f3");
    }
    
}
