/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gestionConsultas;

import POJO.Empleado;
import POJO.Incidencia;
import herramientas.HibernateUtil;
import java.util.ArrayList;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

/**
 *
 * @author eduardolucasmunozdelucas
 */
public class IncidenciaDAO {

    public static boolean insertarIncidencia(Incidencia incidencia) {
        Transaction transaction = null;
        Session session = null;
        boolean ok = false;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            System.out.println("Intentando insertar incidencia...");

            session.persist(incidencia);  // Inserta la incidencia
            transaction.commit();  // Realiza el commit de la transacción

            System.out.println("Incidencia insertada correctamente.");
            
            ok = true;
            
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();  // Si ocurre un error, se hace rollback
            }
            System.out.println("Error al insertar incidencia: " + e.getMessage());
            e.printStackTrace();
            ok = false;
        } finally {
            if (session != null) {
                session.close();  // Cierra la sesión después de la transacción
            }
        }
        return ok;
    }

    public static ArrayList<Incidencia> listar_incidencias() {
        ArrayList<Incidencia> listaIncidencias = new ArrayList<>();

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            // Consulta HQL para obtener todas las incidencias junto con los empleados asociados
            String hql = "SELECT i FROM Incidencia i "
                    + "LEFT JOIN FETCH i.id_empleado_origen "
                    + "LEFT JOIN FETCH i.id_empleado_destino"; // Usamos LEFT JOIN FETCH para evitar problemas de NULL

            Query<Incidencia> query = session.createQuery(hql, Incidencia.class);
            listaIncidencias = new ArrayList<>(query.getResultList()); // Convertimos List a ArrayList

        } catch (Exception e) {
            e.printStackTrace();
        }

        return listaIncidencias;
    }

    public static Incidencia obtener_incidencia_por_Id_incidencia(int id) {
        Incidencia incidencia = null;

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            // Usar HQL con JOIN FETCH para cargar las relaciones
            String hql = "SELECT i FROM Incidencia i "
                    + "JOIN FETCH i.id_empleado_origen "
                    + // Asegúrate de que el nombre de la relación sea correcto
                    "JOIN FETCH i.id_empleado_destino "
                    + "WHERE i.id_incidencia = :id";

            Query<Incidencia> query = session.createQuery(hql, Incidencia.class);
            query.setParameter("id", id);

            // Ejecuta la consulta y obtiene la incidencia
            incidencia = query.uniqueResult();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return incidencia;
    }

    public static ArrayList<Incidencia> obtener_incidencias_por_empleado(int idEmpleado) {
        ArrayList<Incidencia> listaIncidencias = new ArrayList<>();

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            // Usar HQL con JOIN FETCH para cargar las relaciones y filtrar por el id del empleado
            String hql = "SELECT i FROM Incidencia i "
                    + "JOIN FETCH i.id_empleado_origen "
                    + "JOIN FETCH i.id_empleado_destino "
                    + "WHERE i.id_empleado_origen.id_empleado = :idEmpleado";  // Filtra por el id del empleado

            Query<Incidencia> query = session.createQuery(hql, Incidencia.class);
            query.setParameter("idEmpleado", idEmpleado);

            // Ejecutar la consulta y obtener la lista de incidencias
            listaIncidencias = new ArrayList<>(query.getResultList()); // Convertir el resultado en un ArrayList
        } catch (Exception e) {
            e.printStackTrace();
        }

        return listaIncidencias;
    }

    public static ArrayList<Incidencia> obtener_incidencias_para_empleado(Empleado empleado) {
        ArrayList<Incidencia> listaIncidencias = new ArrayList<>();

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            // Usar HQL con JOIN FETCH para cargar las relaciones y filtrar por el id del empleado destinatario
            String hql = "SELECT i FROM Incidencia i "
                    + "JOIN FETCH i.id_empleado_origen "
                    + "JOIN FETCH i.id_empleado_destino "
                    + "WHERE i.id_empleado_destino.id_empleado = :idEmpleado";  // Filtra por el id del empleado destinatario

            Query<Incidencia> query = session.createQuery(hql, Incidencia.class);
            query.setParameter("idEmpleado", empleado.getId_empleado());  // Obtener id del empleado a partir del objeto

            // Ejecutar la consulta y obtener la lista de incidencias
            listaIncidencias = new ArrayList<>(query.getResultList()); // Convertir el resultado en un ArrayList
        } catch (Exception e) {
            e.printStackTrace();
        }

        return listaIncidencias;
    }

}
