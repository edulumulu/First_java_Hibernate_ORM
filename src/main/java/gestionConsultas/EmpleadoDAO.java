/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gestionConsultas;
   import POJO.Empleado;
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
            if (transaction != null) transaction.rollback();
            e.printStackTrace();
        }
    }
}
