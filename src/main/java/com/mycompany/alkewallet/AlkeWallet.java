/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.alkewallet;

import java.util.Scanner;
import java.util.ArrayList;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Clase principal que maneja la ejecución del programa de AlkeWallet. Permite a
 * los usuarios acceder a sus cuentas, crear nuevas cuentas digitales, realizar
 * operaciones como consultas de saldo, depósitos, retiros, conversiones de
 * moneda, transferencias y ver el historial de transacciones.
 *
 * @author Andre Fellice
 */
public class AlkeWallet {
    // Lista de clientes predefinidos

    private static final ArrayList<Cliente> clientesPredefinidos = new ArrayList<>();
    private static final ArrayList<CuentaBancaria> cuentasPredefinidas = new ArrayList<>();

    /**
     * Método principal que inicia la ejecución del programa.
     *
     * @param args
     */
    public static void main(String[] args) {
        Scanner leer = new Scanner(System.in);
        inicializarClientesPredefinidos();// Agregar clientes predefinidos
        inicializarCuentasPredefinidas();  // Agregar cuentas bancarias predefinidas (contraseñas)
        ArrayList<Cliente> clientesAdicionales = new ArrayList<>();// Crear lista para almacenar clientes nuevos
        ArrayList<CuentaBancaria> cuentasAdicionales = new ArrayList<>(); //Crear lista para almacenar cuentas adicionales

        int opcionCuenta = -1;

        do {
            mostrarMenuPrincipal();
            // Validar entrada numérica
            while (!leer.hasNextInt()) {
                System.out.println("Entrada invalida. Por favor, ingrese una opcion de 0 a 3.");
                leer.next(); // Limpiar la entrada inválida
            }

            opcionCuenta = leer.nextInt();
            switch (opcionCuenta) {
                case 1:
                    System.out.println("*Para volver a Menu Principal presione 0*");
                    accesoCuenta(leer, clientesPredefinidos, cuentasPredefinidas);
                    break;

                case 2:
                    System.out.println("*Para volver a Menu Principal presione 0*");
                    crearCuentaDigital(leer, clientesAdicionales, cuentasAdicionales);
                    break;
                case 3:
                    System.out.println("Saliendo del Menu. Esta seguro?");
                    System.out.println("1. Si    2. No");
                    int salirMenu = leer.nextInt();
                    if (salirMenu == 1) {
                        System.out.println("Que tenga un buen dia .");
                        return;// Para salir del programa
                    } else if (salirMenu == 2) {
                        System.out.println("Volviendo al  Menu Principal.");
                        System.out.println("________________________________ ");
                        break;// Continuar con el bucle do-while para mostrar el menú principal nuevamente
                    } else {
                        System.out.println("Opcion invalida. Volviendo al Menu Principal.");
                        break; // Continuar con el bucle do-while para mostrar el menú principal nuevamente
                    }
                default:
                    System.out.println("Por favor,elige una opcion valida");

            }
        } while (opcionCuenta != 0);

    }

    private static void mostrarMenuPrincipal() {
        // Obtener la fecha y hora actual
        SimpleDateFormat formatoFecha = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        Date fechaActual = new Date();
        String fechaHoraActual = formatoFecha.format(fechaActual);

        // Menu de opciones BANCO  ALKEMY  DIGITAL
        // Menú para la creación de cuentas bancarias
        System.out.println("________________________________ ");
        System.out.println("W     W     W     ");
        System.out.println("  W  W W  W    ");
        System.out.println("    W   W            ");
        System.out.println("________________________________ ");
        System.out.println("          BANCO  ALKEMY  DIGITAL   ");
        System.out.println("             " + fechaHoraActual);
        System.out.println("________________________________");
        System.out.println("Bienvenido");
        System.out.println("Por Favor ingrese una opcion");
        System.out.println("________________________________");
        System.out.println(" 1: ACCESO A CUENTA");
        System.out.println(" 2: CREAR CUENTA  DIGITAL");
        System.out.println(" 3: SALIR MENU ");
        System.out.println("________________________________");
        System.out.println(" ");

    }
// Método para inicializar clientes predefinidos    

