package main;

import POJO.Empleado;
import POJO.Incidencia;
import gestionConsultas.EmpleadoDAO;
import gestionConsultas.IncidenciaDAO;
import herramientas.HibernateUtil;
import interfaz_gráfica.MenuPrincipal;
import java.util.ArrayList;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.Scanner;
import org.hibernate.Session;

/**
 *
 * @author edulumulu
 */
public class main {

    static EmpleadoDAO empleadoDAO = new EmpleadoDAO();
    static IncidenciaDAO incidenciaDAO = new IncidenciaDAO();
    static ArrayList<Empleado> lista_empleados = new ArrayList<>();
    static ArrayList<Incidencia> lista_incidencias = new ArrayList<>();

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int opcion;
        System.out.println("----- COMIENZA EL PROGRAMA ------");

        lista_empleados = empleadoDAO.listarEmpleados();
        lista_incidencias = incidenciaDAO.listar_incidencias();

        //Controla que haya datos en las tablas de la base de datos, si no ofrece la opción de incorporar datos de prueba
        if (lista_empleados.isEmpty() || lista_incidencias.isEmpty()) {

            System.out.println("---------------");
            System.out.println("");
            System.out.println("------ LEA CON ATENCIÓN ------");

            while (true) {

                try {
                    System.out.println("Tienes la opción de incluir datos de prueba en la BBDD: ");
                    System.out.println("1. Cargar datos predeterminados");
                    System.out.println("2. No cargar datos");
                    System.out.print("Elige una opción:");
                    opcion = sc.nextInt();
                    if (opcion == 1) {

                        Session session = HibernateUtil.getSessionFactory().openSession();

                        Empleado empleado1 = new Empleado("juanperez", "pass1234", "Juan Pérez", "654321987");
                        Empleado empleado2 = new Empleado("maria_gomez", "maria2024", "María Gómez", "687456123");
                        Empleado empleado3 = new Empleado("carlos_lopez", "carlitos99", "Carlos López", "698745632");
                        Empleado empleado4 = new Empleado("ana_rodriguez", "anaR_85", "Ana Rodríguez", "612345678");
                        Empleado empleado5 = new Empleado("pedro_martin", "pedroM2023", "Pedro Martín", "623987456");
                        Empleado empleado6 = new Empleado("laura_sanchez", "lauSanx12", "Laura Sánchez", "635214789");
                        Empleado empleado7 = new Empleado("david_fernandez", "davidF_90", "David Fernández", "647852369");
                        Empleado empleado8 = new Empleado("sandra_moreno", "sanMo2022", "Sandra Moreno", "659874123");
                        Empleado empleado9 = new Empleado("jose_ramirez", "ramirezJ0s3", "José Ramírez", "678912345");
                        Empleado empleado10 = new Empleado("elena_torres", "elenaTorres!", "Elena Torres", "689745231");

                        EmpleadoDAO.insertarEmpleado(empleado1);
                        EmpleadoDAO.insertarEmpleado(empleado2);
                        EmpleadoDAO.insertarEmpleado(empleado3);
                        EmpleadoDAO.insertarEmpleado(empleado4);
                        EmpleadoDAO.insertarEmpleado(empleado5);
                        EmpleadoDAO.insertarEmpleado(empleado6);
                        EmpleadoDAO.insertarEmpleado(empleado7);
                        EmpleadoDAO.insertarEmpleado(empleado8);
                        EmpleadoDAO.insertarEmpleado(empleado9);
                        EmpleadoDAO.insertarEmpleado(empleado10);

                        empleado1 = session.get(Empleado.class, 1); // ID de Juan Pérez
                        empleado2 = session.get(Empleado.class, 2);
                        empleado3 = session.get(Empleado.class, 3); // ID de Juan Pérez
                        empleado4 = session.get(Empleado.class, 4);
                        empleado5 = session.get(Empleado.class, 5); // ID de Juan Pérez
                        empleado6 = session.get(Empleado.class, 6);
                        empleado7 = session.get(Empleado.class, 7); // ID de Juan Pérez
                        empleado8 = session.get(Empleado.class, 8);
                        empleado9 = session.get(Empleado.class, 9); // ID de Juan Pérez
                        empleado10 = session.get(Empleado.class, 10);

                        IncidenciaDAO.insertarIncidencia(new Incidencia(new Date(), empleado1, empleado2, "Error en el sistema de login", 'U'));

                        IncidenciaDAO.insertarIncidencia(new Incidencia(new Date(), empleado1, empleado2, "Error en el sistema de login", 'U'));
                        IncidenciaDAO.insertarIncidencia(new Incidencia(new Date(), empleado3, empleado2, "Solicitud de acceso a la red interna", 'N'));
                        IncidenciaDAO.insertarIncidencia(new Incidencia(new Date(), empleado5, empleado8, "Fallo en la impresora del departamento", 'U'));
                        IncidenciaDAO.insertarIncidencia(new Incidencia(new Date(), empleado7, empleado8, "Revisión del servidor de correo", 'N'));
                        IncidenciaDAO.insertarIncidencia(new Incidencia(new Date(), empleado2, empleado10, "Problema con la VPN", 'U'));
                        IncidenciaDAO.insertarIncidencia(new Incidencia(new Date(), empleado2, empleado3, "Solicitud de actualización de software", 'N'));
                        IncidenciaDAO.insertarIncidencia(new Incidencia(new Date(), empleado3, empleado5, "Revisión del hardware en la oficina", 'U'));
                        IncidenciaDAO.insertarIncidencia(new Incidencia(new Date(), empleado7, empleado8, "Configuración de permisos en carpetas compartidas", 'N'));
                        IncidenciaDAO.insertarIncidencia(new Incidencia(new Date(), empleado8, empleado10, "Reparación de equipo informático", 'U'));
                        IncidenciaDAO.insertarIncidencia(new Incidencia(new Date(), empleado10, empleado1, "Problema con conexión a internet", 'N'));
                        IncidenciaDAO.insertarIncidencia(new Incidencia(new Date(), empleado1, empleado3, "Cambio de contraseña no autorizado", 'U'));
                        IncidenciaDAO.insertarIncidencia(new Incidencia(new Date(), empleado2, empleado5, "Error en aplicación de nómina", 'N'));
                        IncidenciaDAO.insertarIncidencia(new Incidencia(new Date(), empleado5, empleado7, "Restauración de copia de seguridad", 'U'));
                        IncidenciaDAO.insertarIncidencia(new Incidencia(new Date(), empleado8, empleado7, "Solicitud de soporte para nueva herramienta", 'N'));
                        IncidenciaDAO.insertarIncidencia(new Incidencia(new Date(), empleado8, empleado10, "Problema con licencias de software", 'U'));
                        IncidenciaDAO.insertarIncidencia(new Incidencia(new Date(), empleado3, empleado5, "Acceso denegado en sistema de gestión", 'N'));
                        IncidenciaDAO.insertarIncidencia(new Incidencia(new Date(), empleado7, empleado8, "Configuración de firma digital", 'U'));
                        IncidenciaDAO.insertarIncidencia(new Incidencia(new Date(), empleado3, empleado10, "Revisión de logs de seguridad", 'N'));
                        IncidenciaDAO.insertarIncidencia(new Incidencia(new Date(), empleado2, empleado7, "Fallo en el acceso a la base de datos", 'U'));
                        IncidenciaDAO.insertarIncidencia(new Incidencia(new Date(), empleado1, empleado10, "Revisión de cuentas de usuario inactivas", 'N'));

                        System.out.println("Continuamos con datos predefinidos");
                        break;

                    } else if(opcion == 2){
                        System.out.println("Continuamos sin datos predefinidos");
                    }

                } catch (InputMismatchException e) {
                    System.out.println("Debes incluir una de las dos opciones: 1 o 2");
                    e.printStackTrace();
                    sc.next();
                }
            }

        }

        MenuPrincipal menu = new MenuPrincipal();
        menu.setLocationRelativeTo(null);
        menu.setVisible(true);
        System.out.println("---------------------");
        System.out.println("FIN DE PROGRAMA");
    }
}
