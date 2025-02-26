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
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    public void insertarIncidencia(Incidencia incidencia) {
        Transaction transaction = null;
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            System.out.println("Intentando insertar incidencia...");

            session.persist(incidencia);  // Inserta la incidencia
            transaction.commit();  // Realiza el commit de la transacción

            System.out.println("Incidencia insertada correctamente.");
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();  // Si ocurre un error, se hace rollback
            }
            System.out.println("Error al insertar incidencia: " + e.getMessage());
            e.printStackTrace();
        } finally {
            if (session != null) {
                session.close();  // Cierra la sesión después de la transacción
            }
        }
    }

}