    private static void inicializarClientesPredefinidos() {
        // Agregar clientes predefinidos con sus RUTs
        clientesPredefinidos.add(new Cliente("Andre Cuetos", 145449685, new BilleteraDigital()));
        clientesPredefinidos.add(new Cliente("Mario Canedo", 203040506, new BilleteraDigital()));
        clientesPredefinidos.add(new Cliente("Cristian Rodriguez", 152535456, new BilleteraDigital()));
        clientesPredefinidos.add(new Cliente("Pato Donald", 123456789, new BilleteraDigital()));
    }
    // Método para inicializar cuentas bancarias predefinidas (contraseñas)

    private static void inicializarCuentasPredefinidas() {
        cuentasPredefinidas.add(new CuentaBancaria("14544968-001", clientesPredefinidos.get(0), 777777, 777777769, "fellice@example.com")); // asociado a Andre Cuetos
        cuentasPredefinidas.add(new CuentaBancaria("12345678-002", clientesPredefinidos.get(1), 123456, 123456789, "mcanedo@example.com")); // asociado a Mario Canedo
        cuentasPredefinidas.add(new CuentaBancaria("18765432-003", clientesPredefinidos.get(2), 987654, 987654321, "cristian@gmail.com")); // asociado a Cristian Rodriguez
        cuentasPredefinidas.add(new CuentaBancaria("12344321-004", clientesPredefinidos.get(3), 112233, 987656789, "donald@hotmail.com")); // asociado a Pato Donald
    }

    private static void accesoCuenta(Scanner leer, ArrayList<Cliente> clientesPredefinidos, ArrayList<CuentaBancaria> cuentasPredefinidas) {

        System.out.println("________________________________ ");
        System.out.println("          BANCO  ALKEMY  DIGITAL   ");
        System.out.println("________________________________ ");
        System.out.println("W     W     W     ");
        System.out.println("  W  W W  W    ");
        System.out.println("    W   W            ");
        System.out.println("________________________________ ");
        System.out.println("                     MENU WALLET  ");
        System.out.println("                  CUENTA DIGITAL  ");
        System.out.println("________________________________");
        System.out.println("ACCESO");
        System.out.println("________________________________");
        leer.nextLine(); // Limpiar el buffer del scanner
        // Lógica para solicitar el RUT y la contraseña del cliente
        System.out.println("Ingrese su RUT : ");
        String rutClienteStr = leer.nextLine();

        int rutCliente; // Intentamos convertir el RUT a un número entero
        try {
            rutCliente = Integer.parseInt(rutClienteStr);
        } catch (NumberFormatException e) {
            // Si no se puede convertir a un número, el RUT es inválido
            System.out.println("El RUT ingresado no es valido. Por favor, verifique su RUT.");
            return;
        }
        // Validar que el RUT no tenga numeros negativos
        if (rutCliente <= 0) {
            System.out.println("El RUT ingresado no es valido. Por favor, verifique su RUT.");
            return;
        }
        System.out.println("Ingrese su contrasena: ");
        int password = leer.nextInt();
        // Variable para indicar si se encontró el cliente
        boolean clienteEncontrado = false;
        // Verificar si el cliente está en la lista de clientes predefinidos
        for (int i = 0; i < clientesPredefinidos.size(); i++) {
            Cliente cliente = clientesPredefinidos.get(i);
            CuentaBancaria cuenta = cuentasPredefinidas.get(i);
            if (String.valueOf(cliente.getRut()).equals(rutClienteStr)) {
                if (cuenta.getPassword() == password) {
                    // La autenticación es exitosa
                    System.out.println("________________________________ ");
                    System.out.println("Bienvenido, Don(a) " + cliente.getNombreCliente() + "!");

                    menuWallet(leer, cliente); // Llama al método menuWallet con el cliente válido
                    return;
                } else {
                    // Contraseña incorrecta
                    System.out.println("Contrasena incorrecta. Intente nuevamente.");
                    return;
                }
            }
        }

        // Mostrar mensaje si el cliente no fue encontrado
        if (!clienteEncontrado) {
            System.out.println("Cliente no encontrado. Verifique su RUT.");
        }
    }

