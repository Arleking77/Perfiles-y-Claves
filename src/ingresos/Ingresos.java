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
import java.awt.HeadlessException;
import java.util.Stack;
import javax.swing.JOptionPane;



public class Ingresos {

    static Usuario Vendedor;
    static Usuario Gerente;
    static Usuario Admin;
    static Stack<Auto> Autos;
    
    

    public static void main(String[] args) {
        JOptionPane visor = new JOptionPane();
        Admin = new Usuario("Juan", "Admin123", Perfiles.ADMIN);
        Vendedor = new Usuario("Hugo", null, Perfiles.VENDEDOR);
        Gerente = new Usuario("Francisco",null, Perfiles.GERENTE);
        Autos = setauto();
       int opcion;
       String op;
       boolean salir = false;
       while (!salir) {
            
            op= JOptionPane.showInputDialog("INDIQUE SU PERFIL\n"+ "0.- ADMINISTRADOR \n"+ "1.- VENDEDOR \n"+ "2.- GERENTE \n"+ "3.- SALIR");
            opcion = Integer.parseInt(op);
            switch (opcion) {
                case 0:
                    menuadmin(visor, Admin);
                    break;
                case 1:
                    menuvendedor(visor, Vendedor);
                    break;
                case 2:
                    menugerente(visor, Gerente);
                    break;
                default:
                    break;
                case 3:
                    visor.showMessageDialog(null,"VUELVA PRONTO");
                    salir = true;
                    break;
                  
                    
            }
        }
    }

    private static String menuadmin(JOptionPane visor, Usuario user) {
        String opcion = "";
        if (!validarclave(user, visor)) {
            return "";
        }

        while (!opcion.equals("4")) {
            opcion = visor.showInputDialog(
                    "MENU ADMINISTRADOR \n"
                    + "1.- NUEVA CLAVE \n"+ "2.- CONSULTA DE CLAVES \n"+ "3.- RETROCEDER");

            switch (opcion) {
     
                case "1":
                    String subopcion = visor.showInputDialog("1.- ADMINISTRADOR \n"+ "2.- VENDEDOR \n"+ "3.- GERENTE \n"+ "4.- RETROCEDER");
                    int compa;
                    compa = Integer.parseInt(subopcion);
                    if (compa<4) {
                    String contraseña = visor.showInputDialog("INGRESE NUEVA CLAVEDE SEGURIDAD" +"FORMATO \n"+ "-MAS DE 8 CARACTERES \n"+  "-INICIAR CON UNA MAYUSCULA \n"+ "-MINIMO 2 NNUMEROS \n"+"-INTERCALAR NUMEROS \n" );
                    if (Validar.NivelClave(contraseña)) {
                        switch (subopcion) {
                            case "1":
                                Admin.setContraseña(contraseña);
                                break;
                            case "2":
                                Vendedor.setContraseña(contraseña);
                                break;
                            case "3":
                               Gerente.setContraseña(contraseña);
                                break;
                            default:
                                break;
                       }}} else {
                        visor.showMessageDialog(null, "Contraseña no cumple protocolos de seguridad");
                    }
                    break;
                        
                    case "2":
                    opcion = visor.showInputDialog("CONSULTA CONTRASEÑAS \n"+ "1.- ADMINISTRADOR \n"+ "2.- VENDEDOR \n"+ "3.- GERENTE \n"+ "4.- RETROCEDER");

                    switch (opcion) {
                        case "1":
                            visor.showMessageDialog(null, Admin.getContraseña());
                            break;
                            
                        case "2":
                            visor.showMessageDialog(null, Vendedor.getContraseña());
                            ;
                            break;
                        case "3":
                            visor.showMessageDialog(null, Gerente.getContraseña());
                            break;
                       case "4":
                           
                           opcion = "4";
                           
                           break; 
                    }
                    case "3":
                      opcion = "4";
                        
                        break; 
              
            }

        }
        return opcion;
    }

    private static String menuvendedor(JOptionPane pane, Usuario user) {
        if (!validarclave(user, pane)) {
            return "";
        }
        String opcion = "";
        while (!opcion.equals("3")) {
            opcion = pane.showInputDialog(
                    "MENU VENDEDOR \n"+ "1.-STOCK\n"+ "2.-VENTA \n"+ "3.- Retroceder\n");
            switch (opcion) {
                case "1":
                    ConsultaStock();
                    break;
                case "2":
                    Ventas();
                    break;
                default:
                    break;
            }
        }

        return opcion;
    }

    private static String menugerente(JOptionPane pane, Usuario user) {
        if (!validarclave(user, pane)) {
            return "";
        }
        String opcion = "";
        while (!opcion.equals("3")) {
            opcion = pane.showInputDialog(
                    "MENU GERENTE \n"+ "1.- STOCK \n" + "2.-ESTADISTICA DE VENTA\n" + "3.- RETROCEDER\n");
            switch (opcion) {
                case "1":
                    ConsultaStock();
                    break;
                case "2":
                    consultarVentas();
                    break;
                default:
                    break;
            }

        }
        return opcion;
    }



