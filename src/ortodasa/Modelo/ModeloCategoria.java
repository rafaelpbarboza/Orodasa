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
import javax.swing.JOptionPane;


/**
 *
 * @author Rafael p. barboza
 */
public class ModeloCategoria implements Crud{
    Connection conexion;
    ArrayList<PojoCategoria> categorias;

    public ModeloCategoria() throws SQLException, ClassNotFoundException {
        this.conexion = Conexion.obtener();
    }
    

    @Override
    public Boolean Guardar(Object objeto) {
        PojoCategoria categoria= (PojoCategoria)objeto;
        String sql="insert into categoria(nombre,descripcion)values('"+categoria.getNombre()+"','"+categoria.getDescripcion()+"')";
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
        categorias=new ArrayList();
        try {
            s = conexion.createStatement();
            ResultSet rs = s.executeQuery ("select * from categoria");
            while(rs.next()){
                PojoCategoria categoria=new PojoCategoria();
                categoria.setCategoria_id(rs.getInt(1));
                categoria.setNombre(rs.getString(2));
                categoria.setDescripcion(rs.getString(3));
                categorias.add(categoria);
              
            }
            rs.close();
            ArrayList<Object> o=new ArrayList();
            o.addAll(categorias);
            return o;
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }            
       return null;
    }

    @Override
    public Boolean eliminar(Object objeto) {
        PojoCategoria categoria=(PojoCategoria)objeto;
        String sql="DELETE FROM categoria WHERE categoria_id='"+categoria.getCategoria_id()+"'";
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
