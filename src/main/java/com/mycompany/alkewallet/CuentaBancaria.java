/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.alkewallet;

/**
 *
 * @author andre
 */
public class CuentaBancaria {

    private int numeroCuenta;

    private String saldo;

    public CuentaBancaria(int numeroCuenta, String saldo, String nombreCliente, int rut, BilleteraDigital Wallet) {

        this.numeroCuenta = numeroCuenta;

        this.saldo = saldo;
    }

    public int getNumeroCuenta() {
        return numeroCuenta;
    }

    public String getSaldo() {
        return saldo;
    }

    public void setNumeroCuenta(int numeroCuenta) {
        this.numeroCuenta = numeroCuenta;
    }

    public void setSaldo(String saldo) {
        this.saldo = saldo;
    }

}
