
package main;

import POJO.Empleado;
import gestionConsultas.EmpleadoDAO;

/**
 *
 * @author eduardolucasmunozdelucas
 */
public class main {

    public static void main(String[] args) {

        System.out.println("Empezamos");

         EmpleadoDAO empleadoDAO = new EmpleadoDAO();

        Empleado nuevoEmpleado = new Empleado("usuario1", "1234", "Juan Pérez", "600123456");
        empleadoDAO.insertarEmpleado(nuevoEmpleado);

        System.out.println("Empleado insertado con éxito.");

    }
}
