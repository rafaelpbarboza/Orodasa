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
public class ModeloProveedor implements Crud{
    Connection conexion;
    ArrayList<PojoProveedor> proveedores;

    public ModeloProveedor() throws SQLException, ClassNotFoundException {
       conexion = Conexion.obtener();
    }
    
    
    @Override
    public Boolean Guardar(Object objeto) {
        try {
            PojoProveedor proveedor=(PojoProveedor)objeto;
            String sql="insert into proveedor(nombre,telefono_fijo,celular,e_mail,identificacion,direccion)values"
                    + "('"+proveedor.getNombre()+"','"+proveedor.getTelefono_fijo()+"','"+proveedor.getCelular()+"',"
                    + "'"+proveedor.getEmail()+"','"+proveedor.getIdentificacion()+"','"+proveedor.getDireccion()+"')";
                    PreparedStatement pr=conexion.prepareStatement(sql);
                    pr.executeUpdate();
                    return true;
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
              
            return false;
        }
    }

    @Override
    public ArrayList<Object> listar() {
        
        Statement s = null; 
        proveedores=new ArrayList();
        try {
            s = conexion.createStatement();
            ResultSet rs = s.executeQuery ("select * from proveedor");
            while(rs.next()){
                PojoProveedor proveedor=new PojoProveedor();
                proveedor.setProveedor_id(rs.getInt(1));
                proveedor.setNombre(rs.getString(2));
                proveedor.setTelefono_fijo(rs.getString(3));
                proveedor.setCelular(rs.getString(4));
                proveedor.setEmail(rs.getString(5));
                proveedor.setIdentificacion(rs.getString(6));
                proveedor.setDireccion(rs.getString(7));
                proveedores.add(proveedor);
              
            }
            rs.close();
            ArrayList<Object> o=new ArrayList();
            o.addAll(proveedores);
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
