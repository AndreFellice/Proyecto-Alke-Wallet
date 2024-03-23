/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.mycompany.alkewallet;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author andre
 */
public class BilleteraDigitalTest {
    
    public BilleteraDigitalTest() {
    }
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() {
    }
    
    @AfterEach
    public void tearDown() {
    }

    /**
     * Test of obtenerSaldo method, of class BilleteraDigital.
     */
    @Test
    public void testObtenerSaldo() {
        System.out.println("obtenerSaldo");
        BilleteraDigital instance = new BilleteraDigital();
        double expResult = 0.0;
        double result = instance.obtenerSaldo();
        assertEquals(expResult, result, 0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of depositar method, of class BilleteraDigital.
     */
    @Test
    public void testDepositar() {
        System.out.println("depositar");
        double cantidad = 0.0;
        BilleteraDigital instance = new BilleteraDigital();
        instance.depositar(cantidad);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of retirar method, of class BilleteraDigital.
     */
    @Test
    public void testRetirar() {
        System.out.println("retirar");
        double cantidad = 0.0;
        BilleteraDigital instance = new BilleteraDigital();
        instance.retirar(cantidad);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of convertirMoneda method, of class BilleteraDigital.
     */
    @Test
    public void testConvertirMoneda() {
        System.out.println("convertirMoneda");
        int aMoneda = 0;
        Double cantidad = null;
        BilleteraDigital instance = new BilleteraDigital();
        instance.convertirMoneda(aMoneda, cantidad);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of obtenerTransacciones method, of class BilleteraDigital.
     */
    @Test
    public void testObtenerTransacciones() {
        System.out.println("obtenerTransacciones");
        BilleteraDigital instance = new BilleteraDigital();
        instance.obtenerTransacciones();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of hacerTransferencia method, of class BilleteraDigital.
     */
    @Test
    public void testHacerTransferencia() {
        System.out.println("hacerTransferencia");
        double monto = 0.0;
        BilleteraDigital destinatario = null;
        BilleteraDigital instance = new BilleteraDigital();
        instance.hacerTransferencia(monto, destinatario);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setNombreCliente method, of class BilleteraDigital.
     */
    @Test
    public void testSetNombreCliente() {
        System.out.println("setNombreCliente");
        String nombre = "";
        BilleteraDigital instance = new BilleteraDigital();
        instance.setNombreCliente(nombre);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
