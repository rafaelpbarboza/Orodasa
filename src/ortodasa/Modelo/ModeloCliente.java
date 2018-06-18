/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ortodasa.Modelo;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author rafael
 */
public class ModeloCliente implements Crud{
    
    private ArrayList<PojoCliente>clientes;
    private Connection conexion;
    
    public ModeloCliente() throws SQLException, ClassNotFoundException{
        //this.conexion = Conexion.obtener();
        clientes=new ArrayList();
    }

    @Override
    public Boolean Guardar(Object objeto) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<Object> listar() {
        ArrayList<Object> objeto=new ArrayList();
        ArrayList<PojoCliente> clientes=new ArrayList();
        clientes.add(new PojoCliente(0, "rafael","1143359380","barboza.rafael.p@gmail.com","3046573274","San jose de los campanos"));
        clientes.add(new PojoCliente(1, "juan manuel","1143359320", "juan.castro@gmail.com","304653274", "pepe junior"));
        objeto.addAll(clientes);
        return objeto;
    }

    @Override
    public Boolean eliminar(Object objeto) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Boolean actualizar(Object objeto) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
