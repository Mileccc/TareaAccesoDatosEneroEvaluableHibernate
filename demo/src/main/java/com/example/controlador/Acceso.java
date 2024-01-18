package com.example.controlador;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.example.modelo.Alumno;

public class Acceso {
    // Definición estática de sessionFactory, para manejar la sesión de Hibernate
    public static SessionFactory sessionFactory;

    static {
        // Bloque estático para inicializar la fábrica de sesiones
        // Carga la configuración de 'hibernate.cfg.xml'
        sessionFactory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
    }

    // Método para insertar un alumno en la base de datos
    public static void insertarAlumno(Alumno alumno) {
        // Creación de una nueva sesión de Hibernate
        Session session = sessionFactory.openSession();
        Transaction transaction = null;
        
        // Try-with-resources para cerrar la sesión de Hibernate
        try (session) {
            // Iniciar una nueva transacción
            transaction = session.beginTransaction();
            
            // Guardar el objeto alumno en la base de datos
            session.save(alumno);

            // Comprometer (commit) la transacción
            transaction.commit();

        } catch (Exception e) {
            // En caso de error, revertir la transacción
            if (transaction != null) {
                transaction.rollback();
            }
            // Imprimir la pila de errores
            e.printStackTrace();
        }
    }

    // Método para listar todos los alumnos en la base de datos
    public static void listarAlumnos() {
        // Creación de una nueva sesión de Hibernate
        Session session = sessionFactory.openSession();
        List<Alumno> alumnos = null;
        
        // Try-with-resources para cerrar la sesión de Hibernate
        try (session) {
            // Realizar una consulta HQL para obtener todos los alumnos
            alumnos = session.createQuery("from Alumno").list();

            // Verificar si la lista de alumnos está vacía
            if (alumnos.isEmpty()) {
                System.out.println("No hay alumnos");
            } else {
                // Iterar sobre la lista de alumnos y mostrar cada uno
                for (Alumno alumno : alumnos) {
                    System.out.println(alumno.toString());
                }
            }

        } catch (Exception e) {
            // Imprimir la pila de errores en caso de excepción
            e.printStackTrace();
        }
    }

    // Método para cerrar la fábrica de sesiones
    public static void desconectar() {
        // Cerrar la sesión de Hibernate
        sessionFactory.close();
    }
}
