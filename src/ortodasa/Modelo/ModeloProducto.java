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

/**
 *
 * @author rafael
 */
public class ModeloProducto implements Crud{
    private Connection conexion;
    private ArrayList<PojoProducto> productos;
    
    public ModeloProducto() throws SQLException, ClassNotFoundException{
        conexion=Conexion.obtener();
        productos=new ArrayList();
    }
    @Override
    public Boolean Guardar(Object objeto) {
        PojoProducto producto= (PojoProducto)objeto;
        String sql="";
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
        try {
            s = conexion.createStatement();
            ResultSet rs = s.executeQuery ("select * from producto");
            
            while(rs.next()){
                PojoProducto producto=new PojoProducto();
                
                productos.add(producto);
            }
            
            rs.close();
            ArrayList<Object> o=new ArrayList();
            o.addAll(productos);
            return o;
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }      
       return null;
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
