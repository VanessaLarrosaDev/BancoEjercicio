/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BancoClases;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;


/**
 *
 * @author vanessa
 */
public class Banco {

    private Map<String, CuentaBancaria> cuentas;
    private int numeroCuentas = 0;

    public Banco() {
        this.cuentas = new HashMap<>();
        this.numeroCuentas = 0;
    }

    public Map<String, CuentaBancaria> getCuentas() {
        return cuentas;
    }

    public int getNumeroCuentas() {
        return numeroCuentas;
    }

    public void setCuentas(Map<String, CuentaBancaria> cuentas) {
        this.cuentas = cuentas;
    }

    public void setNumeroCuentas(int numeroCuentas) {
        this.numeroCuentas = numeroCuentas;
    }

    @Override
    public String toString() {
        return "Banco{" + "cuentas=" + cuentas + ", numeroCuentas=" + numeroCuentas + '}';
    }

       public String crearCuenta(Usuario usuario) { // Recibe el usuario como parámetro
        String numeroCuenta = generarNumeroCuenta();
        CuentaBancaria cuenta = new CuentaBancaria(numeroCuenta, usuario); 
        cuentas.put(numeroCuenta, cuenta);
        numeroCuentas++;

        // Asociar la cuenta al usuario
        usuario.setCuenta(cuenta);
        return numeroCuenta;
    }

    private String generarNumeroCuenta() {
        String countryCode = "ES";
        String bban = "201011067444" + String.format("%04d", numeroCuentas + 1);
        String iban = countryCode + calcularCodigoVerificacion(bban) + bban;
        return iban;
    }

    private String calcularCodigoVerificacion(String bban) {
        int resto = 98 - (Integer.parseInt(bban.substring(0, 2)) % 97);
        return String.format("%02d", resto);
    }

    public void consultarSaldo(String numeroCuenta) {
        if (cuentas.containsKey(numeroCuenta)) {
            CuentaBancaria cuenta = cuentas.get(numeroCuenta);
            System.out.println("El saldo de la cuenta " + numeroCuenta + " es de " + cuenta.getSaldo() + " euros.");
        } else {
            System.out.println("La cuenta " + numeroCuenta + " no existe.");
        }
    }

    public void ingresarDinero(String numeroCuenta, double cantidad) {
        if (cuentas.containsKey(numeroCuenta)) {
            CuentaBancaria cuenta = cuentas.get(numeroCuenta);
            cuenta.setSaldo(cuenta.getSaldo() + cantidad);
            System.out.println("Se han ingresado " + cantidad + " euros en la cuenta " + numeroCuenta + ".");
        } else {
            System.out.println("La cuenta " + numeroCuenta + " no existe.");
        }
    }

    public void retirarDinero(String numeroCuenta, double cantidad) {
        if (cuentas.containsKey(numeroCuenta)) {
            CuentaBancaria cuenta = cuentas.get(numeroCuenta);
            if (cuenta.getSaldo() >= cantidad) {
                cuenta.setSaldo(cuenta.getSaldo() - cantidad);
                System.out.println("Se han retirado " + cantidad + " euros de la cuenta " + numeroCuenta + ".");
            } else {
                System.out.println("No hay suficiente saldo en la cuenta " + numeroCuenta + ".");
            }
        } else {
            System.out.println("La cuenta " + numeroCuenta + " no existe.");
        }
    }
}
    
    
