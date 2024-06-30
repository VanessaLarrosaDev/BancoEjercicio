/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BancoClases;

import java.util.Date;
/**
 *
 * @author vanessa
 */
public class Tarjeta {
    
    private String numeroTarjeta;
    private Date fechaVencimiento;
    private int cvv;
    private CuentaBancaria cuentaBancaria;

    // Constructor
    public Tarjeta(String numeroTarjeta, Date fechaVencimiento, int cvv, CuentaBancaria CuentaBancaria) {
        this.numeroTarjeta = numeroTarjeta;
        this.fechaVencimiento = fechaVencimiento;
        this.cvv = cvv;
        this.cuentaBancaria = cuentaBancaria;
    }


    // Getters
    public String getNumeroTarjeta() {
        return numeroTarjeta;
    }

    public Date getFechaVencimiento() {
        return fechaVencimiento;
    }

    public int getCvv() {
        return cvv;
    }

    public CuentaBancaria getCuentaBancaria() {
        return cuentaBancaria;
    }

    // Setters
    public void setNumeroTarjeta(String numeroTarjeta) {
        this.numeroTarjeta = numeroTarjeta;
    }

    public void setFechaVencimiento(Date fechaVencimiento) {
        this.fechaVencimiento = fechaVencimiento;
    }

    public void setCvv(int cvv) {
        this.cvv = cvv;
    }

    public void setCuentaBancaria(CuentaBancaria cuentaBancaria) {
        this.cuentaBancaria = cuentaBancaria;
    }

    // Método toString
    @Override
    public String toString() {
        return "Tarjeta{" +
                "numeroTarjeta='" + numeroTarjeta + '\'' +
                ", fechaVencimiento=" + fechaVencimiento +
                ", cvv=" + cvv +
                ", cuentaBancaria=" + cuentaBancaria +
                '}';
    }
    
     // Método para validar la tarjeta
    public boolean validarTarjeta() {
        // Verificar si la tarjeta ha caducado
        if (fechaVencimiento.before(new Date())) {
            System.out.println("La tarjeta ha caducado.");
            return false;
        }

        // Verificar si el CVV es válido
        if (cvv < 100 || cvv > 999) {
            System.out.println("El CVV es inválido.");
            return false;
        }

        // Verificar si la cuenta bancaria asociada es válida
        if (cuentaBancaria == null) {
            System.out.println("La cuenta bancaria asociada es inválida.");
            return false;
        }

        return true;
    }

    // Método para realizar un pago con la tarjeta
    public void realizarPago(double monto) {
        if (validarTarjeta()) {
            if (cuentaBancaria.getSaldo() >= monto) {
                cuentaBancaria.setSaldo(cuentaBancaria.getSaldo() - monto);
                System.out.println("Pago realizado con éxito.");
            } else {
                System.out.println("No hay suficiente saldo en la cuenta bancaria.");
            }
        }
    }
}


