
package main;

import POJO.Empleado;
import POJO.Incidencia;
import gestionConsultas.EmpleadoDAO;
import gestionConsultas.IncidenciaDAO;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author eduardolucasmunozdelucas
 */
public class main {

    public static void main(String[] args) {

        System.out.println("Empezamos");

         EmpleadoDAO empleadoDAO = new EmpleadoDAO();
         IncidenciaDAO incidenciaDao = new IncidenciaDAO();
         

                Empleado nuevoEmpleado = new Empleado("10", "10", "Eduardo Lucas", "600123456");
                empleadoDAO.insertarEmpleado(nuevoEmpleado);

//                Date fechahoy = new Date();
//                Incidencia nuevaInc = new Incidencia(fechahoy, new Empleado(1), new Empleado(5), "Thuevear", 'U');
//                incidenciaDao.insertarIncidencia(nuevaInc);

        //        empleadoDAO.eliminar_Empleado(6);
        //        
        //        empleadoDAO.modificar_empleado(new Empleado(2,"2", "2", "2", "2"));
            
        //empleadoDAO.modificar_contrasena_empleado(5, "12345");
//        if(empleadoDAO.validar_empleado(2, "2")){
//            System.out.println("BRAVO");
//        }

//            ArrayList<Incidencia> lista_incidencias = incidenciaDao.listar_incidencias();
//            
//            System.out.println("INCIDENCIAS");
//            for(Incidencia in : lista_incidencias){
//                System.out.println(in.toString());
//                System.out.println("-------------");
//            }
//        
            
//               Incidencia inci = IncidenciaDAO.obtener_incidencia_por_Id_incidencia(1);
//               
//               if(inci != null){
//                   System.out.println(inci.toString());
//               }else{
//                   System.out.println("esto no marcha");
//               }
//               
//               ArrayList<Incidencia> lista_incidencias = incidenciaDao.obtener_incidencias_por_empleado(1);
//               
//               if(!lista_incidencias.isEmpty()){
//                   
//                   System.out.println("LISTADO NUEVO DE INCIDENCIAS");
//                   for(Incidencia in : lista_incidencias){
//                System.out.println(in.toString());
//                System.out.println("-------------");
//            }
//               }
               
//               
//                Empleado emp= new Empleado(2,"2", "2", "2", "2");
//                
//           ArrayList<Incidencia> lista_incidencias = incidenciaDao.obtener_incidencias_para_empleado(emp);
//           
//            if(!lista_incidencias.isEmpty()){
//                   
//                   System.out.println("LISTADO NUEVO DE INCIDENCIAS");
//                   for(Incidencia in : lista_incidencias){
//                System.out.println(in.toString());
//                System.out.println("-------------");
//            }
//               }
            
//                       ArrayList<Empleado> lista_empleados = empleadoDAO.listarEmpleados();
//                       
//                       if(!lista_empleados.isEmpty()){
//                   
//                   System.out.println("LISTADO NUEVO DE EMPLEADOS");
//                   for(Empleado in : lista_empleados){
//                System.out.println(in.toString());
//                System.out.println("-------------");
//            }
//               }

            

                   
               
        

        //System.out.println("Incidencia insertada con éxito.");

    }
}
