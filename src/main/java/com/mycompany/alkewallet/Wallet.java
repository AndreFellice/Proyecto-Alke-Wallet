/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.alkewallet;

/**
 *Interfaz  implementa metodos de clase BilleteraDigital
 * @author andre
 */
public interface Wallet {

    //obtener saldo
    double obtenerSaldo();

    //depositar saldo
    void depositar(double cantidad);

    //retirar saldo
    void retirar (double cantidad);
    
    // convertir moneda 
    void convertirMoneda (int aMoneda, Double cantidad);
    
    // mostrar transacciones
    void  obtenerTransacciones ();
    
    // hacer transferencia 
     void hacerTransferencia(double monto, BilleteraDigital destinatario);
     
   
    


   
    
    
}
