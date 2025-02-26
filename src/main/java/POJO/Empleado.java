
package POJO;

import java.io.Serializable;
import jakarta.persistence.*;


/**
 *
 * @author eduardolucasmunozdelucas
 */




public class Empleado implements Serializable{
    
    private int id_empleado;
    private String nombre_usuario;    
    private String contrasena;
    private String nombre_completo;
    private String telefono_contacto;

    public Empleado() {
    }

    public Empleado(int id_Empleado) {
        this.id_empleado = id_Empleado;
    }

    public Empleado( String nombre_usuario, String contrasena, String nombre_completo, String telefono_contacto) {
       
        this.nombre_usuario = nombre_usuario;
        this.contrasena = contrasena;
        this.nombre_completo = nombre_completo;
        this.telefono_contacto = telefono_contacto;
    }

    public int getId_empleado() {
        return id_empleado;
    }

    public void setId_empleado(int id_empleado) {
        this.id_empleado = id_empleado;
    }

    public String getNombre_usuario() {
        return nombre_usuario;
    }

    public void setNombre_usuario(String nombre_usuario) {
        this.nombre_usuario = nombre_usuario;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public String getNombre_completo() {
        return nombre_completo;
    }

    public void setNombre_completo(String nombre_completo) {
        this.nombre_completo = nombre_completo;
    }

    public String getTelefono_contacto() {
        return telefono_contacto;
    }

    public void setTelefono_contacto(String telefono_contacto) {
        this.telefono_contacto = telefono_contacto;
    }

    @Override
    public String toString() {
        return "Empleado{" + 
                "id_empleado=" + id_empleado + 
                ", nombre_usuario=" + nombre_usuario + 
                ", contrasena=" + contrasena + 
                ", nombre_completo=" + nombre_completo + 
                ", telefono_contacto=" + telefono_contacto + 
                '}';
    }

    
    

    
    
    
    
}
