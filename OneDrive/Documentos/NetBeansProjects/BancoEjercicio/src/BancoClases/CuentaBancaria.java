/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BancoClases;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
/**
 *
 * @author vanessa
 */
public class CuentaBancaria {
    
   private String numeroCuenta;
    private double saldo;
    private Usuario usuario;
    private Tarjeta tarjeta;  // Puede ser null si no hay tarjeta asociada
    private List<Transaccion> transacciones;

    // Constructor (sin crear Tarjeta)
    public CuentaBancaria(String numeroCuenta, Usuario usuario) {
        this.numeroCuenta = numeroCuenta;
        this.usuario = usuario;
        this.saldo = 0.0;
        this.tarjeta = null; // No hay tarjeta asociada inicialmente
        this.transacciones = new ArrayList<>();
    }

    // Getters
    public String getNumeroCuenta() {
        return numeroCuenta;
    }

    public double getSaldo() {
        return saldo;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public Tarjeta getTarjeta() {
        return tarjeta;
    }

    public List<Transaccion> getTransacciones() {
        return transacciones;
    }

    // Setters
    public void setNumeroCuenta(String numeroCuenta) {
        this.numeroCuenta = numeroCuenta;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public void setTarjeta(Tarjeta tarjeta) {
        this.tarjeta = tarjeta;
    }

    // Método toString
    @Override
    public String toString() {
        return "CuentaBancaria{" +
                "numeroCuenta=" + numeroCuenta +
                ", saldo=" + saldo +
                ", usuario=" + usuario +
                ", tarjeta=" + tarjeta + // Puede ser null
                ", transacciones=" + transacciones +
                '}';
    }

    // Métodos
    public void addTransaccion(Transaccion transaccion) {
        transacciones.add(transaccion);
    }

    public void asociarTarjeta(String numeroTarjeta, Date fechaVencimiento, int cvv) {
        this.tarjeta = new Tarjeta(numeroTarjeta, fechaVencimiento, cvv, this);
    }

    public void ingresarDinero(double cantidad) {
        saldo += cantidad;
        Date fecha = new Date();
        int idTransaccion = transacciones.size() + 1;
        transacciones.add(new Transaccion(idTransaccion, fecha, cantidad, "Ingreso", this));
        System.out.println("Se ha ingresado " + cantidad + " euros en la cuenta.");
    }

    public void retirarDinero(double cantidad) {
        if (saldo >= cantidad) {
            saldo -= cantidad;
            Date fecha = new Date();
            int idTransaccion = transacciones.size() + 1;
            transacciones.add(new Transaccion(idTransaccion, fecha, -cantidad, "Retiro", this));
            System.out.println("Se ha retirado " + cantidad + " euros de la cuenta.");
        } else {
            System.out.println("Saldo insuficiente");
        }
    }
    
}

