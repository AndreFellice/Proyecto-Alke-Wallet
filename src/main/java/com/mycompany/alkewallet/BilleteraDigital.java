/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.alkewallet;

import java.util.List;
import java.util.ArrayList;
import java.util.List;
import java.util.Date;

/**
 *
 * @author andre
 */
public class BilleteraDigital implements Wallet {

    private double saldo; // Muestra el saldo de cliente
    private List<Transaccion> transacciones = new ArrayList<>();  //mostrar o listar  informacion de cliente
    private String nombreCliente;

    public BilleteraDigital() {
        this.saldo = 0.0;
        this.transacciones = new ArrayList<>();

    }

    @Override
    public double obtenerSaldo() {
        String saldoR = String.format("%.0f", this.saldo);
        transacciones.add(new Transaccion(new Date(), "Consulta de saldo : " + saldoR));
        return saldo;
         

    }

    @Override
    public void depositar(double cantidad) {
        if (cantidad > 0) {
            this.saldo += cantidad;
            String cantidadR = String.format("%.0f", cantidad);
            transacciones.add(new Transaccion(new Date(), "Deposito: " + cantidadR));
            String saldoR = String.format("%.0f", this.saldo);
            System.out.println("Deposito correcto su nuevo saldo es :  $" + saldoR);
        } else {
            System.out.println("Error la cantidad debe ser mayor a 0");
        }
    }

    /**
     *
     * @param cantidad
     */
    @Override
    public void retirar(double cantidad) {
        if (cantidad > 0 && this.saldo >= cantidad) {
            this.saldo -= cantidad;
            String cantidadR = String.format("%.0f", cantidad);
            transacciones.add(new Transaccion(new Date(), "Retiro: -" + cantidadR));
            String saldoR = String.format("%.0f", this.saldo);
            System.out.println("Retiro exitoso. Su nuevo saldo es: $" + saldoR);
        } else {
            System.out.println("Error: saldo insuficiente o cantidad inválida.");
        }
    }

    @Override
    public void convertirMoneda(int aMoneda, Double cantidad) {
        // Define la tasa de cambio de USD o Euro  a CLP (pesos chilenos)
        double tasaCambioUsd = 968;  // // Tasa de cambio: 1 Dólar = 968 pesos chilenos
        double tasaCambioEu = 1051.89; // // Tasa de cambio: 1 Euro = 1052 pesos chilenos

        // Verifica si la conversión es de USD o  EU  a CLP 
        if (aMoneda == 1) {
            // Realiza la conversión a USD
            double dolares = cantidad / tasaCambioUsd;
            this.saldo -= cantidad;
            String cantidadR = String.format("%.0f", cantidad);
            transacciones.add(new Transaccion(new Date(), "Retiro * conversion * cambio de divisa: -" + cantidadR));
            System.out.println("La cantidad convertida a dolares es: $" + dolares);
            System.out.println("Retiro exitoso. Su nuevo saldo es: $" + saldo);
        } else if (aMoneda == 2) {
            // Realiza la conversión a EU
            double euros = cantidad / tasaCambioEu;
            this.saldo -= cantidad;
             String cantidadR = String.format("%.0f", cantidad);
            transacciones.add(new Transaccion(new Date(), "Retiro * conversion * cambio de divisa: -" + cantidadR));
            System.out.println("La cantidad convertida a euros es €" + euros);
            System.out.println("Retiro exitoso. Su nuevo saldo es: $" + saldo);
        } else if (aMoneda == 3) {
            // Convertir de dólares a pesos chilenos
            double pesosChilenos = cantidad * tasaCambioUsd;
            this.saldo += pesosChilenos;
            String cantidadR = String.format("%.0f", cantidad);
            transacciones.add(new Transaccion(new Date(), "Deposito * conversion * cambio de divisa: -" + cantidadR));
            System.out.println("La cantidad convertida a pesos chilenos es: $" + pesosChilenos);
            System.out.println("Deposito exitoso. Su nuevo saldo es: $" + saldo);
        } else if (aMoneda == 4) {
            // Convertir de euros a pesos chilenos
            double pesosChilenos = cantidad * tasaCambioEu;
            this.saldo += pesosChilenos;
             String cantidadR = String.format("%.0f", cantidad);
            transacciones.add(new Transaccion(new Date(), "Deposito * conversion * cambio de divisa: -" + cantidadR));
            System.out.println("La cantidad convertida a pesos chilenos es: $" + pesosChilenos);
            System.out.println("Deposito exitoso. Su nuevo saldo es: $" + saldo);
        } else {

            // Conversión no soportada
            System.out.println("Conversion no soportada.");
        }

    }

    @Override
    public void obtenerTransacciones() {
        System.out.println("Estas son sus transacciones del dia:");
        for (Transaccion transaccion : transacciones) {
            String formattedDate = transaccion.getFecha().toString();
            System.out.println(formattedDate + ": " + transaccion.getDescripcion());
        }
    }

    @Override
    public void hacerTransferencia(double monto, BilleteraDigital destinatario) {
        if (monto > 0 && this.saldo >= monto) {
            this.saldo -= monto;
            destinatario.depositar(monto);
            String montoR = String.format("%.0f", monto);
            transacciones.add(new Transaccion(new Date(), "Transferencia a " + destinatario + ": -" + montoR));
            System.out.println("Transferencia exitosa. Su nuevo saldo es: $" + obtenerSaldo());
        } else {
            System.out.println("Error: saldo insuficiente o monto inválido para la transferencia.");
        }
    }

    public void setNombreCliente(String nombre) {
    this.nombreCliente = nombre;
       
    }

}
