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
import ortodasa.Modelo.ModeloCliente;
import ortodasa.Modelo.PojoCliente;
import ortodasa.Vista.VistaCliente;

/**
 *
 * @author rafael
 */
public class Cliente implements ActionListener{
    private Crud modelo;
    private VistaCliente vista;
    
    public Cliente() throws SQLException, ClassNotFoundException{
        modelo=new ModeloCliente();
        vista=new VistaCliente();
        vista.setResizable(false);
        vista.setTitle("Cliente");
        vista.setLocationRelativeTo(null);
        vista.setVisible(true);
        vista.BtnGuardarCliente.addActionListener(this);
        vista.BtnConsultarCliente.addActionListener(this);
        vista.BtnEliminarCliente.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        if(e.getSource()==vista.BtnGuardarCliente){
            ArrayList<String> campos=new ArrayList();
            campos.add(vista.TxtIdentificacionCliente.getText());
            campos.add(vista.TxtNombreCliente.getText());
            campos.add(vista.TxtTelefonoCliente.getText());
            ValidarCampos validar=new ValidarCampos();
            
            if(validar.validarEspacios(campos, vista)){
                PojoCliente cliente=new PojoCliente();
                cliente.setIdentificacion(vista.TxtIdentificacionCliente.getText());
                cliente.setNombre(vista.TxtNombreCliente.getText());
                cliente.setTelefono(vista.TxtTelefonoCliente.getText());
                cliente.setEmail(vista.TxtMailCliente.getText());
                cliente.setDireccion(vista.TxtDireccionCliente.getText());
                Object objeto=(Object)cliente;
                if(modelo.Guardar(objeto)){
                    vista.TxtIdentificacionCliente.setText(null);
                    vista.TxtNombreCliente.setText(null);
                    vista.TxtTelefonoCliente.setText(null);
                    vista.TxtMailCliente.setText(null);
                    vista.TxtDireccionCliente.setText(null);
                    
                           
                    JOptionPane.showMessageDialog(vista, "Guardado con exito");
                }
                else{
                    JOptionPane.showMessageDialog(vista, "Error al guardar","Error",JOptionPane.ERROR_MESSAGE);
                }
            }           
                    
        }
        if(e.getSource()==vista.BtnConsultarCliente){
            ArrayList<Object> objetos=modelo.listar();
            eliminar((DefaultTableModel)vista.TablaCliente.getModel());
           
            for(Object o:objetos){
                PojoCliente cliente=(PojoCliente)o;
                contruyeTabla(cliente);
            }
        }
        if(e.getSource()==vista.BtnEliminarCliente){
            int fila=vista.TablaCliente.getSelectedRow();
            if(fila!=-1){
                PojoCliente cliente=new PojoCliente();
                cliente.setCliente_id(Integer.parseInt(vista.TablaCliente.getModel()
                        .getValueAt(fila,0).toString()));
                Object objeto=(Object)cliente;
                int codigo=JOptionPane.showConfirmDialog(vista,"Esta seguro de eliminar registro? ",
                        "Eliminar registro", JOptionPane.WARNING_MESSAGE);
                if(codigo==0)
                    if(modelo.eliminar(objeto)){
                          vista.BtnConsultarCliente.doClick();
                    }
                    else{
                        JOptionPane.showMessageDialog(vista, "Error al eliminar ");
                    }
            }else{
                JOptionPane.showMessageDialog(vista, "No se selecciono ningun registro");
            }
        }
        
        
        
    }
    
     public void contruyeTabla(PojoCliente cliente){
        DefaultTableModel modelo = (DefaultTableModel) vista.TablaCliente.getModel();
        Object[]nu ={
            cliente.getCliente_id(),cliente.getIdentificacion(),
            cliente.getNombre(),cliente.getEmail(),cliente.getTelefono(),
            cliente.getDireccion()
        };
        
        modelo.addRow(nu);
    }
    public void eliminar(DefaultTableModel modelo){
        for (int i = 0; i < vista.TablaCliente.getRowCount(); i++) {
            modelo.removeRow(i);
            i-=1;
            System.out.println(i);
        }
    }
    
    
    
    
    
}
