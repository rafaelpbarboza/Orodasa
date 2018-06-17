/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ortodasa.Controlador;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.table.DefaultTableModel;
import ortodasa.Modelo.ModeloCategoria;
import ortodasa.Modelo.PojoCategoria;
import ortodasa.Vista.VistaCategoria;

/**
 *
 * @author Rafael p. barboza
 */
public class Categoria implements ActionListener{
    private VistaCategoria vista;
    private ModeloCategoria modelo;
    
    public Categoria () throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException{
        vista=new VistaCategoria();
        vista.TablaGestion.setSelectionForeground( Color.white );
        vista.TablaGestion.setSelectionBackground( Color.red );
        modelo=new ModeloCategoria();
        vista.setTitle("Categoria");
        vista.setLocationRelativeTo(null);
        vista.setVisible(true);
        vista.BtnGuardar.addActionListener(this);
        vista.BtnEliminar.addActionListener(this);
        vista.BtnConsultar.addActionListener(this);
    }
    

    @Override
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource()==vista.BtnGuardar){
                    ValidarCampos validar=new ValidarCampos();
                    ArrayList <String> campos=new ArrayList();
                    campos.add(vista.TxtNombreAdd.getText());
                    campos.add(vista.txtDescripcionAdd.getText());

                    if(validar.validarEspacios(campos, vista)){
                        PojoCategoria categoria=new PojoCategoria();
                        categoria.setNombre(vista.TxtNombreAdd.getText());
                        categoria.setDescripcion(vista.txtDescripcionAdd.getText());
                            if(modelo.Guardar(categoria) ){
                                    JOptionPane.showMessageDialog(vista, "Registo agregado correctamente");
                                    vista.TxtNombreAdd.setText(null);
                                    vista.txtDescripcionAdd.setText(null);
                            }   
                    }
        }else if(ae.getSource()==vista.BtnEliminar){
            int fila=vista.TablaGestion.getSelectedRow();
            if(fila!=-1){
                PojoCategoria categoria=new PojoCategoria();
                categoria.setCategoria_id(Integer.parseInt(vista.TablaGestion.getModel()
                        .getValueAt(fila,0).toString()));
                categoria.setNombre(vista.TablaGestion.getModel()
                        .getValueAt(fila,1).toString());
                categoria.setDescripcion(vista.TablaGestion.getModel()
                        .getValueAt(fila,0).toString());

                Object objeto=(Object)categoria;
                int codigo=JOptionPane.showConfirmDialog(vista,"Esta seguro de eliminar registro? ",
                        "Eliminar registro", JOptionPane.WARNING_MESSAGE);
                if(codigo==0)
                    if(modelo.eliminar(objeto)){
                          vista.BtnConsultar.doClick();
                    }
                    else{
                        JOptionPane.showMessageDialog(vista, "Error al eliminar ");
                    }
            }else{
                JOptionPane.showMessageDialog(vista, "No se selecciono ningun registro");
            }
            
        }
        else if(ae.getSource()==vista.BtnConsultar){
            ArrayList<Object> objetos=modelo.listar();
            eliminar((DefaultTableModel)vista.TablaGestion.getModel());
            for (Object o:objetos){
                PojoCategoria categoria=(PojoCategoria)o;
                contruyeTabla(categoria);
            }
        }
    }
    
    public void contruyeTabla(PojoCategoria categoria){
        DefaultTableModel modelo = (DefaultTableModel) vista.TablaGestion.getModel();
        Object[]nu ={categoria.getCategoria_id(),categoria.getNombre(),categoria.getDescripcion()};
        
        modelo.addRow(nu);
    }
    public void eliminar(DefaultTableModel modelo){
        for (int i = 0; i < vista.TablaGestion.getRowCount(); i++) {
            modelo.removeRow(i);
            i-=1;
        }
    } 
    
}
