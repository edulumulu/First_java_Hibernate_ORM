
package POJO;

import java.io.Serializable;
import java.util.Date;


/**
 *
 * @author eduardolucasmunozdelucas
 */

public class Incidencia implements Serializable{
    
    
    private int id_incidencia;
    private Date fecha_hora_generacion;
    private Empleado id_empleado_origen; 
    private Empleado id_empleado_destino;
    private String detalle;
    private char tipo; // 'U' para Urgente, 'N' para Normal

    public Incidencia() {
    }

    public Incidencia(int id_Incidencia) {
        this.id_incidencia = id_Incidencia;
    }

    public Incidencia( Date fecha_hora_generacion, Empleado id_empleado_origen, Empleado id_empleado_destino, String detalle, char tipo) {
        
        this.fecha_hora_generacion = fecha_hora_generacion;
        this.id_empleado_origen = id_empleado_origen;
        this.id_empleado_destino = id_empleado_destino;
        this.detalle = detalle;
        this.tipo = tipo;
    }

    public int getId_incidencia() {
        return id_incidencia;
    }

    public void setId_incidencia(int id_incidencia) {
        this.id_incidencia = id_incidencia;
    }

    public Date getFecha_hora_generacion() {
        return fecha_hora_generacion;
    }

    public void setFecha_hora_generacion(Date fecha_hora_generacion) {
        this.fecha_hora_generacion = fecha_hora_generacion;
    }

    public Empleado getId_empleado_origen() {
        return id_empleado_origen;
    }

    public void setId_empleado_origen(Empleado id_empleado_origen) {
        this.id_empleado_origen = id_empleado_origen;
    }

    public Empleado getId_empleado_destino() {
        return id_empleado_destino;
    }

    public void setId_empleado_destino(Empleado id_empleado_destino) {
        this.id_empleado_destino = id_empleado_destino;
    }

    public String getDetalle() {
        return detalle;
    }

    public void setDetalle(String detalle) {
        this.detalle = detalle;
    }

    public char getTipo() {
        return tipo;
    }

    public void setTipo(char tipo) {
        this.tipo = tipo;
    }

    @Override
    public String toString() {
        return "Incidencia{" +
                "idIncidencia=" + id_incidencia +
                ", fechaCreacion=" + fecha_hora_generacion +
                ", empleadoOrigen=" + id_empleado_origen +
                ", empleadoDestino=" + id_empleado_destino +
                ", detalle='" + detalle + '\'' +
                ", tipo=" + tipo +
                '}';
    }
   
}
