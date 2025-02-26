
package main;

import POJO.Empleado;
import POJO.Incidencia;
import gestionConsultas.EmpleadoDAO;
import java.util.Date;

/**
 *
 * @author eduardolucasmunozdelucas
 */
public class main {

    public static void main(String[] args) {

        System.out.println("Empezamos");

         EmpleadoDAO empleadoDAO = new EmpleadoDAO();

//        Empleado nuevoEmpleado = new Empleado("usu4", "1244", "Paco", "600123456");
//        empleadoDAO.insertarEmpleado(nuevoEmpleado);
        
        Date fechahoy = new Date();
        Incidencia nuevaInc = new Incidencia(fechahoy, new Empleado(1), new Empleado(2), "Me huelen los pies a queso", 'N');
        empleadoDAO.insertarIncidencia(nuevaInc);
        
        

        System.out.println("Incidencia insertada con éxito.");

    }
}
