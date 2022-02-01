/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ingresos;

import java.math.BigDecimal;
import javax.swing.JOptionPane;

/**
 *
 * @author pmaca
 */
public class Validar {
    
 String rut;
    boolean revisar;
    boolean validacion; 
    static int factura=0;
    
    public Validar(String rut, boolean revisar, boolean validacion) {
        
        this.rut="";
        this.revisar=true;
        this.validacion = false; 
        
        
        
        
    }

    Validar() {
        
    }
    
    
    
    
    
      public int getfactura() {
        return factura;
    }
      
      
      public void setfactura() {
         factura++;
    }
      
      public void setfactura2() {
         if ( factura > 0 ){
            factura--; 
         }
              
    }
      
      
      
      
      
      
     public void llamadorut(String Rut) {
         
         this.rut=Rut;
        
         
         
     }
     
      public boolean revisar(){    
   
     
    if ( rut.length() == 0 ){ revisar = false; JOptionPane.showMessageDialog(null, "El rut no tiene caracteres ");}
    if ( rut.length() < 8 ){  revisar = false; JOptionPane.showMessageDialog(null, "El rut tiene muy pocos caracteres");}
    if ( rut.length() > 10 ){ revisar = false; JOptionPane.showMessageDialog(null, "El rut tiene demasiados caracteres ");; }
    if ( rut.length() > 3 ){
    int tamaño = this.rut.length() -3;
     
    for(int i = tamaño; i >= 0; i--) { 
        char caracter = rut.charAt(i);
        int Ascii = (int)caracter;
        if ((Ascii < 48 || Ascii > 57)){
                   revisar = false;
                } 
        }
    int Guion = this.rut.length() -2;
    char caracter2 = rut.charAt(Guion);
   int valorAscii = (int)caracter2;
    if ((valorAscii < 45 || valorAscii > 45)){
               revisar = false;      
  }
    }else {
        revisar = false;
    }
    
    return revisar;
  



}
      
       public boolean validarRut(String rut){
     
    
        rut =  rut.toUpperCase(); 
        rut = rut.replace("-", "");
        int rutAux = Integer.parseInt(rut.substring(0, rut.length() - 1));
        char dv = rut.charAt(rut.length() - 1);

       int m = 0, s = 1;
       for (; rutAux != 0; rutAux /= 10) {
        s = (s + rutAux % 10 * (9 - m++ % 6)) % 11;
       }
       
       if (dv == (char) (s != 0 ? s + 47 : 75)) {
        JOptionPane.showMessageDialog(null, "El rut es correcto ");
        validacion = false;
    }else {
         
         JOptionPane.showMessageDialog(null, "El rut esta mal escrito "); 
         validacion = true;
       }
       
   
      return validacion;
      
      



 }
     

    public static boolean Clave(String contraseña, String contraseñaUsuario) {
        if (contraseña.equals(contraseñaUsuario)) {
            return true;
        }
        return false;
    }

    public static boolean NivelClave(String contraseña) {
       
        boolean  ac = false;    
        boolean  bc = false;    
        boolean  cc = false;
       boolean otroc = true;
       int numc = 0;
       int dec = 0;
       
       int tamaño = contraseña.length();
       if ( tamaño > 7 ){ 
          ac = true;
          }else {JOptionPane.showMessageDialog(null, "SE NECESITA QUE TENGA MAS CARACTERES");
       }
       char  charclave [] = contraseña.toCharArray();
       int primeral = (int) charclave[0];            
       
        if ( primeral  >= 65 && primeral <= 90 ){ 
          bc = true;
          }else {JOptionPane.showMessageDialog(null, "LA CLAVE DEBE PARTIR CON MAYUSCULA");
       }
        
      for(int i = 0; i < tamaño; i++) { 
        int revisanum = (int) charclave[i];
         if ((revisanum >= 48 && revisanum <= 57)){
             dec = 0;
             dec = i + 1;
             numc = numc + 1 ;
             if (dec < tamaño){
            char perrc = charclave[dec]; 
             int  acus = (int) perrc; 
              if (acus >= 48 && acus <= 57){
                otroc = false;
                JOptionPane.showMessageDialog(null, "RECORDAR INTERCALAR LOS NUMEROS");
         }   
         }
         }         
        }
       
         if ( numc < 1){JOptionPane.showMessageDialog(null, "RECORDAR QUE SON 2 NUMEROS MINIMOS");}
         if ( numc > 3){JOptionPane.showMessageDialog(null, "RECORDAR QUE SON 2 NUMEROS MAXIMO");}               
      
         if ( numc == 2 && otroc == true){ 
             
             cc = true;
          }     
   
         if ( ac == true && bc == true && cc == true){ 
         JOptionPane.showMessageDialog(null, "CLAVE INGRESADA EXITOSAMENTE"); 
          
                     
       }  
        return ac && bc && cc;
         
    
     }   
       
