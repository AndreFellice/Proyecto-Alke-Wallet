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
public class ClienteTest {
    
    public ClienteTest() {
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
     * Test of getNombreCliente method, of class Cliente.
     */
    @Test
    public void testGetNombreCliente() {
        System.out.println("getNombreCliente test");
        Cliente instance = new Cliente("Pato Donald",123456789, new BilleteraDigital());
        String expResult = "Pato Donald";
        String result = instance.getNombreCliente();
        assertEquals(expResult, result);
        
    }

    /**
     * Test of getRut method, of class Cliente.
     */
    @Test
    public void testGetRut() {
        System.out.println("getRut test");
        Cliente instance = new Cliente("Pato Donald",123456789, new BilleteraDigital());
        int expResult = 123456789;
        int result = instance.getRut();
        assertEquals(expResult, result);
      
    }

      

    /**
     * Test of setNombreCliente method, of class Cliente.
     */
    @Test
    public void testSetNombreCliente() {
        System.out.println("setNombreCliente test");
        String nombreCliente = "Pato Donald";
        BilleteraDigital billetera = new BilleteraDigital();
        Cliente instance = new Cliente("Pato Donald", 123456789, billetera);
        instance.setNombreCliente(nombreCliente);
        assertEquals(nombreCliente, instance.getNombreCliente());
    }

}