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
public class PojoProveedor {
    private int proveedor_id;
    private String nombre,telefono_fijo,celular,email,identificacion,direccion;

    public PojoProveedor(int proveedor_id, String nombre, String telefono_fijo, String celular, String email, String identificacion, String direccion) {
        this.proveedor_id = proveedor_id;
        this.nombre = nombre;
        this.telefono_fijo = telefono_fijo;
        this.celular = celular;
        this.email = email;
        this.identificacion = identificacion;
        this.direccion = direccion;
    }

    public PojoProveedor() {
    }

    
    public int getProveedor_id() {
        return proveedor_id;
    }

    public void setProveedor_id(int proveedor_id) {
        this.proveedor_id = proveedor_id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTelefono_fijo() {
        return telefono_fijo;
    }

    public void setTelefono_fijo(String telefono_fijo) {
        this.telefono_fijo = telefono_fijo;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(String identificacion) {
        this.identificacion = identificacion;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
    
}
