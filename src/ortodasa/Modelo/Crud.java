/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ortodasa.Modelo;

import java.util.ArrayList;

/**
 *
 * @author Rafael p. barboza
 */
public interface Crud {
    public Boolean Guardar(Object objeto);
    public ArrayList<Object> listar();
    public Boolean eliminar(Object objeto);
    public Boolean actualizar(Object objeto);
}
