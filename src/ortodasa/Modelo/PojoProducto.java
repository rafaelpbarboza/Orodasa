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
public class PojoProducto {
    private int producto_id,categoria_pro_id,prov_id,precio_sugerido,existencia;
    private String nombre,descripcion,fecha_ingreso;

    public PojoProducto() {
    }

    public PojoProducto(int producto_id, int categoria_pro_id, int prov_id, int precio_sugerido, int existencia, String nombre, String descripcion, String fecha_ingreso) {
        this.producto_id = producto_id;
        this.categoria_pro_id = categoria_pro_id;
        this.prov_id = prov_id;
        this.precio_sugerido = precio_sugerido;
        this.existencia = existencia;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.fecha_ingreso = fecha_ingreso;
    }

    public int getProducto_id() {
        return producto_id;
    }

    public void setProducto_id(int producto_id) {
        this.producto_id = producto_id;
    }

    public int getCategoria_pro_id() {
        return categoria_pro_id;
    }

    public void setCategoria_pro_id(int categoria_pro_id) {
        this.categoria_pro_id = categoria_pro_id;
    }

    public int getProv_id() {
        return prov_id;
    }

    public void setProv_id(int prov_id) {
        this.prov_id = prov_id;
    }

    public int getPrecio_sugerido() {
        return precio_sugerido;
    }

    public void setPrecio_sugerido(int precio_sugerido) {
        this.precio_sugerido = precio_sugerido;
    }

    public int getExistencia() {
        return existencia;
    }

    public void setExistencia(int existencia) {
        this.existencia = existencia;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getFecha_ingreso() {
        return fecha_ingreso;
    }

    public void setFecha_ingreso(String fecha_ingreso) {
        this.fecha_ingreso = fecha_ingreso;
    }
}
