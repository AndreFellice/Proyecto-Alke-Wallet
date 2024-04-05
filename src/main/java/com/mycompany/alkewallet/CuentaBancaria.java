/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.alkewallet;

import java.util.Scanner;
import java.util.Random;

/**
 * La clase CuentaBancaria representa una cuenta bancaria asociada a un cliente.
 * @author andre
 */
public class CuentaBancaria {

    Scanner leer = new Scanner(System.in);
    // contador estatico para generar numero de cuenta 
    private static int contadorCuentas = 0;// Inicializar el contador de números de cuenta bancaria
 
//Atributos
    private String numeroCuenta;
    private Cliente cliente;
    private int password;
    private int telefono;
    private String email;



 /**
     * Constructor de la clase CuentaBancaria.
     * @param numeroCuenta
     * @param cliente El cliente asociado a la cuenta.
     * @param password La contraseña de la cuenta.
     * @param telefono El número de teléfono asociado a la cuenta.
     * @param email El correo electrónico asociado a la cuenta.
     */
    public CuentaBancaria(String numeroCuenta, Cliente cliente, int password, int telefono, String email) {
      this.numeroCuenta = generarNumeroCuenta(cliente.getRut());
        this.cliente = cliente; 
        this.password = password;
        this.telefono = telefono;
        this.email = email;
       contadorCuentas++;
    }
// Getters

    public String getNumeroCuenta() {
        return numeroCuenta;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public int getPassword() {
        return password;
    }

    public int getTelefono() {
        return telefono;
    }

    public String getEmail() {
        return email;
    }


//Setters
    

    public void setNumeroCuenta(String numeroCuenta) {
        this.numeroCuenta = numeroCuenta;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public void setPassword(int password) {
        this.password = password;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public void setEmail(String email) {
        this.email = email;
    }

/**
     * Genera un número de cuenta único basado en el RUT del cliente y un contador.
     * @param rut El RUT del cliente.
     * @return El número de cuenta generado.
     */
    public static String generarNumeroCuenta(int rut) {
        String rutStr = String.valueOf(rut);
        String cuentaGenerada = rutStr.substring(0, rutStr.length() - 1) + "-"
                + String.format("%03d", contadorCuentas);
        // Agrega un número aleatorio adicional al final del número de cuenta
        Random random = new Random();
        cuentaGenerada += String.format("%03d", random.nextInt(1000));
        return cuentaGenerada;
    }

    /**
     * Permite obtener una contraseña de 6 digitos y validarla.
     */ 
    public void generarPassword() {
        while (true) {
            try {
                System.out.println("Ingrese una contraseña de 6 números:");
                password = Integer.parseInt(leer.nextLine());
                if (String.valueOf(password).length() == 6) {
                    System.out.println("Confirme su contraseña:");
                    int confirmarPassword = Integer.parseInt(leer.nextLine());
                    if (confirmarPassword == password) {
                        break;
                    } else {
                        System.out.println("Las contraseñas no coinciden. Intente nuevamente.");
                    }
                } else {
                    System.out.println("La contraseña debe tener 6 números. Intente nuevamente.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Ingrese un valor numérico válido.");
            }
        }
    }

      /**
     * Permite obtener numero telefono celular validando que este tenga formato establecido
     */ 
    public void obtenerTelefono() {

        while (true) {
            System.out.println("Ingrese su numero de telefono de 9 digitos (solo nuemros):  ");
            String nuevoTelefono = leer.nextLine();
            // formato telefono final "+56 123456789"  Valida el formato del número de teléfono usando una expresión regular
            if (nuevoTelefono.matches("\\d{9}")) {//patron telefono
                this.telefono = Integer.parseInt(nuevoTelefono);
                System.out.println("El numero de telefono ingresado es: +56 " + nuevoTelefono);
                break;
            } else {
                System.out.println("El numero de telefono debe tener 9 numeros . ");
            }
        }
    }
     /**
     * Permite ingreso de correo electronico y validar formato
     */ 
    public void obtenerEmail() {
        while (true) {
            System.out.println("Ingrese su correo electrónico: ");
            String nuevoEmail = leer.nextLine();

            // Expresión regular para validar el formato del correo electrónico
            String patronCorreo = "[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}";

            if (nuevoEmail.matches(patronCorreo)) {
                this.email = nuevoEmail;
                System.out.println("El correo electrónico ingresado es: " + nuevoEmail);
                break;
            } else {
                System.out.println("El correo electrónico ingresado no es válido. Debe tener el formato usuario@example.com. Inténtelo nuevamente.");
            }
        }
    }

}
