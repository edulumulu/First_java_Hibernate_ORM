
package main;

import POJO.Empleado;
import POJO.Incidencia;
import gestionConsultas.EmpleadoDAO;
import gestionConsultas.IncidenciaDAO;
import interfaz_gráfica.MenuPrincipal;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author eduardolucasmunozdelucas
 */
public class main {

    public static void main(String[] args) {

        System.out.println("Empezamos");

         MenuPrincipal menu = new MenuPrincipal();
            menu.setLocationRelativeTo(null);
            menu.setVisible(true);

        //System.out.println("Incidencia insertada con éxito.");

    }
}