    private static void crearCuentaDigital(Scanner leer, ArrayList<Cliente> clientesAdicionales, ArrayList<CuentaBancaria> cuentasAdicionales) {
// Crear un nuevo cliente
        Cliente nuevoCliente = crearCliente(leer); // Crear una nueva cuenta bancaria
        CuentaBancaria nuevaCuenta = crearCuentaBancaria(nuevoCliente, leer);// Asignar la billetera digital al cliente

        BilleteraDigital nuevaBilletera = new BilleteraDigital(); // Crear una nueva billetera digital
        nuevoCliente.setBilletera(nuevaBilletera); // Asignar la billetera al cliente
        // Agregar el nuevo cliente a la lista de usuarios
        clientesAdicionales.add(nuevoCliente);
        cuentasAdicionales.add(nuevaCuenta);

        System.out.println("________________________________ ");
        System.out.println("Cuenta digital creada con exito ");
        System.out.println("________________________________ ");
        System.out.println("          BANCO  ALKEMY  DIGITAL   ");
        System.out.println("________________________________ ");
        System.out.println("W     W     W     ");
        System.out.println("  W  W W  W    ");
        System.out.println("    W   W            ");
        System.out.println("________________________________ ");
        System.out.println("                     MENU WALLET  ");
        System.out.println("                  CUENTA DIGITAL  ");
        System.out.println("________________________________");
        System.out.println("Don(a) " + nuevoCliente.getNombreCliente());
        System.out.println("ACCESO");
        System.out.println("________________________________");

        // Accede a una verificacion para acceder posteriormente al menú de la billetera digital
        verificacionMenuWallet(leer, nuevoCliente);
    }

    private static Cliente crearCliente(Scanner leer) {
        String nombre = validarNombre(leer);
        int rut = validarRut(leer);
        BilleteraDigital billetera = new BilleteraDigital(); // Crear una nueva billetera digital para el cliente
        return new Cliente(nombre, rut, billetera);
    }

    private static CuentaBancaria crearCuentaBancaria(Cliente cliente, Scanner leer) {

        System.out.println("Creacion de Cuenta Bancaria:");
        CuentaBancaria nuevaCuenta = new CuentaBancaria(
                CuentaBancaria.generarNumeroCuenta(cliente.getRut()),
                cliente, 0, 0, null);

        // Llamar a los métodos correspondientes para obtener la contraseña, el teléfono y el correo electrónico
        nuevaCuenta.generarPassword();
        System.out.println("Contrasena ingresada correctamente");
        System.out.println("________________________________");
        nuevaCuenta.obtenerTelefono();
        System.out.println("Telefono ingresado correctamente");
        System.out.println("________________________________");
        nuevaCuenta.obtenerEmail();
        System.out.println("Correo electronico  ingresado correctamente");
        System.out.println("________________________________");
        System.out.println("Su numero de cuenta es: " + nuevaCuenta.getNumeroCuenta());

        cliente.setCuenta(nuevaCuenta);
        return nuevaCuenta;

    }

    private static void verificacionMenuWallet(Scanner leer, Cliente cliente) {
        // Verificar la autenticación
        if (autenticarCliente(leer, cliente)) {
            System.out.println("________________________________");
            System.out.println("Bienvenido,  Don(a) " + cliente.getNombreCliente() + "!");
            menuWallet(leer, cliente);  // Mostrar el menú de la billetera digital ya como cliente
        } else {
            System.out.println("Cliente no encontrado o contrasena incorrecta. Verifique su RUT y contrasena.");
        }
    }

// Método para autenticar al cliente
    private static boolean autenticarCliente(Scanner leer, Cliente cliente) {
        // Lógica para solicitar usuario (RUT) y contraseña
        System.out.println("Ingrese su RUT: ");
        int rutCliente = leer.nextInt();
        System.out.println("Ingrese su contrasena: ");
        int password = leer.nextInt();

        // Verificar la autenticación
        if (cliente.getRut() == rutCliente && cliente.getCuentaBancaria().getPassword() == password) {
            // Autenticación exitosa
            return true;
        } else {
            // Autenticación fallida
            System.out.println("Cliente no encontrado o contrasena incorrecta. Verifique su RUT y contrasena.");
            return false;
        }
    }

// Método para validar el nombre del cliente
    private static String validarNombre(Scanner leer) {
        String nombreCliente = "";
        boolean nombreValido = false;

        leer.nextLine(); // Limpiar el buffer del scanner 
        while (!nombreValido) {
            try {
                System.out.println("________________________________");
                System.out.println("Bienvenido  ");
                System.out.println("________________________________");
                System.out.println("Por favor, ingrese su nombre: ");
                nombreCliente = leer.nextLine(); // Leer la entrada del usuario como String

                if (nombreCliente.isEmpty()) { // Verificar si la entrada está vacía después de eliminar espacios en blanco
                    throw new Exception("El nombre no puede estar vacio.");
                }
                // Verificar si el nombre contiene solo letras
                if (!nombreCliente.matches("[a-zA-ZáéíóúÁÉÍÓÚüÜ\\s]+")) {
                    throw new Exception("El nombre debe contener solo letras.");
                }
                // Verificar longitud mínima (por ejemplo, 3 caracteres)
                if (nombreCliente.length() < 3) {
                    throw new Exception("El nombre debe tener al menos 3 caracteres.");
                }
                nombreValido = true; // Si no ocurre ninguna excepción, marcamos como válido
                System.out.println("Nombre validado: " + nombreCliente);
                System.out.println("________________________________ ");
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }

        }
        return nombreCliente;
    }
    // Método para validar el RUT del cliente

