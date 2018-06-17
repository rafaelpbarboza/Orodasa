/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ortodasa.Controlador;

import java.awt.TextField;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author Rafael p. barboza
 */
public class ValidarCampos {
    
    public Boolean validarEspacios(ArrayList<String> campos,JFrame vista){
        for(String campo:campos){
            if(campo.equals("") | campo.trim().equals("")){
                JOptionPane.showMessageDialog(vista,"Hay campos requeridos vacios ");
                return false;
            }
        }
        return true;
    }
}
