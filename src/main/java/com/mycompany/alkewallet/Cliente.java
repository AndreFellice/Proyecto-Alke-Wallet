/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.alkewallet;

/**
 *Clase cliente 
 * @author andre
 */
public class Cliente {

    //Atributos de la clase Cliente: nombre y rut
    private String nombreCliente;
    private int rut;
    private BilleteraDigital billetera;
    
    
  

// Constructor vacio 
    public Cliente() {
    }

    // Contructor con parametros de cliente 
    public Cliente(String nombreCliente, int rut) {
        this.nombreCliente = nombreCliente;
        this.rut = rut;
        //creamos instancia de billeteradigital para el usuario
        this.billetera = new BilleteraDigital();

    }

   
   

//Getter para obtener nombre cliente
    public String getNombreCliente() {
        return nombreCliente;
    }

    // Getter para obtener rut (identificador) del cliente
    public int getRut() {
        return rut;
    }

    //Getter para obtener la billetera digital asociada al cliente
    public BilleteraDigital getWallet() {
        return billetera;
    }

    //Setter para establecer el nombre del cliente
    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }

    // Setter para establecer el rut
    public void setRut(int rut) {
        this.rut = rut;
    }
   // Setter para establecer billetera digital asociada al cliente
    public void setBilletera(BilleteraDigital billetera) {
        this.billetera = billetera;
    }

    Object getBilleteraDigital() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
