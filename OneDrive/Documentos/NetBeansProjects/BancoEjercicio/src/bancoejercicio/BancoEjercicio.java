/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package bancoejercicio;

import BancoClases.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 *
 * @author vanessa
 */
public class BancoEjercicio {

    private static Usuario usuarioActual = null;
    private static Banco banco = new Banco();
    private static Map<String, Usuario> usuariosRegistrados = new HashMap<>();

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws ParseException {
        Scanner scanner = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("\n--- Banco ---");
            if (usuarioActual == null) {
                System.out.println("1. Login");
                System.out.println("2. Crear cuenta");
            } else {
                System.out.println("3. Consultar saldo");
                System.out.println("4. Ingresar dinero");
                System.out.println("5. Retirar dinero");
                System.out.println("6. Asociar tarjeta");
                System.out.println("0. Salir (Logout)");
            }
            System.out.print("Elija una opción: ");

            opcion = scanner.nextInt();
            scanner.nextLine(); // Consumir el salto de línea
            switch (opcion) {
                case 1:
                    login(scanner);
                    break;
                    
                case 2:
                    crearCuenta(scanner);
                    break;

                case 3:
                    consultarSaldo(scanner);
                    break;
                    
                case 4:
                    ingresarDinero(scanner);
                    break;
                    
                case 5:
                    retirarDinero(scanner);
                    break;
                    
                case 6:
                    asociarTarjeta(scanner);
                    break;
                    
                case 0:
                    if (usuarioActual != null) {
                        usuarioActual = null; // Logout
                        System.out.println("Sesión cerrada.");
                    } else {
                        System.out.println("Saliendo...");
                    }
                    break;
                default:
                    if (usuarioActual != null) {
                        System.out.println("Opción no implementada.");
                    } else {
                        System.out.println("Debe iniciar sesión primero.");
                    }
            }
        } while (opcion != 0);

        scanner.close();
    }

    private static void login(Scanner scanner) {
        System.out.print("Ingrese su DNI/username: ");
        String username = scanner.nextLine();
        System.out.print("Ingrese su contraseña: ");
        String password = scanner.nextLine();

        Usuario usuario = usuariosRegistrados.get(username);
        if (usuario != null && usuario.login(username, password)) {
            usuarioActual = usuario;
            System.out.println("¡Bienvenido, " + usuarioActual.getNombre() + "!");
        } else {
            System.out.println("Credenciales incorrectas.");
        }
    }

    // Método crearCuenta
    private static void crearCuenta(Scanner scanner) {
        System.out.print("Ingrese nombre del usuario: ");
        String nombre = scanner.nextLine();
        System.out.print("Ingrese apellidos del usuario: ");
        String apellidos = scanner.nextLine();
        System.out.print("Ingrese DNI/username del usuario: ");
        String username = scanner.nextLine();
        System.out.print("Ingrese contraseña del usuario: ");
        String password = scanner.nextLine();

        // Crear el usuario y agregarlo al mapa
        Usuario usuario = new Usuario(nombre, apellidos, username, password);
        usuariosRegistrados.put(username, usuario);

        //Ahora se va a crear y asociar la cuenta al usuario
        String numeroCuenta = banco.crearCuenta(usuario);

        System.out.println("Cuenta creada exitosamente con el número " + numeroCuenta + ". ¡Bienvenido, " + nombre + "!");

        usuarioActual = usuario; //Esta línea sirve para iniciar sesión automáticamente
    }

    //Método para consultar el saldo
    private static void consultarSaldo(Scanner scanner) {
        if (usuarioActual != null) { // Verificar si el usuario está logueado
            System.out.print("Ingrese el número de cuenta: ");
            String numeroCuenta = scanner.nextLine();

            // Obtener la cuenta del usuario actual
            CuentaBancaria cuenta = banco.getCuentas().get(numeroCuenta);

            if (cuenta != null) {
                System.out.println("Su saldo actual es: " + cuenta.getSaldo() + " euros");
            } else {
                System.out.println("Cuenta no encontrada.");
            }
        } else {
            System.out.println("Debe iniciar sesión para consultar el saldo.");
        }
    }

    //Método Case 4, ingresar dinero, intentando usar los métodos de las clases
    private static void ingresarDinero(Scanner scanner) {
        if (usuarioActual != null) {
           // Obtener el número de cuenta del usuario actual
        String numeroCuenta = usuarioActual.getCuenta().getNumeroCuenta(); 

        System.out.print("Ingrese la cantidad a ingresar: ");
        double cantidad = scanner.nextDouble();
        scanner.nextLine();

        CuentaBancaria cuenta = banco.getCuentas().get(numeroCuenta);

        if (cuenta != null) {
            cuenta.ingresarDinero(cantidad);
            System.out.println("Ingreso realizado con éxito.");
        } else {
            System.out.println("Cuenta no encontrada.");
        }
    } else {
        System.out.println("Debe iniciar sesión para ingresar dinero.");
    }
}
    

    // Método Case 5: Retirar dinero
    private static void retirarDinero(Scanner scanner) {
        if (usuarioActual != null) {
            System.out.print("Ingrese el número de cuenta: ");
            String numeroCuenta = scanner.nextLine();
            System.out.print("Ingrese la cantidad a retirar: ");
            double cantidad = scanner.nextDouble();
            scanner.nextLine();

            // Obtener la cuenta del usuario actual
            CuentaBancaria cuenta = banco.getCuentas().get(numeroCuenta);

            if (cuenta != null) {
                cuenta.retirarDinero(cantidad); // Usar el método de la clase CuentaBancaria
            } else {
                System.out.println("Cuenta no encontrada.");
            }
        } else {
            System.out.println("Debe iniciar sesión para retirar dinero.");
        }
    }

    private static void asociarTarjeta(Scanner scanner) throws ParseException {
        if (usuarioActual != null) {
            System.out.print("Ingrese el número de cuenta: ");
            String numeroCuenta = scanner.nextLine();

            CuentaBancaria cuenta = banco.getCuentas().get(numeroCuenta);

            if (cuenta != null) {
                System.out.print("Ingrese el número de tarjeta: ");
                String numeroTarjeta = scanner.nextLine();
                System.out.print("Ingrese la fecha de vencimiento (dd/MM/yyyy): ");
                String fechaStr = scanner.nextLine();
                System.out.print("Ingrese el CVV: ");
                int cvv = scanner.nextInt();
                scanner.nextLine();

                // No he querido usar excepciones por lo que se asume que la fecha es siempre correcta
                Date fechaVencimiento = new SimpleDateFormat("dd/MM/yyyy").parse(fechaStr);

                cuenta.asociarTarjeta(numeroTarjeta, fechaVencimiento, cvv);
                System.out.println("Tarjeta asociada correctamente.");
            } else {
                System.out.println("Cuenta no encontrada.");
            }
        } else {
            System.out.println("Debe iniciar sesión para asociar una tarjeta.");
        }
    }

}
