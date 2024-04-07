/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.alkewallet;

import java.util.ArrayList;
import java.util.List;
import java.util.Date;
import java.util.Scanner;

/**
 *
 * @author andre
 */
public class BilleteraDigital implements Wallet {
    //Atributos
    Scanner leer = new Scanner(System.in);
    private double saldo; // Muestra el saldo de cliente
    private List<Transaccion> transacciones; //mostrar o listar  informacion de cliente
    private String moneda;

    //Constructor 
    public BilleteraDigital() {
        this.saldo = 0.0;
        this.transacciones = new ArrayList<>();

        this.moneda = "CLP"; // Moneda por defecto en pesos chilenos
    }
    //Getters 

    public double getSaldo() {
        return saldo;
    }

    public List<Transaccion> getTransacciones() {
        return transacciones;
    }

    public String getMoneda() {
        return moneda;
    }

    public void setMoneda(String moneda) {
        this.moneda = moneda;
    }
// Setters 

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public void setTransacciones(List<Transaccion> transacciones) {
        this.transacciones = transacciones;
    }

    @Override
    public double obtenerSaldo() {
        String saldoR = String.format("%.2f", this.saldo);
        transacciones.add(new Transaccion(new Date(), "Consulta de saldo : " + saldoR));
        return saldo;
    }

    /**
     *
     * @param cantidadDeposito
     */
    @Override
    public void depositar(double cantidadDeposito) {

        // Verifica si la cantidad es menor a cero para generar mensaje de error
        if (cantidadDeposito < 0) {
            System.out.println("El monto del deposito debe ser mayor a 0.");
            return;
        }
        if (cantidadDeposito > 0) {
            this.saldo += cantidadDeposito;
            String cantidadR = String.format("%.2f", cantidadDeposito);
            transacciones.add(new Transaccion(new Date(), "Deposito: " + cantidadR));
            System.out.println("Deposito exitoso ");
        }
    }

    /**
     *
     * @param cantidadRetiro
     */
    @Override
    public void retirar(double cantidadRetiro) {

        // Verifica si la cantidad es menor a cero para generar mensaje de error
        if (cantidadRetiro <= 0) {
            System.out.println("El monto del retiro debe ser mayor a 0.");
            return;
        }
        //verifica si hay saldo para poder gestionar un retiro
        if (cantidadRetiro > saldo) {
            System.out.println("Fondos Insuficientes para retirar");
            return;
        }
        this.saldo -= cantidadRetiro;
        String cantidadR = String.format("%.2f", cantidadRetiro);
        transacciones.add(new Transaccion(new Date(), "Retiro: -" + cantidadR));
        System.out.println("Retiro exitoso");
    }

