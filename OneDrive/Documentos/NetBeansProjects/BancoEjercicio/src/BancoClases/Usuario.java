/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BancoClases;


/**
 *
 * @author vanessa
 */
public class Usuario {
    
    private String nombre;
    private String apellido;
    private String username; // también conocido como DNI
    private String password;
     private CuentaBancaria cuenta;

    // Constructor
    public Usuario(String nombre, String apellido, String username, String password) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.username = username;
        this.password = password;
        this.cuenta = cuenta;
    }

    // Getters
    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public String getUsername() {
        return username;
         
    }

    public String getPassword() {
        return password;
    }

    public CuentaBancaria getCuenta() {
        return cuenta;
    }

    // Setters
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setCuenta(CuentaBancaria cuenta) {
        this.cuenta = cuenta;
    }
    
  
    
    // Método login
    public boolean login(String username, String password) {
        if (this.username.equals(username) && this.password.equals(password)) {
            return true;
        } else {
            System.out.println("Error: Username o contraseña incorrectos.");
            return false;
        }
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", username='" + username + '\'' +
                '}';
    }
}

