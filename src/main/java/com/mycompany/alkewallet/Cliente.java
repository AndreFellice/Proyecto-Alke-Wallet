/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.alkewallet;

import java.util.Objects;

/**
 * Clase cliente:epresenta a un cliente del banco.
 *
 * @author andre
 */
public class Cliente {

    //Atributos de la clase Cliente
    private String nombreCliente;
    private final int rut;// Hacer rut de solo lectura
    private BilleteraDigital billetera;
    private CuentaBancaria cuentaBancaria;

 
    /**
     * Constructor de la clase Cliente.
     * @param nombreCliente El nombre del cliente.
     * @param rut El RUT del cliente.
     * @param billetera La billetera digital asociada al cliente.
     */
    public Cliente(String nombreCliente, int rut,BilleteraDigital billetera) {
        this.nombreCliente = nombreCliente;
        this.rut = rut;
        this.billetera = billetera;//creamos instancia de billeteradigital para el usuario
    }

     /**
     * Obtiene el nombre del cliente.
     * @return El nombre del cliente.
     */
    public String getNombreCliente() {
        return nombreCliente;
    }

   /**
     * Obtiene el RUT (identificador) del cliente.
     * @return El RUT del cliente.
     */
    public int getRut() {
        return rut;
    }

   /**
     * Obtiene la billetera digital asociada al cliente.
     * @return La billetera digital asociada al cliente.
     */
    public BilleteraDigital getBilletera() {
        return billetera;
    }
/**
     * Obtiene la cuenta asociada al cliente.
     * @return La cuenta  asociada al cliente.
     */
    public CuentaBancaria getCuentaBancaria() {
    return this.cuentaBancaria;
}
    /**
     * Establece el nombre del cliente.
     * @param nombreCliente El nombre del cliente a establecer.
     */
    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }

    /**
     * Establece la billetera digital asociada al cliente.
     * @param billetera La billetera digital a establecer.
     */
    public void setBilletera(BilleteraDigital billetera) {
        this.billetera = billetera;
    }
   public void setCuenta(CuentaBancaria cuentaBancaria) {
        this.cuentaBancaria= cuentaBancaria;
    }


     @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cliente cliente = (Cliente) o;
        return rut == cliente.rut &&
                Objects.equals(nombreCliente, cliente.nombreCliente);
    }
     /**
     * {@inheritDoc}
     */
    @Override
    public int hashCode() {
        return Objects.hash(nombreCliente, rut);
    }
    /**
     * {@inheritDoc}
     */
    @Override
    public String toString(){
        return "Cliente[" + 
                "nombreCliente=' " + nombreCliente + '\'' +
                "rut=" + rut + 
                ", billetera=" + billetera +
                '}';
    }
}