    @Override
    public void convertirMoneda(double cantidad, int aMoneda) throws IllegalArgumentException {
        // Define la tasa de cambio de USD o Euro  a CLP (pesos chilenos)
        double tasaCambioUsd = 940.80;  // // Tasa de cambio: 1 Dólar = 940.80 pesos chilenos
        double tasaCambioEu = 1018.55; // // Tasa de cambio: 1 Euro = 1018.55 pesos chilenos
        // Verifica que la cantidad ingresada se valide para generar las operaciones
          if (cantidad < 0 || this.saldo < cantidad) {
            System.out.println("Error. Saldo Insuficiente o monto invalido para convertir.");
            return;
        }
        switch (aMoneda) {
            case 1:// Cliente Convierte  dólares  en  pesos chilenos para deposito en su cuenta
                double pesos = cantidad * tasaCambioUsd;
                this.saldo += pesos;
                String cantidadR = String.format("%.2f", cantidad);
                transacciones.add(new Transaccion(new Date(), "Deposito * conversion * cambio de divisa: -" + cantidadR));
                System.out.println("Su deposito en dolares es $" + cantidadR);
                System.out.println("Deposito exitoso.");
                System.out.println("La cantidad convertida a pesos chilenos es: $" + String.format("%.0f", pesos));
                System.out.println("Su nuevo saldo es: $" + String.format("%.2f", obtenerSaldo()));
                break;
            case 2: // Cliente solicita Conversion de dolares a pesos chilenos para retirarlos desde su cuenta
                pesos = cantidad * tasaCambioUsd;
                this.saldo -= pesos;
                String cantidadR2 = String.format("%.2f", cantidad);
                transacciones.add(new Transaccion(new Date(), "Retiro * conversion * cambio de divisa: -" + cantidadR2));
                System.out.println("Su cantidad solicitada en dolares es $" + cantidadR2);
                System.out.println("Retiro exitoso.");
                System.out.println("La cantidad retirada en CLP para cambiar a USD es: $" + String.format("%.2f", pesos));
                System.out.println("Su nuevo saldo es: $" + String.format("%.2f", obtenerSaldo()));
                break;
            case 3://Cliente Convierte  euros  en  pesos chilenos para deposito en su cuenta
                pesos = cantidad * tasaCambioEu;
                this.saldo += pesos;
                String cantidadR3 = String.format("%.2f", cantidad);
                transacciones.add(new Transaccion(new Date(), "Deposito * conversion * cambio de divisa: -" + cantidadR3));
                System.out.println("Su deposito en euros es $" + cantidadR3);
                System.out.println("Deposito exitoso.");
                System.out.println("La cantidad convertida a pesos chilenos es: $" + String.format("%.2f", pesos));
                System.out.println("Su nuevo saldo es: $" + String.format("%.2f", obtenerSaldo()));
                break;
            case 4:// Cliente solicita Conversion de euros a pesos chilenos para retirarlos desde su cuenta 
                pesos = cantidad * tasaCambioEu;
                this.saldo -= pesos;
                String cantidadR4 = String.format("%.2f", cantidad);
                transacciones.add(new Transaccion(new Date(), "Retiro * conversion * cambio de divisa: -" + cantidadR4));
                System.out.println("Su cantidad retirada en Pesos es $" + cantidadR4);
                System.out.println("Retiro exitoso.");
                System.out.println("La cantidad retirada en CLP para cambiar a EU es " + String.format("%.2f", pesos));
                 System.out.println("Su nuevo saldo es: $" + String.format("%.2f", obtenerSaldo()));
                break;
            case 5:// Cliente solicita Conversion de  pesos chilenos a dolares en modo consulta
                double dolares = cantidad / tasaCambioUsd;
                transacciones.add(new Transaccion(new Date(), " Conversion a dolares * cambio de divisa: -" + String.format("%.2f", dolares)));
                System.out.println("El valor del dolar es $" + tasaCambioUsd);
                System.out.println("La Conversion a moneda extranjera es: $ " + String.format("%.2f", dolares));
                break;
            case 6:// Cliente solicita Conversion de  pesos chilenos a euros en modo consulta
                double euros = cantidad / tasaCambioEu;
                transacciones.add(new Transaccion(new Date(), " Conversion a dolares * cambio de divisa: -" + String.format("%.2f", euros)));
                System.out.println("El valor del dolar es $" + tasaCambioUsd);
                System.out.println("La Conversion a moneda extranjera es: $ " + String.format("%.2f", euros));
                break;
            default: // Conversión no soportada
               throw new IllegalArgumentException("Conversión no soportada.");
        }
        
    }

    @Override
    public List<String> obtenerTransacciones() {
        System.out.println("Estos son sus movimientos del dia:");
        System.out.println("________________________________ ");
        List<String> descricpcionTransacciones = new ArrayList<>();
        for (Transaccion transaccion : transacciones) {
            descricpcionTransacciones.add(transaccion.getDescripcion() + " - Fecha: " + transaccion.getFecha());
        }
        return descricpcionTransacciones;
    }

    /**
     *
     * @param montoTransferencia
     * @param destinatario
     */
    @Override
    public void hacerTransferencia(double montoTransferencia, String destinatario) {
        if (montoTransferencia < 0 || this.saldo < montoTransferencia) {
            System.out.println("Error.saldo Insuficiente o monto invalido para hacer transferencia.");
            return;
        }
        this.saldo -= montoTransferencia;
        //destinatario.depositar(montoTransferencia);
        String montoR = String.format("%.2f", montoTransferencia);
        transacciones.add(new Transaccion(new Date(), "Transferencia a " + destinatario + ": -" + montoR));
        
        System.out.println("Ud trasnfririo $" + montoR);
        System.out.println("A destinatario Don(a) " + destinatario);
    }
}
