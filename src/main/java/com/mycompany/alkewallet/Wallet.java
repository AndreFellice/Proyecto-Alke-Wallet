/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.alkewallet;
import java.util.List;
/**
 * Interfaz que define los métodos de una billetera digital.
 * Las clases que implementen esta interfaz deben proporcionar implementaciones para
 * obtener saldo, depositar, retirar, convertir moneda, mostrar transacciones y hacer transferencia.
 * 
 * @author andre
 */
public interface Wallet {

    /**
     * Obtiene el saldo actual de la billetera digital.
     * 
     * @return el saldo actual de la billetera
     */
    double obtenerSaldo();

    /**
     * Deposita una cantidad especificada en la billetera digital.
     * 
     * @param cantidad la cantidad a depositar
     */
    void depositar(double cantidad);

    /**
     * Retira una cantidad especificada de la billetera digital.
     * 
     * @param cantidad la cantidad a retirar
     */
    void retirar(double cantidad);
    
    /**
     * Convierte una cantidad de una moneda a otra.
     * 
     * @param cantidad la cantidad a convertir
     * @param aMoneda la moneda a la cual convertir la cantidad
     */
    
    void convertirMoneda(double cantidad, int aMoneda);
    
    /**
     * Devuelve una lista de transacciones realizadas en la billetera digital.
     * 
     * @return la lista de transacciones
     */
    List<String> obtenerTransacciones();
    
    /**
     * Realiza una transferencia de fondos a otra billetera digital.
     * 
     * @param montoTransferencia el monto a transferir
     * @param destinatario persona a la que se destina transferencia
     */
    void hacerTransferencia(double montoTransferencia, String destinatario);
}