    private static Stack<Auto> setauto() {
        Stack<Auto> autos = new Stack<Auto>();
        Auto auto1 = new Auto("INFINITI Q60", 20000, 5, 0, 0);
        Auto auto2 = new Auto("INFINITI QX50", 30000, 3, 0, 0);
        autos.add(auto1);
        autos.add(auto2);
        return autos;
    }

    private static void ConsultaStock() {
        StringBuilder sb = new StringBuilder();
        sb.append("Stock de vehiculos.  \n");
        for (int i = 0; i < Autos.size(); i++) {
            Auto auto = Autos.get(i);
            sb.append("Auto: " + auto.getNombre() + " Stock: " + auto.getStock() + " \n");
        }
        JOptionPane.showMessageDialog(null, sb.toString());
    }



    private static Auto Ventas() {
    
        String rut;
       int numfac=0;
       StringBuilder OPP = new StringBuilder();
       rut = JOptionPane.showInputDialog("Ingresar el RUT de la persona"+"\n"+"FORMATO XXXXXXXX-X");
       Validar ver = new Validar();
       ver.llamadorut(rut);
       ver.revisar(); 
      if (ver.revisar != true) {
        ver.validarRut(rut);
      if (ver.validacion != true) {                               
                       
        
        OPP.append("INGRESE OPCION A COMPRAR \n");
        for (int i = 0; i < Autos.size(); i++) {
            Auto auto = Autos.get(i);
            OPP.append((i + 1) + ".- NOMBRE: " + auto.getNombre() + " STOCK: " + auto.getStock() + " PRECIO EN DOLAR $: " + auto.getPrecio() + " \n");
        }
        String opcion = JOptionPane.showInputDialog(OPP.toString());

        try {
            Auto auto = Autos.get(Integer.parseInt(opcion) - 1);
            int cantidad = Integer.parseInt(JOptionPane.showInputDialog("NOMBRE: " + auto.getNombre() + " PRECIO EN DOLAR " + auto.getPrecio() + " STOCK: " + auto.getStock() + "\n"
                    + " Cuantas unidades desea?"));
            if (cantidad > auto.getStock()) {
                JOptionPane.showMessageDialog(null, "BAJO STOCK");
            } else {
                int totalPagar = cantidad * auto.getPrecio();
                String cambio = Integer.toString(totalPagar);                                 
                Validar.cantidadConLetra(cambio);                         
                             
                ver.setfactura();
                int ingreso = Integer.parseInt(JOptionPane.showInputDialog("FACTURA: "+ver.getfactura()+"\n"+ "RUT CLIENTE : " + rut + "\n"+ "VEHICULO: " +  auto.getNombre() + "\n"+ "TOTAL A PAGAR $: " + totalPagar + " DOLARES\n"+ "SON : " + Validar.cantidadConLetra(cambio) + " DOLARES" + "\n"
                        + "" + "\n" + "CUANTO DINERO CANCELARA "));

                if (ingreso >= totalPagar) {
                    JOptionPane.showMessageDialog(null, "VUELVA A COMPRAR CUANDO QUIERA \n"
                            + "EL VUELTO ES DE : " + (ingreso - totalPagar));

                    for (int i = 0; i <  Autos .size(); i++) {
                        if ( Autos .get(i).getNombre().equals( auto.getNombre())) {
                             Autos .get(i).registrarVenta(cantidad)
                             ;
                        }
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "DINERO INSUFICIENTE");
                    ver.setfactura2();
                }
            }
        }
        catch (HeadlessException | NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "NO EXISTE ESE VEHICULO");
        }
       
    }   
       
            } 
        return null; 
 } 
    
    
        private static boolean validarclave(Usuario user, JOptionPane visor) {
        String contraseña = visor.showInputDialog("INGRESE CONTRASEÑA");
        boolean salida = Validar.Clave(contraseña, user.getContraseña());
        if (!salida) {
            visor.showMessageDialog(null, "CONTRASEÑA INCORRECTA");
        }
        return salida;
    }
    
        private static void consultarVentas() {
        StringBuilder obser = new StringBuilder();
        Validar ver = new Validar();
        obser.append("Stock de vehiculos.  \n");
        for (int i = 0; i < Autos.size(); i++) {
            Auto auto = Autos.get(i);
            obser.append("VEHICULO : " + auto.getNombre()+ "\n" + " -Unidades vendidas: " + auto.getCantidad()+ "\n" + " -Dinero ingresado $: " + auto.getTotal()+ " \n"+" \n"+"Cantidad de facturas: "+ver.getfactura());
        }
        JOptionPane.showMessageDialog(null, obser.toString());
    }
    
 
}