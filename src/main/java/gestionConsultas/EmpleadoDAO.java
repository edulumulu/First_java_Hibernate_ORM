/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gestionConsultas;

import POJO.Empleado;
import POJO.Incidencia;
import org.hibernate.Session;
import org.hibernate.Transaction;
import herramientas.HibernateUtil;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.query.Query;

/**
 *
 * @author eduardolucasmunozdelucas
 */
public class EmpleadoDAO {

    // Insertar un nuevo empleado
    public boolean insertarEmpleado(Empleado empleado) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.persist(empleado);
            transaction.commit();
            session.close();
            return true;
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
            return false;
        }
    }

    public static int eliminar_Empleado(Empleado empleado) {
//    if (empleado == null || empleado.getId_empleado() == null) {
//        System.out.println("El empleado es nulo o no tiene ID, no se puede eliminar.");
//        return false;
//    }

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();

            // Verificar si el empleado tiene incidencias asociadas
            Long count = (Long) session.createQuery(
                    "SELECT COUNT(i) FROM Incidencia i WHERE i.id_empleado_origen.id_empleado = :idEmpleado OR i.id_empleado_destino.id_empleado = :idEmpleado")
                    .setParameter("idEmpleado", empleado.getId_empleado())
                    .uniqueResult();

            if (count > 0) {
                System.out.println("No se puede eliminar, el empleado tiene incidencias asociadas.");
                return 1;
            }

            // Recuperar el empleado desde la base de datos antes de eliminarlo
            Empleado empleadoDB = session.get(Empleado.class, empleado.getId_empleado());
            if (empleadoDB != null) {
                session.remove(empleadoDB);
                transaction.commit();
                System.out.println("Empleado eliminado correctamente.");
                return 0;
            } else {
                System.out.println("No se encontró el empleado en la base de datos.");
                return 2;
            }

        } catch (Exception e) {
            e.printStackTrace();
            return 2;
        }
    }

