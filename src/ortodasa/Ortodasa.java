/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ortodasa;

import java.sql.Connection;
import ortodasa.Controlador.Categoria;
import ortodasa.Controlador.Proveedor;
import ortodasa.Modelo.Conexion;

/**
 *
 * @author Rafael p. barboza
 */
public class Ortodasa {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        /*
        try{
            Connection conexion=Conexion.obtener();
        }
        catch(Exception e){
            System.err.println("Error "+ e.getMessage());
        }
        */
        
        try{
            Proveedor pro=new Proveedor();
        }
        catch (Exception e){
            System.out.println("Error general");
        }
        
        
        
    }
    
}
