/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.alkewallet;

import java.util.Scanner;
import java.util.ArrayList;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author Andre Fellice
 */
public class AlkeWallet {

    /**
     *
     * @param args
     */
    public static void main(String[] args) {
        Scanner leer = new Scanner(System.in);
        //crea un ArrayList llamado usuarios que puede contener objetos del tipo Cliente
        ArrayList<Cliente> usuarios = new ArrayList<>();
        // instanciar objetos
   
        BilleteraDigital destinatario = null;

        System.out.println("****************");
        System.out.println("ALKEMY  DIGITAL ");
        System.out.println("****************");
        System.out.println(" ");

        boolean nombreValido = false;
        String nombreCliente = "";

        while (!nombreValido) {
            try {
                System.out.println("Bienvenido  ");
                System.out.println("Por favor, ingrese su nombre: ");
                nombreCliente = leer.nextLine(); // Leer la entrada del usuario como String

                if (nombreCliente.isEmpty()) { // Verificar si la entrada está vacía después de eliminar espacios en blanco
                    throw new Exception("El nombre no puede estar vacio.");
                }
                // Verificar si el nombre contiene solo letras
                if (!nombreCliente.matches("[a-zA-Z- \"]+")) {
                    throw new Exception("El nombre debe contener solo letras.");
                }
                // Verificar longitud mínima (por ejemplo, 3 caracteres)
                if (nombreCliente.length() < 3) {
                    throw new Exception("El nombre debe tener al menos 3 caracteres.");
                }
                nombreValido = true; // Si no ocurre ninguna excepción, marcamos como válido

            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }

        }
        System.out.println("Nombre validado: " + nombreCliente);
        System.out.println("________________________________ ");

        boolean rutValido = false;
        int rut = 0;

        while (!rutValido) {
            try {
                System.out.println("Don(a) " + nombreCliente);
                System.out.println("Ingrese su Rut (con digito verificador):  ");
                String entrada = leer.nextLine().trim(); // Leer la entrada del usuario como String

                // Verificar si la entrada está vacía después de eliminar espacios en blanco
                if (entrada.isEmpty()) {
                    throw new Exception("El RUT no puede estar vacio.");
                }
                // Eliminar puntos y guiones para obtener solo los dígitos
                entrada = entrada.replace(".", "").replace("-", "");

                // Verificar si el RUT tiene 8 o 9 dígitos (incluyendo el verificador)
                if (entrada.length() < 7 || entrada.length() > 9) {
                    throw new Exception("El RUT debe tener de 7 o 9 digitos.");
                }
                // Verificar formato del RUT (debe terminar en dígito o K)
                if (!entrada.matches("[0-9]+|K")) {
                    throw new Exception("El RUT debe tener un formato valido (digitos o K mayuscula).");
                }
                rut = Integer.parseInt(entrada); // Convertir la entrada a un entero

                rutValido = true; // Si no ocurre ninguna excepción, marcamos como válido
            } catch (NumberFormatException e) {
                System.out.println("Error: Debes ingresar numeros validos para el rut.");
                leer.next(); // Limpiar el buffer del scanner
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
        System.out.println("Rut validado: " + rut);
        System.out.println("________________________________ ");

        // Crear un cliente y agregarlo a la lista de usuarios
        Cliente cliente1 = new Cliente(nombreCliente, rut);
        usuarios.add(cliente1);

        // menu de opciones Wallet
        int opcionWallet;
        do {
            // Obtener la fecha y hora actual
            SimpleDateFormat formatoFecha = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
            Date fechaActual = new Date();
            String fechaHoraActual = formatoFecha.format(fechaActual);
            System.out.println("W     W     W     ");
            System.out.println("  W  W W  W    ");
            System.out.println("    W   W            ");

            System.out.println("________________________________ ");
            System.out.println("                     MENU WALLET  ");
            System.out.println("             " + fechaHoraActual);
            System.out.println("________________________________");
            System.out.println("Don(a) " + nombreCliente);
            System.out.println("________________________________");
            System.out.println(" 0: SALIR MENU");
            System.out.println(" 1: CONSULTA DE SALDO");
            System.out.println(" 2: REALIZAR DEPOSITO");
            System.out.println(" 3: REALIZAR RETIRO");
            System.out.println(" 4: CONVERTIR MONEDA");
            System.out.println(" 5: HISTORIAL DE  TRANSACCIONES");
            System.out.println(" 6: REALIZAR TRANSFERENCIA ");
            System.out.println("________________________________");
            System.out.println(" Por favor ingrese una opcion: ");
            System.out.println("________________________________");
            System.out.println(" ");
            // Validar entrada numérica

            while (!leer.hasNextInt()) {
                System.out.println("Entrada invalida. Por favor, ingrese ua opcion de 0 a 6.");
                leer.next(); // Limpiar la entrada inválida
            }

            opcionWallet = leer.nextInt();

            switch (opcionWallet) {
                case 0 -> {
                    System.out.println("Saliendo del Menu. Esta seguro?");
                    System.out.println("1. Si    2. No");
                    int confirmacion = leer.nextInt();
                    
                    switch (confirmacion) {
                        case 1 -> {
                            System.out.println("Que tenga un buen dia .");
                            opcionWallet = 0; // Para salir del bucle
                        }
                        case 2 -> {
                            System.out.println("Volviendo a  Menu.");
                            System.out.println("________________________________ ");
                            opcionWallet = -1; // Vuelve a mostrar el menú
                        }
                        default -> System.out.println("Opcion  no valida.");
                    }
                    System.out.println("________________________________ ");
                }



                case 1 -> {
                    // Muestra saldo del cliente con un formato String para visualizar todos los numeros de la cifra del saldo
                    System.out.println("Saldo actual: $" + String.format("%.0f", cliente1.getWallet().obtenerSaldo()));
                    System.out.println("________________________________ ");
                }

                case 2 -> {
                    System.out.println("*Para volver a menu presione 0*");
                    System.out.println("Ingrese el monto a depositar: ");
                    double cantidad = leer.nextDouble();
                    if (cantidad == 0) { // opcion para que el usuario vuelva al menu sin generar un deposito
                        System.out.println("Volviendo al Menu.");
                        break;
                    }
                    cliente1.getWallet().depositar(cantidad);
                    System.out.println("Monto depositado: " + String.format("%.0f", cantidad));
                    System.out.println("Su nuevo saldo es: " + String.format("%.0f", cliente1.getWallet().obtenerSaldo()));
                    System.out.println("________________________________ ");
                }

                case 3 -> {
                    System.out.println("*Para volver a menu presione 0*");
                    System.out.println("Ingrese el monto a retirar: ");
                    double cantidadRetiro = leer.nextDouble();
                    if (cantidadRetiro == 0) {
                        System.out.println("Volviendo al Menu.");
                        break;
                    }
                    if (cantidadRetiro > 0) {
                        if (cliente1.getWallet().obtenerSaldo() >= cantidadRetiro) {
                            cliente1.getWallet().retirar(cantidadRetiro);
                            System.out.println("Monto retirado: " + String.format("%.0f", cantidadRetiro));
                            System.out.println("Su nuevo saldo es: " + String.format("%.0f", cliente1.getWallet().obtenerSaldo()));
                            System.out.println("________________________________ ");
                        } else {
                            System.out.println("No se pudo realizar el retiro. Saldo insuficiente.");
                        }
                    }
                }

                case 4 -> {
                    System.out.println("*Para volver a menu presione 0*");
                    System.out.println("Ingrese el monto a convertir: ");
                    double cantidad = leer.nextDouble();
                    if (cantidad == 0) {
                        System.out.println("Volviendo al Menu.");
                        break;
                    }
                    System.out.println("Indique el tipo de moneda ingresado");
                    System.out.println("1. USD,  2.EU   o 3. CLP");
                    int opcionMoneda = leer.nextInt();
                    switch (opcionMoneda) {
                        case 1 -> {
                            System.out.println("$" + cantidad + " dolares");
                            System.out.println("Elija opcion de cambio : ");
                            System.out.println("1. Deposito de USD a su cuenta en pesos ");
                            System.out.println("2. Retiro de pesos para cambio en USD");
                        }
                        case 2 -> {
                            System.out.println("€" + cantidad + " euros");
                            System.out.println("Elija opcion de cambio : ");
                            System.out.println("3. Deposito de EU a su cuenta en pesos ");
                            System.out.println("4. Retiro de pesos para cambio en EU");
                        }
                        case 3 -> {
                            System.out.println("$" + cantidad + " pesos");
                            System.out.println("Elija opcion de cambio : ");
                            System.out.println("5. Cambio a Dolar ");
                            System.out.println("6. Cambio a euro");
                        }
                        default -> System.out.println("Opcion de moneda no valida.");
                    }   System.out.println("________________________________ ");
                    int aMoneda = leer.nextInt();
                    cliente1.getWallet().convertirMoneda(aMoneda, cantidad);// Llama al método convertirMoneda según la opción seleccionada
                    System.out.println("Su nuevo saldo es: $" + String.format("%.0f", cliente1.getWallet().obtenerSaldo()));
                    System.out.println("________________________________ ");
                }



                case 5 -> {
                    System.out.println("Cartola de Operaciones ");
                    System.out.println("Don(a)  " + nombreCliente);
                    cliente1.getWallet().obtenerTransacciones();
                    System.out.println("________________________________ ");
                }

                case 6 -> {
                    System.out.println("*Para volver a menu presione 0*");
                    System.out.println("Ingrese el monto a transferir: ");
                    double montoTransferencia;

                    // Validar entrada numérica para montoTransferencia
                    while (!leer.hasNextDouble()) {
                        System.out.println("Entrada invalida. Por favor, ingrese un valor numerico.");
                        leer.next(); // Limpiar la entrada inválida
                    }
                    montoTransferencia = leer.nextDouble();
                    if (montoTransferencia == 0) {
                        System.out.println("Volviendo al Menu.");
                        break;
                    }
                    System.out.println("Seleccione el destinatario:");
                    System.out.println("1. Mario Canedo");
                    System.out.println("2. Cristian Rodriguez");
                    System.out.println("3. Andre Cuetos");
                    int opcionDestinatario;
                    // Validar entrada numérica para opcionDestinatario
                    while (!leer.hasNextInt()) {
                        System.out.println("Por favor, ingrese un valor numerico de 1 a 3.");
                        leer.next(); // Limpiar la entrada inválida
                    }
                    opcionDestinatario = leer.nextInt();
                    switch (opcionDestinatario) {
                        case 1 -> {
                            destinatario = new BilleteraDigital();
                            destinatario.setnombreDestinatario("Mario Canedo");
                        }
                        case 2 -> {
                            destinatario = new BilleteraDigital();
                            destinatario.setnombreDestinatario("Cristian Rodriguez");
                        }
                        case 3 -> {
                            destinatario = new BilleteraDigital();
                            destinatario.setnombreDestinatario("Andre Cuetos");
                        }
                        default -> {
                            System.out.println("Opcion invalida. Verifique la seleccion.");
                            return; // Salir del case sin hacer la transferencia
                        }
                    }

                    cliente1.getWallet().hacerTransferencia(montoTransferencia, destinatario);
                    System.out.println("Su nuevo saldo es: $" + String.format("%.0f", cliente1.getWallet().obtenerSaldo()));
                    System.out.println("________________________________ ");
                }

                default -> System.out.println("Elija una opcion valida");
            }
        } while (opcionWallet != 0);

        leer.close();
    }

}
