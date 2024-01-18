package com.example;

import com.example.controlador.Acceso;
import com.example.modelo.Alumno;

public class Main {
    public static void main(String[] args) {
        // Crear instancias de Alumno
        Alumno persona1 = new Alumno("Paco", "Perez", "1o DAW", 5, 20);
        Alumno persona2 = new Alumno("Maria", "Lopez", "2o DAW", 3, 18);
        Alumno persona3 = new Alumno("Juan", "Garcia", "3o DAW", 2, 19);

        // Insertar alumnos en la base de datos
        Acceso.insertarAlumno(persona1);
        Acceso.insertarAlumno(persona2);
        Acceso.insertarAlumno(persona3);

        // Listar alumnos desde la base de datos
        Acceso.listarAlumnos();

        // Cerrar la conexión con la base de datos
        Acceso.desconectar();
    }
}