    private static int validarRut(Scanner leer) {
        int rut = 0;
        boolean rutValido = false;

        while (!rutValido) {
            try {

                System.out.println("Ingrese su Rut completo (sin puntos ni guion):  ");
                while (!leer.hasNextInt()) {
                    System.out.println("RUT invalido. Por favor, ingrese solo numeros.");
                    leer.next(); // Limpiar el buffer del scanner
                }
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
                System.out.println("Rut validado: " + rut);
                System.out.println("________________________________ ");
            } catch (NumberFormatException e) {
                System.out.println("Error: Debes ingresar numeros validos para el rut.");
                leer.next(); // Limpiar el buffer del scanner
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
        return rut;

    }

    private static void menuWallet(Scanner leer, Cliente cliente) {

        int opcionWallet;

        do {
            mostrarMenuWallet(cliente);
            // Validar entrada numérica
            while (!leer.hasNextInt()) {
                System.out.println("Entrada invalida. Por favor, ingrese ua opcion de 0 a 6.");
                leer.next(); // Limpiar la entrada inválida
            }
            opcionWallet = leer.nextInt();

            switch (opcionWallet) {
                case 0:
                    System.out.println("Saliendo del Menu. Esta seguro?");
                    System.out.println("1. Si    2. No");
                    while (!leer.hasNextInt()) {
                        System.out.println("Entrada invalida. Por favor, ingrese opcion numerica.");
                        leer.next(); // Limpiar la entrada inválida
                    }
                    int confirmacion = leer.nextInt();

                    switch (confirmacion) {
                        case 1:
                            System.out.println("Saliendo del Menu. ¡Hasta luego!");
                            return; // Salir del método menuWallet
                        case 2:
                            System.out.println("Cancelando operacion. Volviendo al Menu...");
                            break; // Volver al Menú
                        default:
                            System.out.println("Opción no valida. Volviendo al Menu...");
                    }
                    System.out.println("________________________________ ");
                    break;

                case 1:
                    // Muestra saldo del cliente con un formato String para visualizar todos los numeros de la cifra del saldo
                    System.out.println("Saldo actual: $" + String.format("%.2f", cliente.getBilletera().obtenerSaldo()));
                    System.out.println("________________________________ ");
                    break;
                case 2:
                    System.out.println("*Para volver a menu presione 0*");
                    System.out.println("Ingrese el monto a depositar: ");
                    while (!leer.hasNextDouble()) {
                        System.out.println("Entrada invalida. Por favor, ingrese opcion numerica.");
                        leer.next(); // Limpiar la entrada inválida
                    }
                    double cantidadDeposito = leer.nextDouble();
                    if (cantidadDeposito == 0) { // opcion para que el usuario vuelva al menu sin generar un deposito
                        System.out.println("Volviendo al Menu.");
                        break;
                    }
                    cliente.getBilletera().depositar(cantidadDeposito);
                    System.out.println("Monto para deposito: " + String.format("%.2f", cantidadDeposito));
                    System.out.println("Su nuevo saldo es: " + String.format("%.2f", cliente.getBilletera().obtenerSaldo()));
                    System.out.println("________________________________ ");
                    break;
                case 3:
                    System.out.println("*Para volver a menu presione 0*");
                    System.out.println("Ingrese el monto a retirar: ");
                    while (!leer.hasNextInt()) {
                        System.out.println("Entrada invalida. Por favor, ingrese opcion numerica.");
                        leer.next(); // Limpiar la entrada inválida
                    }
                    double cantidadRetiro = leer.nextDouble();

                    cliente.getBilletera().retirar(cantidadRetiro);
                    System.out.println("Monto para retiro: " + String.format("%.2f", cantidadRetiro));
                    System.out.println("Su nuevo saldo es: " + String.format("%.2f", cliente.getBilletera().obtenerSaldo()));
                    System.out.println("________________________________ ");
                    break;

                case 4:
                    System.out.println("*Para volver a menu presione 0*");
                    System.out.println("Ingrese el monto a convertir: ");
                    while (!leer.hasNextDouble()) {
                        System.out.println("Entrada invalida. Por favor, ingrese un valor numerico.");
                        leer.next(); // Limpiar la entrada inválida
                    }

                    double cantidad = leer.nextDouble();
                    if (cantidad == 0) {
                        System.out.println("Volviendo al Menu.");
                        break;
                    }
                    System.out.println("Indique el tipo de moneda ingresado");
                    System.out.println("1. USD,  2. EUROS,  3. CLP");
                    int opcionMoneda;
                    while (true) {
                        if (leer.hasNextInt()) {
                            opcionMoneda = leer.nextInt();
                            if (opcionMoneda >= 1 && opcionMoneda <= 3) {
                                break;
                            } else {
                                System.out.println("Opcion de moneda no valida. Por favor, elija una opción válida.");
                            }
                        } else {
                            System.out.println("Entrada invalida. Por favor, ingrese una opcion numerica.");
                            leer.next(); // Limpiar la entrada inválida
                        }
                    }
                    switch (opcionMoneda) {
                        case 1:
                            System.out.println("$" + cantidad + " dolares");
                            System.out.println("Elija opcion de cambio : ");
                            System.out.println("1. Deposito de USD a su cuenta en pesos ");
                            System.out.println("2. Retiro de pesos para cambio en USD");
                            break;
                        case 2:
                            System.out.println("€" + cantidad + " euros");
                            System.out.println("Elija opcion de cambio : ");
                            System.out.println("3. Deposito de EU a su cuenta en pesos ");
                            System.out.println("4. Retiro de pesos para cambio en EU");
                            break;
                        case 3:
                            System.out.println("$" + cantidad + " pesos");
                            System.out.println("Elija opcion de cambio : ");
                            System.out.println("5. Cambio a Dolar ");
                            System.out.println("6. Cambio a euro");
                            break;
                        default:
                            System.out.println("Opcion de moneda no valida.");
                    }
                    System.out.println("________________________________ ");
                    int aMoneda;
                    while (true) {
                        if (leer.hasNextInt()) {
                            aMoneda = leer.nextInt();
                            if (aMoneda >= 1 && aMoneda <= 6) {
                                break;
                            } else {
                                System.out.println("Opcion no valida. Por favor, elija una opción válida.");
                            }
                        } else {
                            System.out.println("Entrada invalida. Por favor, ingrese una opcion numerica.");
                            leer.next(); // Limpiar la entrada inválida
                        }
                    }
                    cliente.getBilletera().convertirMoneda(cantidad, aMoneda);// Llama al método convertirMoneda según la opción seleccionada
                    System.out.println("Su nuevo saldo es: $" + String.format("%.2f", cliente.getBilletera().obtenerSaldo()));
                    System.out.println("________________________________ ");
                    break;

                case 5:

                    System.out.println("*Para volver a menu presione 0*");
                    System.out.println("Seleccione el destinatario:");
                    for (int i = 0; i < clientesPredefinidos.size(); i++) {
                        System.out.println((i + 1) + ". " + clientesPredefinidos.get(i).getNombreCliente());
                    }

                    int opcionDestinatario;

                    // Validar entrada numérica para opcionDestinatario
                    while (!leer.hasNextInt()) {
                        System.out.println("Por favor, ingrese un valor numérico de 1 a " + clientesPredefinidos.size());
                        leer.next(); // Limpiar la entrada inválida
                    }

                    opcionDestinatario = leer.nextInt();
                    if (opcionDestinatario == 0) {
                        System.out.println("Volviendo a Menu Wallet");
                        break;
                    }

                    // Verificar si la opción seleccionada está dentro del rango válido
                    if (opcionDestinatario < 1 || opcionDestinatario > clientesPredefinidos.size()) {
                        System.out.println("Opcion invalida. Verifique la seleccion.");
                        break;
                    }

                    // Obtener el cliente correspondiente según la opción seleccionada
                    Cliente destinatario = clientesPredefinidos.get(opcionDestinatario - 1);
                    String nombreDestinatario = destinatario.getNombreCliente(); // Obtener el nombre del destinatario

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

                    // Verificar si el cliente tiene suficiente saldo disponible para la transferencia
                    if (montoTransferencia <= cliente.getBilletera().obtenerSaldo()) {
                        // Realizar la transferencia al destinatario seleccionado
                        cliente.getBilletera().hacerTransferencia(montoTransferencia, nombreDestinatario);
                        System.out.println("Transferencia exitosa. Su nuevo saldo es: $" + String.format("%.2f", cliente.getBilletera().obtenerSaldo()));
                    } else {
                        // El cliente no tiene suficiente saldo disponible
                        System.out.println("Saldo insuficiente. No se puede realizar la transferencia.");
                    }

                    System.out.println("Su nuevo saldo es: $" + String.format("%.2f", cliente.getBilletera().obtenerSaldo()));
                    System.out.println("________________________________ ");
                    break;

                case 6:
                    System.out.println("Historial de Transacciones: ");
                    System.out.println("Don(a)  " + cliente.getNombreCliente());
                    System.out.println("________________________________ ");
                    List<String> transacciones = cliente.getBilletera().obtenerTransacciones();
                    if (transacciones.isEmpty()) {
                        System.out.println("No hay transacciones disponibles.");
                    } else {
                        for (String transaccion : transacciones) {
                            System.out.println(transaccion);
                        }
                    }
                    System.out.println("________________________________ ");
                    break;

                default:
                    System.out.println("Elija una opcion valida");
            }
        } while (opcionWallet != 0);

    }

// Método para mostrar el menú de la billetera 
    private static void mostrarMenuWallet(Cliente cliente) {

        SimpleDateFormat formatoFecha = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        Date fechaActual = new Date();
        String fechaHoraActual = formatoFecha.format(fechaActual);
        System.out.println("________________________________ ");
        System.out.println("          BANCO  ALKEMY  DIGITAL   ");
        System.out.println("________________________________ ");
        System.out.println("W     W     W     ");
        System.out.println("  W  W W  W    ");
        System.out.println("    W   W            ");
        System.out.println("________________________________ ");
        System.out.println("                     MENU WALLET  ");
        System.out.println("                  CUENTA DIGITAL  ");
        System.out.println("             " + fechaHoraActual);
        System.out.println("________________________________");
        System.out.println("Don(a) " + cliente.getNombreCliente());
        // Numero de cuenta del cliente nuevo
        if (cliente.getCuentaBancaria() != null) {
            System.out.println("Cuenta Nro:  " + cliente.getCuentaBancaria().getNumeroCuenta());
        }

// Mostrar el número de cuenta del cliente predefinido 
        for (CuentaBancaria cuenta : cuentasPredefinidas) {
            if (cuenta.getCliente() == cliente) {
                System.out.println("Cuenta Nro: " + cuenta.getNumeroCuenta());
                break; // Una vez encontrado, salir del bucle
            }
        }
        System.out.println("________________________________");
        System.out.println(" 1: CONSULTA DE SALDO");
        System.out.println(" 2: REALIZAR DEPOSITO");
        System.out.println(" 3: REALIZAR RETIRO");
        System.out.println(" 4: CONVERTIR MONEDA");
        System.out.println(" 5: REALIZAR TRANSFERENCIA ");
        System.out.println(" 6: HISTORIAL DE  TRANSACCIONES");
        System.out.println(" 0: SALIR MENU");
        System.out.println("________________________________");
        System.out.println(" Por favor ingrese una opcion: ");
        System.out.println("________________________________");
        System.out.println(" ");

    }

}