    public static String cantidadConLetra(String s) {
        
        
        
        StringBuilder result = new StringBuilder();
        BigDecimal totalBigDecimal = new BigDecimal(s).setScale(2, BigDecimal.ROUND_DOWN);
        long parteEntera = totalBigDecimal.toBigInteger().longValue();
        int triUnidades      = (int)((parteEntera % 1000));
        int triMiles         = (int)((parteEntera / 1000) % 1000);
        int triMillones      = (int)((parteEntera / 1000000) % 1000);
        int triMilMillones   = (int)((parteEntera / 1000000000) % 1000);
 
        if (parteEntera == 0) {
            result.append("Cero ");
            return result.toString();
        }
 
        if (triMilMillones > 0) result.append(triTexto(triMilMillones).toString() + "Mil ");
        if (triMillones > 0)    result.append(triTexto(triMillones).toString());
 
        if (triMilMillones == 0 && triMillones == 1) result.append("Millón ");
        else if (triMilMillones > 0 || triMillones > 0) result.append("Millones ");
 
        if (triMiles > 0)       result.append(triTexto(triMiles).toString() + "Mil ");
        if (triUnidades > 0)    result.append(triTexto(triUnidades).toString());
 
        return result.toString();
    }
 
   
    private static StringBuilder triTexto(int n) {
        StringBuilder result = new StringBuilder();
        int centenas = n / 100;
        int decenas  = (n % 100) / 10;
        int unidades = (n % 10);
 
        switch (centenas) {
            case 0: break;
            case 1:
                if (decenas == 0 && unidades == 0) {
                    result.append("Cien ");
                    return result;
                }
                else result.append("Ciento ");
                break;
            case 2: result.append("Doscientos "); break;
            case 3: result.append("Trescientos "); break;
            case 4: result.append("Cuatrocientos "); break;
            case 5: result.append("Quinientos "); break;
            case 6: result.append("Seiscientos "); break;
            case 7: result.append("Setecientos "); break;
            case 8: result.append("Ochocientos "); break;
            case 9: result.append("Novecientos "); break;
        }
 
        switch (decenas) {
            case 0: break;
            case 1:
                if (unidades == 0) { result.append("Diez "); return result; }
                else if (unidades == 1) { result.append("Once "); return result; }
                else if (unidades == 2) { result.append("Doce "); return result; }
                else if (unidades == 3) { result.append("Trece "); return result; }
                else if (unidades == 4) { result.append("Catorce "); return result; }
                else if (unidades == 5) { result.append("Quince "); return result; }
                else result.append("Dieci");
                break;
            case 2:
                if (unidades == 0) { result.append("Veinte "); return result; }
                else result.append("Veinti");
                break;
            case 3: result.append("Treinta "); break;
            case 4: result.append("Cuarenta "); break;
            case 5: result.append("Cincuenta "); break;
            case 6: result.append("Sesenta "); break;
            case 7: result.append("Setenta "); break;
            case 8: result.append("Ochenta "); break;
            case 9: result.append("Noventa "); break;
        }
 
        if (decenas > 2 && unidades > 0)
            result.append("y ");
 
        switch (unidades) {
            case 0: break;
            case 1: result.append("Un "); break;
            case 2: result.append("Dos "); break;
            case 3: result.append("Tres "); break;
            case 4: result.append("Cuatro "); break;
            case 5: result.append("Cinco "); break;
            case 6: result.append("Seis "); break;
            case 7: result.append("Siete "); break;
            case 8: result.append("Ocho "); break;
            case 9: result.append("Nueve "); break;
        }
 
        return result;
    }
}
 
  