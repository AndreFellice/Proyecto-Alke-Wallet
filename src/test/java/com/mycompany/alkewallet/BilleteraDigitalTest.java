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
import java.util.List;


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
        System.out.println("obtenerSaldo test");
        // Se instancia al usuario quien puede usar los métodos
        BilleteraDigital billetera = new BilleteraDigital();
        // Con saldo inicial  de 1000.00
        billetera.depositar(1000.00);
        // Verificamos que el saldo sea igual a 1000.0
        assertEquals(1000.00, billetera.obtenerSaldo(), 0.001);
    }

    /**
     * Test of depositar method, of class BilleteraDigital.
     */
    @Test
    public void testDepositar() {
        System.out.println("depositar test");
        // Se instancia al usuario quien puede usar los metodos 
        BilleteraDigital billetera = new BilleteraDigital();
        //Realizar un depósito válido
        billetera.depositar(500.00);
        // Compara los valores
        assertEquals(500.0, billetera.obtenerSaldo(), 0.001);

        //Realizar un deposito con una cantidad negativa
        billetera.depositar(-500.00);
        // compara lo que se espera con lo que se trae
        assertEquals(500.0, billetera.obtenerSaldo(), 0.001);

        // depositar  un valor 0
        billetera.depositar(0);
        assertEquals(500.0, billetera.obtenerSaldo(), 0.001);
    }

    /**
     * Test of retirar method, of class BilleteraDigital.
     */
    @Test
    public void testRetirar() {
        System.out.println("retirar test");

        // Se instancia al usuario quien puede usar los metodos 
        BilleteraDigital billetera = new BilleteraDigital();
        //Realizar un depósito válido
        billetera.depositar(500.00);
        //Realizar un retiro 
        billetera.retirar(300);
        // Compara los valores
        assertEquals(200.0, billetera.obtenerSaldo(), 0.001);

        //Realizar un retiro negativo
        billetera.retirar(-400);
        // Compara los valores
        assertEquals(200.0, billetera.obtenerSaldo(), 0.001);

        //Realizar un retiro con valor 0
        billetera.retirar(0);
        // Compara los valores
        assertEquals(200.0, billetera.obtenerSaldo(), 0.001);

    }

    /**
     * Test of convertirMoneda method, of class BilleteraDigital.
     */
    @Test
    public void testConvertirMoneda() {
        System.out.println("Convertir Moneda test");
        // Se instancia al usuario quien puede usar los metodos 
        BilleteraDigital billetera = new BilleteraDigital();
        //Realizar un depósito válido
        billetera.depositar(500.00);
        billetera.convertirMoneda(40.00, 1); // Convertir 40 dolares (USD) a pesos chilenos (CLP), opcion 1 reperesenta laopcion de conversion de divisa 
        assertEquals(500.0 + (40.0 * 940.80), billetera.obtenerSaldo(), 0.001);//saldo esperado despues de la conversion 

    }

    /**
     * Test of obtenerTransacciones method, of class BilleteraDigital.
     */
    @Test
   public void testObtenerTransacciones() {
    System.out.println("obtenerTransacciones");
    // Se instancia al usuario quien puede usar los metodos 
    BilleteraDigital billetera = new BilleteraDigital();
    //generamos transacciones 
    billetera.depositar(2000.00);
    billetera.retirar(500.00);
    billetera.hacerTransferencia(500.00, "destinatario");
    //Se llama al método obtenerTransacciones() en la billetera para obtener la lista de transacciones registradas.
    List<String> transacciones = billetera.obtenerTransacciones();
    // Verificar que cada transacción tenga el formato esperado 
    for (String transaccion : transacciones) {
        assertTrue(transaccion.matches(".* - Fecha: .*"), "Formato de transacción incorrecto: " + transaccion);
    }
}

    /**
     * Test of hacerTransferencia method, of class BilleteraDigital.
     */
    @Test
    public void testHacerTransferencia() {
        System.out.println("hacerTransferencia");
       // Se crean dos instancias de billetera digital una para el ususrio remitente     y otra para el usuario destinatario
        BilleteraDigital billetera1 = new BilleteraDigital();
        // generamos transacciones depositar, retirar y trasnferencia como ejemplo   
        billetera1.depositar(1000.00);
        billetera1.retirar(500.00);
        billetera1.hacerTransferencia(300.00, "destinatario");

        // Verificamos que el saldo de billetera1 sea 200.0 después del retiro y transferencia 
        assertEquals(200.0, billetera1.obtenerSaldo(), 0.001);
        
    }

}
