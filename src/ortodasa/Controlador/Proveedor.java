/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ortodasa.Controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import ortodasa.Modelo.Crud;
import ortodasa.Modelo.ModeloProveedor;
import ortodasa.Modelo.PojoProveedor;
import ortodasa.Vista.VistaProveedor;

/**
 *
 * @author Rafael p. barboza
 */
public class Proveedor implements ActionListener{
    private Crud modelo;
    private VistaProveedor vista;
    
    public Proveedor() throws SQLException, ClassNotFoundException{
        modelo=new ModeloProveedor();
        vista=new VistaProveedor();
        vista.setResizable(false);
        vista.setTitle("Proveedor");
        vista.setLocationRelativeTo(null);
        vista.setVisible(true);
        vista.BtnGuardarProveedor.addActionListener(this);
        vista.BtnConsultarProveedor.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource()==vista.BtnGuardarProveedor){
            ValidarCampos validar=new ValidarCampos();
            ArrayList<String>campos=new ArrayList();
            campos.add(vista.TxtIdentificacionProveedor.getText());
            campos.add(vista.TxtDireccionProveedor.getText());
            campos.add(vista.TxtNombreProveedor.getText());
            campos.add(vista.TxtTelefonoProveedor.getText());
                if(validar.validarEspacios(campos, vista)){
                    PojoProveedor proveedor=new PojoProveedor();
                    proveedor.setIdentificacion(vista.TxtIdentificacionProveedor.getText());
                    proveedor.setNombre(vista.TxtNombreProveedor.getText());
                    proveedor.setCelular(vista.TxtTelefonoProveedor.getText());
                    proveedor.setDireccion(vista.TxtDireccionProveedor.getText());
                    proveedor.setEmail(vista.TxtEmailProveedor.getText());
                    proveedor.setTelefono_fijo(vista.TxtFijoProveedor.getText());
                    Object objeto=(Object)proveedor;

                if(modelo.Guardar(objeto)){
                    JOptionPane.showMessageDialog(vista, "Proveedor Guardado");
                    vista.TxtDireccionProveedor.setText(null);
                    vista.TxtEmailProveedor.setText(null);
                    vista.TxtFijoProveedor.setText(null);
                    vista.TxtIdentificacionProveedor.setText(null);
                    vista.TxtNombreProveedor.setText(null);
                    vista.TxtTelefonoProveedor.setText(null);
                }else{
                    JOptionPane.showMessageDialog(vista, "Error al ingresar","Error",JOptionPane.ERROR_MESSAGE);
                }
                }            
            }
        else if(ae.getSource()==vista.BtnConsultarProveedor){
            ArrayList<Object> objetos=new ArrayList();
            objetos=modelo.listar();
            eliminar((DefaultTableModel)vista.TablaProveedor.getModel());
            
            for(Object o:objetos){
                PojoProveedor proveedor=(PojoProveedor)o;
                contruyeTabla(proveedor);
            }
            
            
        }
    }
    public void contruyeTabla(PojoProveedor proveedor){
        DefaultTableModel modelo = (DefaultTableModel) vista.TablaProveedor.getModel();
        Object[]nu ={proveedor.getProveedor_id(),proveedor.getIdentificacion()
                ,proveedor.getNombre(),proveedor.getTelefono_fijo(),proveedor.getCelular()
                ,proveedor.getEmail(),proveedor.getDireccion()};
        
        modelo.addRow(nu);
    }
    public void eliminar(DefaultTableModel modelo){
        for (int i = 0; i < vista.TablaProveedor.getRowCount(); i++) {
            modelo.removeRow(i);
            i-=1;
        }
    }
}
