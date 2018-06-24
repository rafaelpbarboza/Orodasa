/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ortodasa.Modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author rafael
 */
public class ModeloCliente implements Crud{
    
    private ArrayList<PojoCliente>clientes;
    private Connection conexion;
    
    public ModeloCliente() throws SQLException, ClassNotFoundException{
        this.conexion = Conexion.obtener();
        clientes=new ArrayList();
    }

    @Override
    public Boolean Guardar(Object objeto) {
      PojoCliente cliente= (PojoCliente)objeto;
        String sql="insert into cliente(nombres,identificacion,email,telefono,direccion)"
                + "values('"+cliente.getNombre()+"','"+cliente.getIdentificacion()+"','"
                +cliente.getEmail()+"','"+cliente.getTelefono()+"','"+cliente.getDireccion()+"')";
        try{
            PreparedStatement st= conexion.prepareStatement(sql);
            st.executeUpdate();
            return true;
        }
        catch (SQLException e){
            System.out.println("Error al guardar registro "+e.getMessage());
         return false;   
        }
    }

    @Override
    public ArrayList<Object> listar() {
        Statement s = null;
        ArrayList<Object> objeto=new ArrayList();
        try {
            s=  conexion.createStatement();
            ResultSet rs= s.executeQuery("SELECT * FROM cliente;");
            if(rs.next()){
                PojoCliente cliente=new PojoCliente();
                cliente.setCliente_id(rs.getInt(1));
                cliente.setNombre(rs.getString(2));
                cliente.setIdentificacion(rs.getString(3));
                cliente.setEmail(rs.getString(4));
                cliente.setTelefono(rs.getString(5));
                cliente.setDireccion(rs.getString(6));
                clientes.add(cliente);
            }
            
        } catch (SQLException ex) {
            System.out.println("Error al conectar a la base datos "+ex.getMessage());
        }
        objeto.addAll(clientes);
            return objeto;
    }

    @Override
    public Boolean eliminar(Object objeto) {
       PojoCliente cliente=(PojoCliente)objeto;
        String sql="DELETE FROM categoria WHERE categoria_id='"+cliente.getCliente_id()+"'";
        try {
            Statement pr=conexion.createStatement();
            pr.execute(sql);
            return true;
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return false;
        }
    }

    @Override
    public Boolean actualizar(Object objeto) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
