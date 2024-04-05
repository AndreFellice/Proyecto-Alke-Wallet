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
     * Test of setnombreDestinatario method, of class BilleteraDigital.
     */
    @Test
    public void testSetnombreDestinatario() {
        System.out.println("setnombreDestinatario");
        String nombre = "";
        BilleteraDigital instance = new BilleteraDigital();
        instance.setnombreDestinatario(nombre);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of obtenerSaldo method, of class BilleteraDigital.
     */
    @Test
   
public void testObtenerSaldo() {
    System.out.println("obtenerSaldo");
    // Se instancia al usuario quien puede usar los métodos
    Cliente cliente2 = new Cliente("Pablo", 1);

    cliente2.getBilleteraDigital().depositar(2000.0);
    double saldo = cliente2.getBilleteraDigital().obtenerSaldo();
    assertEquals(2000.0, saldo, 0.001);
}

    /**
     * Test of depositar method, of class BilleteraDigital.
     */
    @Test
    public void testDepositar() {
        System.out.println("depositar");
         // Se instancia al usuario quien puede usar los metodos 
        Cliente cliente1 = new Cliente("Andre", 1);
        //Realizar un depósito válido
        cliente1.getBilleteraDigital().depositar(500.0);
        // Compara los valores
        assertEquals(500.0, cliente1.getBilleteraDigital().obtenerSaldo(), 0);
        //Realizar un deposito con una cantidad negativa
        cliente1.getBilleteraDigital().depositar(-500.0);
        // compara lo que se espera con lo que se trae
        assertEquals(500.0, cliente1.getBilleteraDigital().obtenerSaldo(), 0);
        // depositar  un valor 0
        cliente1.getBilleteraDigital().depositar(0);
        assertEquals(500.0, cliente1.getBilleteraDigital().obtenerSaldo(), 0);
    }

    /**
     * Test of retirar method, of class BilleteraDigital.
     */
    @Test
    public void testRetirar() {
        System.out.println("retirar");
        // realizar un retiro 
        Cliente cliente2 = new Cliente ("Peter",1);
        cliente2.getBilleteraDigital().depositar(2000.0);

        // retirar saldo
        cliente2.getBilleteraDigital().retirar(1000.0);
        // compara los valores
        assertEquals(1000.0, cliente2.getBilleteraDigital().obtenerSaldo(), 0);

        // intentar realizar un giro con una cantidad negativa 
        cliente2.getBilleteraDigital().retirar(-50.0);
        // compara lo que se espera con lo que se trae
        assertEquals(1000.0, cliente2.getBilleteraDigital().obtenerSaldo(), 0);
        
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

}
