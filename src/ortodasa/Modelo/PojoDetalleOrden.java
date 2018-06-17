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
public class PojoDetalleOrden {
    private int detalle_orden_id,orden_id,producto_id,cantidad,precio_venta;

    public PojoDetalleOrden() {
    }

    public PojoDetalleOrden(int detalle_orden_id, int orden_id, int producto_id, int cantidad, int precio_venta) {
        this.detalle_orden_id = detalle_orden_id;
        this.orden_id = orden_id;
        this.producto_id = producto_id;
        this.cantidad = cantidad;
        this.precio_venta = precio_venta;
    }

    public int getDetalle_orden_id() {
        return detalle_orden_id;
    }

    public void setDetalle_orden_id(int detalle_orden_id) {
        this.detalle_orden_id = detalle_orden_id;
    }

    public int getOrden_id() {
        return orden_id;
    }

    public void setOrden_id(int orden_id) {
        this.orden_id = orden_id;
    }

    public int getProducto_id() {
        return producto_id;
    }

    public void setProducto_id(int producto_id) {
        this.producto_id = producto_id;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public int getPrecio_venta() {
        return precio_venta;
    }

    public void setPrecio_venta(int precio_venta) {
        this.precio_venta = precio_venta;
    }
    
    
}