//    public static void modificar_empleado(int id, String contrasena, String nombre_user, String nombre_completo, String tlf){//Modifica un objeto cuyo id se pasa como parámetro
//        Transaction transaction=null; 
//        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
//
//            transaction=session.beginTransaction(); //Crea una transacción
//            Empleado empl = session.get(Empleado.class, id);
//             if (empl != null) {
//                empl.setNombre_usuario(nombre_user);
//                empl.setNombre_completo(nombre_completo);
//                empl.setContrasena(contrasena);
//                empl.setTelefono_contacto(tlf);
//                
//                session.update(empl);
//                System.out.println("Empleado modificado");
//            
//             }else {
//                System.out.println("Empleado no encontrado");
//            }
//            
//             transaction.commit();
//             
//        }catch (Exception e) {
//            if (transaction != null) {
//                transaction.rollback();
//            }
//            e.printStackTrace();
//        }
//        
//    }
    public static boolean modificar_empleado(Empleado empleado) {
        Transaction transaction = null;
        boolean ok = false;

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction(); // Inicia la transacción

            // Verificar si el nombre de usuario ya está en uso por otro empleado
            Long count = session.createQuery(
                    "SELECT COUNT(e) FROM Empleado e WHERE e.nombre_usuario = :nombreUsuario AND e.id_empleado <> :idEmpleado",
                    Long.class)
                    .setParameter("nombreUsuario", empleado.getNombre_usuario())
                    .setParameter("idEmpleado", empleado.getId_empleado())
                    .getSingleResult();

            if (count > 0) {
                System.out.println("Error: El nombre de usuario ya está en uso.");
                return false; // Salir del método sin actualizar
            }

            // Obtener el empleado que se va a modificar
            Empleado empl = session.get(Empleado.class, empleado.getId_empleado());

            if (empl != null) {
                // Modificar los atributos del empleado
                empl.setNombre_usuario(empleado.getNombre_usuario());
                empl.setNombre_completo(empleado.getNombre_completo());
                empl.setContrasena(empleado.getContrasena());
                empl.setTelefono_contacto(empleado.getTelefono_contacto());

                // Obtener incidencias donde el empleado sea origen o destino
                List<Incidencia> incidencias = session.createQuery(
                        "FROM Incidencia i WHERE i.id_empleado_origen.id_empleado = :idEmpleado OR i.id_empleado_destino.id_empleado = :idEmpleado",
                        Incidencia.class)
                        .setParameter("idEmpleado", empleado.getId_empleado())
                        .getResultList();

                // Actualizar las incidencias relacionadas
                for (Incidencia incidencia : incidencias) {
                    if (incidencia.getId_empleado_origen().getId_empleado() == empleado.getId_empleado()) {
                        incidencia.getId_empleado_origen().setNombre_usuario(empleado.getNombre_usuario());
                    }
                    if (incidencia.getId_empleado_destino().getId_empleado() == empleado.getId_empleado()) {
                        incidencia.getId_empleado_destino().setNombre_usuario(empleado.getNombre_usuario());
                    }
                    session.update(incidencia); // Persistir la incidencia actualizada
                }

                // Persistir el empleado modificado
                session.update(empl);
                System.out.println("Empleado y sus incidencias modificados");
                ok = true;
            } else {
                System.out.println("Empleado no encontrado");
                ok = false;
            }

            // Commit de la transacción
            transaction.commit();

        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback(); // Si ocurre un error, revertir la transacción
            }
            e.printStackTrace();
            ok = false;
        }

        return ok;
    }

    public static boolean modificar_contrasena_empleado(int id, String contrasena) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {

            transaction = session.beginTransaction(); // Crea una transacción

            // Buscar el empleado en la tabla empleado
            Empleado empl = session.get(Empleado.class, id);
            if (empl != null) {
                // Modificar la contraseña del empleado
                empl.setContrasena(contrasena);
                session.update(empl);
                System.out.println("Contraseña modificada");

                // Modificar las incidencias relacionadas con este empleado (si es necesario)
                // Buscar incidencias donde el empleado esté como origen o destino
                String hql = "FROM Incidencia i WHERE i.id_empleado_origen.id_empleado = :id OR i.id_empleado_destino.id_empleado = :id";
                List<Incidencia> incidencias = session.createQuery(hql, Incidencia.class)
                        .setParameter("id", id)
                        .list();

                // Actualizar las incidencias si se necesitan cambios relacionados con la contraseña del empleado
                // Aquí solo es un ejemplo, puedes actualizar algún campo relevante de la incidencia
                for (Incidencia incidencia : incidencias) {
                    // Ejemplo de modificación (aquí podrías actualizar lo que necesites en las incidencias)
                    //incidencia.setEstado("Actualizado por cambio de contraseña");
                    session.update(incidencia);
                }

                System.out.println("Incidencias relacionadas actualizadas");

            } else {
                System.out.println("Empleado no encontrado");
            }

            // Commit de la transacción
            transaction.commit();
            session.close();

            return true;

        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback(); // Si ocurre un error, hacer rollback
            }
            e.printStackTrace();
        }

        return false;
    }

    public static boolean validar_empleado(String user, String contrasena) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            String hql = "FROM Empleado WHERE nombre_usuario = :user AND contrasena = :contrasena";
            Query<Empleado> query = session.createQuery(hql, Empleado.class);
            query.setParameter("user", user);
            query.setParameter("contrasena", contrasena);

            Empleado empleado = query.uniqueResult();
            System.out.println("Empledo validado");
            session.close();
            return empleado != null; // Si encuentra el usuario, es válido

        } catch (Exception e) {
            e.printStackTrace();
            return false; // Si hay error, retorna falso
        }
    }

    public static ArrayList<Empleado> listarEmpleados() {
        ArrayList<Empleado> listaEmpleados = new ArrayList<>();

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            // Consulta HQL para obtener todos los empleados
            String hql = "FROM Empleado";
            Query<Empleado> query = session.createQuery(hql, Empleado.class);

            listaEmpleados = new ArrayList<>(query.getResultList()); // Convertir List a ArrayList

        } catch (Exception e) {
            e.printStackTrace();
        }

        return listaEmpleados;
    }

    public static Empleado obtener_empleado_por_user(String user) {
        Empleado empleado = null;

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            // Consulta HQL para obtener el empleado por id
            String hql = "FROM Empleado WHERE nombre_usuario = :user";
            Query<Empleado> query = session.createQuery(hql, Empleado.class);
            query.setParameter("user", user);  // Establecer el valor del parámetro id

            // Obtener el único resultado de la consulta (o null si no existe)
            empleado = query.uniqueResult();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return empleado;
    }

}
