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
public class Usuario {
    
private  String Nombreu,Contraseña;
    private Perfiles Perfil;

    public Usuario(String nombreu, String contraseña, Perfiles perfil) {
        this.Nombreu = nombreu;
        this.Contraseña = contraseña;
        this.Perfil = perfil;
    }

 

    public String getNombreu() {
        return Nombreu;
    }

    public String getContraseña() {
        return Contraseña;
    }
    
     public Perfiles getPerfil() {
        return Perfil;
    }
     
    public void setNombreu(String nombreu) {
        this.Nombreu = nombreu;
    }

    public void setContraseña(String contraseña) {
        this.Contraseña = contraseña;
        
    }
    public void setPerfil(Perfiles perfil) {
        this.Perfil = perfil;
    }
    
    
    
}
