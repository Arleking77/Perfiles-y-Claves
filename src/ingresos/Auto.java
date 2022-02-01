/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ingresos;

/**
 *
 * @author pmaca
 */
public class Auto {
    
String Nombre;
    int Precio,Stock,Cantidad,Total;
   
    public Auto(String nombre, int precio, int stock, int cantidades, int total) {
        this.Nombre = nombre;
        this.Precio = precio;
        this.Stock = stock;
        this.Cantidad = cantidades;
        this.Total = total;
    }

    public String getNombre() {
        return Nombre;
    }
 
    public int getPrecio() {
        return Precio;
        
    }

    public int getStock() {
        return Stock;
    }
    
    
    public int getCantidad() {
        return Cantidad;
    }
    
 
    public int getTotal() {
        return Total;
    }
    
    public void setNombre(String nombre) {
        this.Nombre = nombre;
    }


    public void setPrecio(int precio) {
        this.Precio = precio;
    }
    
    
    public void setStock(int stock) {
        this.Stock = stock;
    }

    public void setCantidad(int prodVendidos) {
        this.Cantidad = prodVendidos;
    }

    public void setTotal(int totalVenta) {
        this.Total = totalVenta;
    }

    public void registrarVenta(int cantidad) {
        this.Stock -= cantidad;
        this.Cantidad += cantidad;
        this.Total += cantidad * this.Precio;
    }

}


