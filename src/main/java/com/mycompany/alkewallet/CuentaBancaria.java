/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.alkewallet;

/**
 *
 * @author andre
 */
public class CuentaBancaria extends Cliente {

    private int numeroCuenta;
    private int TipoCuenta;
    private int Password;
    private int telefono;
    

    public CuentaBancaria(int numeroCuenta, int TipoCuenta, int Password, int telefono,  String nombreCliente, int rut, BilleteraDigital billetera) {
        super(nombreCliente, rut);
        this.numeroCuenta = numeroCuenta;
        this.TipoCuenta = TipoCuenta;
        this.Password = Password;
        this.telefono = telefono;
       
    }

    public int getNumeroCuenta() {
        return numeroCuenta;
    }

    public int getTipoCuenta() {
        return TipoCuenta;
    }

    public int getPassword() {
        return Password;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setNumeroCuenta(int numeroCuenta) {
        this.numeroCuenta = numeroCuenta;
    }

    public void setTipoCuenta(int TipoCuenta) {
        this.TipoCuenta = TipoCuenta;
    }

    public void setPassword(int Password) {
        this.Password = Password;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

}
