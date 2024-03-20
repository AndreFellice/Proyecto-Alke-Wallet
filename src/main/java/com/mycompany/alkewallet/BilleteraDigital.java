/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.alkewallet;


import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author andre
 */
public  class BilleteraDigital implements Wallet{
    private double saldo; // muestra el saldo de cliente
    private List<String> transacciones;  //mostrar o listar  informacion de cliente
    private double cantidad;
    
    
    
    public BilleteraDigital() {
        this.saldo = 0.0;
        this.transacciones = new  ArrayList<>();
    }

    
    

    @Override
    public double obtenerSaldo() {
       return saldo; 
    }

    @Override
    public void depositar(double cantidad) {
         if (cantidad > 0) {
            this.saldo += cantidad;
            transacciones.add("Depósito: " + cantidad); 
    }
    }
     @Override
    public boolean retirar(double cantidad) {
        if (cantidad > 0 && this.saldo >= cantidad) {
            this.saldo -= cantidad;
            transacciones.add("Retiro: " + cantidad);
            return true;
        }
        return false;
    }

    @Override
    public boolean convertirMoneda(double cantidad, String desdeMoneda, String aMoneda) {
        double d = 0;
      // Define la tasa de cambio de USD a CLP
        double tasaCambio = d;  // obtener dolar mediante ingreso ususario segun valor dia

    // Verifica si la conversión es de USD a CLP
    if (desdeMoneda.equals("USD") && aMoneda.equals("CLP")) {
        // Realiza la conversión
        double cantidadConvertida = cantidad * tasaCambio;
        System.out.println("La cantidad convertida de USD a CLP es: " + cantidadConvertida + " CLP");
     
    } else {
        // Conversión no soportada
        System.out.println("Conversión no soportada.");
        
    }  
    }

    
}
    

