/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ortodasa.Controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.Action;
import ortodasa.Modelo.*;
import ortodasa.Vista.VistaProducto;

/**
 *
 * @author rafael
 */
public class Producto implements ActionListener,KeyListener{
    private ModeloProducto modelo;
    private ModeloCategoria modeloCategoria;
    private ModeloProveedor modeloProveedor;
    private VistaProducto vista;
    private ArrayList<PojoProveedor>proveedores;
    
    public Producto() throws SQLException, ClassNotFoundException{
        //modelo=new ModeloProducto();
        modeloCategoria=new ModeloCategoria();
        modeloProveedor=new ModeloProveedor();
        proveedores=new ArrayList();
        vista=new VistaProducto();       
        vista.setResizable(false);
        vista.setTitle("Producto");
        vista.setLocationRelativeTo(null);
        vista.setVisible(true);
        vista.BtnGuardar.addActionListener(this);
        vista.TxtPrecioProducto.addKeyListener(this);
        addListProveedor();
        addListCategoria();
    }
    
    public void addListProveedor(){
        ArrayList<Object> ob=modeloProveedor.listar();
        for (Object o:ob){
            PojoProveedor producto=(PojoProveedor)o;
            vista.ComboProveedor.addItem(producto.getNombre());
        }
    }
    
    public void addListCategoria(){
        ArrayList<Object> ob=modeloCategoria.listar();
        for (Object o:ob){
            PojoCategoria cat=(PojoCategoria)o;
            vista.ComboCategoria.addItem(cat.getNombre());
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==vista.BtnGuardar){
            System.out.println("presionaste el boton guardar");
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {
         char caracter = e.getKeyChar();
        
      // Verificar si la tecla pulsada no es un digito
      if(((caracter < '0') ||
         (caracter > '9')) &&
         (caracter != '\b' /*corresponde a BACK_SPACE*/))
      {
         e.consume();  // ignorar el evento de teclado
      }
    }

    @Override
    public void keyPressed(KeyEvent e) {
   
    }

    @Override
    public void keyReleased(KeyEvent e) {
   
    }
    
    
    
    
}
