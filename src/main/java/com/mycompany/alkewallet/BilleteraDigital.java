/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.alkewallet;

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
    private String nombreDestinatario;

    public BilleteraDigital() {
        this.saldo = 0.0;
        this.transacciones = new ArrayList<>();
        this.nombreDestinatario = "";

    }

    public void setnombreDestinatario(String nombre) {
        this.nombreDestinatario = nombre;

    }
     private String getnombreDestinatario() {
        return nombreDestinatario;
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
            System.out.println("Deposito correcto ");
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
            System.out.println("Retiro exitoso");
        } else {
            System.out.println("Error: saldo insuficiente o cantidad inválida.");
        }
    }

    @Override
    public void convertirMoneda(int aMoneda, Double cantidad) {
        // Define la tasa de cambio de USD o Euro  a CLP (pesos chilenos)
        double tasaCambioUsd = 968;  // // Tasa de cambio: 1 Dólar = 968 pesos chilenos
        double tasaCambioEu = 1051.89; // // Tasa de cambio: 1 Euro = 1052 pesos chilenos
        // Verifica si la conversión es de USD o  EU  a CLP o viceversa
        switch (aMoneda) {
            case 1 ->                 {
                    // Cliente Convierte  dólares  en  pesos chilenos para deposito en su cuenta
                    double pesosChilenos = cantidad * tasaCambioUsd;
                    this.saldo += pesosChilenos;
                    String cantidadR = String.format("%.0f", cantidad);
                    transacciones.add(new Transaccion(new Date(), "Deposito * conversion * cambio de divisa: -" + cantidadR));
                    System.out.println("Su deposito en dolares es $" + cantidadR);
                    System.out.println("Deposito exitoso.");
                    System.out.println("La cantidad convertida a pesos chilenos es: $" +String.format("%.0f",  pesosChilenos));
                }
            case 2 ->                 {
                    // Cliente solicita Conversion de  pesos chilenos a dolares y retira en pesos chilenos desde su cuenta
                    double pesosChilenos = cantidad * tasaCambioUsd;
                    this.saldo -= pesosChilenos;
                    String cantidadR = String.format("%.0f", cantidad);
                    transacciones.add(new Transaccion(new Date(), "Retiro * conversion * cambio de divisa: -" + cantidadR));
                    System.out.println("Su cantidad solicitada en dolares es $" + cantidadR);
                    System.out.println("Retiro exitoso.");
                    System.out.println("La cantidad retirada en CLP para cambiar a USD es: $" + String.format("%.0f",pesosChilenos));
                }
            case 3 ->                 {
                    //Cliente Convierte  euros  en  pesos chilenos para deposito en su cuenta
                    double pesosChilenos = cantidad * tasaCambioEu;
                    this.saldo += pesosChilenos;
                    String cantidadR = String.format("%.0f", cantidad);
                    transacciones.add(new Transaccion(new Date(), "Deposito * conversion * cambio de divisa: -" + cantidadR));
                    System.out.println("Su deposito en euros es $" + cantidadR);
                    System.out.println("Deposito exitoso.");
                    System.out.println("La cantidad convertida a pesos chilenos es: $" + String.format("%.0f",  pesosChilenos));
                }
            case 4 ->                 {
                    // Cliente solicita Conversion de  pesos chilenos a dolares y retira en pesos chilenos desde su cuenta
                    double pesosChilenos = cantidad * tasaCambioEu;
                    this.saldo -= pesosChilenos;
                    String cantidadR = String.format("%.0f", cantidad);
                    transacciones.add(new Transaccion(new Date(), "Retiro * conversion * cambio de divisa: -" + cantidadR));
                    System.out.println("Su cantidad retirada en Pesos es $" + cantidadR);
                    System.out.println("Retiro exitoso.");
                    System.out.println("La cantidad retirada en CLP para cambiar a EU es " + String.format("%.0f",pesosChilenos));
                }
            case 5 -> {
                // Cliente solicita Conversion de  pesos chilenos a dolares
                double dolares = cantidad / tasaCambioUsd;
                transacciones.add(new Transaccion(new Date(), " Conversion a dolares * cambio de divisa: -" + String.format("%.0f",dolares)));
                System.out.println("El valor del dolar es $" + tasaCambioUsd);
                System.out.println("La Conversion a moneda extramjera es: $ " + String.format("%.0f",dolares));
            }
            case 6 -> {
                // Cliente solicita Conversion de  pesos chilenos a euros
                double euros = cantidad / tasaCambioEu;
                transacciones.add(new Transaccion(new Date(), " Conversion a dolares * cambio de divisa: -" + String.format("%.0f",euros)));
                System.out.println("El valor del dolar es $" + tasaCambioUsd);
                System.out.println("La Conversion a moneda extranjera es: $ " + String.format("%.0f",euros));
            }
            default -> // Conversión no soportada
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
            transacciones.add(new Transaccion(new Date(), "Transferencia a " + destinatario.getnombreDestinatario() + ": -" + montoR));
            System.out.println("Transferencia exitosa");
            System.out.println("Ud trasnfririo $" +montoR );
            System.out.println("A destinatario Don(a) " + destinatario.getnombreDestinatario());
        } else {
            System.out.println("Error: saldo insuficiente o monto inválido para la transferencia.");
        }
    }

  

}
