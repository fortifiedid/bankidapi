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
public class QRCodeAsemblyTest {

    public QRCodeAsemblyTest() {
    }

    //bankid.67df3917-fa0d-44e5-b327-edcc928297f8.0.dc69358e712458a66a7525beef148ae8526b1c71610eff2c16cdffb4cdac9bf8
    @Test
    public void testSomeMethod() {

        assertEquals("bankid.67df3917-fa0d-44e5-b327-edcc928297f8.0.dc69358e712458a66a7525beef148ae8526b1c71610eff2c16cdffb4cdac9bf8",
                QRCodeAsembly.generate("67df3917-fa0d-44e5-b327-edcc928297f8", 0, "dc69358e712458a66a7525beef148ae8526b1c71610eff2c16cdffb4cdac9bf8"));
    }

}
