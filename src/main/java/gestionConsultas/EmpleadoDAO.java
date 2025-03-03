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
import org.hibernate.query.Query;

/**
 *
 * @author eduardolucasmunozdelucas
 */
public class EmpleadoDAO {

    // Insertar un nuevo empleado
    public void insertarEmpleado(Empleado empleado) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.persist(empleado);
            transaction.commit();
            session.close();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    public static void eliminar_Empleado(int id) {
        Transaction transaction = null;

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction(); // Inicio transacción

            Empleado emple = session.get(Empleado.class, id); // Obtengo el empleado por ID
            if (emple != null) {
                session.delete(emple);
                System.out.println("Empleado eliminado");
            } else {
                System.out.println("Empleado no encontrado");
            }

            transaction.commit(); // Confirmar transacción
            session.close();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
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
    
    public static void modificar_empleado(Empleado empleado)
    {//Modifica un objeto cuyo id se pasa como parámetro
        Transaction transaction=null; 
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {

            transaction=session.beginTransaction(); //Crea una transacción
            Empleado empl = session.get(Empleado.class, empleado.getId_empleado());
             if (empl != null) {
                empl.setNombre_usuario(empleado.getNombre_usuario());
                empl.setNombre_completo(empleado.getNombre_completo());
                empl.setContrasena(empleado.getContrasena());
                empl.setTelefono_contacto(empleado.getTelefono_contacto());
                
                session.update(empl);
                System.out.println("Empleado modificado");
            
             }else {
                System.out.println("Empleado no encontrado");
            }
            
             transaction.commit();
             session.close();
             
        }catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        
    }
    
    
    
    public static void modificar_contrasena_empleado(int id, String contrasena){
//Modifica un objeto cuyo id se pasa como parámetro
        Transaction transaction=null; 
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {

            transaction=session.beginTransaction(); //Crea una transacción
            Empleado empl = session.get(Empleado.class, id);
             if (empl != null) {
                
                empl.setContrasena(contrasena);
                
                session.update(empl);
                System.out.println("Contraseña modificada");
            
             }else {
                System.out.println("No se ha podido cambiar la contraseña");
            }
            
             transaction.commit();
             session.close();
             
        }catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        
    }
    
    public static boolean validar_empleado(int id, String contrasena) {
    try (Session session = HibernateUtil.getSessionFactory().openSession()) {
        String hql = "FROM Empleado WHERE id_empleado = :id AND contrasena = :contrasena";
        Query<Empleado> query = session.createQuery(hql, Empleado.class);
        query.setParameter("id", id);
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


}
