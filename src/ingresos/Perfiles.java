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
public enum Perfiles {
    
  ADMIN("0"),VENDEDOR("1"),GERENTE("2");
 
    public final String selec;
 
    private Perfiles(String selec) {
        this.selec = selec;
    }
}