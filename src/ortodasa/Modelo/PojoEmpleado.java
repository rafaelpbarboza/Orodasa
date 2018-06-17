/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ortodasa.Modelo;

/**
 *
 * @author Rafael p. barboza
 */
public class PojoEmpleado {
    private int empleado_id;
    private String nombre,apellido,identificacion,cargo,telefono;

    public PojoEmpleado() {
    }

    public PojoEmpleado(int empleado_id, String nombre, String apellido, String identificacion, String cargo, String telefono) {
        this.empleado_id = empleado_id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.identificacion = identificacion;
        this.cargo = cargo;
        this.telefono = telefono;
    }

    
    public int getEmpleado_id() {
        return empleado_id;
    }

    public void setEmpleado_id(int empleado_id) {
        this.empleado_id = empleado_id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(String identificacion) {
        this.identificacion = identificacion;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
    
}
